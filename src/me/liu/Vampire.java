package me.liu;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Vampire implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Vampire(final Main main) {
        Vampire.plugin = main;
    }
    
    @EventHandler
    public void vampireDeath(final PlayerDeathEvent event) {
        if (!(event.getEntity().getKiller() instanceof Player)) {
            return;
        }
        if (event.getEntity().getKiller() == null) {
            return;
        }
        if (Main.vampire.contains(event.getEntity().getKiller().getName())) {
            event.getEntity().getKiller().setHealth(20.0);
            event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 120, 1));
            final Potion potion = new Potion(PotionType.INSTANT_DAMAGE, 1, true);
            event.getEntity().getKiller().getInventory().addItem(new ItemStack[] { potion.toItemStack(1) });
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cVampire");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("vampire")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.vampire")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oVampire", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            Main.vampire.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            final Potion potion = new Potion(PotionType.INSTANT_DAMAGE, 1, true);
            p.getInventory().addItem(new ItemStack[] { potion.toItemStack(1) });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
