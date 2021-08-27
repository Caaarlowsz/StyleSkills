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

public class GuiVipastica implements CommandExecutor, Listener
{
    public Main plugin;
    public static Inventory kits;
    
    static {
        GuiVipastica.kits = Bukkit.createInventory((InventoryHolder)null, 54, "§aSeus Kits:");
    }
    
    public GuiVipastica(final Main instance) {
        this.plugin = instance;
    }
    
    @EventHandler
    public void Click(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
            final Inventory inv = e.getInventory();
            final Player p = (Player)e.getWhoClicked();
            if (inv.getTitle().equals("§aSeus Kits:")) {
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
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCamel")) {
                    Bukkit.dispatchCommand((CommandSender)p, "camel");
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
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bRobinHood")) {
                    Bukkit.dispatchCommand((CommandSender)p, "robinhood");
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
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (commandLabel.equalsIgnoreCase("kits") || commandLabel.equalsIgnoreCase("kit") || (commandLabel.equalsIgnoreCase("kitvip1") && p.hasPermission("kitmenu.vip"))) {
            GuiVipastica.kits.clear();
            p.playSound(p.getLocation(), Sound.NOTE_PIANO, 10.0f, 5.0f);
            final ItemStack glass = new ItemStack(Material.THIN_GLASS);
            final ItemMeta glassmeta = glass.getItemMeta();
            glassmeta.setDisplayName("§7-");
            glass.setItemMeta(glassmeta);
            GuiVipastica.kits.setItem(1, glass);
            GuiVipastica.kits.setItem(2, glass);
            GuiVipastica.kits.setItem(3, glass);
            GuiVipastica.kits.setItem(5, glass);
            GuiVipastica.kits.setItem(6, glass);
            GuiVipastica.kits.setItem(7, glass);
            final ItemStack a = new ItemStack(Material.CARPET);
            final ItemMeta aa = a.getItemMeta();
            aa.setDisplayName("-");
            a.setItemMeta(aa);
            GuiVipastica.kits.setItem(0, a);
            final ItemStack po = new ItemStack(Material.getMaterial(289));
            final ItemMeta pom = po.getItemMeta();
            pom.setDisplayName("-");
            po.setItemMeta(pom);
            GuiVipastica.kits.setItem(4, po);
            final ItemStack av = new ItemStack(Material.CARPET);
            final ItemMeta ava = av.getItemMeta();
            ava.setDisplayName("§aAvancar -->");
            av.setItemMeta(ava);
            GuiVipastica.kits.setItem(8, av);
            final ItemStack pvp = new ItemStack(Material.DIAMOND_SWORD);
            final ItemMeta pvpmeta = pvp.getItemMeta();
            pvpmeta.setDisplayName("§bPvP");
            final ArrayList<String> pvplore = new ArrayList<String>();
            pvplore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            pvplore.add("§7-§7Habilidade §7- Nenhuma");
            pvplore.add("§7-*-*-*-*-*-*-*-*-*-*");
            pvpmeta.setLore((List)pvplore);
            pvp.setItemMeta(pvpmeta);
            GuiVipastica.kits.setItem(9, pvp);
            final ItemStack archer = new ItemStack(Material.BOW);
            final ItemMeta archermeta = archer.getItemMeta();
            archermeta.setDisplayName("§bArcher");
            final ArrayList<String> archerlore = new ArrayList<String>();
            archerlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            archerlore.add("§7-§7Habilidade §7- Taque Flechas!");
            archerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            archermeta.setLore((List)archerlore);
            archer.setItemMeta(archermeta);
            GuiVipastica.kits.setItem(10, archer);
            final ItemStack kangaroo = new ItemStack(Material.FIREWORK);
            final ItemMeta kangaroometa = kangaroo.getItemMeta();
            kangaroometa.setDisplayName("§bKangaroo");
            final ArrayList<String> kangaroolore = new ArrayList<String>();
            kangaroolore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            kangaroolore.add("§7-§7Habilidade §7- De boost com o Firework!");
            kangaroolore.add("§7-*-*-*-*-*-*-*-*-*-*");
            kangaroometa.setLore((List)kangaroolore);
            kangaroo.setItemMeta(kangaroometa);
            GuiVipastica.kits.setItem(11, kangaroo);
            final ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
            final ItemMeta fishermanmeta = fisherman.getItemMeta();
            fishermanmeta.setDisplayName("§bFisherman");
            final ArrayList<String> fishermanlore = new ArrayList<String>();
            fishermanlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            fishermanlore.add("§7-§7Habilidade §7- Puxe com uma vara!");
            fishermanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            fishermanmeta.setLore((List)fishermanlore);
            fisherman.setItemMeta(fishermanmeta);
            GuiVipastica.kits.setItem(12, fisherman);
            final ItemStack milkman = new ItemStack(Material.LEATHER);
            final ItemMeta milkmanmeta = milkman.getItemMeta();
            milkmanmeta.setDisplayName("§bBackpacker");
            final ArrayList<String> milkmanlore = new ArrayList<String>();
            milkmanlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            milkmanlore.add("§7-§7Habilidade §7- Clique na mochila e abra um inventario de sopas!");
            milkmanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            milkmanmeta.setLore((List)milkmanlore);
            milkman.setItemMeta(milkmanmeta);
            GuiVipastica.kits.setItem(13, milkman);
            final ItemStack frosty = new ItemStack(Material.SNOW);
            final ItemMeta frostymeta = frosty.getItemMeta();
            frostymeta.setDisplayName("§bFrosty");
            final ArrayList<String> frostylore = new ArrayList<String>();
            frostylore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            frostylore.add("§7-§7Habilidade §7- Na neve tenha velocidade!");
            frostylore.add("§7-*-*-*-*-*-*-*-*-*-*");
            frostymeta.setLore((List)frostylore);
            frosty.setItemMeta(frostymeta);
            GuiVipastica.kits.setItem(14, frosty);
            final ItemStack milkman2 = new ItemStack(Material.MILK_BUCKET);
            final ItemMeta milkmanm = milkman2.getItemMeta();
            milkmanm.setDisplayName("§bMilkman");
            final ArrayList<String> milkmanl = new ArrayList<String>();
            milkmanl.add("§7*-*-*-*-*-*-*-*-*-**-*");
            milkmanl.add("§7-§7Habilidade §7- Tome o leite vire a SUPERVACA");
            milkmanl.add("§7-*-*-*-*-*-*-*-*-*-*");
            milkmanm.setLore((List)milkmanl);
            milkman2.setItemMeta(milkmanm);
            GuiVipastica.kits.setItem(15, milkman2);
            final ItemStack cultivator = new ItemStack(Material.GRASS);
            final ItemMeta cultivatormeta = cultivator.getItemMeta();
            cultivatormeta.setDisplayName("§bCultivator");
            final ArrayList<String> cultivatorlore = new ArrayList<String>();
            cultivatorlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            cultivatorlore.add("§7-§7Habilidade §7- Velocidade na grama!");
            cultivatorlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            cultivatormeta.setLore((List)cultivatorlore);
            cultivator.setItemMeta(cultivatormeta);
            GuiVipastica.kits.setItem(16, cultivator);
            final ItemStack viking = new ItemStack(Material.DIAMOND_AXE);
            final ItemMeta vikingmeta = viking.getItemMeta();
            vikingmeta.setDisplayName("§bViking");
            final ArrayList<String> vikinglore = new ArrayList<String>();
            vikinglore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            vikinglore.add("§7-§7Habilidade §7- De mais dano com seu machado!");
            vikinglore.add("§7-*-*-*-*-*-*-*-*-*-*");
            vikingmeta.setLore((List)vikinglore);
            viking.setItemMeta(vikingmeta);
            GuiVipastica.kits.setItem(17, viking);
            final ItemStack switcher = new ItemStack(Material.SNOW_BALL);
            final ItemMeta switchermeta = switcher.getItemMeta();
            switchermeta.setDisplayName("§bSwitcher");
            final ArrayList<String> switcherlore = new ArrayList<String>();
            switcherlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            switcherlore.add("§7-§7Abilidade §7- Troque de lugar !");
            switcherlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            switchermeta.setLore((List)switcherlore);
            switcher.setItemMeta(switchermeta);
            GuiVipastica.kits.setItem(18, switcher);
            final ItemStack grappler = new ItemStack(Material.LEASH);
            final ItemMeta grapplermeta = grappler.getItemMeta();
            grapplermeta.setDisplayName("§bGrappler");
            final ArrayList<String> grapplerlore = new ArrayList<String>();
            grapplerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            grapplerlore.add("§7-§7Abilidade §7- Jogue sua corda e seja rapido!");
            grapplerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            grapplermeta.setLore((List)grapplerlore);
            grappler.setItemMeta(grapplermeta);
            GuiVipastica.kits.setItem(19, grappler);
            final ItemStack turtle = new ItemStack(Material.BEDROCK);
            final ItemMeta turtlemeta = turtle.getItemMeta();
            turtlemeta.setDisplayName("§bTurtle");
            final ArrayList<String> turtlelore = new ArrayList<String>();
            turtlelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            turtlelore.add("§7-§7Abilidade §7- No shift leve menos dano e nao morra de queda!");
            turtlelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            turtlemeta.setLore((List)turtlelore);
            turtle.setItemMeta(turtlemeta);
            GuiVipastica.kits.setItem(20, turtle);
            final ItemStack flash = new ItemStack(Material.REDSTONE_TORCH_ON);
            final ItemMeta flashmeta = flash.getItemMeta();
            flashmeta.setDisplayName("§bFlash");
            final ArrayList<String> flashlore = new ArrayList<String>();
            flashlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            flashlore.add("§7-§7Abilidade §7- Se teleporte pra longe!");
            flashlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            flashmeta.setLore((List)flashlore);
            flash.setItemMeta(flashmeta);
            GuiVipastica.kits.setItem(21, flash);
            final ItemStack thor = new ItemStack(Material.STONE_AXE);
            final ItemMeta thormeta = thor.getItemMeta();
            thormeta.setDisplayName("§bThor");
            final ArrayList<String> thorlore = new ArrayList<String>();
            thorlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            thorlore.add("§7-§7Abilidade §7- Com seu machado solte raios!");
            thorlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            thormeta.setLore((List)thorlore);
            thor.setItemMeta(thormeta);
            GuiVipastica.kits.setItem(22, thor);
            final ItemStack snowman = new ItemStack(Material.SNOW_BLOCK);
            final ItemMeta snwomanmeta = snowman.getItemMeta();
            snwomanmeta.setDisplayName("§bSnowman");
            final ArrayList<String> snwomanlore = new ArrayList<String>();
            snwomanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            snwomanlore.add("§7-§7Abilidade §7- Tenha velocidade e for\u00e7a na neve!");
            snwomanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            snwomanmeta.setLore((List)snwomanlore);
            snowman.setItemMeta(snwomanmeta);
            GuiVipastica.kits.setItem(23, snowman);
            final ItemStack healer = new ItemStack(Material.MELON);
            final ItemMeta healermeta = healer.getItemMeta();
            healermeta.setDisplayName("§bHealer");
            final ArrayList<String> healerlore = new ArrayList<String>();
            healerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            healerlore.add("§7-§7Abilidade §7- Ganhe uma pocao de regeneracao ao matar alguem!");
            healerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            healermeta.setLore((List)healerlore);
            healer.setItemMeta(healermeta);
            GuiVipastica.kits.setItem(24, healer);
            final ItemStack sonic = new ItemStack(Material.SUGAR_CANE);
            final ItemMeta sonicmeta = sonic.getItemMeta();
            sonicmeta.setDisplayName("§bSonic");
            final ArrayList<String> soniclore = new ArrayList<String>();
            soniclore.add("§7-*-*-*-*-*-*-*-*-*-*");
            soniclore.add("§7-§7Abilidade §7- Clique na Sugar_Cane e tenha velocidade!");
            soniclore.add("§7-*-*-*-*-*-*-*-*-*-*");
            sonicmeta.setLore((List)soniclore);
            sonic.setItemMeta(sonicmeta);
            GuiVipastica.kits.setItem(25, sonic);
            final ItemStack neo = new ItemStack(Material.getMaterial(2256));
            final ItemMeta neom = neo.getItemMeta();
            neom.setDisplayName("§bNeo");
            final ArrayList<String> neol = new ArrayList<String>();
            neol.add("§7-*-*-*-*-*-*-*-*-*-*");
            neol.add("§7-§7Abilidade §7- Nao leve knockback de projeteis!");
            neol.add("§7-*-*-*-*-*-*-*-*-*-*");
            neom.setLore((List)neol);
            neo.setItemMeta(neom);
            GuiVipastica.kits.setItem(26, neo);
            final ItemStack phantom = new ItemStack(Material.FEATHER);
            final ItemMeta phantommeta = phantom.getItemMeta();
            phantommeta.setDisplayName("§bPhantom");
            final ArrayList<String> phantomlore = new ArrayList<String>();
            phantomlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            phantomlore.add("§7-§7Abilidade §7- Clique na pena e voe 5 seg!");
            phantomlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            phantommeta.setLore((List)phantomlore);
            phantom.setItemMeta(phantommeta);
            GuiVipastica.kits.setItem(27, phantom);
            final ItemStack endermage = new ItemStack(Material.PORTAL);
            final ItemMeta endermagem = endermage.getItemMeta();
            endermagem.setDisplayName("§bEndermage");
            final ArrayList<String> endermagel = new ArrayList<String>();
            endermagel.add("§7-*-*-*-*-*-*-*-*-*-*");
            endermagel.add("§7-§7Abilidade §7- Teleporte players!");
            endermagel.add("§7-*-*-*-*-*-*-*-*-*-*");
            endermagem.setLore((List)endermagel);
            endermage.setItemMeta(endermagem);
            GuiVipastica.kits.setItem(28, endermage);
            final ItemStack urgal = new ItemStack(Material.POTION, 1, (short)41);
            final ItemMeta urgalm = urgal.getItemMeta();
            urgalm.setDisplayName("§bUrgal");
            final ArrayList<String> urgall = new ArrayList<String>();
            urgall.add("§7-*-*-*-*-*-*-*-*-*-*");
            urgall.add("§7-Abilidades - Tenha Forca!");
            urgall.add("§7-*-*-*-*-*-*-*-*-*-*");
            urgalm.setLore((List)urgall);
            urgal.setItemMeta(urgalm);
            GuiVipastica.kits.setItem(29, urgal);
            final ItemStack lifeline = new ItemStack(Material.MAGMA_CREAM);
            final ItemMeta lifelinemeta = lifeline.getItemMeta();
            lifelinemeta.setDisplayName("§bLifeline");
            final ArrayList<String> lifelinelore = new ArrayList<String>();
            lifelinelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            lifelinelore.add("§7-§7Abilidade §7- Clique na MagmaCream e ganha regeneration!");
            lifelinelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            lifelinemeta.setLore((List)lifelinelore);
            lifeline.setItemMeta(lifelinemeta);
            GuiVipastica.kits.setItem(30, lifeline);
            final ItemStack gambler = new ItemStack(Material.GLOWSTONE_DUST);
            final ItemMeta gamblermeta = gambler.getItemMeta();
            gamblermeta.setDisplayName("§bGambler");
            final ArrayList<String> gamblerlore = new ArrayList<String>();
            gamblerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            gamblerlore.add("§7-§7Abilidade §7- Clique na Glowstone e ganhe efeitos Random!");
            gamblerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            gamblermeta.setLore((List)gamblerlore);
            gambler.setItemMeta(gamblermeta);
            GuiVipastica.kits.setItem(31, gambler);
            final ItemStack darkmage = new ItemStack(Material.POTATO_ITEM);
            final ItemMeta darkmagemeta = darkmage.getItemMeta();
            darkmagemeta.setDisplayName("§bDarkmage");
            final ArrayList<String> darkmagelore = new ArrayList<String>();
            darkmagelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            darkmagelore.add("§7-§7Abilidade §7- Bata em alguem e deixe cego!");
            darkmagelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            darkmagemeta.setLore((List)darkmagelore);
            darkmage.setItemMeta(darkmagemeta);
            GuiVipastica.kits.setItem(32, darkmage);
            final ItemStack spectre = new ItemStack(Material.REDSTONE);
            final ItemMeta spectremeta = spectre.getItemMeta();
            spectremeta.setDisplayName("§bSpectre");
            final ArrayList<String> spectrelore = new ArrayList<String>();
            spectrelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            spectrelore.add("§7-§7Abilidade §7- Clique na redstone e fique invisivel!");
            spectrelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            spectremeta.setLore((List)spectrelore);
            spectre.setItemMeta(spectremeta);
            GuiVipastica.kits.setItem(33, spectre);
            final ItemStack zombie = new ItemStack(Material.ANVIL);
            final ItemMeta zombiemeta = zombie.getItemMeta();
            zombiemeta.setDisplayName("§bAnchor");
            final ArrayList<String> zombielore = new ArrayList<String>();
            zombielore.add("§7-*-*-*-*-*-*-*-*-*-*");
            zombielore.add("§7-§7Abilidade §7- Nao leve e nao de knockback!");
            zombielore.add("§7-*-*-*-*-*-*-*-*-*-*");
            zombiemeta.setLore((List)zombielore);
            zombie.setItemMeta(zombiemeta);
            GuiVipastica.kits.setItem(34, zombie);
            final ItemStack lavaman = new ItemStack(Material.STATIONARY_LAVA);
            final ItemMeta lavamanmeta = lavaman.getItemMeta();
            lavamanmeta.setDisplayName("§bSalamander");
            final ArrayList<String> lavamanlore = new ArrayList<String>();
            lavamanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            lavamanlore.add("§7-§7Abilidade §7- Seja Deus na Lava!");
            lavamanlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            lavamanmeta.setLore((List)lavamanlore);
            lavaman.setItemMeta(lavamanmeta);
            GuiVipastica.kits.setItem(35, lavaman);
            final ItemStack reaper = new ItemStack(Material.WOOD_HOE);
            final ItemMeta reapermeta = reaper.getItemMeta();
            reapermeta.setDisplayName("§bReaper");
            final ArrayList<String> reaperlore = new ArrayList<String>();
            reaperlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            reaperlore.add("§7-§7Abilidade §7- Bata com a hoe e deixe com Wither!");
            reaperlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            reapermeta.setLore((List)reaperlore);
            reaper.setItemMeta(reapermeta);
            GuiVipastica.kits.setItem(36, reaper);
            final ItemStack previus = new ItemStack(Material.IRON_BOOTS);
            final ItemMeta previusmeta = previus.getItemMeta();
            previusmeta.setDisplayName("§bStomper");
            final ArrayList<String> previuslore = new ArrayList<String>();
            previuslore.add("§7-*-*-*-*-*-*-*-*-*-*");
            previuslore.add("§7-Abilidade - Pule em alguem e faca um estrago!");
            previuslore.add("§7-*-*-*-*-*-*-*-*-*-*");
            previusmeta.setLore((List)previuslore);
            previus.setItemMeta(previusmeta);
            GuiVipastica.kits.setItem(37, previus);
            final ItemStack chemist = new ItemStack(Material.BREWING_STAND_ITEM);
            final ItemMeta chemistmeta = chemist.getItemMeta();
            chemistmeta.setDisplayName("§bChemist");
            final ArrayList<String> chemistlore = new ArrayList<String>();
            chemistlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            chemistlore.add("§7-§7Abilidade §7- Jogo pocoes em seus inimigos!");
            chemistlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            chemistmeta.setLore((List)chemistlore);
            chemist.setItemMeta(chemistmeta);
            GuiVipastica.kits.setItem(38, chemist);
            final ItemStack pyro = new ItemStack(Material.FIRE);
            final ItemMeta pyrometa = pyro.getItemMeta();
            pyrometa.setDisplayName("§bPyro");
            final ArrayList<String> pyrolore = new ArrayList<String>();
            pyrolore.add("§7-*-*-*-*-*-*-*-*-*-*");
            pyrolore.add("§7-§7Abilidade §7- Deixe seus inimigos em chamas!");
            pyrolore.add("§7-*-*-*-*-*-*-*-*-*-*");
            pyrometa.setLore((List)pyrolore);
            pyro.setItemMeta(pyrometa);
            GuiVipastica.kits.setItem(39, pyro);
            final ItemStack tank = new ItemStack(Material.TNT);
            final ItemMeta tankm = tank.getItemMeta();
            tankm.setDisplayName("§bTank");
            final ArrayList<String> tankl = new ArrayList<String>();
            tankl.add("§7*-*-*-*-*-*-*-*-*-**-*");
            tankl.add("§7-§7Abilidade §7- Ao Matar Alguem cause uma explosao!");
            tankl.add("§7-*-*-*-*-*-*-*-*-*-*");
            tankm.setLore((List)tankl);
            tank.setItemMeta(tankm);
            GuiVipastica.kits.setItem(40, tank);
            final ItemStack viper = new ItemStack(Material.POTION, 1, (short)4);
            final ItemMeta vipermeta = viper.getItemMeta();
            vipermeta.setDisplayName("§bViper");
            final ArrayList<String> viperlore = new ArrayList<String>();
            viperlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            viperlore.add("§7-§7Abilidade §7- Deixe seus inimigos com veneno!");
            viperlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            vipermeta.setLore((List)viperlore);
            viper.setItemMeta(vipermeta);
            GuiVipastica.kits.setItem(41, viper);
            final ItemStack timelord = new ItemStack(Material.WATCH);
            final ItemMeta timelordmeta = timelord.getItemMeta();
            timelordmeta.setDisplayName("§bTimelord");
            final ArrayList<String> timelordlore = new ArrayList<String>();
            timelordlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            timelordlore.add("§7-§7Abilidade §7- Congele seus inimigos!!");
            timelordlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            timelordmeta.setLore((List)timelordlore);
            timelord.setItemMeta(timelordmeta);
            GuiVipastica.kits.setItem(42, timelord);
            final ItemStack snail = new ItemStack(Material.SPIDER_EYE);
            final ItemMeta snailmeta = snail.getItemMeta();
            snailmeta.setDisplayName("§bSnail");
            final ArrayList<String> snaillore = new ArrayList<String>();
            snaillore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            snaillore.add("§7-§7Abilidade §7- Deixe seus inimigos lentos!");
            snaillore.add("§7-*-*-*-*-*-*-*-*-*-*");
            snailmeta.setLore((List)snaillore);
            snail.setItemMeta(snailmeta);
            GuiVipastica.kits.setItem(43, snail);
            final ItemStack rider = new ItemStack(Material.SADDLE);
            final ItemMeta riderm = rider.getItemMeta();
            riderm.setDisplayName("§bRider");
            final ArrayList<String> riderl = new ArrayList<String>();
            riderl.add("§7*-*-*-*-*-*-*-*-*-**-*");
            riderl.add("§7-§7Abilidade §7- Clique na cela para spawnar um cavalo!");
            riderl.add("§7-*-*-*-*-*-*-*-*-*-*");
            riderm.setLore((List)riderl);
            rider.setItemMeta(riderm);
            GuiVipastica.kits.setItem(44, rider);
            final ItemStack specialist = new ItemStack(Material.BOOK);
            final ItemMeta specialistmeta = specialist.getItemMeta();
            specialistmeta.setDisplayName("§bSpecialist");
            final ArrayList<String> specialistlore = new ArrayList<String>();
            specialistlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            specialistlore.add("§7-§7Abilidade §7- Encante seus Itens!");
            specialistlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            specialistmeta.setLore((List)specialistlore);
            specialist.setItemMeta(specialistmeta);
            GuiVipastica.kits.setItem(45, specialist);
            final ItemStack poseidon = new ItemStack(Material.WATER);
            final ItemMeta poseidonmeta = poseidon.getItemMeta();
            poseidonmeta.setDisplayName("§bPoseidon");
            final ArrayList<String> poseidonlore = new ArrayList<String>();
            poseidonlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            poseidonlore.add("§7-§7Abilidade §7- Tenha Velocidade na Agua!");
            poseidonlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            poseidonmeta.setLore((List)poseidonlore);
            poseidon.setItemMeta(poseidonmeta);
            GuiVipastica.kits.setItem(46, poseidon);
            final ItemStack cookie = new ItemStack(Material.COOKIE);
            final ItemMeta cookiem = cookie.getItemMeta();
            cookiem.setDisplayName("§bCookieMonster");
            final ArrayList<String> cookiel = new ArrayList<String>();
            cookiel.add("§7*-*-*-*-*-*-*-*-*-**-*");
            cookiel.add("§7-§7Abilidade §7- Como um cookie e ganhe velocidade!");
            cookiel.add("§7-*-*-*-*-*-*-*-*-*-*");
            cookiem.setLore((List)cookiel);
            cookie.setItemMeta(cookiem);
            GuiVipastica.kits.setItem(47, cookie);
            final ItemStack vampire = new ItemStack(Material.POTION, 1, (short)12);
            final ItemMeta vampiremeta = vampire.getItemMeta();
            vampiremeta.setDisplayName("§bVampire");
            final ArrayList<String> vampirelore = new ArrayList<String>();
            vampirelore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            vampirelore.add("§7-§7Abilidade §7- Ganhe pocao de dano!");
            vampirelore.add("§7-*-*-*-*-*-*-*-*-*-*");
            vampiremeta.setLore((List)vampirelore);
            vampire.setItemMeta(vampiremeta);
            GuiVipastica.kits.setItem(48, vampire);
            final ItemStack hulk = new ItemStack(Material.BONE);
            final ItemMeta hulkmeta = hulk.getItemMeta();
            hulkmeta.setDisplayName("§bHulk");
            final ArrayList<String> hulklore = new ArrayList<String>();
            hulklore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            hulklore.add("§7-§7Abilidade §7- Carregue e jogue os players!");
            hulklore.add("§7-*-*-*-*-*-*-*-*-*-*");
            hulkmeta.setLore((List)hulklore);
            hulk.setItemMeta(hulkmeta);
            GuiVipastica.kits.setItem(49, hulk);
            final ItemStack berserker = new ItemStack(Material.POTION, 1, (short)25);
            final ItemMeta berserkermeta = berserker.getItemMeta();
            berserkermeta.setDisplayName("§bBerserker");
            final ArrayList<String> berserkerlore = new ArrayList<String>();
            berserkerlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            berserkerlore.add("§7-§7Abilidade §7- Ganhe forca ao matar alguem!");
            berserkerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
            berserkermeta.setLore((List)berserkerlore);
            berserker.setItemMeta(berserkermeta);
            GuiVipastica.kits.setItem(50, berserker);
            final ItemStack monk = new ItemStack(Material.BLAZE_ROD);
            final ItemMeta monkmeta = monk.getItemMeta();
            monkmeta.setDisplayName("§bMonk");
            final ArrayList<String> monklore = new ArrayList<String>();
            monklore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            monklore.add("§7-§7Abilidade §7- Monke a espada de seus inimigos!");
            monklore.add("§7-*-*-*-*-*-*-*-*-*-*");
            monkmeta.setLore((List)monklore);
            monk.setItemMeta(monkmeta);
            GuiVipastica.kits.setItem(51, monk);
            final ItemStack camel = new ItemStack(Material.SAND);
            final ItemMeta camelmeta = camel.getItemMeta();
            camelmeta.setDisplayName("§bCamel");
            final ArrayList<String> camellore = new ArrayList<String>();
            camellore.add("§7*-*-*-*-*-*-*-*-*-**-*");
            camellore.add("§7-§7Abilidade §7- Na areia tenha velocidade!");
            camellore.add("§7-*-*-*-*-*-*-*-*-*-*");
            camelmeta.setLore((List)camellore);
            camel.setItemMeta(camelmeta);
            GuiVipastica.kits.setItem(52, camel);
            final ItemStack macaco = new ItemStack(Material.VINE);
            final ItemMeta macacom = macaco.getItemMeta();
            macacom.setDisplayName("§bMacaco");
            final ArrayList<String> macacol = new ArrayList<String>();
            macacol.add("§7-*-*-*-*-*-*-*-*-*-*");
            macacol.add("§7-§7Abilidade §7- Suba pelas paredes");
            macacol.add("§7- Clicando com o Botao Direito!");
            macacol.add("§7-*-*-*-*-*-*-*-*-*-*");
            macacom.setLore((List)macacol);
            macaco.setItemMeta(macacom);
            GuiVipastica.kits.setItem(53, macaco);
            p.openInventory(GuiVipastica.kits);
        }
        return false;
    }
    
    @EventHandler
    public void KitSelector(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.CHEST && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || (e.getAction() == Action.LEFT_CLICK_BLOCK && p.hasPermission("kitmenu.vip")))) {
            Bukkit.dispatchCommand((CommandSender)p, "kitvip1");
        }
    }
}
