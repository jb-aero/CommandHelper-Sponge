package com.laytonsmith.commandhelper;

import com.laytonsmith.abstraction.enums.MCChatColor;
import com.laytonsmith.abstraction.sponge.SpongeMCCommandSender;
import com.laytonsmith.abstraction.sponge.SpongeMCConsole;
import com.laytonsmith.abstraction.sponge.events.SpongeServerEvents.SpongeMCCommandEvent;
import com.laytonsmith.core.InternalException;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.events.EventUtils;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import org.spongepowered.api.command.source.ConsoleSource;

import java.util.logging.Level;

/**
 *
 *
 */
public class CommandHelperServerListener {

	public void onServerCommand(SpongeMCCommandEvent event) {
		//Run this first, so external events can intercept it.
		EventUtils.TriggerListener(Driver.SERVER_COMMAND, "server_command", event);
		SpongeMCCommandSender sender = event.getSender();
		if (sender.getHandle() instanceof ConsoleSource) {
			//Need the more specific subtype for player()
			sender = new SpongeMCConsole((ConsoleSource) sender.getHandle());
		}
		boolean match = false;
		try {
			match = Static.getAliasCore().alias("/" + event.getCommand(), sender);
		} catch (InternalException e) {
			Static.getLogger().log(Level.SEVERE, e.getMessage());
		} catch (ConfigRuntimeException e) {
			Static.getLogger().log(Level.WARNING, e.getMessage());
		} catch (Throwable e) {
			sender.sendMessage(MCChatColor.RED + "Command failed with following reason: " + e.getMessage());
			//Obviously the command is registered, but it somehow failed. Cancel the event.
			e.printStackTrace();
			return;
		}
		//To prevent "unknown console command" error, set the command to the meta command
		//commandhelper null, which just returns true.
		if (match) {
			event.setCommand("commandhelper null");
		}
	}

}
