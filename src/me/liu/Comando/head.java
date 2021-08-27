package me.liu.Comando;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import me.liu.*;

public class head implements CommandExecutor
{
    Main main;
    
    public head(Main plugin) {
        plugin = this.main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "comandos para players");
            return true;
        }
        if (sender instanceof Player) {
            final Player player1 = (Player)sender;
            if (args.length != 0 && args.length == 1) {
                if (player1.hasPermission("admin.mod")) {
                    final ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
                    skullItem.setDurability((short)3);
                    final SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
                    skullMeta.setOwner(args[0]);
                    skullItem.setItemMeta((ItemMeta)skullMeta);
                    player1.getInventory().addItem(new ItemStack[] { skullItem });
                    player1.sendMessage(ChatColor.GREEN + "Voce pegou uma cabe\u00e7a");
                }
                else {
                    Permissions.semPermiassao(player1);
                }
            }
        }
        return false;
    }
}
