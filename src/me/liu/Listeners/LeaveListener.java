package me.liu.Listeners;

import org.bukkit.configuration.file.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;

public class LeaveListener implements Listener
{
    FileConfiguration cfg;
    
    public LeaveListener(final FileConfiguration config) {
        this.cfg = config;
    }
    
    @EventHandler
    public void onquit(final PlayerQuitEvent event) {
        event.setQuitMessage("");
    }
}
