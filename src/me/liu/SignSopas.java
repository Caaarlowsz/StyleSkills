package me.liu;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;

public class SignSopas implements Listener {
	public Main plugin;

	public SignSopas(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onSignChangeSoup(final SignChangeEvent event) {
		if (event.getLine(1).equals("Sopas")) {
			event.setLine(1, "§1Sopas");
		}
	}

	@EventHandler
	public void onSignChangePote(final SignChangeEvent event) {
		if (event.getLine(1).equals("Potes")) {
			event.setLine(1, "§1Potes");
		}
	}

	@EventHandler
	public void onSignChangeCogu(final SignChangeEvent event) {
		if (event.getLine(1).equals("CoguVermelho")) {
			event.setLine(1, "§1CoguVermelho");
		}
	}

	@EventHandler
	public void onSignChangeCogu1(final SignChangeEvent event) {
		if (event.getLine(1).equals("CoguMarrom")) {
			event.setLine(1, "§1CoguMarrom");
		}
	}

	@EventHandler
	public void onSignChangeGratis(final SignChangeEvent event) {
		if (event.getLine(0).equals("Gratis")) {
			event.setLine(0, "§6[§4Gratis§6]");
		}
	}

	@EventHandler
	public void SignClickEvent111(final PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.SIGN
				|| e.getClickedBlock().getType() == Material.SIGN_POST
				|| e.getClickedBlock().getType() == Material.WALL_SIGN)) {
			final Sign sign = (Sign) e.getClickedBlock().getState();
			if (sign.getLine(0).equalsIgnoreCase("§6[§4Gratis§6]")
					&& sign.getLine(1).equalsIgnoreCase("§1CoguVermelho")) {
				final Inventory v = Bukkit.createInventory((InventoryHolder) null, 36, "§1Free CoguVermelho");
				final ItemStack tigela = new ItemStack(Material.RED_MUSHROOM, 1);
				final ItemMeta tigelameta = tigela.getItemMeta();
				tigelameta.setDisplayName(ChatColor.RED + "Cogu Vermelho");
				tigela.setItemMeta(tigelameta);
				v.setItem(0, tigela);
				v.setItem(1, tigela);
				v.setItem(2, tigela);
				v.setItem(3, tigela);
				v.setItem(4, tigela);
				v.setItem(5, tigela);
				v.setItem(6, tigela);
				v.setItem(7, tigela);
				v.setItem(8, tigela);
				v.setItem(9, tigela);
				v.setItem(10, tigela);
				v.setItem(11, tigela);
				v.setItem(12, tigela);
				v.setItem(13, tigela);
				v.setItem(14, tigela);
				v.setItem(15, tigela);
				v.setItem(16, tigela);
				v.setItem(17, tigela);
				v.setItem(18, tigela);
				v.setItem(19, tigela);
				v.setItem(20, tigela);
				v.setItem(21, tigela);
				v.setItem(22, tigela);
				v.setItem(23, tigela);
				v.setItem(24, tigela);
				v.setItem(25, tigela);
				v.setItem(26, tigela);
				v.setItem(27, tigela);
				v.setItem(28, tigela);
				v.setItem(29, tigela);
				v.setItem(30, tigela);
				v.setItem(31, tigela);
				v.setItem(32, tigela);
				v.setItem(33, tigela);
				v.setItem(34, tigela);
				v.setItem(35, tigela);
				e.getPlayer().openInventory(v);
			}
		}
	}

	@EventHandler
	public void SignClickEvent11(final PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.SIGN
				|| e.getClickedBlock().getType() == Material.SIGN_POST
				|| e.getClickedBlock().getType() == Material.WALL_SIGN)) {
			final Sign sign = (Sign) e.getClickedBlock().getState();
			if (sign.getLine(0).equalsIgnoreCase("§6[§4Gratis§6]")
					&& sign.getLine(1).equalsIgnoreCase("§1CoguMarrom")) {
				final Inventory v = Bukkit.createInventory((InventoryHolder) null, 36, "§1Free CoguMarrom");
				final ItemStack tigela = new ItemStack(Material.BROWN_MUSHROOM, 1);
				final ItemMeta tigelameta = tigela.getItemMeta();
				tigelameta.setDisplayName(ChatColor.DARK_AQUA + "Cogu Marrom");
				tigela.setItemMeta(tigelameta);
				v.setItem(0, tigela);
				v.setItem(1, tigela);
				v.setItem(2, tigela);
				v.setItem(3, tigela);
				v.setItem(4, tigela);
				v.setItem(5, tigela);
				v.setItem(6, tigela);
				v.setItem(7, tigela);
				v.setItem(8, tigela);
				v.setItem(9, tigela);
				v.setItem(10, tigela);
				v.setItem(11, tigela);
				v.setItem(12, tigela);
				v.setItem(13, tigela);
				v.setItem(14, tigela);
				v.setItem(15, tigela);
				v.setItem(16, tigela);
				v.setItem(17, tigela);
				v.setItem(18, tigela);
				v.setItem(19, tigela);
				v.setItem(20, tigela);
				v.setItem(21, tigela);
				v.setItem(22, tigela);
				v.setItem(23, tigela);
				v.setItem(24, tigela);
				v.setItem(25, tigela);
				v.setItem(26, tigela);
				v.setItem(27, tigela);
				v.setItem(28, tigela);
				v.setItem(29, tigela);
				v.setItem(30, tigela);
				v.setItem(31, tigela);
				v.setItem(32, tigela);
				v.setItem(33, tigela);
				v.setItem(34, tigela);
				v.setItem(35, tigela);
				e.getPlayer().openInventory(v);
			}
		}
	}

	@EventHandler
	public void SignClickEvent1(final PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.SIGN
				|| e.getClickedBlock().getType() == Material.SIGN_POST
				|| e.getClickedBlock().getType() == Material.WALL_SIGN)) {
			final Sign sign = (Sign) e.getClickedBlock().getState();
			if (sign.getLine(0).equalsIgnoreCase("§6[§4Gratis§6]") && sign.getLine(1).equalsIgnoreCase("§1Potes")) {
				final Inventory v = Bukkit.createInventory((InventoryHolder) null, 36, "§1Free Potes");
				final ItemStack tigela = new ItemStack(Material.BOWL, 1);
				final ItemMeta tigelameta = tigela.getItemMeta();
				tigelameta.setDisplayName(ChatColor.GRAY + "Tigela");
				tigela.setItemMeta(tigelameta);
				v.setItem(0, tigela);
				v.setItem(1, tigela);
				v.setItem(2, tigela);
				v.setItem(3, tigela);
				v.setItem(4, tigela);
				v.setItem(5, tigela);
				v.setItem(6, tigela);
				v.setItem(7, tigela);
				v.setItem(8, tigela);
				v.setItem(9, tigela);
				v.setItem(10, tigela);
				v.setItem(11, tigela);
				v.setItem(12, tigela);
				v.setItem(13, tigela);
				v.setItem(14, tigela);
				v.setItem(15, tigela);
				v.setItem(16, tigela);
				v.setItem(17, tigela);
				v.setItem(18, tigela);
				v.setItem(19, tigela);
				v.setItem(20, tigela);
				v.setItem(21, tigela);
				v.setItem(22, tigela);
				v.setItem(23, tigela);
				v.setItem(24, tigela);
				v.setItem(25, tigela);
				v.setItem(26, tigela);
				v.setItem(27, tigela);
				v.setItem(28, tigela);
				v.setItem(29, tigela);
				v.setItem(30, tigela);
				v.setItem(31, tigela);
				v.setItem(32, tigela);
				v.setItem(33, tigela);
				v.setItem(34, tigela);
				v.setItem(35, tigela);
				e.getPlayer().openInventory(v);
			}
		}
	}

	@EventHandler
	public void SignClickEvent(final PlayerInteractEvent e) {
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.SIGN
				|| e.getClickedBlock().getType() == Material.SIGN_POST
				|| e.getClickedBlock().getType() == Material.WALL_SIGN)) {
			final Sign sign = (Sign) e.getClickedBlock().getState();
			if (sign.getLine(0).equalsIgnoreCase("§6[§4Gratis§6]") && sign.getLine(1).equalsIgnoreCase("§1Sopas")) {
				final Inventory v = Bukkit.createInventory((InventoryHolder) null, 36, "§1Free Soup");
				for (int i = 0; i < 36; ++i) {
					v.addItem(new ItemStack[] { new ItemStack(sopa) });
				}
				e.getPlayer().openInventory(v);
			}
		}
	}

	@EventHandler
	public void SignClicasdakEvent(final PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.SIGN
				|| e.getClickedBlock().getType() == Material.SIGN_POST
				|| e.getClickedBlock().getType() == Material.WALL_SIGN)) {
			final Sign sign = (Sign) e.getClickedBlock().getState();
			if (sign.getLine(1).equalsIgnoreCase("§6/main")) {
				if (!Main.used.contains(e.getPlayer().getName())) {
					final PlayerInventory inv = e.getPlayer().getInventory();
					e.getPlayer().getInventory().clear();
					final ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
					final ItemMeta souperaa = dima.getItemMeta();
					souperaa.setDisplayName("§cMain");
					dima.setItemMeta(souperaa);
					dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
					final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
					final ItemMeta sopas = sopa.getItemMeta();
					sopas.setDisplayName("§6§oSopa");
					sopa.setItemMeta(sopas);
					e.getPlayer().getInventory().addItem(new ItemStack[] { dima });
					for (int i = 0; i <= 34; ++i) {
						e.getPlayer().getInventory().addItem(new ItemStack[] { sopa });
					}
					final ItemStack ahelm = new ItemStack(Material.IRON_HELMET);
					final ItemStack achest = new ItemStack(Material.IRON_CHESTPLATE);
					final ItemStack alegs = new ItemStack(Material.IRON_LEGGINGS);
					final ItemStack aboots = new ItemStack(Material.IRON_BOOTS);
					final ItemStack[] armor = { aboots, alegs, achest, ahelm };
					inv.setArmorContents(armor);
					e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), 800.5, 118.9, -52.3));
					BarAPI.setMessage(e.getPlayer(), "§bVoce foi teleportado para §7§oMain", 3);
				} else {
					e.getPlayer()
							.sendMessage(ChatColor.RED + "Voce ja escolheu um kit. Digite /suicide para ir a Main.");
				}
			}
		}
	}

	@EventHandler
	public void SignClicasdasdakEvent(final PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.SIGN
				|| e.getClickedBlock().getType() == Material.SIGN_POST
				|| e.getClickedBlock().getType() == Material.WALL_SIGN)) {
			final Sign sign = (Sign) e.getClickedBlock().getState();
			if (sign.getLine(1).equalsIgnoreCase("§6/fps")) {
				if (Main.pvp.contains(e.getPlayer().getName())) {
					e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), 863.5, 146.9, -678.5));
					BarAPI.setMessage(e.getPlayer(), "§bVoce foi teleportado para §7§lFPS", 4);
				} else {
					e.getPlayer().sendMessage(ChatColor.RED + "Voce so pode ir com o kit pvp. De /pvp.");
				}
			}
		}
	}

	@EventHandler
	public void SignClicasdakasdEvent(final PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.SIGN
				|| e.getClickedBlock().getType() == Material.SIGN_POST
				|| e.getClickedBlock().getType() == Material.WALL_SIGN)) {
			final Sign sign = (Sign) e.getClickedBlock().getState();
			if (sign.getLine(1).equalsIgnoreCase("§6/challenge")) {
				if (Main.pvp.contains(e.getPlayer().getName())) {
					e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), 125.5, 92.9, 457.5));
					BarAPI.setMessage(e.getPlayer(), "§bVoce foi teleportado para §7§oLava Challange", 3);
				} else {
					e.getPlayer().sendMessage(ChatColor.RED + "Voce so pode ir com o kit pvp. De /pvp.");
				}
			}
		}
	}

	@EventHandler
	public void SignClicasdaaskEvent(final PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK && (event.getClickedBlock().getType() == Material.SIGN
				|| event.getClickedBlock().getType() == Material.SIGN_POST
				|| event.getClickedBlock().getType() == Material.WALL_SIGN)) {
			final Sign sign = (Sign) event.getClickedBlock().getState();
			if (sign.getLine(1).equalsIgnoreCase("§6/hg")) {
				if (!Main.used.contains(event.getPlayer().getName())) {
					event.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
					event.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
					event.getPlayer().removePotionEffect(PotionEffectType.CONFUSION);
					event.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					event.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
					event.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					event.getPlayer().removePotionEffect(PotionEffectType.HARM);
					event.getPlayer().removePotionEffect(PotionEffectType.HEAL);
					event.getPlayer().removePotionEffect(PotionEffectType.HEALTH_BOOST);
					event.getPlayer().removePotionEffect(PotionEffectType.HUNGER);
					event.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					event.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
					event.getPlayer().removePotionEffect(PotionEffectType.JUMP);
					event.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
					event.getPlayer().removePotionEffect(PotionEffectType.POISON);
					event.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
					event.getPlayer().removePotionEffect(PotionEffectType.SATURATION);
					event.getPlayer().removePotionEffect(PotionEffectType.SLOW);
					event.getPlayer().removePotionEffect(PotionEffectType.SLOW_DIGGING);
					event.getPlayer().removePotionEffect(PotionEffectType.SPEED);
					event.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
					event.getPlayer().removePotionEffect(PotionEffectType.WEAKNESS);
					event.getPlayer().removePotionEffect(PotionEffectType.WITHER);
					event.getPlayer().getInventory().setArmorContents((ItemStack[]) null);
					event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 1099.3, 77.9, 1001.6));
					event.getPlayer().getInventory().clear();
					final ItemStack kits = new ItemStack(Material.CHEST);
					final ItemMeta kitsm = kits.getItemMeta();
					kitsm.setDisplayName("§4Veja os Kits");
					final ArrayList<String> archerlore = new ArrayList<String>();
					archerlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
					archerlore.add("§b-Clique para abrir o menu de kits!");
					archerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
					kitsm.setLore(archerlore);
					kits.setItemMeta(kitsm);
					event.getPlayer().getInventory().setItem(0, kits);
					final ItemStack kitsa = new ItemStack(Material.EMERALD);
					final ItemMeta kitsma = kitsa.getItemMeta();
					kitsma.setDisplayName("§aShop");
					final ArrayList<String> archerlorea = new ArrayList<String>();
					archerlorea.add("§7*-*-*-*-*-*-*-*-*-**-*");
					archerlorea.add("§b-Em Breve!");
					archerlorea.add("§7-*-*-*-*-*-*-*-*-*-*");
					kitsma.setLore(archerlorea);
					kitsa.setItemMeta(kitsma);
					event.getPlayer().getInventory().setItem(8, kitsa);
					BarAPI.setMessage(event.getPlayer(), "§bVoce foi teleportado para §7§lEarlyHG", 4);
				} else {
					event.getPlayer().sendMessage(ChatColor.RED + "Voce nao pode ir para earlyhg com kits!");
				}
			}
		}
	}
}
