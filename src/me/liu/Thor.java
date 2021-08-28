package me.liu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.confuser.barapi.BarAPI;

public class Thor implements Listener, CommandExecutor {
	public static Main plugin;
	static List<Player> cooldown;

	static {
		Thor.cooldown = new ArrayList<Player>();
	}

	public Thor(final Main main) {
		Thor.plugin = main;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Main.thor.contains(p.getName())
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			final ItemStack hand = p.getItemInHand();
			if (hand.getType() == Material.GOLD_AXE) {
				if (Thor.cooldown.contains(p)) {
					p.sendMessage(ChatColor.RED + "Cooldown");
				} else {
					final Location loc = p.getTargetBlock(null, 20).getLocation();
					p.getWorld().strikeLightning(loc);
					Thor.cooldown.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Thor.plugin,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									Thor.cooldown.remove(p);
								}
							}, 80L);
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cThor");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack thor = new ItemStack(Material.GOLD_AXE);
		final ItemMeta name = thor.getItemMeta();
		name.setDisplayName("§6§oStyle Thor");
		thor.setItemMeta(name);
		if (cmd.equalsIgnoreCase("thor")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.thor")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			Main.thor.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oThor", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { thor });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
