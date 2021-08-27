package me.liu;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class StaffChat implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("s")) {
            final Player player = (Player)sender;
            if (player.hasPermission(new Permissions().StaffChat)) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Usar: " + ChatColor.RED + "/s <mensagem>");
                }
                else if (args.length == 1) {
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player p = onlinePlayers[i];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0]);
                        }
                    }
                }
                else if (args.length == 2) {
                    Player[] onlinePlayers2;
                    for (int length2 = (onlinePlayers2 = Bukkit.getServer().getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                        final Player p = onlinePlayers2[j];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1]);
                        }
                    }
                }
                else if (args.length == 3) {
                    Player[] onlinePlayers3;
                    for (int length3 = (onlinePlayers3 = Bukkit.getServer().getOnlinePlayers()).length, k = 0; k < length3; ++k) {
                        final Player p = onlinePlayers3[k];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]);
                        }
                    }
                }
                else if (args.length == 4) {
                    Player[] onlinePlayers4;
                    for (int length4 = (onlinePlayers4 = Bukkit.getServer().getOnlinePlayers()).length, l = 0; l < length4; ++l) {
                        final Player p = onlinePlayers4[l];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3]);
                        }
                    }
                }
                else if (args.length == 5) {
                    Player[] onlinePlayers5;
                    for (int length5 = (onlinePlayers5 = Bukkit.getServer().getOnlinePlayers()).length, n = 0; n < length5; ++n) {
                        final Player p = onlinePlayers5[n];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4]);
                        }
                    }
                }
                else if (args.length == 6) {
                    Player[] onlinePlayers6;
                    for (int length6 = (onlinePlayers6 = Bukkit.getServer().getOnlinePlayers()).length, n2 = 0; n2 < length6; ++n2) {
                        final Player p = onlinePlayers6[n2];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5]);
                        }
                    }
                }
                else if (args.length == 7) {
                    Player[] onlinePlayers7;
                    for (int length7 = (onlinePlayers7 = Bukkit.getServer().getOnlinePlayers()).length, n3 = 0; n3 < length7; ++n3) {
                        final Player p = onlinePlayers7[n3];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6]);
                        }
                    }
                }
                else if (args.length == 8) {
                    Player[] onlinePlayers8;
                    for (int length8 = (onlinePlayers8 = Bukkit.getServer().getOnlinePlayers()).length, n4 = 0; n4 < length8; ++n4) {
                        final Player p = onlinePlayers8[n4];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]);
                        }
                    }
                }
                else if (args.length == 9) {
                    Player[] onlinePlayers9;
                    for (int length9 = (onlinePlayers9 = Bukkit.getServer().getOnlinePlayers()).length, n5 = 0; n5 < length9; ++n5) {
                        final Player p = onlinePlayers9[n5];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8]);
                        }
                    }
                }
                else if (args.length == 10) {
                    Player[] onlinePlayers10;
                    for (int length10 = (onlinePlayers10 = Bukkit.getServer().getOnlinePlayers()).length, n6 = 0; n6 < length10; ++n6) {
                        final Player p = onlinePlayers10[n6];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9]);
                        }
                    }
                }
                else if (args.length == 11) {
                    Player[] onlinePlayers11;
                    for (int length11 = (onlinePlayers11 = Bukkit.getServer().getOnlinePlayers()).length, n7 = 0; n7 < length11; ++n7) {
                        final Player p = onlinePlayers11[n7];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10]);
                        }
                    }
                }
                else if (args.length == 12) {
                    Player[] onlinePlayers12;
                    for (int length12 = (onlinePlayers12 = Bukkit.getServer().getOnlinePlayers()).length, n8 = 0; n8 < length12; ++n8) {
                        final Player p = onlinePlayers12[n8];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11]);
                        }
                    }
                }
                else if (args.length == 13) {
                    Player[] onlinePlayers13;
                    for (int length13 = (onlinePlayers13 = Bukkit.getServer().getOnlinePlayers()).length, n9 = 0; n9 < length13; ++n9) {
                        final Player p = onlinePlayers13[n9];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12]);
                        }
                    }
                }
                else if (args.length == 14) {
                    Player[] onlinePlayers14;
                    for (int length14 = (onlinePlayers14 = Bukkit.getServer().getOnlinePlayers()).length, n10 = 0; n10 < length14; ++n10) {
                        final Player p = onlinePlayers14[n10];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13]);
                        }
                    }
                }
                else if (args.length == 15) {
                    Player[] onlinePlayers15;
                    for (int length15 = (onlinePlayers15 = Bukkit.getServer().getOnlinePlayers()).length, n11 = 0; n11 < length15; ++n11) {
                        final Player p = onlinePlayers15[n11];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14]);
                        }
                    }
                }
                else if (args.length == 16) {
                    Player[] onlinePlayers16;
                    for (int length16 = (onlinePlayers16 = Bukkit.getServer().getOnlinePlayers()).length, n12 = 0; n12 < length16; ++n12) {
                        final Player p = onlinePlayers16[n12];
                        if (p.hasPermission(new Permissions().StaffReceiveChat)) {
                            p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName() + ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12] + " " + args[13] + " " + args[14] + " " + args[15]);
                        }
                    }
                }
            }
        }
        return false;
    }
}
