package me.liu.Comando;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.liu.*;
import org.bukkit.*;

public class CommandVoar implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String cmdLabel, final String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("voar")) {
                final Player player = (Player)sender;
                if (args.length == 0) {
                    if (sender.hasPermission("style.voar.usar")) {
                        if (!player.getAllowFlight()) {
                            player.sendMessage(ChatColor.GREEN + "Voo Habilitado");
                            player.setAllowFlight(true);
                        }
                        else {
                            sender.sendMessage(ChatColor.GREEN + "Voo Desabilitado");
                            player.setAllowFlight(false);
                        }
                    }
                    else {
                        Permissions.semPermiassao((Player)sender);
                    }
                }
                if (args.length == 1) {
                    if (sender.hasPermission("style.voar.set")) {
                        final Player player2 = Bukkit.getPlayer(args[0]);
                        if (player2 == null) {
                            sender.sendMessage(ChatColor.RED + "Jogador Offline");
                            return true;
                        }
                        if (!player.getAllowFlight()) {
                            sender.sendMessage(ChatColor.GREEN + "Voo Habilitado para " + player2.getName());
                            player2.setAllowFlight(true);
                            player2.sendMessage(ChatColor.GREEN + "Voo Habilitado por " + player.getName());
                        }
                        else {
                            sender.sendMessage(ChatColor.GREEN + "Voo Desabilitado para " + player2.getName());
                            player.setAllowFlight(false);
                            player2.sendMessage(ChatColor.GREEN + "Voo Desabilitado por " + player.getName());
                        }
                    }
                    else {
                        Permissions.semPermiassao((Player)sender);
                    }
                }
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "Voc\u00ea deve ser um usu\u00e1rio!");
        }
        return false;
    }
}
