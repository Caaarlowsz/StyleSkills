package me.liu.Comando;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.liu.Permissions;

public class CommandPlugins implements Listener {
	@EventHandler
	public void commandPreProcessas(final PlayerCommandPreprocessEvent event) {
		final String message = event.getMessage();
		if (message.equalsIgnoreCase("/bukkit:plugins") && !event.getPlayer().isPermissionSet("style.nopl")
				&& !event.getPlayer().isOp()) {
			event.setCancelled(true);
			Permissions.semPermiassao(event.getPlayer());
		}
	}
}
