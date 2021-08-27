package me.liu.Comando;

import org.bukkit.command.*;
import org.bukkit.*;

public class CommandBroadcast implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command command, final String commandLabel, final String[] args) {
        if (command.getName().equalsIgnoreCase("anuncio") && Sender.hasPermission("style.anuncio") && args.length > 0) {
            final StringBuffer me = new StringBuffer();
            for (int i = 0; i < args.length; ++i) {
                me.append(String.valueOf(args[i]) + " ");
            }
            Bukkit.broadcastMessage("§4[§aAnuncio§4]§b§o§l " + (Object)me);
        }
        return false;
    }
}
