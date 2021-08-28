package me.liu;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.confuser.barapi.BarAPI;

public class Timelord implements Listener, CommandExecutor {
	public static Main plugin;
	public ArrayList<String> frozenPlayers;
	public static ArrayList<String> cooldownt;

	static {
		Timelord.cooldownt = new ArrayList<String>();
	}

	public Timelord(final Main main) {
		this.frozenPlayers = new ArrayList<String>();
		Timelord.plugin = main;
	}

	@EventHandler
	public void timelordkit(final PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& player.getItemInHand().getType() == Material.WATCH && Main.timelord.contains(player.getName())) {
			if (Timelord.cooldownt.contains(player.getName())) {
				player.sendMessage(ChatColor.RED + "Voce ainda est\u00e1 no cooldown!");
			} else {
				for (final Entity frozen : player.getNearbyEntities(4.0, 4.0, 4.0)) {
					if (frozen != null && frozen instanceof Player) {
						Main.freeze.add(((Player) frozen).getName());
						if (Main.freezing.contains(player.getName())) {
							continue;
						}
						player.getWorld().playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
						player.getWorld().playSound(player.getLocation(), Sound.WITHER_SHOOT, 10.0f, 1.0f);
						Main.freezing.add(player.getName());
						Timelord.cooldownt.add(player.getName());
						Timelord.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Timelord.plugin,
								(Runnable) new Runnable() {
									@Override
									public void run() {
										Main.freezing.remove(player.getName());
										Timelord.cooldownt.remove(player.getName());
									}
								}, 5500L);
					}
				}
			}
		}
	}

	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if (Main.freeze.contains(player.getName()) && !Main.freezing.contains(player.getName())) {
			event.setTo(player.getLocation());
			player.sendMessage("§cOh nao um timelord me congelou!");
			Timelord.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Timelord.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							Main.freeze.remove(player.getName());
						}
					}, 100L);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cTimelord");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack timelord = new ItemStack(Material.WATCH);
		final ItemMeta timelorda = timelord.getItemMeta();
		timelorda.setDisplayName("§5Timelord's Clock");
		timelord.setItemMeta(timelorda);
		if (cmd.equalsIgnoreCase("timelord")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.timelord")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oTimelord", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			Main.timelord.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { timelord });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
