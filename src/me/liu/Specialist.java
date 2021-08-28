package me.liu;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;

public class Specialist implements Listener, CommandExecutor {
	public static Main plugin;

	public Specialist(final Main main) {
		Specialist.plugin = main;
	}

	@EventHandler
	public void specialistDeath(final PlayerDeathEvent event) {
		if (event.getEntity().getKiller() == null) {
			return;
		}
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		if (!(event.getEntity().getKiller() instanceof Player)) {
			return;
		}
		final Player k = event.getEntity().getKiller();
		if (Main.specialist.contains(k.getName())) {
			k.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EXP_BOTTLE, 1) });
		}
	}

	@EventHandler
	public void enchant(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (Main.specialist.contains(p.getName()) && p.getItemInHand().getType() == Material.BOOK) {
			p.openEnchanting(p.getLocation(), true);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cSpecialist");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack specialist = new ItemStack(Material.BOOK);
		final ItemMeta specialists = specialist.getItemMeta();
		specialists.setDisplayName("§aSpecialist's Enchant");
		specialist.setItemMeta(specialists);
		if (cmd.equalsIgnoreCase("specialist")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.specialist")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oSpecialist", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			Main.specialist.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { specialist });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
