package me.liu.Comando;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import java.util.logging.*;
import me.liu.*;
import org.bukkit.inventory.*;
import org.bukkit.*;

public class CommandInvSee implements CommandExecutor
{
    public Main plugin;
    
    public CommandInvSee(final Main instance) {
        this.plugin = instance;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("So no jogo console!");
            return true;
        }
        final Logger log = Logger.getLogger("Minecraft");
        final Player player = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("inv")) {
            if (!player.hasPermission("style.opi")) {
                Permissions.semPermiassao((Player)sender);
                return true;
            }
            if (args.length == 1) {
                if (player.getServer().getPlayer(args[0]) != null) {
                    final Player targetplayer = player.getServer().getPlayer(args[0]);
                    player.openInventory((Inventory)targetplayer.getInventory());
                    log.info("[StylePvP] [Commando] " + player.getDisplayName() + ": " + "/" + commandLabel + " " + targetplayer.getDisplayName());
                    player.sendMessage(ChatColor.GRAY + "Abriu o inventario de " + targetplayer.getDisplayName() + ".");
                }
                else {
                    player.sendMessage(ChatColor.RED + "Jogador nao encontrado ele pode esta offline ou nao existir.");
                }
            }
            else if (args.length > 1 || args.length < 1) {
                player.sendMessage(ChatColor.RED + "Erro!");
                player.sendMessage(ChatColor.RED + "Usar: /" + commandLabel + " <jogador>");
            }
        }
        return true;
    }
}
