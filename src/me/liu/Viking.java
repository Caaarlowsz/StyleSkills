package me.liu;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.enchantments.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Viking implements CommandExecutor, Listener
{
    public static Main plugin;
    
    public Viking(final Main main) {
        Viking.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(final PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player && e.getEntity() instanceof Player) {
            final Player killer = e.getEntity().getKiller();
            if (Main.viking.contains(killer.getName())) {
                killer.sendMessage(ChatColor.RED + "Upgrade no machado!");
                killer.getItemInHand().addEnchantment(Enchantment.DAMAGE_ALL, killer.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL) + 1);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.STONE_AXE);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cViking Axe");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("viking")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.viking")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            Main.viking.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6Viking", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_BARDING) });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
