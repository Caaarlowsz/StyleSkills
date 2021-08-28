package me.liu;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import net.minecraft.server.v1_7_R4.EntityHuman;

public class Grappler1 implements CommandExecutor, Listener {
	public static Main plugin;
	Map<Player, CordaGrappler> hooks;

	public Grappler1(final Main main) {
		this.hooks = new HashMap<Player, CordaGrappler>();
		Grappler1.plugin = main;
	}

	@EventHandler
	public void onSlot(final PlayerItemHeldEvent e) {
		if (this.hooks.containsKey(e.getPlayer())) {
			this.hooks.get(e.getPlayer()).remove();
			this.hooks.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void grapplerDamageNoLeash(final EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getEntity();
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (this.hooks.containsKey(player) && this.hooks.get(player).isHooked() && event.getDamage() > 3.0) {
			event.setDamage(3.0);
		}
	}

	@EventHandler
	public void onMove(final PlayerMoveEvent e) {
		if (this.hooks.containsKey(e.getPlayer())
				&& !e.getPlayer().getItemInHand().getType().equals((Object) Material.LEASH)) {
			this.hooks.get(e.getPlayer()).remove();
			this.hooks.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void onLeash(final PlayerLeashEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType().equals((Object) Material.LEASH)) {
			e.setCancelled(true);
			e.getPlayer().updateInventory();
			e.setCancelled(true);
			if (!this.hooks.containsKey(p)) {
				return;
			}
			if (!this.hooks.get(p).isHooked()) {
				return;
			}
			final double t;
			t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
			final double v_x = (1.0 + 0.07 * t)
					* (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
			final double v_y = (1.0 + 0.03 * t)
					* (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
			final double v_z = (1.0 + 0.07 * t)
					* (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
			final Vector v = p.getVelocity();
			v.setX(v_x);
			v.setY(v_y);
			v.setZ(v_z);
			p.setVelocity(v);
			p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 1.0f, 1.0f);
		}
	}

	@EventHandler
	public void onClick(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType().equals((Object) Material.LEASH)) {
			e.setCancelled(true);
			if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				if (this.hooks.containsKey(p)) {
					this.hooks.get(p).remove();
				}
				final CordaGrappler nmsHook = new CordaGrappler(p.getWorld(),
						(EntityHuman) ((CraftPlayer) p).getHandle());
				nmsHook.spawn(p.getEyeLocation().add(p.getLocation().getDirection().getX(),
						p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()));
				nmsHook.move(p.getLocation().getDirection().getX() * 5.0, p.getLocation().getDirection().getY() * 5.0,
						p.getLocation().getDirection().getZ() * 5.0);
				this.hooks.put(p, nmsHook);
			} else {
				if (!this.hooks.containsKey(p)) {
					return;
				}
				if (!this.hooks.get(p).isHooked()) {
					return;
				}
				final double t;
				t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
				final double v_x = (1.0 + 0.2 * t)
						* (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
				final double v_y = (1.0 + 0.03 * t)
						* (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
				final double v_z = (1.0 + 0.2 * t)
						* (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
				final Vector v = p.getVelocity();
				v.setX(v_x);
				v.setY(v_y);
				v.setZ(v_z);
				p.setVelocity(v);
				p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 1.0f, 1.0f);
			}
		}
	}

	public void playFirework(final World paramWorld, final Location paramLocation,
			final FireworkEffect paramFireworkEffect) throws Exception {
		throw new Error("Nao decompile gay!");
	}

	@SuppressWarnings("unused")
	private static Method getMethod(final Class<?> cl, final String method) {
		Method[] methods;
		for (int length = (methods = cl.getMethods()).length, i = 0; i < length; ++i) {
			final Method m = methods[i];
			if (m.getName().equals(method)) {
				return m;
			}
		}
		return null;
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cGrappler");
		dima.setItemMeta(souperaa);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		final ItemStack grappler = new ItemStack(Material.LEASH);
		final ItemMeta imdd = grappler.getItemMeta();
		imdd.setDisplayName("§a§oStyle Grappler");
		grappler.setItemMeta(imdd);
		if (cmd.equalsIgnoreCase("grappler")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.grappler")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			Main.grappler.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oGrappler", 5);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { grappler });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
