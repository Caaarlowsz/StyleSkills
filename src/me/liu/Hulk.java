package me.liu;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.util.*;
import org.bukkit.command.*;
import me.confuser.barapi.*;
import org.bukkit.*;

public class Hulk implements Listener, CommandExecutor
{
    public static Main plugin;
    static List<Player> cooldown;
    
    static {
        Hulk.cooldown = new ArrayList<Player>();
    }
    
    public Hulk(final Main main) {
        Hulk.plugin = main;
    }
    
    @EventHandler
    public void hulk(final PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Player)) {
            return;
        }
        final ItemStack hulk = new ItemStack(Material.BONE);
        final ItemMeta name323 = hulk.getItemMeta();
        name323.setDisplayName("§2§oStyle Hulk");
        hulk.setItemMeta(name323);
        final Player player = event.getPlayer();
        final Player clicked = (Player)event.getRightClicked();
        if (!Main.hulk.contains(player.getName())) {
            return;
        }
        if (player.getItemInHand().getType() != Material.BONE) {
            return;
        }
        if (Hulk.cooldown.contains(player)) {
            player.sendMessage("§cCooldown Aguarde!");
        }
        else {
            if (player.getPassenger() == null && clicked.getPassenger() == null) {
                player.setPassenger((Entity)clicked);
            }
            Hulk.cooldown.add(player);
            Hulk.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Hulk.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Hulk.cooldown.remove(player);
                }
            }, 500L);
        }
    }
    
    @EventHandler
    public void hulkSmash(final EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        final Player damager = (Player)event.getDamager();
        if (damager.getPassenger() != null) {
            if (!Main.hulk.contains(damager.getName())) {
                return;
            }
            event.setCancelled(true);
            player.setSneaking(true);
            final Vector vec = player.getLocation().getDirection().multiply(2.0f);
            vec.setY(2.0);
            player.setVelocity(vec);
            Hulk.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Hulk.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    player.setSneaking(false);
                }
            }, 1000L);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cHulk");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        final ItemStack hulk = new ItemStack(Material.BONE);
        final ItemMeta name323 = hulk.getItemMeta();
        name323.setDisplayName("§2§oStyle Hulk");
        hulk.setItemMeta(name323);
        if (cmd.equalsIgnoreCase("hulk")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.hulk")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oHulk", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            Main.hulk.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { hulk });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
