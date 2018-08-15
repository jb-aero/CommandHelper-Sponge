package com.laytonsmith.commandhelper;

import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.enums.MCChatColor;
import com.laytonsmith.abstraction.sponge.events.SpongeServerEvents.SpongeMCCommandEvent;
import com.laytonsmith.core.AliasCore;
import com.laytonsmith.core.InternalException;
import com.laytonsmith.core.Prefs;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.events.EventUtils;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.persistence.DataSourceException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Event listener for Hey0's server mod.
 *
 * @author sk89q
 */
public class CommandHelperPlayerListener {

	/**
	 * Logger.
	 */
	private static final Logger logger = Logger.getLogger("Minecraft");

	/**
	 * List of global aliases.
	 */
	private AliasCore ac;
	private CommandHelperPlugin plugin;

	public CommandHelperPlayerListener(CommandHelperPlugin plugin) {
		this.plugin = plugin;
	}

	/**
	 * Load global aliases.
	 */
	public void loadGlobalAliases() {
		ac = CommandHelperPlugin.getCore();
	}

	/**
	 * Find and run aliases for a player for a given command.
	 *
	 * @param command
	 * @return
	 */
	public boolean runAlias(String command, MCPlayer player) throws DataSourceException {
		return CommandHelperPlugin.getCore().alias(command, player);
	}

	/**
	 * Called when a player attempts to use a command
	 *
	 * @param event Relevant event details
	 */
	public void onPlayerCommandPreprocess(SpongeMCCommandEvent event) {
		if (CommandHelperPlugin.self.interpreterListener
				.isInInterpreterMode(event.getPlayer().getName())) {
			//They are in interpreter mode, so we want it to handle this, not everything else.
			return;
		}
		EventUtils.TriggerListener(Driver.PLAYER_COMMAND, "player_command", event);
		if (event.isCancelled()) {
			return;
		}
		MCPlayer player = event.getPlayer();

		if (!Prefs.PlayDirty()) {
			if (event.isCancelled()) {
				return;
			}
		} //If we are playing dirty, ignore the cancelled flag

		try {
			if (runAlias(event.getCommand(), player)) {
				event.cancel();
			}
		} catch (InternalException e) {
			logger.log(Level.SEVERE, e.getMessage());
		} catch (ConfigRuntimeException e) {
			logger.log(Level.WARNING, e.getMessage());
		} catch (Throwable e) {
			player.sendMessage(MCChatColor.RED + "Command failed with following reason: " + e.getMessage());
			//Obviously the command is registered, but it somehow failed. Cancel the event.
			event.cancel();
			e.printStackTrace();
		}
	}
}