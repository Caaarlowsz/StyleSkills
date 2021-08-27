package me.liu;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Launcher implements Listener, CommandExecutor
{
    public static Main plugin;
    public long cooldownLenght;
    
    public Launcher(final Main main) {
        this.cooldownLenght = 0L;
        Launcher.plugin = main;
    }
    
    @EventHandler
    public void eventLauncher(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player clicked = (Player)e.getRightClicked();
            if (Main.launcher.contains(p.getName())) {
                if (this.hasCooldown()) {
                    p.sendMessage("§cFaltam " + this.cooldownTimeRemaining() + " para o cooldown acabar!");
                    return;
                }
                clicked.setVelocity(clicked.getVelocity().setY(2.0));
                this.addCooldown(p, 30);
            }
        }
    }
    
    public void addCooldown(final Player player, final int seconds) {
        this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
    }
    
    public String cooldownTimeRemaining() {
        final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
        if (faltam < 60L) {
            return String.valueOf(faltam) + " segundos restantes";
        }
        return String.valueOf(faltam) + " minutos restantes";
    }
    
    public boolean hasCooldown() {
        return this.cooldownLenght > System.currentTimeMillis();
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cLauncher");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("launcher")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.launcher")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oLauncher", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            Main.launcher.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
