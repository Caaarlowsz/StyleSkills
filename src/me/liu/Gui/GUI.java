package me.liu.Gui;

import me.liu.*;
import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import java.util.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;

public class GUI implements CommandExecutor, Listener
{
    public Main plugin;
    public static Inventory kits;
    
    static {
        GUI.kits = Bukkit.createInventory((InventoryHolder)null, 54, "§aFree Kits:");
    }
    
    public GUI(final Main instance) {
        this.plugin = instance;
    }
    
    @EventHandler
    public void Click(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
            final Inventory inv = e.getInventory();
            final Player p = (Player)e.getWhoClicked();
            if (inv.getTitle().equals("§aFree Kits:")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7-")) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("-")) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAvancar -->")) {
                    Bukkit.dispatchCommand((CommandSender)p, "kitvip");
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPvP")) {
                    Bukkit.dispatchCommand((CommandSender)p, "pvp");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bArcher")) {
                    Bukkit.dispatchCommand((CommandSender)p, "archer");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bKangaroo")) {
                    Bukkit.dispatchCommand((CommandSender)p, "kangaroo");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFisherman")) {
                    Bukkit.dispatchCommand((CommandSender)p, "fisherman");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bBackpacker")) {
                    Bukkit.dispatchCommand((CommandSender)p, "backpacker");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFrosty")) {
                    Bukkit.dispatchCommand((CommandSender)p, "frosty");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bMilkman")) {
                    Bukkit.dispatchCommand((CommandSender)p, "milkman");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCultivator")) {
                    Bukkit.dispatchCommand((CommandSender)p, "cultivator");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCamel")) {
                    Bukkit.dispatchCommand((CommandSender)p, "camel");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (commandLabel.equalsIgnoreCase("kits") || (commandLabel.equalsIgnoreCase("kit") && p.hasPermission("kitmenu.normal"))) {
            GUI.kits.clear();
            p.playSound(p.getLocation(), Sound.NOTE_PIANO, 10.0f, 5.0f);
            final ItemStack glass = new ItemStack(Material.THIN_GLASS);
            final ItemMeta glassmeta = glass.getItemMeta();
            glassmeta.setDisplayName("§7-");
            glass.setItemMeta(glassmeta);
            GUI.kits.setItem(1, glass);
            GUI.kits.setItem(2, glass);
            GUI.kits.setItem(3, glass);
            GUI.kits.setItem(5, glass);
            GUI.kits.setItem(6, glass);
            GUI.kits.setItem(7, glass);
            GUI.kits.setItem(9, glass);
            GUI.kits.setItem(10, glass);
            GUI.kits.setItem(16, glass);
            GUI.kits.setItem(17, glass);
            GUI.kits.setItem(18, glass);
            GUI.kits.setItem(19, glass);
            GUI.kits.setItem(20, glass);
            GUI.kits.setItem(21, glass);
            GUI.kits.setItem(22, glass);
            GUI.kits.setItem(23, glass);
            GUI.kits.setItem(24, glass);
            GUI.kits.setItem(25, glass);
            GUI.kits.setItem(26, glass);
            GUI.kits.setItem(27, glass);
            GUI.kits.setItem(28, glass);
            GUI.kits.setItem(29, glass);
            GUI.kits.setItem(30, glass);
            GUI.kits.setItem(31, glass);
            GUI.kits.setItem(32, glass);
            GUI.kits.setItem(33, glass);
            GUI.kits.setItem(34, glass);
            GUI.kits.setItem(35, glass);
            GUI.kits.setItem(36, glass);
            GUI.kits.setItem(37, glass);
            GUI.kits.setItem(38, glass);
            GUI.kits.setItem(39, glass);
            GUI.kits.setItem(40, glass);
            GUI.kits.setItem(41, glass);
            GUI.kits.setItem(42, glass);
            GUI.kits.setItem(43, glass);
            GUI.kits.setItem(44, glass);
            GUI.kits.setItem(45, glass);
            GUI.kits.setItem(46, glass);
            GUI.kits.setItem(47, glass);
            GUI.kits.setItem(48, glass);
            GUI.kits.setItem(49, glass);
            GUI.kits.setItem(50, glass);
            GUI.kits.setItem(51, glass);
            GUI.kits.setItem(52, glass);
            GUI.kits.setItem(53, glass);
            final ItemStack a = new ItemStack(Material.CARPET);
            final ItemMeta aa = a.getItemMeta();
            aa.setDisplayName("-");
            a.setItemMeta(aa);
            GUI.kits.setItem(0, a);
            final ItemStack po = new ItemStack(Material.getMaterial(289));
            final ItemMeta pom = po.getItemMeta();
            pom.setDisplayName("-");
            po.setItemMeta(pom);
            GUI.kits.setItem(4, po);
            final ItemStack av = new ItemStack(Material.CARPET);
            final ItemMeta ava = av.getItemMeta();
            ava.setDisplayName("§aAvancar -->");
            av.setItemMeta(ava);
            GUI.kits.setItem(8, av);
            final ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
            final ItemMeta pvpmeta = pvp.getItemMeta();
            pvpmeta.setDisplayName("§bPvP");
            final ArrayList<String> pvplore = new ArrayList<String>();
            pvplore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            pvplore.add("§7-§7Habilidade §7- Nenhuma");
            pvplore.add("§7-*-*-*-*-*-*-*-*-*-*");
            pvpmeta.setLore((List)pvplore);
            pvp.setItemMeta(pvpmeta);
            GUI.kits.setItem(11, pvp);
            final ItemStack archer = new ItemStack(Material.BOW);
            final ItemMeta archermeta = archer.getItemMeta();
            archermeta.setDisplayName("§bArcher");
            final ArrayList<String> archerlore = new ArrayList<String>();
            archerlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            archerlore.add("§7-§7Habilidade §7- Taque Flechas!");
            archerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            archermeta.setLore((List)archerlore);
            archer.setItemMeta(archermeta);
            GUI.kits.setItem(12, archer);
            final ItemStack kangaroo = new ItemStack(Material.FIREWORK);
            final ItemMeta kangaroometa = kangaroo.getItemMeta();
            kangaroometa.setDisplayName("§bKangaroo");
            final ArrayList<String> kangaroolore = new ArrayList<String>();
            kangaroolore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            kangaroolore.add("§7-§7Habilidade §7- De boost com o Firework!");
            kangaroolore.add("§7-*-*-*-*-*-*-*-*-*-*");
            kangaroometa.setLore((List)kangaroolore);
            kangaroo.setItemMeta(kangaroometa);
            GUI.kits.setItem(13, kangaroo);
            final ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
            final ItemMeta fishermanmeta = fisherman.getItemMeta();
            fishermanmeta.setDisplayName("§bFisherman");
            final ArrayList<String> fishermanlore = new ArrayList<String>();
            fishermanlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            fishermanlore.add("§7-§7Habilidade §7- Puxe com uma vara!");
            fishermanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            fishermanmeta.setLore((List)fishermanlore);
            fisherman.setItemMeta(fishermanmeta);
            GUI.kits.setItem(14, fisherman);
            final ItemStack camel = new ItemStack(Material.SAND);
            final ItemMeta camelmeta = camel.getItemMeta();
            camelmeta.setDisplayName("§bCamel");
            final ArrayList<String> camellore = new ArrayList<String>();
            camellore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            camellore.add("§7-§7Habilidades: §7- Na areia tenha velocidade!");
            camellore.add("§7-*-*-*-*-*-*-*-*-*-*");
            camelmeta.setLore((List)camellore);
            camel.setItemMeta(camelmeta);
            GUI.kits.setItem(15, camel);
            p.openInventory(GUI.kits);
        }
        return false;
    }
    
    @EventHandler
    public void KitSelector(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.CHEST && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)) {
            Bukkit.dispatchCommand((CommandSender)p, "kits");
        }
    }
}
