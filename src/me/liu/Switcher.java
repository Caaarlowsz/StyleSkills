package me.liu;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Switcher implements Listener, CommandExecutor
{
    public static Main plugin;
    public long cooldownLenght;
    
    public Switcher(final Main main) {
        this.cooldownLenght = 0L;
        Switcher.plugin = main;
    }
    
    @EventHandler
    public void snowball(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Egg && e.getEntity() instanceof Player) {
            final Egg s = (Egg)e.getDamager();
            final Player shooter = (Player)s.getShooter();
            if (s.getShooter() instanceof Player && Main.switcher.contains(shooter.getName())) {
                if (this.hasCooldown1()) {
                    shooter.sendMessage("§cFaltam " + this.cooldownTimeRemaining1() + " para o cooldown acabar!");
                    return;
                }
                final Location shooterLoc = shooter.getLocation();
                shooter.teleport(e.getEntity().getLocation());
                e.getEntity().teleport(shooterLoc);
                this.addCooldown1(shooter, 10);
            }
        }
    }
    
    public void addCooldown1(final Player player, final int seconds) {
        this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
    }
    
    public String cooldownTimeRemaining1() {
        final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
        if (faltam < 60L) {
            return String.valueOf(faltam) + " segundos restantes";
        }
        return String.valueOf(faltam) + " minutos restantes";
    }
    
    public boolean hasCooldown1() {
        return this.cooldownLenght > System.currentTimeMillis();
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cSwitcher");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        final ItemStack switcher = new ItemStack(Material.EGG, 10);
        final ItemMeta nam = switcher.getItemMeta();
        nam.setDisplayName("§6§oSwitcher's Ball");
        switcher.setItemMeta(nam);
        if (cmd.equalsIgnoreCase("switcher")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.switcher")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            Main.switcher.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oSwitcher", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { switcher });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
