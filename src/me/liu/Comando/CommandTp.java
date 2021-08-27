package me.liu.Comando;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.liu.*;
import org.bukkit.*;

public class CommandTp implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (sender instanceof ConsoleCommandSender) {
                System.out.println("Console nao pode usar esse comando");
                return true;
            }
            final Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Sintaxe Incorreta.");
            }
            else if (args.length == 1) {
                if (p.hasPermission("style.tp") || p.isOp()) {
                    final Player targetPlayer = p.getServer().getPlayer(args[0]);
                    final Location tpLoc = targetPlayer.getLocation();
                    p.teleport(tpLoc);
                    p.sendMessage(ChatColor.YELLOW + "Teleportado para " + targetPlayer.getDisplayName() + ChatColor.YELLOW + ".");
                }
                else {
                    Permissions.semPermiassao(p);
                }
            }
            else if (args.length == 2) {
                if (p.hasPermission("style.tp.otros") || p.isOp()) {
                    final Player targetPlayer = p.getServer().getPlayer(args[0]);
                    final Player targetPlayer2 = p.getServer().getPlayer(args[1]);
                    if (targetPlayer == null || targetPlayer2 == null) {
                        p.sendMessage("§4§oJogador Offline!");
                    }
                    else {
                        final Location tpLoc2 = targetPlayer2.getLocation();
                        targetPlayer.teleport(tpLoc2);
                        p.sendMessage(ChatColor.YELLOW + "Voce foi teleportado " + targetPlayer.getDisplayName() + ChatColor.YELLOW + " para " + targetPlayer2.getDisplayName() + ChatColor.YELLOW + ".");
                    }
                }
                else {
                    Permissions.semPermiassao(p);
                }
            }
        }
        return false;
    }
}
