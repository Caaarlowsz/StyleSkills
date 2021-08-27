package me.liu.Listeners;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class NoPlugins implements Listener
{
    @EventHandler
    public void onPlugin(final PlayerCommandPreprocessEvent event) {
        final Player p = event.getPlayer();
        if (!p.hasPermission("style.noplugins") && (event.getMessage().toLowerCase().startsWith("/pl") || event.getMessage().toLowerCase().startsWith("/plugins") || event.getMessage().toLowerCase().startsWith("/?") || event.getMessage().toLowerCase().startsWith("/rl") || event.getMessage().toLowerCase().startsWith("/achievement") || event.getMessage().toLowerCase().startsWith("/bukkit") || event.getMessage().toLowerCase().startsWith("%") || event.getMessage().toLowerCase().startsWith("/bukkit:") || event.getMessage().toLowerCase().startsWith("/reload") || event.getMessage().toLowerCase().startsWith("/bukkit:plugins"))) {
            event.setCancelled(true);
            p.sendMessage("§cEste comando foi retirado para jogadores normais!");
        }
    }
}
