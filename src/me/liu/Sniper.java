package me.liu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;

public class Sniper implements CommandExecutor, Listener {
	public static Main plugin;

	public Sniper(final Main main) {
		Sniper.plugin = main;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Main.sniper.contains(p.getName())) {
			if (e.getAction() != Action.RIGHT_CLICK_AIR) {
				return;
			}
			if (e.getItem().getType() != Material.IRON_BARDING) {
				return;
			}
			final Vector velo1 = p.getLocation().getDirection().normalize().multiply(5);
			velo1.add(new Vector(Math.random() * 0.0 + 0.0, 0.0, 0.0));
			if (Main.reload.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Recarregando!");
			} else {
				p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
				((Arrow) p.launchProjectile(Arrow.class)).setVelocity(velo1);
				Main.reload.add(p.getName());
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Sniper.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (Main.sniper.contains(p.getName())) {
									p.sendMessage("�aVoce pode atirar novamente!");
									Main.reload.remove(p.getName());
								}
							}
						}, 160L);
			}
		}
	}

	@EventHandler
	public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Arrow && ((Arrow) event.getDamager()).getShooter() instanceof Player) {
			final Arrow arrow = (Arrow) event.getDamager();
			final Player p = (Player) arrow.getShooter();
			p.getLocation().distance(event.getEntity().getLocation());
			if (event.getEntity() instanceof Player && Main.sniper.contains(p.getName())) {
				p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 1.0f, 1.0f);
				event.setDamage(17.0);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("�cSniper");
		dima.setItemMeta(souperaa);
		final ItemStack sopaa = new ItemStack(Material.IRON_BARDING);
		final ItemMeta sopasa = sopaa.getItemMeta();
		sopasa.setDisplayName("�6Sniper m-927182 longshot 360 noscope");
		sopaa.setItemMeta(sopasa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("�6�oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("sniper")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "�cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.sniper")) {
				BarAPI.setMessage(p,
						"�c�oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			Main.sniper.add(p.getName());
			BarAPI.setMessage(p, "�bVoce escolheu o kit: �6Sniper", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { sopaa });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
