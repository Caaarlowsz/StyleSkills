package me.liu;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Demoman implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove(final PlayerMoveEvent paramPlayerMoveEvent) {
		final Block localBlock1 = paramPlayerMoveEvent.getTo().getBlock();
		final Location localLocation = localBlock1.getLocation();
		localLocation.setY(localLocation.getY() - 1.0);
		final Block localBlock2 = localLocation.getBlock();
		if (localBlock1.getType() == Material.STONE_PLATE && localBlock2.getType() == Material.GRAVEL) {
			localBlock1.getWorld().createExplosion(localBlock1.getLocation(), 4.0f);
		}
	}
}
