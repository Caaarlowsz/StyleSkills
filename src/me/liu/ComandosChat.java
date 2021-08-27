package me.liu;

import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class ComandosChat implements CommandExecutor
{
    public Main plugin;
    
    public ComandosChat(final Main main) {
        this.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("chat")) {
            if (args[0].equalsIgnoreCase("clear")) {
                if (sender.hasPermission("derpchat.*") || sender.hasPermission("derpchat.command.*") || sender.hasPermission("derpchat.command.clear")) {
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
                        final Player p = onlinePlayers[j];
                        for (int i = 0; i < 101; ++i) {
                            p.sendMessage("");
                        }
                    }
                    sender.getServer().broadcastMessage("§7O chat foi limpo por §c" + sender.getName());
                }
            }
            else {
                Permissions.semPermiassao((Player)sender);
            }
        }
        return false;
    }
}
