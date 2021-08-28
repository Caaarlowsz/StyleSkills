package me.liu.Comando;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTag implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tags")) {
			p.sendMessage(
					"§2/tag §7Normal §2| §a§oVip §2| §6§oEterno §2| §b§oYoutuber §2| §5Mod §2| §5§oMod+ §2| §3§oBuilder §2| §c Admin §2| §c§oOrganizador §2| §4§oDono§2|");
		}
		return true;
	}
}
