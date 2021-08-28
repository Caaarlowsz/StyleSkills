package me.liu.Comando;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import me.liu.Main;

public class CommandRefil implements CommandExecutor {
	public Main plugin;
	int segundos;

	public CommandRefil(final Main instance) {
		this.segundos = 5;
		this.plugin = instance;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (args.length == 0 && cmd.getName().equalsIgnoreCase("refil")) {
			if (Main.instakill.contains(p.getName())) {
				p.sendMessage(ChatColor.DARK_PURPLE + "Comando so para jogadores");
			} else if (Main.used.contains(p.getName())) {
				Main.instakill.add(p.getName());
				p.getInventory().setHelmet(new ItemStack(Material.HUGE_MUSHROOM_2, 1));
				p.getInventory().setChestplate(new ItemStack(Material.AIR, 1));
				p.getInventory().setLeggings(new ItemStack(Material.AIR, 1));
				p.getInventory().setBoots(new ItemStack(Material.AIR, 1));
				p.playSound(p.getLocation(), Sound.FIZZ, 7.0f, 7.0f);
				BarAPI.setMessage(p.getPlayer(), " §4§o§lVoce morrera em um hit, §c§o§lFazendo Resoup em 5 segundos",
						this.segundos);
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 100));
				p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 120, 100));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 100));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 120, 100));
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						if (Main.instakill.contains(p.getName())) {
							Main.instakill.remove(p.getName());
							BarAPI.setMessage(p.getPlayer(), " §5§o§lResoup terminado!", 5);
							p.playSound(p.getLocation(), Sound.ENDERDRAGON_HIT, 7.0f, 7.0f);
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
							p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
						}
					}
				}, 120L);
			}
		}
		return false;
	}
}
