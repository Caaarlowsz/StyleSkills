package me.liu;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;

public class Urgal implements Listener, CommandExecutor {
	public static Main plugin;

	public Urgal(final Main main) {
		Urgal.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("?cUrgal");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("?6?oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("urgal")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "?cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.urgal")) {
				BarAPI.setMessage(p,
						"?c?oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			Main.urgal.add(p.getName());
			BarAPI.setMessage(p, "?bVoce escolheu o kit: ?6?oUrgal", 5);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().addItem(new ItemStack[] { dima });
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 4500, 0));
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
