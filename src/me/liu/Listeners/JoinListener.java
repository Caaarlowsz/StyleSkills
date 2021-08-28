package me.liu.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;

public class JoinListener implements Listener {
	FileConfiguration cfg;

	public JoinListener(final FileConfiguration config) {
		this.cfg = config;
	}

	@EventHandler
	public void noPlace(final BlockPlaceEvent e) {
		if (e.getBlock().getType() == Material.CHEST) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void noPlaceasasd(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (p.hasPermission("style.colocar")) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void noPlaceas(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (!p.hasPermission("style.colocar") && e.getBlock().getType() == Material.SIGN) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void joinEvents(final PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		BarAPI.setMessage(player, "§6§oBem Vindo §5§o" + player.getName() + ", §6§oao §4§oStylePvP", 4);
		player.sendMessage("§c------------------=------------------");
		Bukkit.dispatchCommand((CommandSender) player, "list");
		player.sendMessage("§7Comandos");
		player.sendMessage("§7/kits");
		player.sendMessage("§7/suicide");
		player.sendMessage("§7/msg");
		player.sendMessage("§7/tell");
		player.sendMessage("§7/lag");
		player.sendMessage("§7/ping");
		player.sendMessage("§7/report");
		player.sendMessage("§7/tag");
		player.sendMessage("§c------------------=------------------");
		event.setJoinMessage("");
		player.removePotionEffect(PotionEffectType.ABSORPTION);
		player.removePotionEffect(PotionEffectType.BLINDNESS);
		player.removePotionEffect(PotionEffectType.CONFUSION);
		player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		player.removePotionEffect(PotionEffectType.FAST_DIGGING);
		player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		player.removePotionEffect(PotionEffectType.HARM);
		player.removePotionEffect(PotionEffectType.HEAL);
		player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
		player.removePotionEffect(PotionEffectType.HUNGER);
		player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		player.removePotionEffect(PotionEffectType.INVISIBILITY);
		player.removePotionEffect(PotionEffectType.JUMP);
		player.removePotionEffect(PotionEffectType.NIGHT_VISION);
		player.removePotionEffect(PotionEffectType.POISON);
		player.removePotionEffect(PotionEffectType.REGENERATION);
		player.removePotionEffect(PotionEffectType.SATURATION);
		player.removePotionEffect(PotionEffectType.SLOW);
		player.removePotionEffect(PotionEffectType.SLOW_DIGGING);
		player.removePotionEffect(PotionEffectType.SPEED);
		player.removePotionEffect(PotionEffectType.WATER_BREATHING);
		player.removePotionEffect(PotionEffectType.WEAKNESS);
		player.removePotionEffect(PotionEffectType.WITHER);
		player.getInventory().setArmorContents((ItemStack[]) null);
		player.teleport(player.getWorld().getSpawnLocation());
		player.getInventory().clear();
		player.sendMessage("§6Va ate a area das warps clique na placa e va para la!");
	}
}
