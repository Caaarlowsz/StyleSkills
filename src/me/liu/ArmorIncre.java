package me.liu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ArmorIncre implements Listener {
	public static Main plugin;

	public ArmorIncre(final Main main) {
		ArmorIncre.plugin = main;
	}

	@EventHandler
	public void onBlockBreak(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (!p.isOp()) {
			e.setCancelled(true);
			p.sendMessage("§cVoce nao pode quebrar blocos.");
		} else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onBlockBreakasd(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (!p.isOp()) {
			e.setCancelled(true);
			p.sendMessage("§cVoce nao pode colocar blocos.");
		} else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void semQuebrar(final EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			final Player p = (Player) event.getDamager();
			if (p.getItemInHand().getType().equals((Object) Material.WOOD_SWORD)
					|| p.getItemInHand().getType().equals((Object) Material.STONE_SWORD)
					|| p.getItemInHand().getType().equals((Object) Material.GOLD_SWORD)
					|| p.getItemInHand().getType().equals((Object) Material.IRON_SWORD)
					|| p.getItemInHand().getType().equals((Object) Material.DIAMOND_SWORD)
					|| p.getItemInHand().getType().equals((Object) Material.STONE_AXE)
					|| p.getItemInHand().getType().equals((Object) Material.WOOD_AXE)
					|| p.getItemInHand().getType().equals((Object) Material.GOLD_AXE)
					|| p.getItemInHand().getType().equals((Object) Material.FISHING_ROD)) {
				p.getItemInHand().setDurability((short) (-p.getItemInHand().getType().getMaxDurability()));
			}
		}
	}
}
