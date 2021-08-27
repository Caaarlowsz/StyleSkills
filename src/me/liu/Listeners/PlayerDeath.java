package me.liu.Listeners;

import me.liu.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_7_R1.entity.*;
import net.minecraft.server.v1_7_R1.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class PlayerDeath implements Listener
{
    public Main plugin;
    
    public PlayerDeath(final Main instance) {
        this.plugin = instance;
    }
    
    @EventHandler
    public void onPlayerDeath(final PlayerDeathEvent e) {
        final Player player = e.getEntity();
        this.plugin.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                if (player.isDead()) {
                    ((CraftPlayer)player).getHandle().playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
                }
            }
        });
    }
}
