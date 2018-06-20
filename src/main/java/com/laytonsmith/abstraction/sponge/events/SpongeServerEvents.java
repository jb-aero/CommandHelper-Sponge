package com.laytonsmith.abstraction.sponge.events;

import com.laytonsmith.PureUtilities.Common.StringUtils;
import com.laytonsmith.abstraction.events.MCConsoleCommandEvent;
import com.laytonsmith.abstraction.events.MCPlayerCommandEvent;
import com.laytonsmith.abstraction.sponge.SpongeMCCommandSender;
import com.laytonsmith.abstraction.sponge.entities.SpongeMCPlayer;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.command.SendCommandEvent;

import java.util.function.Supplier;

public class SpongeServerEvents {

	public static class SpongeMCCommandEvent implements MCConsoleCommandEvent, MCPlayerCommandEvent {

		SendCommandEvent event;

		public SpongeMCCommandEvent(SendCommandEvent event) {
			this.event = event;
		}

		public SpongeMCCommandSender getSender() {
			return new SpongeMCCommandSender(event.getCause().first(CommandSource.class).orElseThrow(
					new Supplier<RuntimeException>() {
						@Override
						public RuntimeException get() {
							return new IllegalArgumentException("Tried to construct " + this.getClass().getName()
									+ " with a " + event.getClass().getName()
									+ " not caused by a CommandSource. Causes include: "
									+ StringUtils.Join(event.getCause().all(), ", ", ", and "));
						}
					}
			));
		}

		@Override
		public String getCommand() {
			return _GetObject().getCommand() + " " + _GetObject().getArguments();
		}

		@Override
		public void cancel() {
			_GetObject().setCommand("commandhelper");
			_GetObject().setArguments("null");
			_GetObject().setCancelled(true);
		}

		@Override
		public void setCommand(String s) {
			if (s.length() == 0) {
				_GetObject().setCommand("");
				_GetObject().setArguments("");
			} else {
				int split = s.indexOf(' ');
				_GetObject().setCommand(s.substring(0, Math.max(split, s.length())));
				_GetObject().setArguments(s.substring(split + 1));
			}
		}

		@Override
		public boolean isCancelled() {
			return _GetObject().isCancelled();
		}

		@Override
		public SendCommandEvent _GetObject() {
			return event;
		}

		@Override
		public SpongeMCPlayer getPlayer() {
			return new SpongeMCPlayer(event.getCause().first(Player.class).orElseThrow(
					new Supplier<RuntimeException>() {
						@Override
						public RuntimeException get() {
							return new IllegalArgumentException("Tried to construct " + this.getClass().getName()
									+ " with a " + event.getClass().getName()
									+ " not caused by a player. Causes include: "
									+ event.getCause().all().toString());
						}
					}
			));
		}
	}
}
