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

public class GUIVIP implements CommandExecutor, Listener
{
    public Main plugin;
    public static Inventory kits;
    
    static {
        GUIVIP.kits = Bukkit.createInventory((InventoryHolder)null, 54, "§4Kits Vip:");
    }
    
    public GUIVIP(final Main instance) {
        this.plugin = instance;
    }
    
    @EventHandler
    public void Click(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
            final Inventory inv = e.getInventory();
            final Player p = (Player)e.getWhoClicked();
            if (inv.getTitle().equals("§4Kits Vip:")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7-")) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("-")) {
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a<-- Voltar")) {
                    Bukkit.dispatchCommand((CommandSender)p, "kits");
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
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bViking")) {
                    Bukkit.dispatchCommand((CommandSender)p, "viking");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSwitcher")) {
                    Bukkit.dispatchCommand((CommandSender)p, "switcher");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGrappler")) {
                    Bukkit.dispatchCommand((CommandSender)p, "grappler");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTurtle")) {
                    Bukkit.dispatchCommand((CommandSender)p, "turtle");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFlash")) {
                    Bukkit.dispatchCommand((CommandSender)p, "flash");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bThor")) {
                    Bukkit.dispatchCommand((CommandSender)p, "thor");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSnowman")) {
                    Bukkit.dispatchCommand((CommandSender)p, "snowman");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bHealer")) {
                    Bukkit.dispatchCommand((CommandSender)p, "healer");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSonic")) {
                    Bukkit.dispatchCommand((CommandSender)p, "sonic");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPhantom")) {
                    Bukkit.dispatchCommand((CommandSender)p, "phantom");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGrandpa")) {
                    Bukkit.dispatchCommand((CommandSender)p, "grandpa");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLifeline")) {
                    Bukkit.dispatchCommand((CommandSender)p, "lifeline");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGambler")) {
                    Bukkit.dispatchCommand((CommandSender)p, "gambler");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bDarkmage")) {
                    Bukkit.dispatchCommand((CommandSender)p, "darkmage");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSpectre")) {
                    Bukkit.dispatchCommand((CommandSender)p, "spectre");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bAnchor")) {
                    Bukkit.dispatchCommand((CommandSender)p, "anchor");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSalamander")) {
                    Bukkit.dispatchCommand((CommandSender)p, "salamander");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bReaper")) {
                    Bukkit.dispatchCommand((CommandSender)p, "reaper");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bChemist")) {
                    Bukkit.dispatchCommand((CommandSender)p, "chemist");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPyro")) {
                    Bukkit.dispatchCommand((CommandSender)p, "pyro");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bStomper")) {
                    Bukkit.dispatchCommand((CommandSender)p, "stomper");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bMacaco")) {
                    Bukkit.dispatchCommand((CommandSender)p, "macaco");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTank")) {
                    Bukkit.dispatchCommand((CommandSender)p, "tank");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bUrgal")) {
                    Bukkit.dispatchCommand((CommandSender)p, "urgal");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bNeo")) {
                    Bukkit.dispatchCommand((CommandSender)p, "neo");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bEndermage")) {
                    Bukkit.dispatchCommand((CommandSender)p, "endermage");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTank")) {
                    Bukkit.dispatchCommand((CommandSender)p, "tank");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bViper")) {
                    Bukkit.dispatchCommand((CommandSender)p, "viper");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSnail")) {
                    Bukkit.dispatchCommand((CommandSender)p, "snail");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTimelord")) {
                    Bukkit.dispatchCommand((CommandSender)p, "timelord");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bRider")) {
                    Bukkit.dispatchCommand((CommandSender)p, "rider");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSpecialist")) {
                    Bukkit.dispatchCommand((CommandSender)p, "specialist");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPoseidon")) {
                    Bukkit.dispatchCommand((CommandSender)p, "poseidon");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCookieMonster")) {
                    Bukkit.dispatchCommand((CommandSender)p, "cookiemonster");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVampire")) {
                    Bukkit.dispatchCommand((CommandSender)p, "vampire");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bHulk")) {
                    Bukkit.dispatchCommand((CommandSender)p, "hulk");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bBerserker")) {
                    Bukkit.dispatchCommand((CommandSender)p, "berserker");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bMonk")) {
                    Bukkit.dispatchCommand((CommandSender)p, "monk");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bViking")) {
                    Bukkit.dispatchCommand((CommandSender)p, "viking");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLauncher")) {
                    Bukkit.dispatchCommand((CommandSender)p, "launcher");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVacuum")) {
                    Bukkit.dispatchCommand((CommandSender)p, "vacuum");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bRobinHood")) {
                    Bukkit.dispatchCommand((CommandSender)p, "robinhood");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bDwarf")) {
                    Bukkit.dispatchCommand((CommandSender)p, "dwarf");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGladiator")) {
                    Bukkit.dispatchCommand((CommandSender)p, "gladiator");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSniper")) {
                    Bukkit.dispatchCommand((CommandSender)p, "sniper");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
                    e.setCancelled(true);
                    p.closeInventory();
                }
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (commandLabel.equalsIgnoreCase("kits") || commandLabel.equalsIgnoreCase("kit") || (commandLabel.equalsIgnoreCase("kitvip") && p.hasPermission("kitmenu.normal"))) {
            GUIVIP.kits.clear();
            p.playSound(p.getLocation(), Sound.NOTE_PIANO, 10.0f, 5.0f);
            final ItemStack glass = new ItemStack(Material.THIN_GLASS);
            final ItemMeta glassmeta = glass.getItemMeta();
            glassmeta.setDisplayName("§7-");
            glass.setItemMeta(glassmeta);
            GUIVIP.kits.setItem(1, glass);
            GUIVIP.kits.setItem(2, glass);
            GUIVIP.kits.setItem(3, glass);
            GUIVIP.kits.setItem(5, glass);
            GUIVIP.kits.setItem(6, glass);
            GUIVIP.kits.setItem(7, glass);
            GUIVIP.kits.setItem(44, glass);
            GUIVIP.kits.setItem(45, glass);
            GUIVIP.kits.setItem(46, glass);
            GUIVIP.kits.setItem(47, glass);
            GUIVIP.kits.setItem(48, glass);
            GUIVIP.kits.setItem(49, glass);
            GUIVIP.kits.setItem(50, glass);
            GUIVIP.kits.setItem(51, glass);
            GUIVIP.kits.setItem(52, glass);
            GUIVIP.kits.setItem(53, glass);
            final ItemStack a = new ItemStack(Material.CARPET);
            final ItemMeta aa = a.getItemMeta();
            aa.setDisplayName("§a<-- Voltar");
            a.setItemMeta(aa);
            GUIVIP.kits.setItem(0, a);
            final ItemStack po = new ItemStack(Material.getMaterial(289));
            final ItemMeta pom = po.getItemMeta();
            pom.setDisplayName("-");
            po.setItemMeta(pom);
            GUIVIP.kits.setItem(4, po);
            final ItemStack av = new ItemStack(Material.CARPET);
            final ItemMeta ava = av.getItemMeta();
            ava.setDisplayName("-");
            av.setItemMeta(ava);
            GUIVIP.kits.setItem(8, av);
            final ItemStack switcher = new ItemStack(Material.SNOW_BALL);
            final ItemMeta switchermeta = switcher.getItemMeta();
            switchermeta.setDisplayName("§bSwitcher");
            final ArrayList<String> switcherlore = new ArrayList<String>();
            switcherlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            switcherlore.add("§7-§7Habilidades: §7- Troque de lugar !");
            switcherlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            switchermeta.setLore((List)switcherlore);
            switcher.setItemMeta(switchermeta);
            GUIVIP.kits.setItem(9, switcher);
            final ItemStack grappler = new ItemStack(Material.LEASH);
            final ItemMeta grapplermeta = grappler.getItemMeta();
            grapplermeta.setDisplayName("§bGrappler");
            final ArrayList<String> grapplerlore = new ArrayList<String>();
            grapplerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            grapplerlore.add("§7-§7Habilidades: §7- Jogue sua corda e seja rapido!");
            grapplerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            grapplermeta.setLore((List)grapplerlore);
            grappler.setItemMeta(grapplermeta);
            GUIVIP.kits.setItem(10, grappler);
            final ItemStack turtle = new ItemStack(Material.BEDROCK);
            final ItemMeta turtlemeta = turtle.getItemMeta();
            turtlemeta.setDisplayName("§bTurtle");
            final ArrayList<String> turtlelore = new ArrayList<String>();
            turtlelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            turtlelore.add("§7-§7Habilidades: §7- No shift leve menos dano e nao morra de queda!");
            turtlelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            turtlemeta.setLore((List)turtlelore);
            turtle.setItemMeta(turtlemeta);
            GUIVIP.kits.setItem(11, turtle);
            final ItemStack thor = new ItemStack(Material.STONE_AXE);
            final ItemMeta thormeta = thor.getItemMeta();
            thormeta.setDisplayName("§bThor");
            final ArrayList<String> thorlore = new ArrayList<String>();
            thorlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            thorlore.add("§7-§7Habilidades: §7- Com seu machado solte raios!");
            thorlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            thormeta.setLore((List)thorlore);
            thor.setItemMeta(thormeta);
            GUIVIP.kits.setItem(12, thor);
            final ItemStack neo = new ItemStack(Material.getMaterial(2256));
            final ItemMeta neom = neo.getItemMeta();
            neom.setDisplayName("§bNeo");
            final ArrayList<String> neol = new ArrayList<String>();
            neol.add("§7-*-*-*-*-*-*-*-*-*-*");
            neol.add("§7-§7Habilidades: §7- Nao leve knockback de projeteis!");
            neol.add("§7-*-*-*-*-*-*-*-*-*-*");
            neom.setLore((List)neol);
            neo.setItemMeta(neom);
            GUIVIP.kits.setItem(13, neo);
            final ItemStack phantom = new ItemStack(Material.FEATHER);
            final ItemMeta phantommeta = phantom.getItemMeta();
            phantommeta.setDisplayName("§bPhantom");
            final ArrayList<String> phantomlore = new ArrayList<String>();
            phantomlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            phantomlore.add("§7-§7Habilidades: §7- Clique na pena e voe 5 seg!");
            phantomlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            phantommeta.setLore((List)phantomlore);
            phantom.setItemMeta(phantommeta);
            GUIVIP.kits.setItem(14, phantom);
            final ItemStack endermage = new ItemStack(Material.PORTAL);
            final ItemMeta endermagem = endermage.getItemMeta();
            endermagem.setDisplayName("§bEndermage");
            final ArrayList<String> endermagel = new ArrayList<String>();
            endermagel.add("§7-*-*-*-*-*-*-*-*-*-*");
            endermagel.add("§7-§7Habilidades: §7- Bugado Arrumando!");
            endermagel.add("§7-*-*-*-*-*-*-*-*-*-*");
            endermagem.setLore((List)endermagel);
            endermage.setItemMeta(endermagem);
            GUIVIP.kits.setItem(15, endermage);
            final ItemStack urgal = new ItemStack(Material.POTION, 1, (short)41);
            final ItemMeta urgalm = urgal.getItemMeta();
            urgalm.setDisplayName("§bUrgal");
            final ArrayList<String> urgall = new ArrayList<String>();
            urgall.add("§7-*-*-*-*-*-*-*-*-*-*");
            urgall.add("§7-Habilidades:s - Tenha Forca!");
            urgall.add("§7-*-*-*-*-*-*-*-*-*-*");
            urgalm.setLore((List)urgall);
            urgal.setItemMeta(urgalm);
            GUIVIP.kits.setItem(16, urgal);
            final ItemStack gambler = new ItemStack(Material.GLOWSTONE_DUST);
            final ItemMeta gamblermeta = gambler.getItemMeta();
            gamblermeta.setDisplayName("§bGambler");
            final ArrayList<String> gamblerlore = new ArrayList<String>();
            gamblerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            gamblerlore.add("§7-§7Habilidades: §7- Clique na Glowstone e ganhe efeitos Random!");
            gamblerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            gamblermeta.setLore((List)gamblerlore);
            gambler.setItemMeta(gamblermeta);
            GUIVIP.kits.setItem(17, gambler);
            final ItemStack spectre = new ItemStack(Material.REDSTONE);
            final ItemMeta spectremeta = spectre.getItemMeta();
            spectremeta.setDisplayName("§bSpectre");
            final ArrayList<String> spectrelore = new ArrayList<String>();
            spectrelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            spectrelore.add("§7-§7Habilidades: §7- Clique na redstone e fique invisivel!");
            spectrelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            spectremeta.setLore((List)spectrelore);
            spectre.setItemMeta(spectremeta);
            GUIVIP.kits.setItem(18, spectre);
            final ItemStack zombie = new ItemStack(Material.ANVIL);
            final ItemMeta zombiemeta = zombie.getItemMeta();
            zombiemeta.setDisplayName("§bAnchor");
            final ArrayList<String> zombielore = new ArrayList<String>();
            zombielore.add("§7-*-*-*-*-*-*-*-*-*-*");
            zombielore.add("§7-§7Habilidades: §7- Nao leve e nao de knockback!");
            zombielore.add("§7-*-*-*-*-*-*-*-*-*-*");
            zombiemeta.setLore((List)zombielore);
            zombie.setItemMeta(zombiemeta);
            GUIVIP.kits.setItem(19, zombie);
            final ItemStack lavaman = new ItemStack(Material.STATIONARY_LAVA);
            final ItemMeta lavamanmeta = lavaman.getItemMeta();
            lavamanmeta.setDisplayName("§bSalamander");
            final ArrayList<String> lavamanlore = new ArrayList<String>();
            lavamanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            lavamanlore.add("§7-§7Habilidades: §7- Seja Deus na Lava!");
            lavamanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            lavamanmeta.setLore((List)lavamanlore);
            lavaman.setItemMeta(lavamanmeta);
            GUIVIP.kits.setItem(20, lavaman);
            final ItemStack previus = new ItemStack(Material.IRON_BOOTS);
            final ItemMeta previusmeta = previus.getItemMeta();
            previusmeta.setDisplayName("§bStomper");
            final ArrayList<String> previuslore = new ArrayList<String>();
            previuslore.add("§7-*-*-*-*-*-*-*-*-*-*");
            previuslore.add("§7-Habilidades: - Pule em alguem e faca um estrago!");
            previuslore.add("§7-*-*-*-*-*-*-*-*-*-*");
            previusmeta.setLore((List)previuslore);
            previus.setItemMeta(previusmeta);
            GUIVIP.kits.setItem(21, previus);
            final ItemStack chemist = new ItemStack(Material.BREWING_STAND_ITEM);
            final ItemMeta chemistmeta = chemist.getItemMeta();
            chemistmeta.setDisplayName("§bChemist");
            final ArrayList<String> chemistlore = new ArrayList<String>();
            chemistlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            chemistlore.add("§7-§7Habilidades: §7- Jogo pocoes em seus inimigos!");
            chemistlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            chemistmeta.setLore((List)chemistlore);
            chemist.setItemMeta(chemistmeta);
            GUIVIP.kits.setItem(22, chemist);
            final ItemStack pyro = new ItemStack(Material.FIRE);
            final ItemMeta pyrometa = pyro.getItemMeta();
            pyrometa.setDisplayName("§bPyro");
            final ArrayList<String> pyrolore = new ArrayList<String>();
            pyrolore.add("§7-*-*-*-*-*-*-*-*-*-*");
            pyrolore.add("§7-§7Habilidades: §7- Deixe seus inimigos em chamas!");
            pyrolore.add("§7-*-*-*-*-*-*-*-*-*-*");
            pyrometa.setLore((List)pyrolore);
            pyro.setItemMeta(pyrometa);
            GUIVIP.kits.setItem(23, pyro);
            final ItemStack tank = new ItemStack(Material.TNT);
            final ItemMeta tankm = tank.getItemMeta();
            tankm.setDisplayName("§bTank");
            final ArrayList<String> tankl = new ArrayList<String>();
            tankl.add("§7*-*-*-*-*-*-*-*-*-**-*");
            tankl.add("§7-§7Habilidades: §7- Ao Matar Alguem cause uma explosao!");
            tankl.add("§7-*-*-*-*-*-*-*-*-*-*");
            tankm.setLore((List)tankl);
            tank.setItemMeta(tankm);
            GUIVIP.kits.setItem(24, tank);
            final ItemStack viper = new ItemStack(Material.POTION, 1, (short)4);
            final ItemMeta vipermeta = viper.getItemMeta();
            vipermeta.setDisplayName("§bViper");
            final ArrayList<String> viperlore = new ArrayList<String>();
            viperlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            viperlore.add("§7-§7Habilidades: §7- Deixe seus inimigos com veneno!");
            viperlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            vipermeta.setLore((List)viperlore);
            viper.setItemMeta(vipermeta);
            GUIVIP.kits.setItem(25, viper);
            final ItemStack timelord = new ItemStack(Material.WATCH);
            final ItemMeta timelordmeta = timelord.getItemMeta();
            timelordmeta.setDisplayName("§bTimelord");
            final ArrayList<String> timelordlore = new ArrayList<String>();
            timelordlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            timelordlore.add("§7-§7Habilidades: §7- Congele seus inimigos!!");
            timelordlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            timelordmeta.setLore((List)timelordlore);
            timelord.setItemMeta(timelordmeta);
            GUIVIP.kits.setItem(26, timelord);
            final ItemStack snail = new ItemStack(Material.SPIDER_EYE);
            final ItemMeta snailmeta = snail.getItemMeta();
            snailmeta.setDisplayName("§bSnail");
            final ArrayList<String> snaillore = new ArrayList<String>();
            snaillore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            snaillore.add("§7-§7Habilidades: §7- Deixe seus inimigos lentos!");
            snaillore.add("§7-*-*-*-*-*-*-*-*-*-*");
            snailmeta.setLore((List)snaillore);
            snail.setItemMeta(snailmeta);
            GUIVIP.kits.setItem(27, snail);
            final ItemStack rider = new ItemStack(Material.SADDLE);
            final ItemMeta riderm = rider.getItemMeta();
            riderm.setDisplayName("§bRider");
            final ArrayList<String> riderl = new ArrayList<String>();
            riderl.add("§7*-*-*-*-*-*-*-*-*-**-*");
            riderl.add("§7-§7Habilidades: §7- Clique na cela para spawnar um cavalo!");
            riderl.add("§7-*-*-*-*-*-*-*-*-*-*");
            riderm.setLore((List)riderl);
            rider.setItemMeta(riderm);
            GUIVIP.kits.setItem(28, rider);
            final ItemStack specialist = new ItemStack(Material.BOOK);
            final ItemMeta specialistmeta = specialist.getItemMeta();
            specialistmeta.setDisplayName("§bSpecialist");
            final ArrayList<String> specialistlore = new ArrayList<String>();
            specialistlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            specialistlore.add("§7-§7Habilidades: §7- Encante seus Itens!");
            specialistlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            specialistmeta.setLore((List)specialistlore);
            specialist.setItemMeta(specialistmeta);
            GUIVIP.kits.setItem(29, specialist);
            final ItemStack poseidon = new ItemStack(Material.WATER);
            final ItemMeta poseidonmeta = poseidon.getItemMeta();
            poseidonmeta.setDisplayName("§bPoseidon");
            final ArrayList<String> poseidonlore = new ArrayList<String>();
            poseidonlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            poseidonlore.add("§7-§7Habilidades: §7- Tenha Velocidade na Agua!");
            poseidonlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            poseidonmeta.setLore((List)poseidonlore);
            poseidon.setItemMeta(poseidonmeta);
            GUIVIP.kits.setItem(30, poseidon);
            final ItemStack cookie = new ItemStack(Material.COOKIE);
            final ItemMeta cookiem = cookie.getItemMeta();
            cookiem.setDisplayName("§bCookieMonster");
            final ArrayList<String> cookiel = new ArrayList<String>();
            cookiel.add("§7*-*-*-*-*-*-*-*-*-**-*");
            cookiel.add("§7-§7Habilidades: §7- Como um cookie e ganhe velocidade!");
            cookiel.add("§7-*-*-*-*-*-*-*-*-*-*");
            cookiem.setLore((List)cookiel);
            cookie.setItemMeta(cookiem);
            GUIVIP.kits.setItem(31, cookie);
            final ItemStack vampire = new ItemStack(Material.POTION, 1, (short)12);
            final ItemMeta vampiremeta = vampire.getItemMeta();
            vampiremeta.setDisplayName("§bVampire");
            final ArrayList<String> vampirelore = new ArrayList<String>();
            vampirelore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            vampirelore.add("§7-§7Habilidades: §7- Ganhe pocao de dano!");
            vampirelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            vampiremeta.setLore((List)vampirelore);
            vampire.setItemMeta(vampiremeta);
            GUIVIP.kits.setItem(32, vampire);
            final ItemStack hulk = new ItemStack(Material.BONE);
            final ItemMeta hulkmeta = hulk.getItemMeta();
            hulkmeta.setDisplayName("§bHulk");
            final ArrayList<String> hulklore = new ArrayList<String>();
            hulklore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            hulklore.add("§7-§7Habilidades: §7- Carregue e jogue os players!");
            hulklore.add("§7-*-*-*-*-*-*-*-*-*-*");
            hulkmeta.setLore((List)hulklore);
            hulk.setItemMeta(hulkmeta);
            GUIVIP.kits.setItem(33, hulk);
            final ItemStack berserker = new ItemStack(Material.POTION, 1, (short)25);
            final ItemMeta berserkermeta = berserker.getItemMeta();
            berserkermeta.setDisplayName("§bBerserker");
            final ArrayList<String> berserkerlore = new ArrayList<String>();
            berserkerlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            berserkerlore.add("§7-§7Habilidades: §7- Ganhe forca ao matar alguem!");
            berserkerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            berserkermeta.setLore((List)berserkerlore);
            berserker.setItemMeta(berserkermeta);
            GUIVIP.kits.setItem(34, berserker);
            final ItemStack monk = new ItemStack(Material.BLAZE_ROD);
            final ItemMeta monkmeta = monk.getItemMeta();
            monkmeta.setDisplayName("§bMonk");
            final ArrayList<String> monklore = new ArrayList<String>();
            monklore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            monklore.add("§7-§7Habilidades: §7- Monke a espada de seus inimigos!");
            monklore.add("§7-*-*-*-*-*-*-*-*-*-*");
            monkmeta.setLore((List)monklore);
            monk.setItemMeta(monkmeta);
            GUIVIP.kits.setItem(35, monk);
            final ItemStack macaco = new ItemStack(Material.VINE);
            final ItemMeta macacom = macaco.getItemMeta();
            macacom.setDisplayName("§bMacaco");
            final ArrayList<String> macacol = new ArrayList<String>();
            macacol.add("§7-*-*-*-*-*-*-*-*-*-*");
            macacol.add("§7-§7Habilidades: §7- Suba pelas paredes");
            macacol.add("§7- Clicando com o Botao Direito!");
            macacol.add("§7-*-*-*-*-*-*-*-*-*-*");
            macacom.setLore((List)macacol);
            macaco.setItemMeta(macacom);
            GUIVIP.kits.setItem(36, macaco);
            final ItemStack launcher = new ItemStack(Material.SPONGE);
            final ItemMeta launcherm = launcher.getItemMeta();
            launcherm.setDisplayName("§bLauncher");
            final ArrayList<String> launcherl = new ArrayList<String>();
            launcherl.add("§7-*-*-*-*-*-*-*-*-*-*");
            launcherl.add("§7-§7Habilidades: §7- Clique em alguem para ela ser jogada!");
            launcherl.add("§7-*-*-*-*-*-*-*-*-*-*");
            launcherm.setLore((List)launcherl);
            launcher.setItemMeta(launcherm);
            GUIVIP.kits.setItem(37, launcher);
            final ItemStack vacuum = new ItemStack(Material.ARROW);
            final ItemMeta vacuumm = vacuum.getItemMeta();
            vacuumm.setDisplayName("§bRobinHood");
            final ArrayList<String> vacuumlore = new ArrayList<String>();
            vacuumlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            vacuumlore.add("§7-§7Habilidades: §7- Mate com uma flechada!");
            vacuumlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            vacuumm.setLore((List)vacuumlore);
            vacuum.setItemMeta(vacuumm);
            GUIVIP.kits.setItem(38, vacuum);
            final ItemStack vacuum2 = new ItemStack(Material.ENDER_PEARL);
            final ItemMeta vacuumm2 = vacuum2.getItemMeta();
            vacuumm2.setDisplayName("§bVacuum");
            final ArrayList<String> vacuuml12 = new ArrayList<String>();
            vacuuml12.add("§7-*-*-*-*-*-*-*-*-*-*");
            vacuuml12.add("§7-§7Habilidades: §7- Puxe seus inimigos para perto de voce!");
            vacuuml12.add("§7-*-*-*-*-*-*-*-*-*-*");
            vacuumm2.setLore((List)vacuuml12);
            vacuum2.setItemMeta(vacuumm2);
            GUIVIP.kits.setItem(39, vacuum2);
            final ItemStack milkman = new ItemStack(Material.LEATHER);
            final ItemMeta milkmanmeta = milkman.getItemMeta();
            milkmanmeta.setDisplayName("§bBackpacker");
            final ArrayList<String> milkmanlore = new ArrayList<String>();
            milkmanlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            milkmanlore.add("§7-§7HHabilidades: §7- Clique na mochila e abra um inventario de sopas!");
            milkmanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            milkmanmeta.setLore((List)milkmanlore);
            milkman.setItemMeta(milkmanmeta);
            GUIVIP.kits.setItem(40, milkman);
            final ItemStack frosty = new ItemStack(Material.SNOW);
            final ItemMeta frostymeta = frosty.getItemMeta();
            frostymeta.setDisplayName("§bFrosty");
            final ArrayList<String> frostylore = new ArrayList<String>();
            frostylore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            frostylore.add("§7-§7HHabilidades: §7- Na neve tenha velocidade!");
            frostylore.add("§7-*-*-*-*-*-*-*-*-*-*");
            frostymeta.setLore((List)frostylore);
            frosty.setItemMeta(frostymeta);
            GUIVIP.kits.setItem(41, frosty);
            final ItemStack milkman2 = new ItemStack(Material.MILK_BUCKET);
            final ItemMeta milkmanm = milkman2.getItemMeta();
            milkmanm.setDisplayName("§bMilkman");
            final ArrayList<String> milkmanl = new ArrayList<String>();
            milkmanl.add("§7*-*-*-*-*-*-*-*-*-**-*");
            milkmanl.add("§7-§7HHabilidades: §7- Tome o leite vire a SUPERVACA");
            milkmanl.add("§7-*-*-*-*-*-*-*-*-*-*");
            milkmanm.setLore((List)milkmanl);
            milkman2.setItemMeta(milkmanm);
            GUIVIP.kits.setItem(42, milkman2);
            final ItemStack gladiatora = new ItemStack(Material.WOOD_AXE);
            final ItemMeta gladiatorma = gladiatora.getItemMeta();
            gladiatorma.setDisplayName("§bViking");
            final ArrayList<String> gladiatorla = new ArrayList<String>();
            gladiatorla.add("§7-*-*-*-*-*-*-*-*-*-*");
            gladiatorla.add("§7-§7Habilidades: §7- A cada kill ganhe Sharpness no machado!");
            gladiatorla.add("§7-*-*-*-*-*-*-*-*-*-*");
            gladiatorma.setLore((List)gladiatorla);
            gladiatora.setItemMeta(gladiatorma);
            GUIVIP.kits.setItem(43, gladiatora);
            final ItemStack gladiatorb = new ItemStack(Material.IRON_BARDING);
            final ItemMeta gladiatormb = gladiatorb.getItemMeta();
            gladiatormb.setDisplayName("§bSniper");
            final ArrayList<String> gladiatorlb = new ArrayList<String>();
            gladiatorlb.add("§7-*-*-*-*-*-*-*-*-*-*");
            gladiatorlb.add("§7-§7Habilidades: §7- De Tiros de sniper");
            gladiatorlb.add("§7-*-*-*-*-*-*-*-*-*-*");
            gladiatormb.setLore((List)gladiatorlb);
            gladiatorb.setItemMeta(gladiatormb);
            GUIVIP.kits.setItem(45, gladiatorb);
            final ItemStack gladiator = new ItemStack(Material.IRON_FENCE);
            final ItemMeta gladiatorm = gladiator.getItemMeta();
            gladiatorm.setDisplayName("§bGladiator");
            final ArrayList<String> gladiatorl = new ArrayList<String>();
            gladiatorl.add("§7-*-*-*-*-*-*-*-*-*-*");
            gladiatorl.add("§7-§7Habilidades: §7- Puxe para 1v1");
            gladiatorl.add("§7-*-*-*-*-*-*-*-*-*-*");
            gladiatorm.setLore((List)gladiatorl);
            gladiator.setItemMeta(gladiatorm);
            GUIVIP.kits.setItem(44, gladiator);
            p.openInventory(GUIVIP.kits);
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
