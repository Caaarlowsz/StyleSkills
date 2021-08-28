package me.liu.Comando;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.liu.Main;

public class CommandList implements CommandExecutor {
	public Main plugin;

	public CommandList(final Main instance) {
		this.plugin = instance;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (args.length != 0) {
			sender.sendMessage(ChatColor.YELLOW + "Excesso de argumentos.");
			return true;
		}
		final Player[] players = Bukkit.getOnlinePlayers();
		String list = "";
		int playerCount = 0;
		for (int i = 0; i < players.length; ++i) {
			if (sender instanceof Player) {
				if (((Player) sender).canSee(players[i])) {
					list = String.valueOf(list) + players[i].getDisplayName() + ChatColor.GRAY + ", ";
					++playerCount;
				}
			} else {
				list = String.valueOf(list) + players[i].getDisplayName() + ChatColor.GRAY + ", ";
				++playerCount;
			}
		}
		if (players.length == 0) {
			sender.sendMessage(ChatColor.AQUA + "Nao tem jogadores online.");
			return true;
		}
		sender.sendMessage(ChatColor.AQUA + "Jogadores online (" + playerCount + "): " + ChatColor.GRAY
				+ list.substring(0, list.length() - 2));
		return true;
	}
}
