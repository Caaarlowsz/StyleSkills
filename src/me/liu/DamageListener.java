package me.liu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {
	public static Main plugin;

	public DamageListener(final Main main) {
		DamageListener.plugin = main;
	}

	@EventHandler
	public void onEntityDamageByEntityasdasdasdf(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player && ((Player) event.getDamager()) instanceof Player) {
			final Player p = (Player) event.getDamager();
			if (event.getEntity() instanceof Player && p.getItemInHand().getType() == Material.WOOD_SWORD) {
				event.setDamage(event.getDamage() * 0.66);
			}
		}
	}

	@EventHandler
	public void onEntityDamageByEntityasdsadf(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player && ((Player) event.getDamager()) instanceof Player) {
			final Player p = (Player) event.getDamager();
			if (event.getEntity() instanceof Player && p.getItemInHand().getType() == Material.STONE_SWORD) {
				event.setDamage(event.getDamage() * 0.66);
			}
		}
	}

	@EventHandler
	public void onEntityDamageByEntityassadasdasdf(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player && ((Player) event.getDamager()) instanceof Player) {
			final Player p = (Player) event.getDamager();
			if (event.getEntity() instanceof Player && p.getItemInHand().getType() == Material.IRON_SWORD) {
				event.setDamage(event.getDamage() * 0.66);
			}
		}
	}

	@EventHandler
	public void onEntityDamageByEntiasdasdtyasdf(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player && ((Player) event.getDamager()) instanceof Player) {
			final Player p = (Player) event.getDamager();
			if (event.getEntity() instanceof Player && p.getItemInHand().getType() == Material.GOLD_SWORD) {
				event.setDamage(event.getDamage() * 0.66);
			}
		}
	}

	@EventHandler
	public void onEntityDamageByEntitasdaasdf(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player && ((Player) event.getDamager()) instanceof Player) {
			final Player p = (Player) event.getDamager();
			if (event.getEntity() instanceof Player && p.getItemInHand().getType() == Material.DIAMOND_SWORD) {
				event.setDamage(event.getDamage() * 0.66);
			}
		}
	}

	@EventHandler
	public void onEntityDamageByasdasEntitya(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player && ((Player) event.getDamager()) instanceof Player) {
			final Player p = (Player) event.getDamager();
			if (event.getEntity() instanceof Player && p.getItemInHand().getType() == Material.GOLD_AXE) {
				event.setDamage(0.0);
			}
		}
	}
}
