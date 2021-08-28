package me.liu.Comando;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.liu.Main;
import me.liu.Permissions;

public class CommandSuicide implements CommandExecutor {
	public Main plugin;

	public CommandSuicide(final Main instance) {
		this.plugin = instance;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Este comando pode ser usado apenas em jogo!");
			return true;
		}
		final Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("suicide")) {
			if (!player.hasPermission("style.suicide")) {
				Permissions.semPermiassao(player);
				return true;
			}
			if (args.length == 0) {
				player.setHealth(0.0);
				Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + player.getName() + " suicidou-se.");
			} else if (args.length > 0) {
				player.sendMessage(ChatColor.RED + "Execo de Argumentos!");
				player.sendMessage(ChatColor.RED + "Usar: /suicide");
			}
		}
		return true;
	}
}
