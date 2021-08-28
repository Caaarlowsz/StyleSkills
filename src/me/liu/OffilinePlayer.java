package me.liu;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class OffilinePlayer {
	public static void jogadorOffline(final Player player) {
		player.sendMessage("§c§lStylePvP §4>>" + ChatColor.GRAY + " Este jogador esta offline!");
	}
}
