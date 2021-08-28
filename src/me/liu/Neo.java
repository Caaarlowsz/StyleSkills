package me.liu;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;

public class Neo implements Listener, CommandExecutor {
	public static Main plugin;

	public Neo(final Main main) {
		Neo.plugin = main;
	}

	@EventHandler
	public void neoEvent(final EntityDamageByEntityEvent event) {
		if (event.getCause() != EntityDamageEvent.DamageCause.PROJECTILE) {
			return;
		}
		final Projectile proj = (Projectile) event.getDamager();
		if (!(proj.getShooter() instanceof Player)) {
			return;
		}
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Entity shot = event.getEntity();
		if (!Main.neo.contains(((Player) shot).getName())) {
			return;
		}
		event.setCancelled(true);
		((Player) shot).launchProjectile(proj.getClass());
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cNeo");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("neo")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.neo")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oNeo", 5);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			Main.neo.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
