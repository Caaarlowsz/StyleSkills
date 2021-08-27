package me.liu;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Jumper implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Jumper(final Main main) {
        Jumper.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Main.jumper.contains(p.getName())) {
            if (e.getAction() != Action.RIGHT_CLICK_AIR) {
                return;
            }
            if (e.getItem().getType() != Material.EYE_OF_ENDER) {
                return;
            }
            final Vector velo1 = p.getLocation().getDirection().normalize().multiply(2);
            velo1.add(new Vector(Math.random() * 0.0 + 0.0, 0.0, 0.0));
            if (Main.reload.contains(p.getName())) {
                p.sendMessage(ChatColor.RED + "Carregando!");
            }
            else {
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
                p.getLocation().getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
                p.getLocation().getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                ((EnderPearl)p.launchProjectile((Class)EnderPearl.class)).setVelocity(velo1);
                Main.reload.add(p.getName());
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Jumper.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.jumper.contains(p.getName())) {
                            p.sendMessage("§aVoce pode atirar novamente!");
                            Main.reload.remove(p.getName());
                        }
                    }
                }, 360L);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cJumper");
        dima.setItemMeta(souperaa);
        final ItemStack sopaa = new ItemStack(Material.EYE_OF_ENDER);
        final ItemMeta sopasa = sopaa.getItemMeta();
        sopasa.setDisplayName("§aTELEPORTER");
        sopaa.setItemMeta(sopasa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("jumper")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.jumper")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            Main.jumper.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oJumper", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { sopaa });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
