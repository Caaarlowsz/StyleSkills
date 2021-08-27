package me.liu;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.util.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Skeleton implements Listener, CommandExecutor
{
    private Main plugin;
    
    public Skeleton(final Main instance) {
        this.plugin = instance;
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Main.skeleton.contains(p.getName())) {
            if (e.getAction() != Action.RIGHT_CLICK_AIR) {
                return;
            }
            if (e.getItem().getType() != Material.BONE) {
                return;
            }
            final Vector velo2 = p.getLocation().getDirection().normalize().multiply(100);
            velo2.add(new Vector(Math.random() * 0.0 - 0.0, 0.0, 0.0));
            if (Main.reload.contains(p.getName())) {
                p.sendMessage(ChatColor.RED + "Recarregando...");
            }
            else {
                p.playSound(p.getLocation(), Sound.SKELETON_WALK, 6.0f, 6.0f);
                p.getEyeLocation().getWorld().playEffect(p.getLocation(), Effect.BOW_FIRE, 50000, 10000);
                p.getLocation().getWorld().playEffect(p.getLocation(), Effect.ZOMBIE_CHEW_IRON_DOOR, 10000, 10000);
                p.getLocation().getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 10000, 10000);
                p.getLocation().getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 100000, 10000);
                p.getLocation().getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, (Object)Material.REDSTONE_WIRE);
                ((Arrow)p.launchProjectile((Class)Arrow.class)).setVelocity(velo2);
                Main.reload.add(p.getName());
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_DEATH, 1.0f, 1.0f);
                        }
                    }
                }, 10L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 20L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 30L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 40L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 60L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 70L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 80L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 90L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 100L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 110L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 120L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 130L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 140L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 160L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 170L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 180L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 190L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 200L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 210L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 220L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 230L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 240L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 250L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 260L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 270L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 280L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 290L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
                        }
                    }
                }, 300L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (Main.skeleton.contains(p.getName())) {
                            p.setExp(1.0f);
                            p.playSound(p.getLocation(), Sound.SKELETON_IDLE, 2.0f, 2.0f);
                            Main.reload.remove(p.getName());
                        }
                    }
                }, 300L);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow) {
            final Arrow s = (Arrow)e.getDamager();
            final Player damaged = (Player)e.getEntity();
            if (s.getShooter() instanceof Player) {
                final Player shooter = (Player)s.getShooter();
                if (shooter.getItemInHand().getType() == Material.BONE) {
                    e.setDamage(999.0);
                    damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.STEP_SOUND, (Object)Material.REDSTONE_WIRE);
                    damaged.getEyeLocation().getWorld().playEffect(damaged.getLocation(), Effect.BOW_FIRE, 50000, 10000);
                    damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.ZOMBIE_CHEW_IRON_DOOR, 10000, 10000);
                    damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.BLAZE_SHOOT, 10000, 10000);
                    damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.ENDER_SIGNAL, 100000, 10000);
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("�cSkeleton");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("�6�oSopa");
        sopa.setItemMeta(sopas);
        final ItemStack skeleton = new ItemStack(Material.BONE);
        final ItemMeta skeletonv = skeleton.getItemMeta();
        skeletonv.setDisplayName("�6�oSkeleton");
        skeleton.setItemMeta(skeletonv);
        if (cmd.equalsIgnoreCase("skeleton")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "�cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.skeleton")) {
                BarAPI.setMessage(p, "�c�oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "�bVoce escolheu o kit: �6�oSkeleton", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            Main.skeleton.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { skeleton });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
