package me.liu;

import org.bukkit.event.player.*;
import org.bukkit.potion.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.inventory.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class Poseidon implements CommandExecutor, Listener
{
    public static Main plugin;
    
    public Poseidon(final Main main) {
        Poseidon.plugin = main;
    }
    
    @EventHandler
    public void poseidon(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (p.getLocation().getBlock().isLiquid() && p.getLocation().getBlock().getType() == Material.STATIONARY_WATER && Main.poseidon.contains(p.getName())) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
            p.setRemainingAir(20);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cPoseidon");
        dima.setItemMeta(souperaa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6§oSopa");
        sopa.setItemMeta(sopas);
        if (cmd.equalsIgnoreCase("poseidon")) {
            if (Main.used.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
                return true;
            }
            if (!p.hasPermission("kit.poseidon")) {
                BarAPI.setMessage(p, "§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
                return true;
            }
            Main.used.add(p.getName());
            BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oPoseidon", 5);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            Main.poseidon.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { dima });
            for (int i = 0; i <= 34; ++i) {
                p.getInventory().addItem(new ItemStack[] { sopa });
            }
        }
        return false;
    }
}
