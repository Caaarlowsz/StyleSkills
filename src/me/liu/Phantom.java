package me.liu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;

import me.confuser.barapi.BarAPI;

public class Phantom implements Listener, CommandExecutor {
	public static Main plugin;
	static List<String> cooldown;

	static {
		Phantom.cooldown = new ArrayList<String>();
	}

	public Phantom(final Main main) {
		Phantom.plugin = main;
	}

	@EventHandler
	public void onInteractPhantom(final PlayerInteractEvent event) {
		final ItemStack chest = new ItemStack(Material.LEATHER_HELMET, 1);
		final LeatherArmorMeta chestp = (LeatherArmorMeta) chest.getItemMeta();
		chestp.setColor(Color.WHITE);
		chest.setItemMeta((ItemMeta) chestp);
		final ItemStack chest2 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		final LeatherArmorMeta chestp2 = (LeatherArmorMeta) chest2.getItemMeta();
		chestp2.setColor(Color.WHITE);
		chest2.setItemMeta((ItemMeta) chestp2);
		final ItemStack calca = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		final LeatherArmorMeta chestp3 = (LeatherArmorMeta) calca.getItemMeta();
		chestp3.setColor(Color.WHITE);
		calca.setItemMeta((ItemMeta) chestp3);
		final ItemStack chest3 = new ItemStack(Material.LEATHER_BOOTS, 1);
		final LeatherArmorMeta chestp4 = (LeatherArmorMeta) chest3.getItemMeta();
		chestp4.setColor(Color.WHITE);
		chest3.setItemMeta((ItemMeta) chestp4);
		if (event.getPlayer().hasPermission("style.phantom") && event.getAction().name().contains("RIGHT")
				&& event.getPlayer().getItemInHand().getType() == Material.FEATHER
				&& Main.phantom.contains(event.getPlayer().getName())) {
			final Player p = event.getPlayer();
			if (Phantom.cooldown.contains(p.getName())) {
				return;
			}
			Phantom.cooldown.add(p.getName());
			p.setAllowFlight(true);
			p.setFlying(true);
			p.getInventory().setHelmet(new ItemStack(chest));
			p.getInventory().setChestplate(new ItemStack(chest2));
			p.getInventory().setLeggings(new ItemStack(calca));
			p.getInventory().setBoots(new ItemStack(chest3));
			p.updateInventory();
			BarAPI.setMessage(p, "�6�oVoce pode voar!", 1);
			final int i = 5;
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
						}
					}, (long) i);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
						}
					}, (long) (i + 20));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							BarAPI.setMessage(p, ChatColor.GREEN + "Voce tem 3 segundos de voo pouse logo!", 1);
						}
					}, (long) (i + 40));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							BarAPI.setMessage(p, ChatColor.GREEN + "Voce tem 2 segundos de voo vai murre!", 1);
						}
					}, (long) (i + 60));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							BarAPI.setMessage(p, ChatColor.GREEN + "Voce tem 1 segundos de voo ;-; i murreu!", 1);
						}
					}, (long) (i + 80));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.setAllowFlight(false);
							BarAPI.setMessage(p, "�4�lVoce nao pode voar mais!", 1);
							p.getInventory().setHelmet((ItemStack) null);
							p.getInventory().setChestplate((ItemStack) null);
							p.getInventory().setLeggings((ItemStack) null);
							p.getInventory().setBoots((ItemStack) null);
							p.updateInventory();
						}
					}, 100L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Phantom.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							Phantom.cooldown.remove(p.getName());
							p.sendMessage("�a�oVoce pode usar agora!");
						}
					}, 800L);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("�cPhantom");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("�6�oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack phantom = new ItemStack(Material.FEATHER);
		final ItemMeta specialistss = phantom.getItemMeta();
		specialistss.setDisplayName("�aPhantom's Feather");
		phantom.setItemMeta(specialistss);
		if (cmd.equalsIgnoreCase("phantom")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "�cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.phantom")) {
				BarAPI.setMessage(p,
						"�c�oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			Main.phantom.add(p.getName());
			BarAPI.setMessage(p, "�bVoce escolheu o kit: �6�oPhantom", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { phantom });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
