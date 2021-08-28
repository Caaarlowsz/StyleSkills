package me.liu.Comando;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.liu.Main;
import me.liu.Permissions;

public class CommandUp implements CommandExecutor {
	public Main plugin;

	public CommandUp(final Main instance) {
		this.plugin = instance;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("upi")) {
			if (args.length == 1) {
				if (sender.hasPermission("style.up")) {
					if (sender instanceof Player) {
						if (!args[0].replaceAll("[\\D]", "").isEmpty()) {
							final int blocks = Integer.parseInt(args[0].replaceAll("[\\D]", ""));
							final Location loc = ((Player) sender).getLocation().add(0.0, (double) blocks, 0.0);
							((Player) sender).teleport(loc);
							if (((Player) sender).getWorld().getBlockAt(loc.add(0.0, -1.0, 0.0)).getType()
									.equals((Object) Material.AIR)) {
								((Player) sender).getWorld().getBlockAt(loc).setType(Material.LEAVES);
								loc.add(0.0, 1.0, 0.0);
							}
							if (!((Player) sender).getWorld().getBlockAt(loc).getType().equals((Object) Material.AIR)) {
								((Player) sender).getWorld().getBlockAt(loc).setType(Material.AIR);
							}
							if (!((Player) sender).getWorld().getBlockAt(loc.add(0.0, 1.0, 0.0)).getType()
									.equals((Object) Material.AIR)) {
								((Player) sender).getWorld().getBlockAt(loc).setType(Material.AIR);
								loc.add(0.0, -1.0, 0.0);
							}
							sender.sendMessage(ChatColor.GREEN + "Subiu! Oxi ;D");
						} else if (sender instanceof Player) {
							sender.sendMessage(ChatColor.RED + "Usar: /upi <blocos>");
						} else {
							sender.sendMessage("Usar: /upi <blocos>");
						}
					} else {
						sender.sendMessage("§a§oNao console!");
					}
				} else if (sender instanceof Player) {
					Permissions.semPermiassao((Player) sender);
				} else {
					Permissions.semPermiassao((Player) sender);
				}
			} else if (sender instanceof Player) {
				sender.sendMessage(ChatColor.RED + "Usar: /upi <blocos>");
			} else {
				sender.sendMessage("Usar: /upi <blocos>");
			}
		}
		return false;
	}
}
