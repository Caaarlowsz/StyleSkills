package me.liu.Comando;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import me.liu.*;
import org.bukkit.inventory.*;

public class CommandClear implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("limparinv") && args.length == 0) {
            if (p.hasPermission("style.limparinv") || p.isOp()) {
                final Inventory inv = (Inventory)p.getInventory();
                inv.clear();
                p.sendMessage(ChatColor.YELLOW + "Seu inventario foi limpo");
            }
            else {
                Permissions.semPermiassao(p);
            }
        }
        return false;
    }
}
