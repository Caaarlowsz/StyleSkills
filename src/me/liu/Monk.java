package me.liu;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;

public class Monk implements Listener, CommandExecutor {
	public static Main plugin;

	public Monk(final Main main) {
		Monk.plugin = main;
	}

	@EventHandler
	public void monk(final PlayerInteractEntityEvent event) {
		final ItemStack item = event.getPlayer().getItemInHand();
		if (Main.monk.contains(event.getPlayer().getName()) && event.getRightClicked() instanceof Player
				&& item.getTypeId() == Monk.plugin.monkItemId) {
			long lastUsed = 0L;
			if (Monk.plugin.monkStaff.containsKey(item)) {
				lastUsed = Monk.plugin.monkStaff.get(item);
			}
			if (lastUsed + 1000 * Monk.plugin.cooldownmonk > System.currentTimeMillis()) {
				event.getPlayer().sendMessage(String.format(Monk.plugin.monkCooldownMessage,
						-((System.currentTimeMillis() - (lastUsed + 1000 * Monk.plugin.cooldownmonk)) / 1000L)));
			} else {
				final PlayerInventory inv = ((Player) event.getRightClicked()).getInventory();
				final int slot = new Random().nextInt(Monk.plugin.sendThroughInventory ? 36 : 9);
				ItemStack replaced = inv.getItemInHand();
				if (replaced == null) {
					replaced = new ItemStack(0);
				}
				ItemStack replacer = inv.getItem(slot);
				if (replacer == null) {
					replacer = new ItemStack(0);
				}
				inv.setItemInHand(replacer);
				inv.setItem(slot, replaced);
				Monk.plugin.monkStaff.put(item, System.currentTimeMillis());
				event.getPlayer().sendMessage("(plugin.monkedMessage)");
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cMonk");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack monk = new ItemStack(Material.BLAZE_ROD);
		final ItemMeta ims = monk.getItemMeta();
		ims.setDisplayName("§6Style Monk");
		monk.setItemMeta(ims);
		if (cmd.equalsIgnoreCase("monk")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.monk")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oMonk", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			Main.monk.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { monk });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
