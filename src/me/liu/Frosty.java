package me.liu;

import org.bukkit.event.player.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Frosty implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Frosty(final Main main) {
        Frosty.plugin = main;
    }
    
    @EventHandler
    public void frostyEvent(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        if (!event.getFrom().getBlock().getLocation().equals((Object)event.getTo().getBlock().getLocation())) {
            return;
        }
        final Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if (block.getType() == Material.SNOW_BLOCK && Main.frosty.contains(player.getName())) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cFrosty");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("frosty")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.frosty")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oFrosty", 5);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
            Main.frosty.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
