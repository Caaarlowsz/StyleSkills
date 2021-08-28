package me.liu.Listeners;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import me.liu.Main;
import net.minecraft.server.v1_7_R4.EnumClientCommand;
import net.minecraft.server.v1_7_R4.PacketPlayInClientCommand;

public class PlayerDeath implements Listener {
	public Main plugin;

	public PlayerDeath(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onPlayerDeath(final PlayerDeathEvent e) {
		final Player player = e.getEntity();
		this.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
			@Override
			public void run() {
				if (player.isDead()) {
					((CraftPlayer) player).getHandle().playerConnection
							.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
				}
			}
		});
	}
}
