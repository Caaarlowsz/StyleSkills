package me.liu;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import me.confuser.barapi.BarAPI;

public class Chesmist implements Listener, CommandExecutor {
	public static Main plugin;
	ArrayList<Player> kanga;

	public Chesmist(final Main main) {
		this.kanga = new ArrayList<Player>();
		Chesmist.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cChemist");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("chemist")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.chemist")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oChemist", 5);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().addItem(new ItemStack[] { dima });
			final Potion potion = new Potion(PotionType.INSTANT_DAMAGE, 2, true);
			p.getInventory().addItem(new ItemStack[] { potion.toItemStack(1) });
			final Potion potion2 = new Potion(PotionType.WEAKNESS, 2, true);
			p.getInventory().addItem(new ItemStack[] { potion2.toItemStack(1) });
			final Potion potion3 = new Potion(PotionType.POISON, 1, true);
			p.getInventory().addItem(new ItemStack[] { potion3.toItemStack(1) });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
