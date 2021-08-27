package me.liu.Comando;

import me.liu.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import me.confuser.barapi.*;

public class CommandEvento implements CommandExecutor
{
    Main main;
    int segundos;
    
    public CommandEvento(Main plugin) {
        this.segundos = 15;
        plugin = this.main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Comando para players!");
                return true;
            }
            final Player player = (Player)sender;
            if (player.hasPermission("admin.mod")) {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player pl = onlinePlayers[i];
                    BarAPI.setMessage(pl, " §4§lEvento Rei Da Mesa! §6/§lrdm!", this.segundos);
                }
            }
        }
        return false;
    }
}
