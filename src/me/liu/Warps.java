package me.liu;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import me.confuser.barapi.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.*;

public class Warps implements CommandExecutor
{
    Main plugin;
    
    public Warps(final Main plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(final CommandSender Sender, final Command command, final String commandLabel, final String[] args) {
        final Player player = (Player)Sender;
        if (command.getName().equalsIgnoreCase("spawn")) {
            if (!Main.used.contains(player.getName())) {
                player.removePotionEffect(PotionEffectType.ABSORPTION);
                player.removePotionEffect(PotionEffectType.BLINDNESS);
                player.removePotionEffect(PotionEffectType.CONFUSION);
                player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                player.removePotionEffect(PotionEffectType.HARM);
                player.removePotionEffect(PotionEffectType.HEAL);
                player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                player.removePotionEffect(PotionEffectType.HUNGER);
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                player.removePotionEffect(PotionEffectType.JUMP);
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.removePotionEffect(PotionEffectType.POISON);
                player.removePotionEffect(PotionEffectType.REGENERATION);
                player.removePotionEffect(PotionEffectType.SATURATION);
                player.removePotionEffect(PotionEffectType.SLOW);
                player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                player.removePotionEffect(PotionEffectType.SPEED);
                player.removePotionEffect(PotionEffectType.WATER_BREATHING);
                player.removePotionEffect(PotionEffectType.WEAKNESS);
                player.removePotionEffect(PotionEffectType.WITHER);
                player.getInventory().setArmorContents((ItemStack[])null);
                player.teleport(player.getWorld().getSpawnLocation());
                player.getInventory().clear();
                player.teleport(player.getWorld().getSpawnLocation());
                BarAPI.setMessage(player, "§bVoce foi teleportado para §7§oSpawn", 3);
            }
            else {
                player.sendMessage(ChatColor.RED + "Voce ja escolheu um kit. Voce nao pode ir ao Spawn.");
            }
        }
        else if (command.getName().equalsIgnoreCase("fps")) {
            if (!Main.used.contains(player.getName())) {
                player.performCommand("pvp");
                player.teleport(new Location(player.getWorld(), 863.5, 146.9, -678.5));
                BarAPI.setMessage(player, "§bVoce foi teleportado para §7§lFPS", 4);
            }
            else {
                player.sendMessage(ChatColor.RED + "Voce ja escolheu um kit. Digite /suicide para ir ao FPS.");
            }
        }
        else if (command.getName().equalsIgnoreCase("earlyhg")) {
            if (!Main.used.contains(player.getName())) {
                player.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
                player.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
                player.getPlayer().removePotionEffect(PotionEffectType.CONFUSION);
                player.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                player.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
                player.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                player.getPlayer().removePotionEffect(PotionEffectType.HARM);
                player.getPlayer().removePotionEffect(PotionEffectType.HEAL);
                player.getPlayer().removePotionEffect(PotionEffectType.HEALTH_BOOST);
                player.getPlayer().removePotionEffect(PotionEffectType.HUNGER);
                player.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
                player.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                player.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.getPlayer().removePotionEffect(PotionEffectType.POISON);
                player.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
                player.getPlayer().removePotionEffect(PotionEffectType.SATURATION);
                player.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                player.getPlayer().removePotionEffect(PotionEffectType.SLOW_DIGGING);
                player.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                player.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
                player.getPlayer().removePotionEffect(PotionEffectType.WEAKNESS);
                player.getPlayer().removePotionEffect(PotionEffectType.WITHER);
                player.getPlayer().getInventory().setArmorContents((ItemStack[])null);
                player.getPlayer().teleport(new Location(player.getPlayer().getWorld(), 1099.3, 77.9, 1001.6));
                player.getPlayer().getInventory().clear();
                final ItemStack kits = new ItemStack(Material.CHEST);
                final ItemMeta kitsm = kits.getItemMeta();
                kitsm.setDisplayName("§4Veja os Kits");
                final ArrayList<String> archerlore = new ArrayList<String>();
                archerlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
                archerlore.add("§b-Clique para abrir o menu de kits!");
                archerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
                kitsm.setLore((List)archerlore);
                kits.setItemMeta(kitsm);
                player.getInventory().setItem(0, kits);
                final ItemStack kitsa = new ItemStack(Material.EMERALD);
                final ItemMeta kitsma = kitsa.getItemMeta();
                kitsma.setDisplayName("§aShop");
                final ArrayList<String> archerlorea = new ArrayList<String>();
                archerlorea.add("§7*-*-*-*-*-*-*-*-*-**-*");
                archerlorea.add("§b-Em Breve!");
                archerlorea.add("§7-*-*-*-*-*-*-*-*-*-*");
                kitsma.setLore((List)archerlorea);
                kitsa.setItemMeta(kitsma);
                player.getInventory().setItem(8, kitsa);
                BarAPI.setMessage(player, "§bVoce foi teleportado para §7§lEarlyHG", 4);
            }
            else {
                player.sendMessage(ChatColor.RED + "Voce nao pode ir para earlyhg com kits!");
            }
        }
        else if (command.getName().equalsIgnoreCase("main")) {
            if (!Main.used.contains(player.getName())) {
                final PlayerInventory inv = player.getInventory();
                player.getInventory().clear();
                final ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
                final ItemMeta souperaa = dima.getItemMeta();
                souperaa.setDisplayName("§cMain");
                dima.setItemMeta(souperaa);
                dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
                final ItemMeta sopas = sopa.getItemMeta();
                sopas.setDisplayName("§6§oSopa");
                sopa.setItemMeta(sopas);
                player.getInventory().addItem(new ItemStack[] { dima });
                for (int i = 0; i <= 34; ++i) {
                    player.getInventory().addItem(new ItemStack[] { sopa });
                }
                final ItemStack ahelm = new ItemStack(Material.IRON_HELMET);
                final ItemStack achest = new ItemStack(Material.IRON_CHESTPLATE);
                final ItemStack alegs = new ItemStack(Material.IRON_LEGGINGS);
                final ItemStack aboots = new ItemStack(Material.IRON_BOOTS);
                final ItemStack[] armor = { aboots, alegs, achest, ahelm };
                inv.setArmorContents(armor);
                player.teleport(new Location(player.getWorld(), 800.5, 118.9, -52.3));
                BarAPI.setMessage(player, "§bVoce foi teleportado para §7§oMain", 3);
            }
            else {
                player.sendMessage(ChatColor.RED + "Voce ja escolheu um kit. Digite /suicide para ir a Main.");
            }
        }
        else if (command.getName().equalsIgnoreCase("challenge")) {
            if (!Main.used.contains(player.getName())) {
                player.performCommand("pvp");
                player.teleport(new Location(player.getWorld(), 125.5, 92.9, 457.5));
                BarAPI.setMessage(player, "§bVoce foi teleportado para §7§oLava Challange", 3);
            }
            else {
                player.sendMessage(ChatColor.RED + "Voce ja escolheu um kit. Digite /suicide para ir ao LavaChallange.");
            }
        }
        else if (command.getName().equalsIgnoreCase("rdm")) {
            if (!Main.used.contains(player.getName())) {
                player.performCommand("pvp");
                player.teleport(new Location(player.getWorld(), 60.5, 61.9, -478.6));
                BarAPI.setMessage(player, "§bVoce foi teleportado para §7§oRDM", 3);
            }
            else {
                player.sendMessage(ChatColor.RED + "Voce ja escolheu um kit. Digite /suicide para ir ao RDM.");
            }
        }
        else if (command.getName().equalsIgnoreCase("mdr")) {
            if (!Main.used.contains(player.getName())) {
                player.performCommand("pvp");
                player.teleport(new Location(player.getWorld(), -284.0, 154.9, -800.0));
                BarAPI.setMessage(player, "§bVoce foi teleportado para §7§oMae da Rua", 3);
            }
            else {
                player.sendMessage(ChatColor.RED + "Voce ja escolheu um kit. Digite /suicide para ir ao Mae da Rua.");
            }
        }
        return false;
    }
}
