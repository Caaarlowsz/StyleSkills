package me.liu;

import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Milkman implements Listener, CommandExecutor
{
    public static Main plugin;
    private transient HashMap<ItemStack, Integer> cooldown;
    public int maxUses;
    public String milkbucketName;
    public String[] potionEffects;
    
    public Milkman(final Main main) {
        this.cooldown = new HashMap<ItemStack, Integer>();
        this.maxUses = 5;
        this.milkbucketName = "§a§lSuper Leite";
        this.potionEffects = new String[] { "REGENERATION 900 0", "FIRE_RESISTANCE 900 0", "SPEED 900 0" };
        Milkman.plugin = main;
    }
    
    @EventHandler
    public void onConsume(final PlayerItemConsumeEvent event) {
        final ItemStack item = event.getItem();
        final Player p = event.getPlayer();
        if (Main.milkman.contains(p.getName())) {
            String[] potionEffects;
            for (int length = (potionEffects = this.potionEffects).length, i = 0; i < length; ++i) {
                final String string = potionEffects[i];
                final String[] effect = string.split(" ");
                final PotionEffect potionEffect = new PotionEffect(PotionEffectType.getByName(effect[0].toUpperCase()), Integer.parseInt(effect[1]), Integer.parseInt(effect[2]));
                p.addPotionEffect(potionEffect, true);
            }
            if (!this.cooldown.containsKey(item)) {
                this.cooldown.put(item, 0);
            }
            this.cooldown.put(item, this.cooldown.get(item) + 1);
            if (this.cooldown.get(item) == this.maxUses) {
                this.cooldown.remove(item);
                event.setCancelled(true);
                p.setItemInHand(new ItemStack(Material.BUCKET, item.getAmount(), item.getDurability()));
            }
            else {
                event.setCancelled(true);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cMilkman");
        dima.setItemMeta(souperaa);
        final ItemStack asd = new ItemStack(Material.MILK_BUCKET);
        final ItemMeta asdd = asd.getItemMeta();
        asdd.setDisplayName("§a§lSuper Leite");
        asd.setItemMeta(asdd);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("milkman")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.milkman")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            Main.milkman.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oMilkman", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { asd });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
