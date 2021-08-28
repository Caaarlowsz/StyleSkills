package me.liu.Comando;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.liu.Permissions;

public class CommandPing implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String c, final String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			final int ping = ((CraftPlayer) p).getHandle().ping;
			if (c.equalsIgnoreCase("ping")) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "- " + ChatColor.YELLOW + p.getDisplayName() + ChatColor.WHITE
							+ " Ping: " + ChatColor.GREEN + ping + ChatColor.WHITE + " ms!");
				} else if (args[0].equalsIgnoreCase("aother")) {
					p.sendMessage("help");
				} else if (p.hasPermission("style.ping.outros")) {
					if (p.getServer().getPlayer(args[0]) != null) {
						final String player2 = args[0];
						final Player target = Bukkit.getServer().getPlayer(args[0]);
						final int ping2 = ((CraftPlayer) target).getHandle().ping;
						p.sendMessage(ChatColor.RED + "- " + ChatColor.YELLOW + player2 + ChatColor.WHITE + "'s Ping: "
								+ ChatColor.GREEN + ping2 + ChatColor.WHITE + " ms!");
					} else {
						final String player2 = args[0];
						p.sendMessage(ChatColor.YELLOW + player2 + ChatColor.WHITE + "'s" + ChatColor.RED
								+ " Nao esta Online!");
					}
				} else {
					Permissions.semPermiassao(p);
				}
			}
		}
		return false;
	}
}
