package me.liu.Comando;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import me.liu.Permissions;

public class CommandTell implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("tell")) {
			if (sender instanceof ConsoleCommandSender) {
				System.out.println("Console nao pode usar esse comando");
				return true;
			}
			final Player p = (Player) sender;
			if (p.hasPermission("style.msg") || p.isOp() || !p.isOp()) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "Use:/tell <jogador> <mensagem>");
				} else if (args.length == 1) {
					p.sendMessage(ChatColor.RED + "Use:/tell <jogador> <mensagem>");
				} else if (args.length > 1) {
					String message = "";
					for (int i = 1; i < args.length; ++i) {
						message = String.valueOf(message) + args[i] + " ";
					}
					final Player targetPlayer = p.getServer().getPlayer(args[0]);
					if (targetPlayer == null) {
						p.sendMessage("?4?Este jogador esta offline!");
					} else {
						targetPlayer.sendMessage(ChatColor.YELLOW + "(De " + p.getDisplayName() + "?e)?f: " + message);
						p.sendMessage(
								ChatColor.YELLOW + "(Para " + targetPlayer.getDisplayName() + "?e)?f: " + message);
					}
				}
			} else {
				Permissions.semPermiassao(p);
			}
		}
		return false;
	}
}
