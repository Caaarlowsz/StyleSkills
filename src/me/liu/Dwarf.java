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

public class Dwarf implements Listener, CommandExecutor
{
    private HashMap<Player, Long> cooldownExpires;
    private HashMap<Player, Long> startedSneaking;
    protected String isSneaking;
    public int cooldown;
    
    public Dwarf(final Main instance) {
        this.cooldownExpires = new HashMap<Player, Long>();
        this.startedSneaking = new HashMap<Player, Long>();
        this.cooldown = 10;
    }
    
    @EventHandler
    public void onSneak(final PlayerToggleSneakEvent event) {
        final Player p1 = event.getPlayer();
        if (Main.dwarf.contains(p1.getName())) {
            if (this.cooldownExpires.containsKey(p1) && this.cooldownExpires.get(p1) < System.currentTimeMillis()) {
                this.cooldownExpires.remove(p1);
            }
            if (event.isSneaking()) {
                this.startedSneaking.put(p1, System.currentTimeMillis());
            }
            else if (this.startedSneaking.containsKey(p1)) {
                this.cooldownExpires.put(p1, System.currentTimeMillis() + this.cooldown * 1000);
                final long sneakingTime = System.currentTimeMillis() - this.startedSneaking.remove(p1);
                final double knockBack = 0.5 * (sneakingTime / 15L);
                for (final Entity entity : p1.getNearbyEntities(knockBack, knockBack, knockBack)) {
                    if (!(entity instanceof Player) || !((Player)entity).isSneaking()) {
                        final Vector vector = entity.getLocation().toVector().subtract(p1.getLocation().toVector()).normalize();
                        entity.setVelocity(vector.multiply(knockBack));
                    }
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cDwarf");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("dwarf")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.dwarf")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            Main.dwarf.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oDwarf", 5);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().addItem(new ItemStack[] { dima });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
