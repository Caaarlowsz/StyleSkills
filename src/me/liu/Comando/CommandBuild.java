package me.liu.Comando;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.liu.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

public final class CommandBuild implements Listener, CommandExecutor
{
    public static final String prefix = "§7[§aStylePvP§7]§b ";
    private static boolean build;
    
    static {
        CommandBuild.build = false;
    }
    
    public final boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!cmd.getName().equalsIgnoreCase("build")) {
            return false;
        }
        if (!sender.hasPermission("style.build")) {
            Permissions.semPermiassao((Player)sender);
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage("§7[§aStylePvP§7]§b Contruir esta em " + (CommandBuild.build ? (ChatColor.GREEN + "ativado") : (ChatColor.RED + "desativado")));
            sender.sendMessage("§7[§aStylePvP§7]§b Usar: " + ChatColor.RED + "/build [on|off]");
            return true;
        }
        if (args[0].equalsIgnoreCase("on")) {
            CommandBuild.build = true;
            sender.sendMessage("§7[§aStylePvP§7]§b Construir esta agora " + (CommandBuild.build ? (ChatColor.GREEN + "ativado") : (ChatColor.RED + "desativado")));
        }
        else if (args[0].equalsIgnoreCase("off")) {
            CommandBuild.build = false;
            sender.sendMessage("§7[§aStylePvP§7]§b Construir esta agora " + (CommandBuild.build ? (ChatColor.GREEN + "desativado") : (ChatColor.RED + "desativado")));
        }
        else {
            sender.sendMessage("§7[§aStylePvP§7]§b Usar: " + ChatColor.RED + "/build [on|off]");
        }
        return true;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public final void onBlockPlace(final BlockPlaceEvent event) {
        if (!CommandBuild.build) {
            event.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public final void onBlockBreak(final BlockBreakEvent event) {
        if (!CommandBuild.build) {
            event.setCancelled(true);
        }
    }
}
