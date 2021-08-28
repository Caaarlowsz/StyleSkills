package me.liu.Listeners;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class PlayerRespawn implements Listener {
	@EventHandler
	public void onRespawn(final PlayerRespawnEvent e) {
		final Player player = e.getPlayer();
		player.getInventory().setArmorContents((ItemStack[]) null);
		player.teleport(player.getWorld().getSpawnLocation());
		player.getInventory().clear();
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
		final ItemStack kits = new ItemStack(Material.CHEST);
		final ItemMeta kitsm = kits.getItemMeta();
		kitsm.setDisplayName("§4Veja os Kits");
		final ArrayList<String> archerlore = new ArrayList<String>();
		archerlore.add("§7*-*-*-*-*-*-*-*-*-**-*");
		archerlore.add("§b-Clique para abrir o menu de kits!");
		archerlore.add("§7-*-*-*-*-*-*-*-*-*-*");
		kitsm.setLore(archerlore);
		kits.setItemMeta(kitsm);
		player.getInventory().setItem(0, kits);
		final ItemStack kitsa = new ItemStack(Material.EMERALD);
		final ItemMeta kitsma = kitsa.getItemMeta();
		kitsma.setDisplayName("§aShop");
		final ArrayList<String> archerlorea = new ArrayList<String>();
		archerlorea.add("§7*-*-*-*-*-*-*-*-*-**-*");
		archerlorea.add("§b-Em Breve!");
		archerlorea.add("§7-*-*-*-*-*-*-*-*-*-*");
		kitsma.setLore(archerlorea);
		kitsa.setItemMeta(kitsma);
		player.getInventory().setItem(8, kitsa);
	}
}
