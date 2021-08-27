package me.liu.Comando;

import org.bukkit.command.*;
import org.bukkit.entity.*;

public class CommandTags implements CommandExecutor
{
    public String description;
    
    public CommandTags() {
        this.description = "Defina sua tag";
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("tag")) {
            if (args.length > 0 && (p.hasPermission("tag.op") || p.isOp())) {
                if (args[0].toLowerCase().equals("normal")) {
                    p.sendMessage("§6Voce esta usando a tag §7Normal");
                    p.setPlayerListName("§7" + p.getName());
                    p.setDisplayName("§7" + p.getName());
                }
                else if (args[0].toLowerCase().equals("vip")) {
                    p.sendMessage("§6Voce esta usando a tag §aVip");
                    p.setPlayerListName("§a" + p.getName());
                    p.setDisplayName("§a" + p.getName());
                }
                else if (args[0].toLowerCase().equals("eterno")) {
                    p.sendMessage("§6Voce esta usando a tag §6§oEterno");
                    p.setPlayerListName("§6§o" + p.getName());
                    p.setDisplayName("§6§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("youtuber")) {
                    p.sendMessage("§6Voce esta usando a tag §b§oYoutuber");
                    p.setPlayerListName("§b§o" + p.getName());
                    p.setDisplayName("§b§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("mod")) {
                    p.sendMessage("§6Voce esta usando a tag §5MOD");
                    p.setPlayerListName("§5" + p.getName());
                    p.setDisplayName(String.valueOf("§5".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("mod+")) {
                    p.sendMessage("§6Voce esta usando a tag §5§oMod+");
                    p.setPlayerListName("§5§o" + p.getName());
                    p.setDisplayName(String.valueOf("§5§o".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("builder")) {
                    p.sendMessage("§6Voce esta usando a tag §3§oBuilder");
                    p.setPlayerListName("§3§o" + p.getName());
                    p.setDisplayName(String.valueOf("§3§o".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("admin")) {
                    p.sendMessage("§6Voce esta usando a tag §cAdmin");
                    p.setPlayerListName(String.valueOf("§c".toString()) + p.getName());
                    p.setDisplayName(String.valueOf("§c".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("organizador")) {
                    p.sendMessage("§6Voce esta usando a tag §c§oOrganizador");
                    p.setPlayerListName(String.valueOf("§c§o".toString()) + p.getName());
                    p.setDisplayName(String.valueOf("§c§o".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("dono")) {
                    p.sendMessage("§6Voce esta usando a tag §4§oDono");
                    p.setPlayerListName(String.valueOf("§4§o".toString()) + p.getName());
                    p.setDisplayName(String.valueOf("§4§o".toString()) + p.getName());
                }
                else {
                    p.sendMessage("§2Use: (§7Normal §2| §a§oVip §2| §6§oEterno §2| §b§oYoutuber §2| §5Mod §2| §5§oMod+ §2| §3§oBuilder §2| §c Admin §2| §c§oOrganizador §2| §4§oDono§2|)");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.tmod")) {
                if (args[0].toLowerCase().equals("normal")) {
                    p.sendMessage("§6Voce esta usando a tag §7Normal");
                    p.setPlayerListName("§7" + p.getName());
                    p.setDisplayName("§7" + p.getName());
                }
                else if (args[0].toLowerCase().equals("vip")) {
                    p.sendMessage("§6Voce esta usando a tag §aVip");
                    p.setPlayerListName("§a" + p.getName());
                    p.setDisplayName("§a" + p.getName());
                }
                else if (args[0].toLowerCase().equals("eterno")) {
                    p.sendMessage("§6Voce esta usando a tag §6§oEterno");
                    p.setPlayerListName("§6§o" + p.getName());
                    p.setDisplayName("§6§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("youtuber")) {
                    p.sendMessage("§6Voce esta usando a tag §b§oYoutuber");
                    p.setPlayerListName("§b§o" + p.getName());
                    p.setDisplayName("§b§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("mod")) {
                    p.sendMessage("§6Voce esta usando a tag §5MOD");
                    p.setPlayerListName("§5" + p.getName());
                    p.setDisplayName(String.valueOf("§5".toString()) + p.getName());
                }
                else {
                    p.sendMessage("§2Use: (§7Normal §2|§a§o Vip §2|§6§o Eterno §2|§b§o Youtuber §2| §5Mod §2|)");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.mod")) {
                if (args[0].toLowerCase().equals("normal")) {
                    p.sendMessage("§6Voce esta usando a tag §7Normal");
                    p.setPlayerListName("§7" + p.getName());
                    p.setDisplayName("§7" + p.getName());
                }
                else if (args[0].toLowerCase().equals("vip")) {
                    p.sendMessage("§6Voce esta usando a tag §aVip");
                    p.setPlayerListName("§a" + p.getName());
                    p.setDisplayName("§a" + p.getName());
                }
                else if (args[0].toLowerCase().equals("eterno")) {
                    p.sendMessage("§6Voce esta usando a tag §6§oEterno");
                    p.setPlayerListName("§6§o" + p.getName());
                    p.setDisplayName("§6§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("youtuber")) {
                    p.sendMessage("§6Voce esta usando a tag §b§oYoutuber");
                    p.setPlayerListName("§b§o" + p.getName());
                    p.setDisplayName("§b§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("mod")) {
                    p.sendMessage("§6Voce esta usando a tag §5MOD");
                    p.setPlayerListName("§5" + p.getName());
                    p.setDisplayName(String.valueOf("§5".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("mod+")) {
                    p.sendMessage("§6Voce esta usando a tag §5§oMod+");
                    p.setPlayerListName("§5§o" + p.getName());
                    p.setDisplayName(String.valueOf("§5§o".toString()) + p.getName());
                }
                else {
                    p.sendMessage("§2Use: (§7Normal §2|§a§o Vip §2|§6§o Eterno §2|§b§o Youtuber §2| §5Mod §2| §5§o Mod+ §2|)");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.eterno")) {
                if (args[0].toLowerCase().equals("normal")) {
                    p.sendMessage("§6Voce esta usando a tag §7Normal");
                    p.setPlayerListName("§7" + p.getName());
                    p.setDisplayName("§7" + p.getName());
                }
                else if (args[0].toLowerCase().equals("vip")) {
                    p.sendMessage("§6Voce esta usando a tag §aVip");
                    p.setPlayerListName("§a" + p.getName());
                    p.setDisplayName("§a" + p.getName());
                }
                else if (args[0].toLowerCase().equals("eterno")) {
                    p.sendMessage("§6Voce esta usando a tag §6§oEterno");
                    p.setPlayerListName("§6§o" + p.getName());
                    p.setDisplayName("§6§o" + p.getName());
                }
                else {
                    p.sendMessage("§2Use: (§7Normal §2|§a§o Vip §2| §6§oEterno§2|)");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.yt")) {
                if (args[0].toLowerCase().equals("normal")) {
                    p.sendMessage("§6Voce esta usando a tag §7Normal");
                    p.setPlayerListName("§7" + p.getName());
                    p.setDisplayName("§7" + p.getName());
                }
                else if (args[0].toLowerCase().equals("youtuber")) {
                    p.sendMessage("§6Voce esta usando a tag §b§oYoutuber");
                    p.setPlayerListName("§b§o" + p.getName());
                    p.setDisplayName("§b§o" + p.getName());
                }
                else {
                    p.sendMessage("§2Use: (§7Normal §2|§b§o Youtuber§2|)");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.admin")) {
                if (args[0].toLowerCase().equals("normal")) {
                    p.sendMessage("§6Voce esta usando a tag §7Normal");
                    p.setPlayerListName("§7" + p.getName());
                    p.setDisplayName("§7" + p.getName());
                }
                else if (args[0].toLowerCase().equals("vip")) {
                    p.sendMessage("§6Voce esta usando a tag §aVip");
                    p.setPlayerListName("§a" + p.getName());
                    p.setDisplayName("§a" + p.getName());
                }
                else if (args[0].toLowerCase().equals("eterno")) {
                    p.sendMessage("§6Voce esta usando a tag §6§oEterno");
                    p.setPlayerListName("§6§o" + p.getName());
                    p.setDisplayName("§6§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("youtuber")) {
                    p.sendMessage("§6Voce esta usando a tag §b§oYoutuber");
                    p.setPlayerListName("§b§o" + p.getName());
                    p.setDisplayName("§b§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("mod")) {
                    p.sendMessage("§6Voce esta usando a tag §5MOD");
                    p.setPlayerListName("§5" + p.getName());
                    p.setDisplayName(String.valueOf("§5".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("mod+")) {
                    p.sendMessage("§6Voce esta usando a tag §5§oMod+");
                    p.setPlayerListName("§5§o" + p.getName());
                    p.setDisplayName(String.valueOf("§5§o".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("admin")) {
                    p.sendMessage("§6 Voce esta usando a tag §cAdmin");
                    p.setPlayerListName(String.valueOf("§c".toString()) + p.getName());
                    p.setDisplayName(String.valueOf("§c".toString()) + p.getName());
                }
                else {
                    p.sendMessage("§2Use: (§7Normal §2| §a§oVip §2| §6§oEterno §2| §b§oYoutuber §2|§5§o Mod §2|§c Admin §2|)");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.organizador")) {
                if (args[0].toLowerCase().equals("normal")) {
                    p.sendMessage("§6Voce esta usando a tag §7Normal");
                    p.setPlayerListName("§7" + p.getName());
                    p.setDisplayName("§7" + p.getName());
                }
                else if (args[0].toLowerCase().equals("vip")) {
                    p.sendMessage("§6Voce esta usando a tag §aVip");
                    p.setPlayerListName("§a" + p.getName());
                    p.setDisplayName("§a" + p.getName());
                }
                else if (args[0].toLowerCase().equals("eterno")) {
                    p.sendMessage("§6Voce esta usando a tag §6§oEterno");
                    p.setPlayerListName("§6§o" + p.getName());
                    p.setDisplayName("§6§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("youtuber")) {
                    p.sendMessage("§6Voce esta usando a tag §b§oYoutuber");
                    p.setPlayerListName("§b§o" + p.getName());
                    p.setDisplayName("§b§o" + p.getName());
                }
                else if (args[0].toLowerCase().equals("mod")) {
                    p.sendMessage("§6Voce esta usando a tag §5MOD");
                    p.setPlayerListName("§5" + p.getName());
                    p.setDisplayName(String.valueOf("§5".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("mod+")) {
                    p.sendMessage("§6Voce esta usando a tag §5§oMod+");
                    p.setPlayerListName("§5§o" + p.getName());
                    p.setDisplayName(String.valueOf("§5§o".toString()) + p.getName());
                }
                else if (args[0].toLowerCase().equals("admin")) {
                    p.sendMessage("§6 Voce esta usando a tag §cAdmin");
                    p.setPlayerListName(String.valueOf("§c".toString()) + p.getName());
                    p.setDisplayName(String.valueOf("§c".toString()) + p.getName());
                }
                else {
                    p.sendMessage("§2Use: (§7Normal §2| §a§oVip §2| §6§oEterno §2| §b§oYoutuber §2|§5§o Mod §2|§c Admin §2| §c§oOrganizador §2|)");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.vip")) {
                if (args[0].toLowerCase().equals("normal")) {
                    p.sendMessage("§6Voce esta usando a tag §7Normal");
                    p.setPlayerListName("§7" + p.getName());
                    p.setDisplayName("§7" + p.getName());
                }
                else if (args[0].toLowerCase().equals("vip")) {
                    p.sendMessage("§6Voce esta usando a tag §aVip");
                    p.setPlayerListName("§a" + p.getName());
                    p.setDisplayName("§a" + p.getName());
                }
                else {
                    p.sendMessage("§2Use: (§7Normal §2|§a§o Vip§2|)");
                }
            }
            else if (args.length > 0) {
                if (args[0].toLowerCase().equals("normal") || args[0].toLowerCase().equals("default")) {
                    p.sendMessage("§6Voce esta usando a tag §7Normal");
                    p.setPlayerListName("§7" + p.getName());
                    p.setDisplayName("§7" + p.getName());
                }
                else {
                    p.sendMessage("§2Use: (§2| §7Normal/Default §2|)");
                }
            }
        }
        return true;
    }
}
