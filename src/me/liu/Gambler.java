package me.liu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;

public class Gambler implements Listener, CommandExecutor {
	public static Main plugin;
	static List<String> cooldown;

	static {
		Gambler.cooldown = new ArrayList<String>();
	}

	public Gambler(final Main main) {
		Gambler.plugin = main;
	}

	@EventHandler
	public void gamblerKit(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (Main.gambler.contains(p.getName()) && p.getItemInHand().getType() == Material.GLOWSTONE_DUST) {
			event.setCancelled(true);
			if (Gambler.cooldown.contains(p.getName())) {
				BarAPI.setMessage(p, ChatColor.RED + "§oGambler em Cooldown!", 1);
			} else {
				final Random r = new Random();
				final int rand = r.nextInt(14);
				if (rand == 1) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
					p.sendMessage("§aVoce ficou com POISON");
				} else if (rand == 2) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0));
					p.sendMessage("§aVoce ficou com REGENERATION");
				} else if (rand == 3) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0));
					p.sendMessage("§aVoce ficou com INCREASE_DAMAGE");
				} else if (rand == 4) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0));
					p.sendMessage("§aVoce ficou com WEAKNESS");
				} else if (rand == 5) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 0));
					p.sendMessage("§aVoce ficou com INVISIBILITY");
				} else if (rand == 6) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0));
					p.sendMessage("§aVoce ficou com FIRE_RESISTANCE");
				} else if (rand == 7) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
					p.sendMessage("§aVoce ficou com SLOWNESS");
				} else if (rand == 8) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0));
					p.sendMessage("§aVoce ficou com SPEED");
				} else if (rand == 9) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
					p.sendMessage("§aVoce ficou com BLINDNESS");
				} else if (rand == 10) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 0));
					p.sendMessage("§aVoce ficou com WITHER");
				} else if (rand == 11) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
					p.sendMessage("§aVoce ficou com CONFUSION");
				} else if (rand == 12) {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 0));
					p.sendMessage("§aVoce ficou com JUMP");
				} else if (rand == 13) {
					p.getInventory().setHelmet(new ItemStack(Material.AIR));
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					p.getInventory().setLeggings(new ItemStack(Material.AIR));
					p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
					p.sendMessage("§aVoce tem sorte cuzido!");
					p.updateInventory();
				}
				Gambler.cooldown.add(p.getName());
				Gambler.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Gambler.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								Gambler.cooldown.remove(p.getName());
								p.getInventory().remove(Material.LEATHER_CHESTPLATE);
								p.getInventory().remove(Material.LEATHER_BOOTS);
								p.sendMessage("§aVoce pode usar novamente!");
							}
						}, 1000L);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cGambler");
		dima.setItemMeta(souperaa);
		final ItemStack arco = new ItemStack(Material.GLOWSTONE_DUST);
		final ItemMeta arcoa = arco.getItemMeta();
		arcoa.setDisplayName("§6Special Gambler's");
		arco.setItemMeta(arcoa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("gambler")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.gambler")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			Main.gambler.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oGambler", 5);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { arco });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
