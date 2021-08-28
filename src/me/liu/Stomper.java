package me.liu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;

public class Stomper implements Listener, CommandExecutor {
	public static Main plugin;
	static List<Player> cooldownm;
	public long cooldownLenght;
	protected Map<String, Long> Cooldownsstomper;
	public int cooldown;
	protected Map<String, Long> playerCooldownss;

	static {
		Stomper.cooldownm = new ArrayList<Player>();
	}

	public Stomper(final Main main) {
		this.cooldownLenght = 0L;
		this.Cooldownsstomper = new HashMap<String, Long>();
		this.cooldown = 30;
		this.playerCooldownss = new HashMap<String, Long>();
		Stomper.plugin = main;
	}

	@EventHandler
	public void stomper(final EntityDamageEvent event) {
		final Player player = (Player) event.getEntity();
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (!Main.stomper.contains(player.getName())) {
			return;
		}
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		if (event.getDamage() <= 3.0) {
			return;
		}
		event.setDamage(4.0);
		for (final Entity stomped : player.getNearbyEntities(5.0, 5.0, 5.0)) {
			if (!(stomped instanceof Player)) {
				return;
			}
			if (((Player) stomped).isSneaking()) {
				continue;
			}
			((Player) stomped).damage((double) (player.getFallDistance() / 2.0f));
			if (((Player) stomped).isDead()) {
				Main.econ.depositPlayer(player.getName(), 120.0);
				player.sendMessage(ChatColor.GREEN + "Voce ganhou " + ChatColor.AQUA + "120" + ChatColor.GREEN
						+ " por stompar " + ChatColor.GREEN + ((Player) stomped).getName());
				((Player) stomped).sendMessage(ChatColor.RED + "Voce foi stompado por §4§l" + player.getName());
			} else {
				if (!((Player) stomped).isSneaking()) {
					continue;
				}
				((Player) stomped).damage(6.0);
			}
		}
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE
				&& Main.stomper.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (this.hasCooldown2()) {
				p.sendMessage("§cFaltam " + this.cooldownTimeRemaining2() + " para o cooldown acabar!");
				return;
			}
			final Vector vector = p.getEyeLocation().getDirection();
			vector.multiply(0.0f);
			vector.setY(6.0f);
			p.setVelocity(vector);
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.ZOMBIE_REMEDY, 5.0f, -5.0f);
			this.addCooldown2(p, 45);
		}
	}

	public void addCooldown2(final Player player, final int seconds) {
		this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
	}

	public String cooldownTimeRemaining2() {
		final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
		if (faltam < 60L) {
			return String.valueOf(faltam) + " segundos restantes";
		}
		return String.valueOf(faltam) + " minutos restantes";
	}

	public boolean hasCooldown2() {
		return this.cooldownLenght > System.currentTimeMillis();
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cStomper");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack archer = new ItemStack(Material.GOLDEN_APPLE);
		final ItemMeta archermeta = archer.getItemMeta();
		archermeta.setDisplayName("§6Stomper Apple");
		final ArrayList<String> archerlore = new ArrayList<String>();
		archerlore.add("§6*-*-*-*-*-*-*-*-*-**-*");
		archerlore.add("§7Clique com o direito para stompar!");
		archerlore.add("§6-*-*-*-*-*-*-*-*-*-*");
		archermeta.setLore(archerlore);
		archer.setItemMeta(archermeta);
		if (cmd.equalsIgnoreCase("stomper")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.stomper")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			p.setGameMode(GameMode.SURVIVAL);
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oStomper", 5);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			Main.stomper.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { archer });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
