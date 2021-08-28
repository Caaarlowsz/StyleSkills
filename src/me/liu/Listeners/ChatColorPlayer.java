package me.liu.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.liu.Main;

public class ChatColorPlayer implements Listener {
	public Main plugin;

	public ChatColorPlayer(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void regular(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("stylechat.normal")) {
			e.setFormat("§7§o%s §6: §f" + e.getMessage());
		}
	}

	@EventHandler
	public void regularas(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("stylechat.designer")) {
			e.setFormat("§e§o%s §6: §f" + e.getMessage());
		}
	}

	@EventHandler
	public void vip(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("stylechat.vip")) {
			e.setFormat("§a§o%s §6: §f" + e.getMessage());
		}
	}

	@EventHandler
	public void eterno(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("stylechat.eterno")) {
			e.setFormat("§6§o%s §6: §f" + e.getMessage());
		}
	}

	@EventHandler
	public void yt(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("stylechat.yt")) {
			e.setFormat("§b§o%s §6: §f" + e.getMessage());
		}
	}

	@EventHandler
	public void mod(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("stylechat.mod")) {
			e.setFormat("§5§o%s §6: §f" + e.getMessage());
		}
	}

	@EventHandler
	public void tmod(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("stylechat.tmod")) {
			e.setFormat("§5%s §6: §f" + e.getMessage());
		}
	}

	@EventHandler
	public void admin(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("stylechat.admin")) {
			e.setFormat("§c§o%s §6: §f" + e.getMessage());
		}
	}

	@EventHandler
	public void dono(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("stylechat.dono")) {
			e.setFormat("§4§o%s §6: §f" + e.getMessage());
		}
	}
}
