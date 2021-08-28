package me.liu.Comando;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.liu.Main;

public class CommandTempo implements CommandExecutor {
	public CommandTempo pl;

	public CommandTempo(final CommandTempo plugin) {
		this.pl = plugin;
	}

	public CommandTempo(final Main main) {
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel,
			final String[] args) {
		final Player player = (Player) sender;
		if (sender instanceof Player && sender.hasPermission("style.tempo")
				&& command.getName().equalsIgnoreCase("tempo") && args.length != 0) {
			if (args[0].equalsIgnoreCase("noite")) {
				player.getWorld().setTime(18000L);
				sender.sendMessage(ChatColor.GREEN + "O tempo foi alterado para: " + ChatColor.DARK_GREEN + "Noite");
				Bukkit.broadcastMessage(ChatColor.GREEN + "O tempo foi alterado para" + ChatColor.WHITE + " Noite "
						+ ChatColor.GREEN + "por " + ChatColor.WHITE + sender.getName());
				return true;
			}
			if (args[0].equalsIgnoreCase("dia")) {
				player.getWorld().setTime(0L);
				sender.sendMessage(ChatColor.GREEN + "O tempo foi alterado para: " + ChatColor.DARK_GREEN + "Dia");
				Bukkit.broadcastMessage(ChatColor.GREEN + "O tempo foi alterado para" + ChatColor.WHITE + " Dia "
						+ ChatColor.GREEN + "por " + ChatColor.WHITE + sender.getName());
				return true;
			}
		}
		return false;
	}
}
