package me.liu.Comando;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.liu.Permissions;

public class Commandgm implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if (sender instanceof ConsoleCommandSender) {
				System.out.println("Console nao pode usar esse comando");
				return true;
			}
			final Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(ChatColor.YELLOW + "O seu modo de gamemode atual \u00e9 " + p.getGameMode() + ".");
			} else if (args.length == 1) {
				if (p.hasPermission("style.gm") || p.isOp()) {
					if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("criativo")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(ChatColor.YELLOW + "Seu gamemode agora esta em criativo.");
					} else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("sobrevivencia")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(ChatColor.YELLOW + "Seu gamemode agora esta em sobrevivencia.");
					} else {
						p.sendMessage(ChatColor.RED + "Nao encontrado este gamemode.");
					}
				} else {
					Permissions.semPermiassao(p);
				}
			}
		}
		return false;
	}
}
