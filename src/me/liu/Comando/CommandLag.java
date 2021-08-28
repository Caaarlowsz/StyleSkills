package me.liu.Comando;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandLag implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (label.equalsIgnoreCase("lag")) {
			final double tps = GetTps.getTPS();
			final double lag = (double) Math.round((1.0 - tps / 20.0) * 100.0);
			sender.sendMessage(ChatColor.AQUA + "Servidor rodando a " + tps + " tps");
			sender.sendMessage(ChatColor.AQUA + "Lag do servidor " + lag + "%");
			return true;
		}
		return false;
	}
}
