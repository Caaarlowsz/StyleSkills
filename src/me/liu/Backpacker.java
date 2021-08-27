package me.liu;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import me.confuser.barapi.*;
import org.bukkit.plugin.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Backpacker implements Listener, CommandExecutor
{
    public static Main plugin;
    static List<Player> cooldownbk;
    
    static {
        Backpacker.cooldownbk = new ArrayList<Player>();
    }
    
    public Backpacker(final Main main) {
        Backpacker.plugin = main;
    }
    
    @EventHandler
    public void backpackerKit(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (p.getItemInHand().getType() == Material.LEATHER && Main.backpacker.contains(p.getName())) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Backpacker.cooldownbk.contains(p)) {
                BarAPI.setMessage(p, ChatColor.RED + "Backpacker cooldown", 1);
            }
            else {
                final Inventory v = Bukkit.createInventory((InventoryHolder)null, 27, "§e§oBackpack");
                for (int i = 0; i < 27; ++i) {
                    v.addItem(new ItemStack[] { new ItemStack(sopa) });
                }
                event.getPlayer().openInventory(v);
                Backpacker.cooldownbk.add(p);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Backpacker.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Backpacker.cooldownbk.remove(p);
                    }
                }, 750L);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cBackpacker");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        final ItemStack backpacker = new ItemStack(Material.LEATHER);
        final ItemMeta backpackera = backpacker.getItemMeta();
        backpackera.setDisplayName("§1§oMochila");
        backpacker.setItemMeta(backpackera);
        if (cmd.equalsIgnoreCase("backpacker")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.backpacker")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            Main.backpacker.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oBackPacker", 5);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { backpacker });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
