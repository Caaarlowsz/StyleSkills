package me.liu;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class Permissions {
	public Permission StaffChat;
	public Permission StaffReceiveChat;

	public Permissions() {
		this.StaffChat = new Permission("style.staffchat");
		this.StaffReceiveChat = new Permission("style.receber.staffchat");
	}

	public static void semPermiassao(final Player player) {
		player.sendMessage("§c§lStylePvP §4>>" + ChatColor.GRAY + " Voce nao tem permissao metido!");
	}
}
