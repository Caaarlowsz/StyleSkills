package me.liu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class KitReset implements CommandExecutor {
	public static Main plugin;

	public KitReset(final Main main) {
		KitReset.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.equalsIgnoreCase("kitreset")) {
			if (!p.hasPermission("style.kitreset")) {
				Permissions.semPermiassao(p);
				return true;
			}
			Main.used.remove(p.getName());
			p.sendMessage("§aSeu kit foi resetado!");
			Phantom.cooldown.remove(p.getName());
			Backpacker.cooldownbk.remove(p);
			Timelord.cooldownt.remove(p.getName());
			Hulk.cooldown.remove(p);
			Gambler.cooldown.remove(p.getName());
			Spectre.cooldown.remove(p.getName());
			p.setLevel(0);
			p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.REGENERATION);
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			Main.used.remove(p.getName());
			Main.anchor.remove(p.getName());
			Main.archer.remove(p.getName());
			Main.backpacker.remove(p.getName());
			Main.poseidon.remove(p.getName());
			Main.cultivator.remove(p.getName());
			Main.fisherman.remove(p.getName());
			Main.frosty.remove(p.getName());
			Main.kangaroo.remove(p.getName());
			Main.milkman.remove(p.getName());
			Main.rider.remove(p.getName());
			Main.snail.remove(p.getName());
			Main.tank.remove(p.getName());
			Main.timelord.remove(p.getName());
			Main.cookiemonster.remove(p.getName());
			Main.hulk.remove(p.getName());
			Main.monk.remove(p.getName());
			Main.specialist.remove(p.getName());
			Main.stomper.remove(p.getName());
			Main.vampire.remove(p.getName());
			Main.viking.remove(p.getName());
			Main.berserker.remove(p.getName());
			Main.camel.remove(p.getName());
			Main.switcher.remove(p.getName());
			Main.turtle.remove(p.getName());
			Main.flash.remove(p.getName());
			Main.thor.remove(p.getName());
			Main.snowman.remove(p.getName());
			Main.healer.remove(p.getName());
			Main.sonic.remove(p.getName());
			Main.neo.remove(p.getName());
			Main.phantom.remove(p.getName());
			Main.endermage.remove(p.getName());
			Main.lifeline.remove(p.getName());
			Main.gambler.remove(p.getName());
			Main.darkmage.remove(p.getName());
			Main.spectre.remove(p.getName());
			Main.zombie.remove(p.getName());
			Main.lavaman.remove(p.getName());
			Main.reaper.remove(p.getName());
			Main.pyro.remove(p.getName());
			Main.soldier.remove(p.getName());
			Main.grappler.remove(p.getName());
			Main.gladiator.remove(p.getName());
			Main.vacuum.remove(p.getName());
			Main.launcher.remove(p.getName());
			Main.robinhood.remove(p.getName());
			Main.urgal.remove(p.getName());
			Main.viper.remove(p.getName());
			Main.snail.remove(p.getName());
			Main.pvp.remove(p.getName());
			Main.dwarf.remove(p.getName());
		}
		return false;
	}
}
