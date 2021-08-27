package me.liu;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.command.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.meta.*;

public class RobinHood implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public RobinHood(final Main main) {
        RobinHood.plugin = main;
    }
    
    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Arrow && ((Arrow)event.getDamager()).getShooter() instanceof Player) {
            final Arrow arrow = (Arrow)event.getDamager();
            final Player p = (Player)arrow.getShooter();
            p.getLocation().distance(event.getEntity().getLocation());
            if (event.getEntity() instanceof Player && Main.robinhood.contains(p.getName())) {
                p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 1.0f, 1.0f);
                event.setDamage(20.0);
            }
        }
    }
    
    @EventHandler
    public void robinHoodKill(final PlayerDeathEvent event) {
        if (!(event.getEntity().getKiller() instanceof Player)) {
            return;
        }
        if (event.getEntity().getKiller() == null) {
            return;
        }
        if (Main.robinhood.contains(event.getEntity().getKiller().getName())) {
            event.getEntity().getKiller().getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW) });
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cRobinHood");
        dima.setItemMeta(souperaa);
        final ItemStack arco = new ItemStack(Material.BOW);
        final ItemMeta arcoa = arco.getItemMeta();
        arcoa.setDisplayName("§6Robin's Bow");
        arco.setItemMeta(arcoa);
        final ItemStack flecha = new ItemStack(Material.ARROW, 1);
        final ItemMeta flecas = flecha.getItemMeta();
        flecas.setDisplayName("§7Arrow");
        flecha.setItemMeta(flecas);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("robinhood")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.robinhood")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oRobinHood", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 0));
            Main.robinhood.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { arco });
            p.getInventory().addItem(new ItemStack[] { flecha });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
