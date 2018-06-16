package com.laytonsmith.abstraction.sponge.events.drivers;

import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.Static;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.message.MessageChannelEvent.Chat;
import org.spongepowered.api.event.network.ClientConnectionEvent.Disconnect;
import org.spongepowered.api.event.network.ClientConnectionEvent.Join;
import org.spongepowered.api.event.network.ClientConnectionEvent.Login;

public class SpongePlayerListener {

	@Listener(order = Order.FIRST)
	public void onPlayerJoin(Join event) {
<<<<<<< HEAD
		Static.HostnameCache(event.getTargetEntity().getName(),
				event.getTargetEntity().getConnection().getAddress()
		);
=======
		Static.HostnameCache(event.getTargetEntity().getName(),	event.getTargetEntity().getConnection().getAddress());
>>>>>>> f99d387686a8524c1abc9e94a436f3c393c43796
	}

	@Listener(order = Order.FIRST)
	public void onPlayerLogin(Login event) {
		Static.SetPlayerHost(event.getProfile().getName().get(), event.getConnection().getAddress().getHostName());
	}

	@Listener(order = Order.FIRST)
	public void onPlayerQuit(Disconnect event) {
		CommandHelperPlugin.self.interpreterListener.onPlayerQuit(event.getTargetEntity().getName());
	}

	public void onPlayerChat(Chat event) {

	}
}
