package me.liu.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;

import me.liu.Main;

public class SemCoisas implements Listener {
	public Main plugin;

	public SemCoisas(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void fullJoin(final PlayerLoginEvent event) {
		final Player p = event.getPlayer();
		if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
			if (p.hasPermission("entrar.vip")) {
				event.setResult(PlayerLoginEvent.Result.ALLOWED);
			} else {
				event.setKickMessage("§cServidor Cheio! §aCompre vip e entre http://style-pvp.buycraft.net/!");
			}
		} else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			event.setKickMessage(ChatColor.GRAY + "Servidor com WhiteList voce nao esta listado!!");
		}
	}

	@EventHandler
	public void onReload(final PlayerCommandPreprocessEvent event) {
		final Player p = event.getPlayer();
		final String msg = event.getMessage();
		if ((msg.equalsIgnoreCase("/rl") || msg.equalsIgnoreCase("/reload")) && p.isOp()
				&& p.hasPermission("style.reload")) {
			event.setCancelled(true);
			Bukkit.reload();
			Bukkit.broadcastMessage("§a§o[§7§oStylePvP§a§o] §bReload Completo!");
		}
	}

	@EventHandler
	public void DisableFireSpread(final BlockSpreadEvent e) {
		if (e.getNewState().getType() == Material.FIRE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMe(final PlayerCommandPreprocessEvent event) {
		final Player p = event.getPlayer();
		if (event.getMessage().toLowerCase().startsWith("/me")) {
			event.setCancelled(true);
			p.sendMessage("§cEste comando foi retirado!");
		}
	}

	@EventHandler
	public void onUnknown(final PlayerCommandPreprocessEvent event) {
		if (event.isCancelled()) {
			return;
		}
		final Player p = event.getPlayer();
		final String msg = event.getMessage().split(" ")[0];
		final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		if (topic == null) {
			event.setCancelled(true);
			p.sendMessage("§cComando nao encontrado!");
		}
	}

	@EventHandler
	public void nohunger(final FoodLevelChangeEvent event) {
		event.setCancelled(true);
		event.setFoodLevel(20);
	}

	@EventHandler
	public void noRain(final WeatherChangeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onCreeperExplosion(final EntityExplodeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void noFMessage(final PlayerDeathEvent event) {
		event.setDeathMessage((String) null);
		event.getEntity().getPlayer().getWorld().playSound(event.getEntity().getPlayer().getLocation(),
				Sound.ANVIL_LAND, 1.0f, 1.0f);
		event.setDroppedExp(0);
		event.setNewLevel(0);
	}

	@EventHandler
	public void onCreeperSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Creeper) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSkeletonSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Skeleton) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSpiderSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Spider) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWitherSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Wither) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onZombieSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Zombie) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSlimeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Slime) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onGhastSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Ghast) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPigZombieSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof PigZombie) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onEndermanSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Enderman) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCaveSpiderSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof CaveSpider) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSilverfishSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Silverfish) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlazeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Blaze) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMagmaCubeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof MagmaCube) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBatSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Bat) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWitchSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Witch) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSheepSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Sheep) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCowSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Cow) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onChickenSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Chicken) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSquidSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Squid) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWolfSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Wolf) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMooshroomSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof MushroomCow) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onOcelotSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Ocelot) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onVillagerSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Villager) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onHorseSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Horse) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onEnderDragonSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof EnderDragon) {
			e.setCancelled(true);
		}
	}
}
