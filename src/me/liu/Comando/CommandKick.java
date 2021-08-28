package me.liu.Comando;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandKick implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("kick")) {
			if (sender instanceof ConsoleCommandSender) {
				System.out.println("Console nao pode usar esse comando");
				return true;
			}
			final Player p = (Player) sender;
			if (p.hasPermission("style.kick") || p.isOp()) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "Sintaxe incorreta.");
				} else if (args.length == 1) {
					final Player targetPlayer = p.getServer().getPlayer(args[0]);
					if (targetPlayer == null) {
						p.sendMessage("§4§oEste jogador esta offline!");
					} else {
						Bukkit.broadcastMessage(ChatColor.RED + targetPlayer.getDisplayName() + "§e foi kickado por §c"
								+ p.getDisplayName() + ".");
					}
				} else if (args.length > 1) {
					final Player targetPlayer = p.getServer().getPlayer(args[0]);
					if (targetPlayer == null) {
						p.sendMessage("&4&oEste jogador esta offline!");
					} else {
						String message = "";
						for (int i = 1; i < args.length; ++i) {
							message = String.valueOf(message) + args[i] + " ";
						}
						targetPlayer.kickPlayer("§eVoce foi kickado pelo jogador §c" + p.getDisplayName()
								+ " §epor §c§o§l> " + message);
						Bukkit.broadcastMessage(ChatColor.RED + targetPlayer.getDisplayName() + " §eFoi kickado por §c"
								+ p.getDisplayName() + " §epor " + message);
					}
				}
			} else {
				p.sendMessage("§4§oVoce nao tem permissao para este comando metido!");
			}
		}
		return false;
	}
}
