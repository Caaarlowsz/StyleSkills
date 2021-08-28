package me.liu;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;

public class Bomber implements Listener, CommandExecutor {
	public static Main plugin;
	public long cooldownLenght;

	public Bomber(final Main main) {
		this.cooldownLenght = 0L;
		Bomber.plugin = main;
	}

	@EventHandler
	public void eventBomber(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.TNT && Main.bomber.contains(p.getName())
				&& (e.getAction().equals((Object) Action.RIGHT_CLICK_AIR)
						|| e.getAction().equals((Object) Action.RIGHT_CLICK_BLOCK))) {
			if (this.hasCooldown()) {
				p.sendMessage("§cFaltam " + this.cooldownTimeRemaining() + " para o cooldown acabar!");
				return;
			}
			final TNTPrimed tnt = (TNTPrimed) p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
			tnt.setVelocity(p.getEyeLocation().getDirection().multiply(2.5));
			tnt.setFuseTicks(40);
			p.getLocation().getWorld().createExplosion(p.getLocation(), 4.0f);
			this.addCooldown(p, 30);
		}
	}

	@EventHandler
	public void bomberDamage(final EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getEntity();
		if (!Main.bomber.contains(player.getName())) {
			return;
		}
		if (event.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
			return;
		}
		event.setCancelled(true);
	}

	public void addCooldown(final Player player, final int seconds) {
		this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
	}

	public String cooldownTimeRemaining() {
		final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
		if (faltam < 60L) {
			return String.valueOf(faltam) + " segundos restantes";
		}
		return String.valueOf(faltam) + " minutos restantes";
	}

	public boolean hasCooldown() {
		return this.cooldownLenght > System.currentTimeMillis();
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cBomber");
		dima.setItemMeta(souperaa);
		final ItemStack flecha = new ItemStack(Material.TNT, 10);
		final ItemMeta flecas = flecha.getItemMeta();
		flecas.setDisplayName("§4§lTNT Explode");
		flecha.setItemMeta(flecas);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("bomber")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.bomber")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oBomber", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			Main.bomber.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { flecha });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
