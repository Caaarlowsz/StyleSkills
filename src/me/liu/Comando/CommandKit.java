package me.liu.Comando;

import me.liu.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;

public class CommandKit implements CommandExecutor
{
    public static Main plugin;
    
    public CommandKit(final Main main) {
        CommandKit.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sMeta = sopa.getItemMeta();
        sMeta.setDisplayName(ChatColor.AQUA + "Sopa");
        sopa.setItemMeta(sMeta);
        final Player player = (Player)sender;
        if (commandLabel.equalsIgnoreCase("kit") || commandLabel.equalsIgnoreCase("kits")) {
            final StringBuilder free = new StringBuilder();
            final StringBuilder other = new StringBuilder();
            final String[] Kits = { "PvP", "Archer", "Kangaroo", "Fisherman", "Backpacker", "Timelord", "Snail", "Frosty", "Tank", "Viper", "Rider", "Milkman", "Cultivator", "Specialist", "Stomper", "Poseidon", "CookieMonster", "Viking", "Vampire", "Hulk", "Berserker", "Monk", "Camel", "Anchor", "Switcher", "Grappler", "Turtle", "Flash", "Thor", "Snowman", "Healer", "Sonic", "Neo", "Phantom", "Endermage", "Urgal", "Lifeline", "Gambler", "Darkmage", "Spectre", "Zombie", "Salamander", "Reaper", "Chemist", "Pyro", "Macaco" };
            String[] array;
            for (int length = (array = Kits).length, i = 0; i < length; ++i) {
                final String kit = array[i];
                if (player.hasPermission("kit." + kit.toLowerCase())) {
                    free.append(ChatColor.WHITE + kit + ChatColor.GREEN + ", ");
                }
                else {
                    other.append(ChatColor.WHITE + kit + ChatColor.RED + ", ");
                }
            }
            if (free.length() == 0) {
                player.sendMessage(ChatColor.DARK_GREEN + "Seus Kits : " + ChatColor.WHITE + "Voce nao tem nenhum kit!");
            }
            else {
                player.sendMessage(ChatColor.DARK_GREEN + "Seus Kits : " + free.toString());
            }
            if (other.length() == 0) {
                player.sendMessage(ChatColor.DARK_RED + "Outros Kits : " + ChatColor.WHITE + "Voce tem todos os kits!");
            }
            else {
                player.sendMessage(ChatColor.DARK_RED + "Outros Kits : " + other.toString());
            }
        }
        return false;
    }
}
