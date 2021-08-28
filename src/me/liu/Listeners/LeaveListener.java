package me.liu.Listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {
	FileConfiguration cfg;

	public LeaveListener(final FileConfiguration config) {
		this.cfg = config;
	}

	@EventHandler
	public void onquit(final PlayerQuitEvent event) {
		event.setQuitMessage("");
	}
}
