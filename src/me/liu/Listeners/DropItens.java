package me.liu.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.liu.Main;

public class DropItens implements Listener {
	public Main plugin;

	public DropItens(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onDropSword(final PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() == Material.SUGAR_CANE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.CHEST) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.VINE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.BEACON) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.APPLE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.GOLD_AXE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.REDSTONE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.WOOD_AXE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.LEASH) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.IRON_SWORD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_AXE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.WATCH) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void cancelDrops(final PlayerDropItemEvent event) {
		final Material type = event.getItemDrop().getItemStack().getType();
		if (type == Material.IRON_SWORD || type == Material.BONE || type == Material.STONE_AXE || type == Material.BOOK
				|| type == Material.FISHING_ROD || type == Material.COOKIE || type == Material.WOOD_AXE
				|| type == Material.REDSTONE_TORCH_ON || type == Material.WOOD_SWORD || type == Material.FEATHER
				|| type == Material.REDSTONE_TORCH_OFF || type == Material.SNOW_BALL || type == Material.LEASH
				|| type == Material.SUGAR_CANE || type == Material.ARROW || type == Material.BLAZE_ROD
				|| type == Material.GOLD_AXE || type == Material.MAGMA_CREAM || type == Material.STONE_SWORD
				|| type == Material.ENDER_PEARL || type == Material.STICK || type == Material.GLOWSTONE_DUST
				|| type == Material.GOLD_SWORD || type == Material.GOLDEN_APPLE || type == Material.PORTAL
				|| type == Material.REDSTONE || type == Material.BOW || type == Material.EGG
				|| type == Material.DIAMOND_SPADE || type == Material.IRON_FENCE || type == Material.LEATHER
				|| type == Material.WATCH || type == Material.FIREWORK || type == Material.MILK_BUCKET
				|| type == Material.SADDLE || type == Material.SNOW_BALL) {
			event.setCancelled(true);
		}
	}
}
