package me.liu;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Vacuum implements Listener, CommandExecutor
{
    public static Main plugin;
    public long cooldownLenght;
    
    public Vacuum(final Main main) {
        this.cooldownLenght = 0L;
        Vacuum.plugin = main;
    }
    
    @EventHandler
    public void onVacuum(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Main.vacuum.contains(p.getName()) && p.getItemInHand().getType().equals((Object)Material.EYE_OF_ENDER)) {
            for (final Entity targetplayer : p.getNearbyEntities(15.0, 15.0, 15.0)) {
                final Entity nearby = targetplayer;
                if (!(targetplayer instanceof Player)) {
                    return;
                }
                if (this.hasCooldown3()) {
                    p.sendMessage("§cFaltam " + this.cooldownTimeRemaining3() + " para o cooldown acabar!");
                    return;
                }
                final Location lc = targetplayer.getLocation();
                final Location to = p.getLocation();
                lc.setY(lc.getY() + 0.5);
                final double g = -0.08;
                final double t;
                final double d = t = to.distance(lc);
                final double v_x = (1.0 + 0.17 * t) * (to.getX() - lc.getX()) / t;
                final double v_y = (1.0 + 0.03 * t) * (to.getY() - lc.getY()) / t - 0.5 * g * t;
                final double v_z = (1.0 + 0.17 * t) * (to.getZ() - lc.getZ()) / t;
                final Vector v = p.getVelocity();
                v.setX(v_x);
                v.setY(v_y);
                v.setZ(v_z);
                targetplayer.setVelocity(v);
                p.sendMessage("§6§lVoce puxou esta puxando!");
                this.addCooldown3(p, 10);
            }
        }
    }
    
    public void addCooldown3(final Player player, final int seconds) {
        this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
    }
    
    public String cooldownTimeRemaining3() {
        final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
        if (faltam < 60L) {
            return String.valueOf(faltam) + " segundos restantes";
        }
        return String.valueOf(faltam) + " minutos restantes";
    }
    
    public boolean hasCooldown3() {
        return this.cooldownLenght > System.currentTimeMillis();
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cVacuum");
        dima.setItemMeta(souperaa);
        final ItemStack puxador = new ItemStack(Material.EYE_OF_ENDER);
        final ItemMeta puxadora = puxador.getItemMeta();
        puxadora.setDisplayName("§aPuxador");
        puxador.setItemMeta(puxadora);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("vacuum")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.vacuum")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oVacuum", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            Main.vacuum.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { puxador });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
