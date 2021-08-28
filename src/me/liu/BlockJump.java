package me.liu;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class BlockJump implements Listener {
	public static Main plugin;
	ArrayList<Player> lanching;
	private ArrayList<Player> Sponge;

	public BlockJump(final Main main) {
		this.lanching = new ArrayList<Player>();
		this.Sponge = new ArrayList<Player>();
		BlockJump.plugin = main;
	}

	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LAPIS_BLOCK) {
			e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(0));
			e.getPlayer().setVelocity(
					new Vector(e.getPlayer().getVelocity().getX(), 10.0, e.getPlayer().getVelocity().getZ()));
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 99));
			this.Sponge.add(e.getPlayer());
		}
	}

	@EventHandler
	public void onPlaggfMovse(final PlayerMoveEvent e) {
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.ENDER_STONE) {
			e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(3));
			e.getPlayer().setVelocity(
					new Vector(e.getPlayer().getVelocity().getX(), 0.5, e.getPlayer().getVelocity().getZ()));
			this.Sponge.add(e.getPlayer());
		}
	}

	@EventHandler
	public void onPlayerDamage(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) BlockJump.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					if (e.getCause() == EntityDamageEvent.DamageCause.FALL && BlockJump.this.Sponge.contains(p)) {
						p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						BlockJump.this.Sponge.remove(p);
					}
				}
			}, 10L);
		}
	}

	@EventHandler
	public void jumpAlto(final PlayerMoveEvent paramPlayerMoveEvent) {
		final Player localPlayer = paramPlayerMoveEvent.getPlayer();
		final Block localBlock1 = paramPlayerMoveEvent.getTo().getBlock();
		final Location localLocation = localBlock1.getLocation();
		localLocation.setY(localLocation.getY() - 1.0);
		final Block localBlock2 = localLocation.getBlock();
		if (localBlock2.getType() == Material.GOLD_BLOCK && localPlayer.hasPermission("style.jump")) {
			localPlayer.setFallDistance(-50.0f);
			localPlayer.setVelocity(new Vector(0, 4, 0));
			localPlayer.playSound(localPlayer.getLocation(), Sound.EXPLODE, 1.0f, 10.0f);
			localPlayer.getWorld().playEffect(localPlayer.getLocation(), Effect.ENDER_SIGNAL, 1);
			localPlayer.setFallDistance(-50.0f);
		}
	}

	@EventHandler
	public void jumpMedio(final PlayerMoveEvent paramPlayerMoveEvent) {
		final Player localPlayer = paramPlayerMoveEvent.getPlayer();
		final Block localBlock1 = paramPlayerMoveEvent.getTo().getBlock();
		final Location localLocation = localBlock1.getLocation();
		localLocation.setY(localLocation.getY() - 1.0);
		final Block localBlock2 = localLocation.getBlock();
		if (localBlock2.getType() == Material.DIAMOND_BLOCK && localPlayer.hasPermission("style.jump")) {
			localPlayer.setFallDistance(-40.0f);
			localPlayer.setVelocity(new Vector(0, 3, 0));
			localPlayer.playSound(localPlayer.getLocation(), Sound.EXPLODE, 1.0f, 10.0f);
			localPlayer.getWorld().playEffect(localPlayer.getLocation(), Effect.ENDER_SIGNAL, 1);
			localPlayer.setFallDistance(-40.0f);
		}
	}

	@EventHandler
	public void jumpBaixo(final PlayerMoveEvent paramPlayerMoveEvent) {
		final Player localPlayer = paramPlayerMoveEvent.getPlayer();
		final Block localBlock1 = paramPlayerMoveEvent.getTo().getBlock();
		final Location localLocation = localBlock1.getLocation();
		localLocation.setY(localLocation.getY() - 1.0);
		final Block localBlock2 = localLocation.getBlock();
		if (localBlock2.getType() == Material.REDSTONE_BLOCK && localPlayer.hasPermission("style.jump")) {
			localPlayer.setFallDistance(-40.0f);
			localPlayer.setVelocity(new Vector(0, 2, 0));
			localPlayer.playSound(localPlayer.getLocation(), Sound.EXPLODE, 1.0f, 10.0f);
			localPlayer.getWorld().playEffect(localPlayer.getLocation(), Effect.ENDER_SIGNAL, 1);
			localPlayer.setFallDistance(-40.0f);
		}
	}

	@EventHandler
	public void jumpBaixo2(final PlayerMoveEvent paramPlayerMoveEvent) {
		final Player localPlayer = paramPlayerMoveEvent.getPlayer();
		final Block localBlock1 = paramPlayerMoveEvent.getTo().getBlock();
		final Location localLocation = localBlock1.getLocation();
		localLocation.setY(localLocation.getY() - 1.0);
		final Block localBlock2 = localLocation.getBlock();
		if (localBlock2.getType() == Material.PISTON_BASE && localPlayer.hasPermission("style.jump")) {
			localPlayer.setFallDistance(-100.0f);
			localPlayer.setVelocity(new Vector(0, 2, 0));
			localPlayer.playSound(localPlayer.getLocation(), Sound.EXPLODE, 1.0f, 10.0f);
			localPlayer.getWorld().playEffect(localPlayer.getLocation(), Effect.ENDER_SIGNAL, 1);
			localPlayer.setFallDistance(-100.0f);
		}
	}
}
