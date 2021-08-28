package me.liu.Gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.liu.Main;

public class GuiVipastica2 implements CommandExecutor, Listener {
	public Main plugin;
	public static Inventory kits;

	static {
		GuiVipastica2.kits = Bukkit.createInventory((InventoryHolder) null, 54, "§aSeus Kits Pagina 2:");
	}

	public GuiVipastica2(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void Click(final InventoryClickEvent e) {
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null) {
			final Inventory inv = e.getInventory();
			final Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§aSeus Kits Pagina 2:")) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7-")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("-")) {
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAvancar -->")) {
					Bukkit.dispatchCommand((CommandSender) p, "kitvip2");
					e.setCancelled(true);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPvP")) {
					Bukkit.dispatchCommand((CommandSender) p, "pvp");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bArcher")) {
					Bukkit.dispatchCommand((CommandSender) p, "archer");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bKangaroo")) {
					Bukkit.dispatchCommand((CommandSender) p, "kangaroo");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFisherman")) {
					Bukkit.dispatchCommand((CommandSender) p, "fisherman");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bBackpacker")) {
					Bukkit.dispatchCommand((CommandSender) p, "backpacker");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFrosty")) {
					Bukkit.dispatchCommand((CommandSender) p, "frosty");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bMilkman")) {
					Bukkit.dispatchCommand((CommandSender) p, "milkman");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCultivator")) {
					Bukkit.dispatchCommand((CommandSender) p, "cultivator");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bViking")) {
					Bukkit.dispatchCommand((CommandSender) p, "viking");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSwitcher")) {
					Bukkit.dispatchCommand((CommandSender) p, "switcher");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGrappler")) {
					Bukkit.dispatchCommand((CommandSender) p, "grappler");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTurtle")) {
					Bukkit.dispatchCommand((CommandSender) p, "turtle");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bFlash")) {
					Bukkit.dispatchCommand((CommandSender) p, "flash");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bThor")) {
					Bukkit.dispatchCommand((CommandSender) p, "thor");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSnowman")) {
					Bukkit.dispatchCommand((CommandSender) p, "snowman");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bHealer")) {
					Bukkit.dispatchCommand((CommandSender) p, "healer");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSonic")) {
					Bukkit.dispatchCommand((CommandSender) p, "sonic");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPhantom")) {
					Bukkit.dispatchCommand((CommandSender) p, "phantom");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGrandpa")) {
					Bukkit.dispatchCommand((CommandSender) p, "grandpa");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLifeline")) {
					Bukkit.dispatchCommand((CommandSender) p, "lifeline");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGambler")) {
					Bukkit.dispatchCommand((CommandSender) p, "gambler");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bDarkmage")) {
					Bukkit.dispatchCommand((CommandSender) p, "darkmage");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSpectre")) {
					Bukkit.dispatchCommand((CommandSender) p, "spectre");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bAnchor")) {
					Bukkit.dispatchCommand((CommandSender) p, "anchor");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSalamander")) {
					Bukkit.dispatchCommand((CommandSender) p, "salamander");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bReaper")) {
					Bukkit.dispatchCommand((CommandSender) p, "reaper");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bChemist")) {
					Bukkit.dispatchCommand((CommandSender) p, "chemist");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPyro")) {
					Bukkit.dispatchCommand((CommandSender) p, "pyro");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bStomper")) {
					Bukkit.dispatchCommand((CommandSender) p, "stomper");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bMacaco")) {
					Bukkit.dispatchCommand((CommandSender) p, "macaco");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTank")) {
					Bukkit.dispatchCommand((CommandSender) p, "tank");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bUrgal")) {
					Bukkit.dispatchCommand((CommandSender) p, "urgal");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bNeo")) {
					Bukkit.dispatchCommand((CommandSender) p, "neo");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bEndermage")) {
					Bukkit.dispatchCommand((CommandSender) p, "endermage");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTank")) {
					Bukkit.dispatchCommand((CommandSender) p, "tank");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bViper")) {
					Bukkit.dispatchCommand((CommandSender) p, "viper");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSnail")) {
					Bukkit.dispatchCommand((CommandSender) p, "snail");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTimelord")) {
					Bukkit.dispatchCommand((CommandSender) p, "timelord");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bRider")) {
					Bukkit.dispatchCommand((CommandSender) p, "rider");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bSpecialist")) {
					Bukkit.dispatchCommand((CommandSender) p, "specialist");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPoseidon")) {
					Bukkit.dispatchCommand((CommandSender) p, "poseidon");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCookieMonster")) {
					Bukkit.dispatchCommand((CommandSender) p, "cookiemonster");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bVampire")) {
					Bukkit.dispatchCommand((CommandSender) p, "vampire");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bHulk")) {
					Bukkit.dispatchCommand((CommandSender) p, "hulk");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bBerserker")) {
					Bukkit.dispatchCommand((CommandSender) p, "berserker");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bMonk")) {
					Bukkit.dispatchCommand((CommandSender) p, "monk");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCamel")) {
					Bukkit.dispatchCommand((CommandSender) p, "camel");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bLauncher")) {
					Bukkit.dispatchCommand((CommandSender) p, "launcher");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bRobinHood")) {
					Bukkit.dispatchCommand((CommandSender) p, "robinhood");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bGladiator")) {
					Bukkit.dispatchCommand((CommandSender) p, "gladiator");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 2.0f, 2.0f);
					e.setCancelled(true);
					p.closeInventory();
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (commandLabel.equalsIgnoreCase("kits") || commandLabel.equalsIgnoreCase("kit")
				|| (commandLabel.equalsIgnoreCase("kitvip2") && p.hasPermission("kitmenu.vip"))) {
			GuiVipastica2.kits.clear();
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 10.0f, 5.0f);
			final ItemStack glass = new ItemStack(Material.THIN_GLASS);
			final ItemMeta glassmeta = glass.getItemMeta();
			glassmeta.setDisplayName("§7-");
			glass.setItemMeta(glassmeta);
			GuiVipastica2.kits.setItem(1, glass);
			GuiVipastica2.kits.setItem(2, glass);
			GuiVipastica2.kits.setItem(3, glass);
			GuiVipastica2.kits.setItem(5, glass);
			GuiVipastica2.kits.setItem(6, glass);
			GuiVipastica2.kits.setItem(7, glass);
			final ItemStack a = new ItemStack(Material.CARPET);
			final ItemMeta aa = a.getItemMeta();
			aa.setDisplayName("-");
			a.setItemMeta(aa);
			GuiVipastica2.kits.setItem(0, a);
			final ItemStack po = new ItemStack(Material.getMaterial(289));
			final ItemMeta pom = po.getItemMeta();
			pom.setDisplayName("-");
			po.setItemMeta(pom);
			GuiVipastica2.kits.setItem(4, po);
			final ItemStack av = new ItemStack(Material.CARPET);
			final ItemMeta ava = av.getItemMeta();
			ava.setDisplayName("§aAvancar -->");
			av.setItemMeta(ava);
			GuiVipastica2.kits.setItem(8, av);
			final ItemStack launcher = new ItemStack(Material.SPONGE);
			final ItemMeta launcherm = launcher.getItemMeta();
			launcherm.setDisplayName("§bLauncher");
			final ArrayList<String> launcherl = new ArrayList<String>();
			launcherl.add("§7-*-*-*-*-*-*-*-*-*-*");
			launcherl.add("§7-§7Abilidade §7- Clique em alguem para ela ser jogada!");
			launcherl.add("§7-*-*-*-*-*-*-*-*-*-*");
			launcherm.setLore(launcherl);
			launcher.setItemMeta(launcherm);
			GuiVipastica2.kits.setItem(9, launcher);
			final ItemStack vacuum = new ItemStack(Material.ARROW);
			final ItemMeta vacuumm = vacuum.getItemMeta();
			vacuumm.setDisplayName("§bRobinHood");
			final ArrayList<String> vacuuml = new ArrayList<String>();
			vacuuml.add("§7-*-*-*-*-*-*-*-*-*-*");
			vacuuml.add("§7-§7Abilidade §7- Mate com 1 hit!");
			vacuuml.add("§7-*-*-*-*-*-*-*-*-*-*");
			vacuumm.setLore(launcherl);
			vacuum.setItemMeta(vacuumm);
			GuiVipastica2.kits.setItem(10, vacuum);
			final ItemStack gladiator = new ItemStack(Material.IRON_FENCE);
			final ItemMeta gladiatorm = gladiator.getItemMeta();
			gladiatorm.setDisplayName("§bGladiator");
			final ArrayList<String> gladiatorl = new ArrayList<String>();
			gladiatorl.add("§7-*-*-*-*-*-*-*-*-*-*");
			gladiatorl.add("§7-§7Abilidade §7- Puxe para 1v1");
			gladiatorl.add("§7-*-*-*-*-*-*-*-*-*-*");
			gladiatorm.setLore(gladiatorl);
			gladiator.setItemMeta(gladiatorm);
			GuiVipastica2.kits.setItem(11, gladiator);
			p.openInventory(GuiVipastica2.kits);
		}
		return false;
	}

	@EventHandler
	public void KitSelector(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.CHEST && (e.getAction() == Action.RIGHT_CLICK_AIR
				|| e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR
				|| (e.getAction() == Action.LEFT_CLICK_BLOCK && p.hasPermission("kitmenu.vip")))) {
			Bukkit.dispatchCommand((CommandSender) p, "kits");
		}
	}
}
