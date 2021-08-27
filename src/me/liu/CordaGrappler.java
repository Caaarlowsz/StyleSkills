package me.liu;

import org.bukkit.craftbukkit.v1_7_R1.*;
import me.confuser.barapi.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.craftbukkit.v1_7_R1.entity.*;
import net.minecraft.server.v1_7_R1.*;
import org.bukkit.*;

public class CordaGrappler extends EntityFishingHook
{
    private Snowball sb;
    private EntitySnowball controller;
    public int a;
    public EntityHuman owner;
    public Entity hooked;
    public boolean lastControllerDead;
    public boolean isHooked;
    
    public CordaGrappler(final World world, final EntityHuman entityhuman) {
        super((net.minecraft.server.v1_7_R1.World)((CraftWorld)world).getHandle(), entityhuman);
        this.owner = entityhuman;
    }
    
    protected void c() {
    }
    
    public void h() {
        if (!this.lastControllerDead && this.controller.dead) {
            BarAPI.setMessage((Player)this.owner.getBukkitEntity(), "�aGotcha", 1);
        }
        this.lastControllerDead = this.controller.dead;
        for (final Entity entity : this.controller.world.getWorld().getEntities()) {
            if (!(entity instanceof Firework) && entity.getEntityId() != this.getBukkitEntity().getEntityId() && entity.getEntityId() != this.owner.getBukkitEntity().getEntityId() && entity.getEntityId() != this.controller.getBukkitEntity().getEntityId() && (entity.getLocation().distance(this.controller.getBukkitEntity().getLocation()) < 2.0 || (entity instanceof Player && ((Player)entity).getEyeLocation().distance(this.controller.getBukkitEntity().getLocation()) < 2.0))) {
                this.controller.die();
                this.hooked = entity;
                this.isHooked = true;
                this.locX = entity.getLocation().getX();
                this.locY = entity.getLocation().getY();
                this.locZ = entity.getLocation().getZ();
                this.motX = 0.0;
                this.motY = 0.04;
                this.motZ = 0.0;
            }
        }
        try {
            this.locX = this.hooked.getLocation().getX();
            this.locY = this.hooked.getLocation().getY();
            this.locZ = this.hooked.getLocation().getZ();
            this.motX = 0.0;
            this.motY = 0.04;
            this.motZ = 0.0;
            this.isHooked = true;
        }
        catch (Exception e) {
            if (this.controller.dead) {
                this.isHooked = true;
            }
            this.locX = this.controller.locX;
            this.locY = this.controller.locY;
            this.locZ = this.controller.locZ;
        }
    }
    
    public void die() {
    }
    
    public void spawn(final Location location) {
        this.sb = (Snowball)this.owner.getBukkitEntity().launchProjectile((Class)Snowball.class);
        this.controller = ((CraftSnowball)this.sb).getHandle();
        final PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] { this.controller.getId() });
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player p = onlinePlayers[i];
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)packet);
            p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 1.0f, 1.0f);
        }
        ((CraftWorld)location.getWorld()).getHandle().addEntity((net.minecraft.server.v1_7_R1.Entity)this);
    }
    
    public void remove() {
        super.die();
    }
    
    public boolean isHooked() {
        return this.isHooked;
    }
    
    public void setHookedEntity(final Entity nodamage) {
        this.hooked = nodamage;
    }
}