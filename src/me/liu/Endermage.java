package me.liu;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;

public class Endermage implements Listener, CommandExecutor {
	public static Main plugin;

	public Endermage(final Main main) {
		Endermage.plugin = main;
	}

	@EventHandler
	public void lelEndermage(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (Main.endermage.contains(p.getName()) && p.getItemInHand().getType() == Material.PORTAL
				&& event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			event.setCancelled(true);
			if (!event.getClickedBlock().getLocation().add(0.0, 2.0, 0.0).getBlock().isEmpty()) {
				p.sendMessage("§cSao necessarios 2 blocos de espaco!");
				event.setCancelled(true);
				return;
			}
			final List<Entity> nearby = (List<Entity>) p.getNearbyEntities(2.0, 300.0, 2.0);
			for (final Entity tmp : nearby) {
				if (tmp != null && tmp instanceof Player) {
					final Block block = event.getClickedBlock().getRelative(BlockFace.UP);
					final Location loc = block.getLocation();
					tmp.teleport(loc);
					p.teleport(loc);
					((Player) tmp).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 10));
					((Player) tmp).sendMessage("§cVoce teleportou alguem!");
					((Player) tmp).sendMessage("§cTem 5 segundos de invencibilidade corra ou lute!");
					p.sendMessage("§cVoce foi teleportado por um endermage!");
					p.sendMessage("§cTem 5 segundos de invencibilidade corra ou lute!");
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 10));
					Main.endermage.add(p.getName());
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cEndermage");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack endermage = new ItemStack(Material.PORTAL);
		final ItemMeta endermagea = endermage.getItemMeta();
		endermagea.setDisplayName("§5Endermage Portal");
		endermage.setItemMeta(endermagea);
		if (cmd.equalsIgnoreCase("endermage")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.endermage")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			Main.endermage.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oEndermage", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { endermage });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
