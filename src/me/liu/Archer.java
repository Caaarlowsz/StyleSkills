package me.liu;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;

public class Archer implements Listener, CommandExecutor {
	public static Main plugin;

	public Archer(final Main main) {
		Archer.plugin = main;
	}

	@EventHandler
	public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Arrow && ((Arrow) event.getDamager()).getShooter() instanceof Player) {
			final Arrow arrow = (Arrow) event.getDamager();
			final Player p = (Player) arrow.getShooter();
			p.getLocation().distance(event.getEntity().getLocation());
			if (event.getEntity() instanceof Player && Main.archer.contains(p.getName())) {
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0f, 1.0f);
				event.setDamage(3.0);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cArcher");
		dima.setItemMeta(souperaa);
		final ItemStack arco = new ItemStack(Material.BOW);
		final ItemMeta arcoa = arco.getItemMeta();
		arcoa.setDisplayName("§aArco");
		arco.setItemMeta(arcoa);
		arco.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		final ItemStack flecha = new ItemStack(Material.ARROW);
		final ItemMeta flecas = flecha.getItemMeta();
		flecas.setDisplayName("§7Flecha");
		flecha.setItemMeta(flecas);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("archer")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.archer")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oArcher", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			Main.archer.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { arco });
			p.getInventory().addItem(new ItemStack[] { flecha });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
