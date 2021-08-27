package me.liu;

import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.potion.*;
import org.bukkit.block.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Camel implements Listener, CommandExecutor
{
    public static Main plugin;
    static List<Player> cooldown;
    
    static {
        Camel.cooldown = new ArrayList<Player>();
    }
    
    public Camel(final Main main) {
        Camel.plugin = main;
    }
    
    @EventHandler
    public void camelEvent(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        if (!event.getFrom().getBlock().getLocation().equals((Object)event.getTo().getBlock().getLocation())) {
            return;
        }
        final Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if (block.getType() == Material.SAND && Main.camel.contains(player.getName())) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 0));
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cCamel");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("camel")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.camel")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oCamel", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            Main.camel.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
