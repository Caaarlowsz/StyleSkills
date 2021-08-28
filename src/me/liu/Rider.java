package me.liu;

import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;

public class Rider implements Listener, CommandExecutor {
	public static Main plugin;
	public static ItemStack[] armorContents;
	public static ItemStack[] inventoryContents;
	public int horseHealth;
	public String horseName;
	public double jumpStrength;
	public boolean modifyHorseStats;
	public boolean nameHorse;
	public boolean preventOthersFromUsing;
	public long cooldownLenght;
	private HashMap<Player, Horse> horses;
	public double runSpeed;

	public Rider(final Main main) {
		this.horseHealth = 40;
		this.horseName = "%s";
		this.jumpStrength = 1.0;
		this.modifyHorseStats = true;
		this.nameHorse = true;
		this.preventOthersFromUsing = true;
		this.cooldownLenght = 0L;
		this.horses = new HashMap<Player, Horse>();
		this.runSpeed = 1.0;
		Rider.plugin = main;
	}

	@EventHandler
	public void onClick888(final InventoryClickEvent event) {
		if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.SADDLE
				&& event.getWhoClicked().getVehicle() != null
				&& this.horses.containsValue(event.getWhoClicked().getVehicle())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onEntityDeath(final EntityDeathEvent event) {
		if (this.horses.containsValue(event.getEntity())) {
			event.setDroppedExp(0);
			final Iterator<Player> itel = this.horses.keySet().iterator();
			while (itel.hasNext()) {
				if (this.horses.get(itel.next()) == event.getEntity()) {
					itel.remove();
				}
			}
		}
	}

	@EventHandler
	public void onInteract4(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR && p.getItemInHand().getType() == Material.SADDLE) {
			if (this.horses.containsKey(p)) {
				final Horse horse = this.horses.remove(p);
				if (!horse.isDead()) {
					horse.eject();
					horse.leaveVehicle();
					horse.remove();
				}
			} else {
				final Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
				this.horses.put(p, horse);
				if (this.nameHorse) {
					horse.setCustomName(String.format(this.horseName, "§4Cavalo de §a" + p.getName()));
					horse.setCustomNameVisible(true);
				}
				horse.setBreed(false);
				horse.setTamed(true);
				horse.setDomestication(horse.getMaxDomestication());
				horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
				horse.setOwner((AnimalTamer) p);
				if (this.modifyHorseStats) {
					horse.setJumpStrength(this.jumpStrength);
					horse.setMaxHealth((double) this.horseHealth);
					horse.setHealth((double) this.horseHealth);
					horse.setColor(Horse.Color.WHITE);
				}
			}
		}
	}

	@EventHandler
	public void onRightClick1(final PlayerInteractEntityEvent event) {
		if (this.preventOthersFromUsing && this.horses.containsValue(event.getRightClicked())) {
			for (final Player p : this.horses.keySet()) {
				if (this.horses.get(p) == event.getRightClicked() && event.getPlayer() != p) {
					event.setCancelled(true);
					break;
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cRider");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack rider = new ItemStack(Material.SADDLE);
		final ItemMeta ridera = rider.getItemMeta();
		ridera.setDisplayName("§a§oRider Saddle");
		rider.setItemMeta(ridera);
		if (cmd.equalsIgnoreCase("rider")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.rider")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oRider", 5);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			Main.rider.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { rider });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
