package me.liu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;

public class Salamander implements Listener, CommandExecutor {
	public static Main plugin;
	static List<String> cooldownzm;

	static {
		Salamander.cooldownzm = new ArrayList<String>();
	}

	public Salamander(final Main main) {
		Salamander.plugin = main;
	}

	@EventHandler
	public void lavamanEvent(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (p.getLocation().getBlock().isLiquid() && p.getLocation().getBlock().getType() == Material.STATIONARY_LAVA
				&& Main.lavaman.contains(p.getName())) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("�cSalamander");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("�6�oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("salamander")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "�cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.salamander")) {
				BarAPI.setMessage(p,
						"�c�oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "�bVoce escolheu o kit: �6�oSalamander", 5);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			Main.lavaman.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
