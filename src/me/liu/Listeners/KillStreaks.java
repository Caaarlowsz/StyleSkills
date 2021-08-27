package me.liu.Listeners;

import me.liu.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class KillStreaks implements Listener
{
    Main plugin;
    
    public KillStreaks(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onKillLevel(final PlayerDeathEvent event) {
        if (!(event.getEntity().getKiller() instanceof Player)) {
            return;
        }
        if (event.getEntity().getKiller() == null) {
            return;
        }
        final Player p = event.getEntity();
        final Player k = p.getKiller();
        k.setLevel(k.getLevel() + 1);
        p.setLevel(0);
    }
    
    @EventHandler
    public void onLevel(final PlayerLevelChangeEvent e) {
        final Player p = e.getPlayer();
        if (e.getNewLevel() == 5) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c5§6!");
            p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
            p.sendMessage("§bVoce ganhou uma bota por ter feito um killstreak de 5!");
        }
        if (e.getNewLevel() == 10) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c10§7!");
        }
        if (e.getNewLevel() == 15) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c15§6!");
            p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
            p.sendMessage("§bVoce ganhou um capacete por ter feito um killstreak de 15!");
        }
        if (e.getNewLevel() == 20) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c20§7!");
        }
        if (e.getNewLevel() == 30) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c30§7!");
            p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
            p.sendMessage("§bVoce ganhou uma cal\u00e7a por ter feito um killstreak de 30!");
        }
        if (e.getNewLevel() == 40) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c40§7!");
        }
        if (e.getNewLevel() == 50) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c50§7!");
        }
        if (e.getNewLevel() == 60) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c60§7!");
            p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            p.sendMessage("§bVoce ganhou um peitoral por ter feito um killstreak de 60!");
        }
        if (e.getNewLevel() == 70) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c70§7!");
        }
        if (e.getNewLevel() == 80) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c80§7!");
        }
        if (e.getNewLevel() == 90) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c90§7!");
        }
        if (e.getNewLevel() == 100) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c100§7!");
        }
        if (e.getNewLevel() == 150) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c150§7!");
        }
        if (e.getNewLevel() == 200) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c200§7!");
        }
        if (e.getNewLevel() == 250) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c250§7!");
        }
        if (e.getNewLevel() == 300) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c300§7!");
        }
        if (e.getNewLevel() == 350) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c350§7!");
        }
        if (e.getNewLevel() == 400) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c400§7!");
        }
        if (e.getNewLevel() == 450) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c450§7!");
        }
        if (e.getNewLevel() == 500) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c500§7!");
            p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
            p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
            p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
            p.sendMessage("§bVoce ganhou um FULL COURO por ter feito um killstreak de 500!");
        }
        if (e.getNewLevel() == 1000) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c1000§7!");
        }
        if (e.getNewLevel() == 1500) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c1500§7!");
        }
        if (e.getNewLevel() == 2000) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getDisplayName() + " §7conseguiu um Killstreak de §c2000§7!");
        }
    }
}
