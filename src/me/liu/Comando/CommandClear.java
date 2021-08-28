package me.liu.Comando;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.liu.Permissions;

public class CommandClear implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("limparinv") && args.length == 0) {
			if (p.hasPermission("style.limparinv") || p.isOp()) {
				final Inventory inv = (Inventory) p.getInventory();
				inv.clear();
				p.sendMessage(ChatColor.YELLOW + "Seu inventario foi limpo");
			} else {
				Permissions.semPermiassao(p);
			}
		}
		return false;
	}
}
