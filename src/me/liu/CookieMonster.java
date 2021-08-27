package me.liu;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class CookieMonster implements Listener, CommandExecutor
{
    public static Main plugin;
    private HashMap<Player, Long> cookieExpires;
    public int delayInMillisecondsBetweenCookies;
    
    public CookieMonster(final Main main) {
        this.cookieExpires = new HashMap<Player, Long>();
        this.delayInMillisecondsBetweenCookies = 500;
        CookieMonster.plugin = main;
    }
    
    @EventHandler
    public void onChomp(final PlayerInteractEvent event) {
        if (event.getAction().name().contains("RIGHT")) {
            final Player p = event.getPlayer();
            if ((!this.cookieExpires.containsKey(p) || this.cookieExpires.get(p) < System.currentTimeMillis()) && event.getItem() != null && event.getItem().getType() == Material.COOKIE) {
                event.setCancelled(true);
                if (p.getHealth() < 20.0) {
                    double hp = p.getHealth() + 1.0;
                    if (hp > 20.0) {
                        hp = 20.0;
                    }
                    p.setHealth((double)(int)hp);
                }
                else if (p.getFoodLevel() < 20) {
                    p.setFoodLevel(p.getFoodLevel() + 1);
                }
                else {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1), true);
                }
                event.getItem().setAmount(event.getItem().getAmount() - 1);
                if (event.getItem().getAmount() == 0) {
                    p.setItemInHand(new ItemStack(0));
                }
                this.cookieExpires.put(p, System.currentTimeMillis() + this.delayInMillisecondsBetweenCookies);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cCookieMonster");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        final ItemStack cookie = new ItemStack(Material.COOKIE, 64);
        final ItemMeta cookiea = cookie.getItemMeta();
        cookiea.setDisplayName("§6Cookie's");
        cookie.setItemMeta(cookiea);
        if (cmd.equalsIgnoreCase("cookiemonster")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.cookiemonster")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            Main.cookiemonster.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oCookieMonster", 5);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { cookie });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
