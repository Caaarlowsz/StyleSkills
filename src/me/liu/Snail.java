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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;

public class Snail implements Listener, CommandExecutor {
	public static Main plugin;

	public Snail(final Main main) {
		Snail.plugin = main;
	}

	@EventHandler
	public void snailEvent(final EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getDamager();
		final Player player2 = (Player) event.getEntity();
		if (!Main.snail.contains(player.getName())) {
			return;
		}
		if (Math.random() > 0.4 && Math.random() < 0.1) {
			player2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1));
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cSnail");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("snail")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.snail")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oSnail", 5);
			p.setGameMode(GameMode.SURVIVAL);
			Main.snail.add(p.getName());
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
