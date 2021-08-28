package me.liu.Comando;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.liu.Main;
import me.liu.Permissions;

public class CommandVida implements CommandExecutor {
	public Main plugin;

	public CommandVida(final Main instance) {
		this.plugin = instance;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String tag, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("vida")) {
			if (sender instanceof ConsoleCommandSender) {
				System.out.println("Console nao pode usar esse comando");
				return true;
			}
			final Player p = (Player) sender;
			if (args.length == 0) {
				if (!p.hasPermission("vida.me")) {
					Permissions.semPermiassao(p);
					return true;
				}
				p.setHealth(20.0);
				p.sendMessage("§2§oVoce foi curado ;D");
				return true;
			} else if (args.length == 1) {
				if (!p.hasPermission("vida.otro")) {
					Permissions.semPermiassao(p);
					return true;
				}
				try {
					final Player a = p.getServer().getPlayer(args[0]);
					a.setHealth(20.0);
					a.sendMessage(ChatColor.YELLOW + sender.getName() + " §cCurou voce!");
					a.sendMessage("§2Voce foi curado!");
					return true;
				} catch (NullPointerException ex) {
					p.sendMessage("§c§oEste player nao esta aqui!");
					return true;
				}
			}
		}
		return false;
	}
}
