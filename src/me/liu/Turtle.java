package me.liu;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;

public class Turtle implements Listener, CommandExecutor {
	public static Main plugin;

	public Turtle(final Main main) {
		Turtle.plugin = main;
	}

	@EventHandler
	public void turtleEntityDamageToOtherEvent(final EntityDamageByEntityEvent event) {
		if (!(event.getDamager() instanceof Player)) {
			return;
		}
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getDamager();
		if (Main.turtle.contains(player.getName()) && player.isSneaking()) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void turtleEvent(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!Main.turtle.contains(((Player) e.getEntity()).getName())) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (p.isSneaking() && (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION
				|| e.getCause() == EntityDamageEvent.DamageCause.CONTACT
				|| e.getCause() == EntityDamageEvent.DamageCause.CUSTOM
				|| e.getCause() == EntityDamageEvent.DamageCause.DROWNING
				|| e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK
				|| e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION
				|| e.getCause() == EntityDamageEvent.DamageCause.FALL
				|| e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK
				|| e.getCause() == EntityDamageEvent.DamageCause.FIRE
				|| e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK
				|| e.getCause() == EntityDamageEvent.DamageCause.LAVA
				|| e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING
				|| e.getCause() == EntityDamageEvent.DamageCause.MAGIC
				|| e.getCause() == EntityDamageEvent.DamageCause.MELTING
				|| e.getCause() == EntityDamageEvent.DamageCause.POISON
				|| e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE
				|| e.getCause() == EntityDamageEvent.DamageCause.STARVATION
				|| e.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION
				|| e.getCause() == EntityDamageEvent.DamageCause.THORNS
				|| e.getCause() == EntityDamageEvent.DamageCause.VOID
				|| e.getCause() == EntityDamageEvent.DamageCause.WITHER)) {
			e.setDamage(2.0);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cTurtle");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("turtle")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.turtle")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			p.setGameMode(GameMode.SURVIVAL);
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oTurtle", 5);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			Main.turtle.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
