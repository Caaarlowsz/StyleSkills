package me.liu;

import org.bukkit.event.player.*;
import org.bukkit.block.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Fisherman implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Fisherman(final Main main) {
        Fisherman.plugin = main;
    }
    
    @EventHandler
    public void onPlayerFish(final PlayerFishEvent event) {
        final Entity caught = event.getCaught();
        final Block block = event.getHook().getLocation().getBlock();
        if (caught != null && caught != block && Main.fisherman.contains(event.getPlayer().getName())) {
            caught.teleport(event.getPlayer().getLocation());
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cFisherman");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        final ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
        final ItemMeta name3233 = fisherman.getItemMeta();
        name3233.setDisplayName("§2Style Fisherman");
        fisherman.setItemMeta(name3233);
        if (cmd.equalsIgnoreCase("fisherman")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.fisherman")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            Main.fisherman.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oFisherman", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { fisherman });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
