package me.liu;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;

public class Berserker implements Listener, CommandExecutor {
	public static Main plugin;

	public Berserker(final Main main) {
		Berserker.plugin = main;
	}

	@EventHandler
	public void berserkerEvent(final PlayerDeathEvent event) {
		if (!(event.getEntity().getKiller() instanceof Player)) {
			return;
		}
		if (event.getEntity().getKiller() == null) {
			return;
		}
		final Player player = event.getEntity().getKiller();
		if (Main.berserker.contains(player.getName())) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999999, -100));
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999999, 1));
			player.sendMessage("§cSua SEDE POR SANGUE foi ativada!");
			player.sendMessage("§cAgora voce da mais dano!");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Berserker.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							player.removePotionEffect(PotionEffectType.JUMP);
							player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							player.sendMessage("§cSua SEDE POR SANGUE foi desativada!");
						}
					}, 220L);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.WOOD_SWORD);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cBerserker");
		dima.setItemMeta(souperaa);
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if (cmd.equalsIgnoreCase("berserker")) {
			if (Main.used.contains(p.getName())) {
				BarAPI.setMessage(p, "§cVoce ja pegou um kit tente na proxima vida :D", 5);
				return true;
			}
			if (!p.hasPermission("kit.berserker")) {
				BarAPI.setMessage(p,
						"§c§oVoce nao tem permissao para este kit de /comprar e adiquira vip na nossa loja ;D!", 10);
				return true;
			}
			Main.used.add(p.getName());
			BarAPI.setMessage(p, "§bVoce escolheu o kit: §6§oBerserker", 5);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			Main.berserker.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i <= 34; ++i) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
