package me.liu.Comando;

import org.bukkit.entity.*;
import org.bukkit.command.*;
import me.confuser.barapi.*;
import org.bukkit.potion.*;
import org.bukkit.inventory.*;
import me.liu.*;
import java.util.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;

public class CommandAdmin implements CommandExecutor
{
    public Main plugin;
    public static final List<Player> admin;
    public static final List<Player> invis;
    
    static {
        admin = new ArrayList<Player>();
        invis = new ArrayList<Player>();
    }
    
    public CommandAdmin(final Main instance) {
        this.plugin = instance;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
            return false;
        }
        final Player p = (Player)sender;
        if (commandLabel.equalsIgnoreCase("admin")) {
            if (p.hasPermission("style.admin")) {
                if (!CommandAdmin.admin.contains(p)) {
                    CommandAdmin.admin.add(p);
                    p.setGameMode(GameMode.CREATIVE);
                    BarAPI.setMessage(p, "§6Voce esta no modo admin!");
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player s = onlinePlayers[i];
                        if (!s.hasPermission("pvp.admin")) {
                            s.hidePlayer(p);
                        }
                    }
                }
                else {
                    CommandAdmin.admin.remove(p);
                    BarAPI.setMessage(p, "§cVoce saiu do modo admin!", 5);
                    Player[] onlinePlayers2;
                    for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                        final Player s = onlinePlayers2[j];
                        s.showPlayer(p);
                    }
                }
            }
            else {
                p.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
            }
        }
        else if (commandLabel.equalsIgnoreCase("invis")) {
            if (p.hasPermission("style.admin")) {
                if (!CommandAdmin.invis.contains(p)) {
                    CommandAdmin.invis.add(p);
                    p.setGameMode(GameMode.CREATIVE);
                    BarAPI.setMessage(p, "§6Voce esta invisivel!");
                    Player[] onlinePlayers3;
                    for (int length3 = (onlinePlayers3 = Bukkit.getOnlinePlayers()).length, k = 0; k < length3; ++k) {
                        final Player s = onlinePlayers3[k];
                        if (!s.hasPermission("pvp.admin")) {
                            s.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 100));
                        }
                    }
                }
                else {
                    CommandAdmin.invis.remove(p);
                    BarAPI.setMessage(p, "§cVoce saiu do invisivel!", 5);
                    Player[] onlinePlayers4;
                    for (int length4 = (onlinePlayers4 = Bukkit.getOnlinePlayers()).length, l = 0; l < length4; ++l) {
                        final Player s = onlinePlayers4[l];
                        s.removePotionEffect(PotionEffectType.INVISIBILITY);
                    }
                }
            }
            else {
                p.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
            }
        }
        else if (commandLabel.equalsIgnoreCase("inv")) {
            if (p.hasPermission("pvp.inv")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Use /inv <jogador>");
                }
                else if (args.length == 1) {
                    final Player target = p.getServer().getPlayer(args[0]);
                    if (target != null) {
                        p.openInventory((Inventory)target.getInventory());
                    }
                    else {
                        p.sendMessage(ChatColor.RED + "Jogador " + args[0] + "inexistente.");
                    }
                }
                else {
                    p.sendMessage(ChatColor.RED + "Use /inv <jogador>");
                }
            }
            else {
                Permissions.semPermiassao(p);
            }
        }
        return false;
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        for (final Player p : CommandAdmin.admin) {
            e.getPlayer().hidePlayer(p);
        }
    }
    
    @EventHandler
    public void onPlayerLeave(final PlayerQuitEvent e) {
        CommandAdmin.admin.remove(e.getPlayer());
    }
    
    @EventHandler
    public void inventoryOpen(final PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Player)) {
            return;
        }
        final Player p = event.getPlayer();
        final Player r = (Player)event.getRightClicked();
        if (CommandAdmin.admin.contains(p) && p.getItemInHand().getType() == Material.AIR) {
            p.openInventory((Inventory)r.getInventory());
        }
    }
}
