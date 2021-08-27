package me.liu;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import java.util.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Freeze implements Listener, CommandExecutor
{
    public Freeze(final Main instance) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.STONE_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cGladiator");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        final ItemStack rod = new ItemStack(Material.TORCH);
        final ItemMeta rodMeta = rod.getItemMeta();
        rodMeta.setDisplayName(ChatColor.DARK_AQUA + "MAGIC WAND");
        final List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_PURPLE + "Acerte a bola de neve");
        lore.add(ChatColor.DARK_PURPLE + "no jogador para ele fica preso!");
        rodMeta.setLore((List)lore);
        rod.setItemMeta(rodMeta);
        if (cmd.equalsIgnoreCase("magico")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.magico")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            Main.kitfreeze.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oMagico", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { rod });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
