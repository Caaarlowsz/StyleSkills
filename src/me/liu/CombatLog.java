package me.liu;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CombatLog implements Listener {
	@EventHandler(ignoreCancelled = false, priority = EventPriority.LOWEST)
	public void onPlayerDamage(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player d = (Player) e.getDamager();
			if (!Main.tagged.containsKey(p.getName())) {
				Main.tagged.put(p.getName(), System.currentTimeMillis());
				p.sendMessage(String.valueOf(Main.format(Main.prefix)) + " " + Main.format(Main.message_ontag));
			} else {
				Main.tagged.remove(p.getName());
				Main.tagged.put(p.getName(), System.currentTimeMillis());
			}
			if (!Main.tagged.containsKey(d.getName())) {
				Main.tagged.put(d.getName(), System.currentTimeMillis());
				d.sendMessage(String.valueOf(Main.format(Main.prefix)) + " " + Main.format(Main.message_ontag));
			} else {
				Main.tagged.remove(d.getName());
				Main.tagged.put(d.getName(), System.currentTimeMillis());
			}
		} else if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (!Main.tagged.containsKey(p.getName())) {
				Main.tagged.put(p.getName(), System.currentTimeMillis());
				p.sendMessage(String.valueOf(Main.format(Main.prefix)) + " " + Main.format(Main.message_ontag));
			} else {
				Main.tagged.remove(p.getName());
				Main.tagged.put(p.getName(), System.currentTimeMillis());
			}
		} else if (e.getDamager() instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (!Main.tagged.containsKey(p.getName())) {
				Main.tagged.put(p.getName(), System.currentTimeMillis());
				p.sendMessage(String.valueOf(Main.format(Main.prefix)) + " " + Main.format(Main.message_ontag));
			} else {
				Main.tagged.remove(p.getName());
				Main.tagged.put(p.getName(), System.currentTimeMillis());
			}
		}
	}

	@EventHandler
	public void onPlayerQuit(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (Main.tagged.containsKey(p.getName())) {
			if (Main.command.equalsIgnoreCase("%killplayer%")) {
				p.setHealth(0.0);
			} else {
				Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
						Main.command.replace("%player%", p.getName()));
			}
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player o = onlinePlayers[i];
				String m = String.valueOf(Main.format(Main.prefix)) + " " + Main.format(Main.message_onlog);
				m = m.replace("{%p}", p.getName());
				o.sendMessage(m);
			}
		}
	}

	@EventHandler
	public void onPlayerCommand(final PlayerCommandPreprocessEvent e) {
		if (Main.tagged.containsKey(e.getPlayer().getName())) {
			final String cmd_name = e.getMessage().split(" ")[0].toLowerCase();
			final String cmd_lower = e.getMessage().toLowerCase();
			for (final String cmd : Main.instance.getConfig().getStringList("blocked-cmds")) {
				final String cmd_blocked = cmd.toLowerCase();
				if (cmd_name.equals(cmd_blocked) || cmd_lower.startsWith(cmd_blocked)) {
					e.setCancelled(true);
					e.getPlayer().sendMessage(String.valueOf(Main.prefix) + " " + Main.format(Main.message_nocommand));
				}
			}
		}
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
	public void onPlayerDeath(final PlayerDeathEvent e) {
		Main.tagged.remove(e.getEntity().getName());
	}
}
