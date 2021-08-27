package me.liu;

import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.event.block.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Sopa implements Listener
{
    public static Main plugin;
    
    public Sopa(final Main main) {
        Sopa.plugin = main;
    }
    
    @EventHandler
    public void onInteract1(final PlayerInteractEvent e) {
        final ItemStack tigela = new ItemStack(Material.BOWL, 1);
        final ItemMeta tigelameta = tigela.getItemMeta();
        tigelameta.setDisplayName(ChatColor.GRAY + "Tigela");
        tigela.setItemMeta(tigelameta);
        final Damageable hp;
        final Player p = (Player)(hp = (Damageable)e.getPlayer());
        if (hp.getHealth() != 20.0) {
            final int sopa = 7;
            if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getTypeId() == 282) {
                p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
                p.getItemInHand().setType(Material.BOWL);
                p.getItemInHand().setItemMeta(tigelameta);
            }
        }
    }
}
