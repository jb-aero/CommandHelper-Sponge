package com.laytonsmith.commandhelper;

import com.google.inject.Inject;
import com.laytonsmith.PureUtilities.ClassLoading.ClassDiscovery;
import com.laytonsmith.PureUtilities.ClassLoading.ClassDiscoveryCache;
import com.laytonsmith.PureUtilities.Common.OSUtils;
import com.laytonsmith.PureUtilities.Common.StreamUtils;
import com.laytonsmith.PureUtilities.ExecutionQueue;
import com.laytonsmith.PureUtilities.MapBuilder;
import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.TermColors;
import com.laytonsmith.abstraction.Implementation;
import com.laytonsmith.abstraction.MCCommandSender;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.MCServer;
import com.laytonsmith.abstraction.StaticLayer;
import com.laytonsmith.abstraction.sponge.SpongeMCCommandBlock;
import com.laytonsmith.abstraction.sponge.SpongeMCCommandSender;
import com.laytonsmith.abstraction.sponge.SpongeMCConsole;
import com.laytonsmith.abstraction.sponge.SpongeMCServer;
import com.laytonsmith.abstraction.sponge.entities.SpongeMCPlayer;
import com.laytonsmith.core.AliasCore;
import com.laytonsmith.core.Installer;
import com.laytonsmith.core.MSLog;
import com.laytonsmith.core.MethodScriptExecutionQueue;
import com.laytonsmith.core.Prefs;
import com.laytonsmith.core.Profiles;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.apps.AppsApiUtil;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.extensions.ExtensionManager;
import com.laytonsmith.core.profiler.Profiler;
import com.laytonsmith.core.telemetry.DefaultTelemetry;
import com.laytonsmith.core.telemetry.Telemetry;
import com.laytonsmith.persistence.PersistenceNetwork;
import org.bstats.sponge.Metrics2;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.command.SendCommandEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePostInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Plugin(id = PomData.NAME, name = PomData.BRANDING,
		version = PomData.VERSION, url = PomData.WEBSITE, description = PomData.DESCRIPTION)
public class CommandHelperPlugin {

	private static AliasCore ac;
	public static MCServer myServer;
	public static CommandHelperPlugin self;

	@Inject
	private Logger logger;
	private JavaToSLogAdapter logAdapter;

	@Inject
	private Metrics2 metrics;

	@Inject
	@ConfigDir(sharedRoot = false)
	private Path configDir;

	public static ExecutorService hostnameLookupThreadPool;
	public static ConcurrentHashMap<String, String> hostnameLookupCache;
	private static int hostnameThreadPoolID = 0;
	public Profiler profiler;
	public final ExecutionQueue executionQueue = new MethodScriptExecutionQueue("CommandHelperExecutionQueue",
			"default"
	);
	public PersistenceNetwork persistenceNetwork;
	public Profiles profiles;
	private boolean firstLoad = true;
	//public boolean firstLoad = true;
	public long interpreterUnlockedUntil = 0;
	private Thread loadingThread;


	/**
	 * Listener for the plugin system.
	 */
	final CommandHelperPlayerListener playerListener = new CommandHelperPlayerListener(this);
	/**
	 * Interpreter listener
	 */
	public final CommandHelperInterpreterListener interpreterListener = new CommandHelperInterpreterListener(this);

	/**
	 * Server Command Listener, for console commands
	 */
	// final CommandHelperServerListener serverListener = new CommandHelperServerListener();

	/**
	 * @return a fake Java Logger that redirects calls to
	 */
	public java.util.logging.Logger getLogger() {
		return logAdapter;
	}

	@Listener
	public void onLoad(GamePreInitializationEvent event) {

		AppsApiUtil.ConfigureDefaults();
		Implementation.setServerType(Implementation.Type.SPONGE);

		self = this;
		logAdapter = new JavaToSLogAdapter(logger);

		CommandHelperFileLocations.setDefault(new CommandHelperFileLocations(), configDir.toFile());
		CommandHelperFileLocations.getDefault().getCacheDirectory().mkdirs();
		CommandHelperFileLocations.getDefault().getCacheDirectory().mkdirs();

		try {
			Prefs.init(CommandHelperFileLocations.getDefault().getPreferencesFile());
		} catch (IOException ex) {
			logger.error(null, ex);
		}

		Prefs.SetColors();
		Installer.Install(CommandHelperFileLocations.getDefault().getConfigDirectory());

		ClassDiscoveryCache cdc = new ClassDiscoveryCache(CommandHelperFileLocations.getDefault().getCacheDirectory());
		cdc.setLogger(getLogger());
		ClassDiscovery.getDefaultInstance().setClassDiscoveryCache(cdc);
		ClassDiscovery.getDefaultInstance().addDiscoveryLocation(ClassDiscovery.GetClassContainer(CommandHelperPlugin.class));
		ClassDiscovery.getDefaultInstance().addDiscoveryLocation(ClassDiscovery.GetClassContainer(Game.class));

		MSLog.initialize(CommandHelperFileLocations.getDefault().getConfigDirectory());

		Telemetry.GetDefault().initializeTelemetry();
		Telemetry.GetDefault().doNag();
		Telemetry.GetDefault().log(DefaultTelemetry.StartupModeMetric.class,
				MapBuilder.start("mode", Implementation.GetServerType().getBranding()), null);

		loadingThread = new Thread("extensionloader") {
			@Override
			public void run() {
				ExtensionManager.AddDiscoveryLocation(CommandHelperFileLocations.getDefault().getExtensionsDirectory());
				if (OSUtils.GetOS() == OSUtils.OS.WINDOWS) {
					logger.info("Caching extensions in the background...");
					ExtensionManager.Cache(CommandHelperFileLocations.getDefault().getExtensionCacheDirectory());
					logger.info("Extension caching complete.");
				}
			}
		};
		loadingThread.start();

		if (new SimpleVersion(System.getProperty("java.version")).lt(new SimpleVersion("1.8"))) {
			MSLog.GetLogger().e(MSLog.Tags.GENERAL, "CommandHelper does not support Java versions older than 8!",
					Target.UNKNOWN);
		}

		// ReflectionUtils.set(StaticLayer.class, "convertor", new SpongeConverter()); // ClassDiscovery broke
		myServer = SpongeMCServer.Get();
	}

	@Listener
	public void onEnable(GameInitializationEvent event) {
		if (loadingThread.isAlive()) {
			logger.info("Waiting for extension caching to complete...");
			try {
				loadingThread.join();
			} catch (InterruptedException ex) {
				logger.error(null, ex);
			}
		}

		if (firstLoad) {
			// This is not known to be needed yet
			/*if(Static.getServer().getMinecraftVersion().gte(MCVersion.MC1_15_X)) {
				// Add dependency on every loaded plugin on Spigot 1.15.2 and later.
				// This suppresses warnings from the PluginClassLoader due to extensions using a plugin API.
				// This should be done before ExtensionManager.Initialize().
				try {
					Object dependencyGraph = ReflectionUtils.get(SimplePluginManager.class, Bukkit.getPluginManager(),
							"dependencyGraph");
					for(Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
						if(plugin == self) {
							continue;
						}
						ReflectionUtils.invokeMethod(dependencyGraph, "putEdge", self.getDescription().getName(),
								plugin.getName());
					}
				} catch (ReflectionUtils.ReflectionException ex) {
					// While this failed, nothing breaks. The server may still get class load warnings, though.
				}
			}*/

			ExtensionManager.Initialize(ClassDiscovery.getDefaultInstance());
			logger.info("Extensions initialized.");
		}

		//Metrics
		metrics.addCustomChart(new Metrics2.SimplePie("Server API", () -> "Sponge"));
		metrics.addCustomChart(new Metrics2.SingleLineChart("player_count",
				() -> Static.getServer().getOnlinePlayers().size()));

		try {
			//This may seem redundant, but on a /reload, we want to refresh these
			//properties.
			Prefs.init(CommandHelperFileLocations.getDefault().getPreferencesFile());
		} catch (IOException ex) {
			logger.error(null, ex);
		}
		if (Prefs.UseSudoFallback()) {
			logger.warn("In your preferences, use-sudo-fallback is turned on. Consider turning this off if you can.");
		}
		MSLog.initialize(CommandHelperFileLocations.getDefault().getConfigDirectory());

		String scriptName = Prefs.ScriptName();
		String mainFile = Prefs.MainFile();
		boolean showSplashScreen = Prefs.ShowSplashScreen();
		if (showSplashScreen) {
			StreamUtils.GetSystemOut().println(TermColors.reset());
			//StreamUtils.GetSystemOut().flush();
			StreamUtils.GetSystemOut().println("\n\n" + Static.Logo());
		}
		ac = new AliasCore(new File(CommandHelperFileLocations.getDefault().getConfigDirectory(), scriptName),
				CommandHelperFileLocations.getDefault().getLocalPackagesDirectory(),
				CommandHelperFileLocations.getDefault().getPreferencesFile(),
				new File(CommandHelperFileLocations.getDefault().getConfigDirectory(), mainFile), this);
		ac.reload(null, null, this.firstLoad);

		//Clear out our hostname cache
		hostnameLookupCache = new ConcurrentHashMap<>();
		//Create a new thread pool, with a custom ThreadFactory,
		//so we can more clearly name our threads.
		hostnameLookupThreadPool = Executors.newFixedThreadPool(3, new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r, "CommandHelperHostnameLookup-" + (++hostnameThreadPoolID));
			}
		});
		for (Player p : Sponge.getServer().getOnlinePlayers()) {
			//Repopulate our cache for currently online players.
			//New players that join later will get a lookup done
			//on them at that time.
			Static.HostnameCache(p.getName(), p.getConnection().getAddress());
		}

		//interpreter events
//		registerEvents(interpreterListener);
//		registerEvents(serverListener);

		//Script events
		StaticLayer.Startup(this);

		playerListener.loadGlobalAliases();
//		interpreterListener.reload();

		firstLoad = false;

		logger.info("CommandHelper {} enabled", PomData.VERSION);
	}

	@Listener
	public void onPostInit(GamePostInitializationEvent event) {
		// build enums
	}

	@Listener
	public void serverStarting(GameStartingServerEvent event) {
		Sponge.getCommandManager().register(this, recompile, "recompile", "reloadalias", "reloadaliases");
		Sponge.getCommandManager().register(this, commandhelper, "commandhelper");
		Sponge.getCommandManager().register(this, runalias, "runalias");
		Sponge.getCommandManager().register(this, interpreteron, "interpreter-on");
		Sponge.getCommandManager().register(this, interpreter, "interpreter");
	}

	@Listener
	public void onDisable(GameStoppingEvent event) {
		//free up some memory
		StaticLayer.GetConvertor().runShutdownHooks();
		stopExecutionQueue();

		ExtensionManager.Cleanup();

		ac = null;
	}

	public static AliasCore getCore() {
		return ac;
	}

	public void stopExecutionQueue() {
		for (String queue : executionQueue.activeQueues()) {
			executionQueue.clear(queue);
		}
	}

	public void registerEvents(Object listener) {
		// getServer().getPluginManager().registerEvents(listener, this);
	}

	@Listener
	public void onCommand(SendCommandEvent event) {
		CommandSource source = (CommandSource) event.getCause().root();

		MCCommandSender sender;

		if (source instanceof Player) {
			sender = new SpongeMCPlayer((Player) source);
		} else if (source instanceof ConsoleSource) {
			sender = new SpongeMCConsole((ConsoleSource) source);
		} else if (source instanceof CommandBlockSource) {
			sender = new SpongeMCCommandBlock((CommandBlockSource) source);
		} else {
			sender = new SpongeMCCommandSender(source);
		}
	}

	Text urlTextHelper(Text.Builder text, String address) {
		URL url;
		try {
			url = new URL(address);
		} catch (MalformedURLException ex) {
			return text.onClick(TextActions.executeCallback(commandSource -> commandSource.sendMessage(
					Text.builder("Go here: ").color(TextColors.YELLOW).append(Text.of(address)).build()))).build();
		}
		return text.onClick(TextActions.openUrl(url)).build();
	}

	CommandSpec
			recompile = CommandSpec.builder()
			.permission(PomData.NAME + ".reloadaliases")
			.description(Text.builder("Reloads plugin settings and recompiles scripts. ").append(
					urlTextHelper(Text.builder("[Help Page]").style(TextStyles.ITALIC).color(TextColors.YELLOW),
							PomData.WEBSITE + "/Staged/Advanced_Guide#reloadaliases"
					)).build())
			.arguments(GenericArguments.optional(GenericArguments.remainingJoinedStrings(Text.of("args"))))
			.executor((src, args) -> {
				String[] myArgs = args.<String>getOne("args").isPresent()
						? args.<String>getOne("args").get().split(" ") : new String[0];
				MCPlayer player = src instanceof Player ? new SpongeMCPlayer((Player) src) : null;
				getCore().reload(player, myArgs, false);
				return CommandResult.success();
			})
			.build(),
			commandhelper = CommandSpec.builder()
					.description(Text.of("This command does nothing."))
					.arguments(GenericArguments.optional(GenericArguments.remainingJoinedStrings(Text.of("args"))))
					.executor((src, args) -> {
						Optional<String> myArgs = args.<String>getOne("args");
						if (myArgs.isPresent() && "null".equals(myArgs.get().split(" ")[0])) {
							return CommandResult.success();
						}
						return CommandResult.empty();
					})
					.build(),
			runalias = CommandSpec.builder()
					.executor((src, args) -> CommandResult.empty())
					.build(),
			interpreteron = CommandSpec.builder()
					.description(Text.of("Enables interpreter mode for the configured time."))
					.extendedDescription(Text.of("Can only be run from console. Turns on the interpreter for however"
							+ " long is specified in the preferences option \"interpreter-timeout\"."))
					.executor(((src, args) -> {
						if (src instanceof ConsoleSource) {
							int interpreterTimeout = Prefs.InterpreterTimeout();
							if (interpreterTimeout != 0) {
								interpreterUnlockedUntil =
										(interpreterTimeout * 60 * 1000) + System.currentTimeMillis();
								src.sendMessage(Text.of("Interpreter mode unlocked for " + interpreterTimeout
										+ " minute" + (interpreterTimeout == 1 ? "" : "s")));
							} else {
								src.sendMessage(Text.of("Interpreter mode was already set for permanent activation."
										+ " If this was not desired, you should change it in "
										+ CommandHelperFileLocations.getDefault().getPreferencesFile().getAbsolutePath()));
							}
						} else {
							src.sendMessage(Text.of("This command can only be run from console."));
						}
						return CommandResult.success();
					}))
					.build(),
			interpreter = CommandSpec.builder()
					.description(Text.builder("Puts your chat in interpreter mode. ").append(urlTextHelper(
							Text.builder("[Help Page]").style(TextStyles.ITALIC).color(TextColors.YELLOW),
							PomData.WEBSITE + "/Interpreter_Mode"
					)).build())
					.permission(PomData.NAME + ".interpreter")
					.executor(((src, args) -> {
						if (src instanceof Player) {
							if (!Prefs.EnableInterpreter()) {
								src.sendMessage(Text.builder("The interpreter is currently disabled."
										+ " Check your preferences file.").color(TextColors.RED).build());
							} else if (Prefs.InterpreterTimeout() != 0
									&& interpreterUnlockedUntil < System.currentTimeMillis()) {
								src.sendMessage(Text.builder("Interpreter mode is currently locked."
										+ " Run \"interpreter-on\" in console to unlock it. If you want to turn this"
										+ " protection off entirely, set the interpreter-timeout option to 0 in "
										+ CommandHelperFileLocations.getDefault().getPreferencesFile().getName())
										.color(TextColors.RED).build());
							} else {
								interpreterListener.startInterpret(src.getName());
								src.sendMessage(Text.builder("You are now in interpreter mode. Type a dash (-) on a"
										+ " line by itself to exit, and >>> to enter multiline mode.")
										.color(TextColors.YELLOW).build());
							}
						} else {
							src.sendMessage(Text.of("Interpreter is only available for players."));
						}
						return CommandResult.success();
					}))
					.build();
}
