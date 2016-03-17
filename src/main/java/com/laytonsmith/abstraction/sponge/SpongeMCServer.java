package com.laytonsmith.abstraction.sponge;

import com.laytonsmith.abstraction.MCCommandException;
import com.laytonsmith.abstraction.MCCommandMap;
import com.laytonsmith.abstraction.MCCommandSender;
import com.laytonsmith.abstraction.MCConsoleCommandSender;
import com.laytonsmith.abstraction.MCInventory;
import com.laytonsmith.abstraction.MCInventoryHolder;
import com.laytonsmith.abstraction.MCItemFactory;
import com.laytonsmith.abstraction.MCItemStack;
import com.laytonsmith.abstraction.MCOfflinePlayer;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.MCPluginManager;
import com.laytonsmith.abstraction.MCRecipe;
import com.laytonsmith.abstraction.MCScoreboard;
import com.laytonsmith.abstraction.MCServer;
import com.laytonsmith.abstraction.MCWorld;
import com.laytonsmith.abstraction.enums.MCInventoryType;
import com.laytonsmith.abstraction.enums.MCVersion;
import com.laytonsmith.abstraction.pluginmessages.MCMessenger;
import com.laytonsmith.abstraction.sponge.entities.SpongeMCPlayer;
import org.spongepowered.api.Game;
import org.spongepowered.api.Server;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatTypes;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class SpongeMCServer implements MCServer {

	Game game;
	MCVersion version;

	public SpongeMCServer(Game game) {
		this.game = game;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Collection<MCPlayer> getOnlinePlayers() {
		Set<MCPlayer> ret = __Server().getOnlinePlayers().stream().map(SpongeMCPlayer::new).collect(Collectors.toSet());
		return ret;
	}

	@Override
	public boolean dispatchCommand(MCCommandSender cs, String string) throws MCCommandException {
		return false;
	}

	@Override
	public MCPluginManager getPluginManager() {
		return null;
	}

	@Override
	public MCPlayer getPlayer(String name) {
		return null;
	}

	@Override
	public MCPlayer getPlayer(UUID uuid) {
		return null;
	}

	@Override
	public MCWorld getWorld(String name) {
		return null;
	}

	@Override
	public List<MCWorld> getWorlds() {
		return null;
	}

	@Override
	public void broadcastMessage(String message) {
		getHandle().getBroadcastChannel().send(Text.of(message), ChatTypes.SYSTEM);
	}

	@Override
	public void broadcastMessage(String message, String permission) {
		getHandle().getOnlinePlayers().stream().filter(p -> p.hasPermission(permission))
				.forEach(p -> p.sendMessage(ChatTypes.SYSTEM, Text.of(message)));
	}

	@Override
	public MCConsoleCommandSender getConsole() {
		return new SpongeMCConsole(__Server().getConsole());
	}

	@Override
	public MCItemFactory getItemFactory() {
		return null;
	}

	@Override
	public MCCommandMap getCommandMap() {
		return null;
	}

	@Override
	public MCInventory createInventory(MCInventoryHolder owner, MCInventoryType type) {
		return null;
	}

	@Override
	public MCInventory createInventory(MCInventoryHolder owner, int size, String title) {
		return null;
	}

	@Override
	public MCInventory createInventory(MCInventoryHolder owner, int size) {
		return null;
	}

	@Override
	public MCOfflinePlayer getOfflinePlayer(String player) {
		return null;
	}

	@Override
	public MCOfflinePlayer getOfflinePlayer(UUID uuid) {
		return null;
	}

	@Override
	public MCOfflinePlayer[] getOfflinePlayers() {
		return new MCOfflinePlayer[0];
	}

	@Override
	public String getServerName() {
		return __Server().getDefaultWorldName();
	}

	@Override
	public String getAPIVersion() {
		return __Game().getPlatform().getApi().getVersion().orElse("unknownVersion");
	}

	@Override
	public String getServerVersion() {
		return __Game().getPlatform().getImplementation().getVersion().orElse("unknownVersion");
	}

	@Override
	public MCVersion getMinecraftVersion() {
		if (version == null) {
			version = MCVersion.match(__Game().getPlatform().getMinecraftVersion().getName().split("\\."));
		}
		return version;
	}

	@Override
	public int getPort() {
		return __Server().getBoundAddress().orElse(new InetSocketAddress(25565)).getPort();
	}

	@Override
	public String getIp() {
		return __Server().getBoundAddress().orElse(new InetSocketAddress("0.0.0.0", getPort())).getHostString();
	}

	@Override
	public boolean getAllowEnd() {
		return true;
	}

	@Override
	public boolean getAllowFlight() {
		return false;
	}

	@Override
	public boolean getAllowNether() {
		return true;
	}

	@Override
	public boolean getOnlineMode() {
		return false;
	}

	@Override
	public int getViewDistance() {
		return 0;
	}

	@Override
	public String getWorldContainer() {
		return null;
	}

	@Override
	public int getMaxPlayers() {
		return 0;
	}

	@Override
	public List<MCOfflinePlayer> getBannedPlayers() {
		return null;
	}

	@Override
	public List<MCOfflinePlayer> getWhitelistedPlayers() {
		return null;
	}

	@Override
	public List<MCOfflinePlayer> getOperators() {
		return null;
	}

	@Override
	public void banIP(String address) {

	}

	@Override
	public Set<String> getIPBans() {
		return null;
	}

	@Override
	public void unbanIP(String address) {

	}

	@Override
	public MCScoreboard getMainScoreboard() {
		return null;
	}

	@Override
	public MCScoreboard getNewScoreboard() {
		return new SpongeMCScoreboard(Scoreboard.builder().build());
	}

	@Override
	public void runasConsole(String cmd) {

	}

	@Override
	public MCMessenger getMessenger() {
		return null;
	}

	@Override
	public boolean unloadWorld(MCWorld world, boolean save) {
		return false;
	}

	@Override
	public boolean addRecipe(MCRecipe recipe) {
		return false;
	}

	@Override
	public List<MCRecipe> getRecipesFor(MCItemStack result) {
		return null;
	}

	@Override
	public List<MCRecipe> allRecipes() {
		return null;
	}

	@Override
	public void clearRecipes() {

	}

	@Override
	public void resetRecipes() {

	}

	@Override
	public void savePlayers() {

	}

	@Override
	public void shutdown() {

	}

	@Override
	public String dispatchAndCaptureCommand(MCCommandSender commandSender, String cmd) {
		return null;
	}

	@Override
	public Server getHandle() {
		return game.getServer();
	}

	public Server __Server() {
		return game.getServer();
	}

	public Game __Game() {
		return game;
	}
}
