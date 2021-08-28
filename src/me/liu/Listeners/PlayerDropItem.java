package me.liu.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import me.liu.Main;

public class PlayerDropItem implements Listener {
	public Main plugin;

	public PlayerDropItem(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void noPegarItens1(final PlayerPickupItemEvent e) {
		final Material type = e.getItem().getItemStack().getType();
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
			e.setCancelled(true);
		} else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onItemDrop(final ItemSpawnEvent e) {
		e.setCancelled(true);
	}
}
