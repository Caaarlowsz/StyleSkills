package me.liu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;

public class Kangaroo implements Listener, CommandExecutor {
	public static Main plugin;
	ArrayList<Player> kanga;
	static List<Player> kangacd;

	static {
		Kangaroo.kangacd = new ArrayList<Player>();
	}

	public Kangaroo(final Main main) {
		this.kanga = new ArrayList<Player>();
		Kangaroo.plugin = main;
	}

	@EventHandler
	public void onInteract(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.FIREWORK && Main.kangaroo.contains(p.getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (!this.kanga.contains(p)) {
				if (!p.isSneaking()) {
					p.setFallDistance(-3.0f);
					final Vector vector = p.getEyeLocation().getDirection();
					vector.multiply(0.6f);
					vector.setY(1.0f);
					p.setVelocity(vector);
				} else {
					p.setFallDistance(-3.0f);
					final Vector vector = p.getEyeLocation().getDirection();
					vector.multiply(1.35f);
					vector.setY(0.66);
					p.setVelocity(vector);
				}
				this.kanga.add(p);
			}
		}
	}

	@EventHandler
	public void onMove(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (this.kanga.contains(p)) {
			final Block b = p.getLocation().getBlock();
			if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
				this.kanga.remove(p);
			}
		}
	}

	@EventHandler
	public void onDrop(final PlayerDropItemEvent event) {
		if (event.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onDamage(final EntityDamageEvent event) {
		final Entity e = event.getEntity();
		if (e instanceof Player) {
			final Player player = (Player) e;
			if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL
					&& player.getInventory().contains(Material.FIREWORK) && event.getDamage() >= 12.0) {
				event.setDamage(12.0);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cKangaroo");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack kanga = new ItemStack(Material.FIREWORK);
		final ItemMeta name33 = kanga.getItemMeta();
		name33.setDisplayName("§6Style Kangaroo");
		kanga.setItemMeta(name33);
		if (cmd.equalsIgnoreCase("kangaroo")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.kangaroo")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oKangaroo", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			Main.kangaroo.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { kanga });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
