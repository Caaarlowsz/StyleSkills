package me.liu;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Viper implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Viper(final Main main) {
        Viper.plugin = main;
    }
    
    @EventHandler
    public void viperEvent(final EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getDamager();
        final Player player2 = (Player)event.getEntity();
        if (!Main.viper.contains(player.getName())) {
            return;
        }
        if (Math.random() > 0.4 && Math.random() < 0.1) {
            player2.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 1));
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cViper");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("viper")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.viper")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oViper", 5);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
            Main.viper.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
