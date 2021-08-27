package me.liu;

import java.util.*;
import org.bukkit.event.player.*;
import me.confuser.barapi.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Spectre implements Listener, CommandExecutor
{
    public static Main plugin;
    static List<String> cooldown;
    
    static {
        Spectre.cooldown = new ArrayList<String>();
    }
    
    public Spectre(final Main main) {
        Spectre.plugin = main;
    }
    
    @EventHandler
    public void spectre(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Main.spectre.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE) {
            event.setCancelled(true);
            if (Spectre.cooldown.contains(p.getName())) {
                BarAPI.setMessage(p, ChatColor.RED + "§oSpectre em cooldown", 1);
            }
            else {
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 400, 1));
                final ItemStack[] armorContents = p.getInventory().getArmorContents();
                p.getInventory().setArmorContents((ItemStack[])null);
                p.updateInventory();
                Spectre.cooldown.add(p.getName());
                Spectre.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Spectre.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Spectre.cooldown.remove(p.getName());
                        p.getInventory().setArmorContents(armorContents);
                    }
                }, 1000L);
                p.sendMessage("§c§oVoce esta invisivel!");
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cSpectre");
        dima.setItemMeta(souperaa);
        final ItemStack spectre = new ItemStack(Material.REDSTONE);
        final ItemMeta spectrea = spectre.getItemMeta();
        spectrea.setDisplayName("§6Spectre Invis");
        spectre.setItemMeta(spectrea);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("spectre")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.spectre")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oSpectre", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            Main.spectre.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { spectre });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
