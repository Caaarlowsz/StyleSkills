package me.liu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import me.liu.Comando.CommandAdmin;
import me.liu.Comando.CommandBroadcast;
import me.liu.Comando.CommandBuild;
import me.liu.Comando.CommandClear;
import me.liu.Comando.CommandEvento;
import me.liu.Comando.CommandFake;
import me.liu.Comando.CommandInvSee;
import me.liu.Comando.CommandKick;
import me.liu.Comando.CommandLag;
import me.liu.Comando.CommandList;
import me.liu.Comando.CommandPing;
import me.liu.Comando.CommandSay;
import me.liu.Comando.CommandShop;
import me.liu.Comando.CommandSuicide;
import me.liu.Comando.CommandTags;
import me.liu.Comando.CommandTell;
import me.liu.Comando.CommandTempo;
import me.liu.Comando.CommandTp;
import me.liu.Comando.CommandUp;
import me.liu.Comando.CommandVida;
import me.liu.Comando.CommandVoar;
import me.liu.Comando.Commandgm;
import me.liu.Comando.Commandmsg;
import me.liu.Comando.head;
import me.liu.Gui.GUI;
import me.liu.Gui.GUIVIP;
import me.liu.Listeners.ChatColorPlayer;
import me.liu.Listeners.DropItens;
import me.liu.Listeners.JoinListener;
import me.liu.Listeners.KillStreaks;
import me.liu.Listeners.LeaveListener;
import me.liu.Listeners.NoPlugins;
import me.liu.Listeners.PlayerDropItem;
import me.liu.Listeners.PlayerRespawn;
import me.liu.Listeners.SemCoisas;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin implements Listener {
	public static Economy econ;
	public static String prefix;
	public static String message_ontag;
	public static String message_onlog;
	public static String message_onsafe;
	public static String message_incombat;
	public static String message_notincombat;
	public static String message_nocommand;
	public static String command;
	public static long time;
	public static HashMap<String, Long> tagged;
	public HashMap<String, Integer> streak;
	public static HashMap<String, String> channel;
	HashMap<String, Integer> queue;
	HashMap<String, Integer> kills;
	HashMap<String, Integer> godlike;
	boolean chatstatus;
	boolean chatclear;
	public static int currentLine;
	protected File file;
	public FileConfiguration conf;
	private FileConfiguration config;
	public static ArrayList<String> tpEvt;
	public static int tid;
	public static int running;
	public static long interval;
	public static Main instance;
	DataFiles data;
	public static Main plugin;
	public String monkCooldownMessage;
	public String monkedMessage;
	transient HashMap<ItemStack, Long> monkStaff;
	transient HashMap<ItemStack, Long> stomperStaff;
	public boolean sendThroughInventory;
	public int cooldownmonk;
	public int monkItemId;
	public static ArrayList<String> instakill;
	public static ArrayList<String> pvp;
	public static ArrayList<String> used;
	public static ArrayList<String> reload;
	public static ArrayList<String> thor;
	public static ArrayList<String> usedhg;
	public static ArrayList<String> jumper;
	public static ArrayList<String> sniper;
	public static ArrayList<String> kitfreeze;
	public static ArrayList<String> dwarf;
	public static ArrayList<String> skeleton;
	public static ArrayList<String> urgal;
	public static ArrayList<String> robinhood;
	public static ArrayList<String> phantom;
	public static ArrayList<String> soldier;
	public static ArrayList<String> cookiemonster;
	public static ArrayList<String> tank;
	public static ArrayList<String> viper;
	public static ArrayList<String> backpacker;
	public static ArrayList<String> snail;
	public static ArrayList<String> stomper;
	public static ArrayList<String> fisherman;
	public static ArrayList<String> kangaroo;
	public static ArrayList<String> kangacd;
	public static ArrayList<String> hulk;
	public static ArrayList<String> milkman;
	public static ArrayList<String> berserker;
	public static ArrayList<String> camel;
	public static ArrayList<String> frosty;
	public static ArrayList<String> monk;
	public static ArrayList<String> anchor;
	public static ArrayList<String> poseidon;
	public static ArrayList<String> timelord;
	public static ArrayList<String> turtle;
	public static ArrayList<String> vampire;
	public static ArrayList<String> spectre;
	public static ArrayList<String> specialist;
	public static ArrayList<String> cultivator;
	public static ArrayList<String> switcher;
	public static ArrayList<String> healer;
	public static ArrayList<String> darkmage;
	public static ArrayList<String> reaper;
	public static ArrayList<String> cooldown5;
	public static ArrayList<String> sonic;
	public static ArrayList<String> lavaman;
	public static ArrayList<String> golem;
	public static ArrayList<String> pyro;
	public static ArrayList<String> viking;
	public static ArrayList<String> gladiator;
	public static ArrayList<String> dubstep;
	public static ArrayList<String> soupmaster;
	public static ArrayList<String> lifeline;
	public static ArrayList<String> archer;
	public static ArrayList<String> snowman;
	public static ArrayList<String> buildon;
	public static ArrayList<String> buildoff;
	public static ArrayList<String> flash;
	public static ArrayList<String> zombie;
	public static ArrayList<String> rider;
	public static ArrayList<String> neo;
	public static ArrayList<String> gambler;
	public static ArrayList<String> grappler;
	public static ArrayList<String> endermage;
	public static ArrayList<String> launcher;
	public static ArrayList<String> bomber;
	public static ArrayList<String> vacuum;
	public static ArrayList<String> freeze;
	public static ArrayList<String> freezing;

	static {
		Main.econ = null;
		Main.prefix = "";
		Main.message_ontag = "§cVoce esta em combate agora nao deslogue!";
		Main.message_onlog = "§7{%p} deslogou em combate!";
		Main.message_onsafe = "§aVoce nao esta mais em combate!";
		Main.message_incombat = "§cVoce esta em combate!";
		Main.message_notincombat = "§aVoce nao esta em combate!";
		Main.message_nocommand = "§cNao use comandos em combate!";
		Main.command = "%killplayer%";
		Main.time = 100L;
		Main.tagged = new HashMap<String, Long>();
		Main.channel = new HashMap<String, String>();
		Main.currentLine = 0;
		Main.tpEvt = new ArrayList<String>();
		Main.tid = 0;
		Main.running = 1;
		Main.interval = 600L;
		Main.instakill = new ArrayList<String>();
		Main.pvp = new ArrayList<String>();
		Main.used = new ArrayList<String>();
		Main.reload = new ArrayList<String>();
		Main.thor = new ArrayList<String>();
		Main.usedhg = new ArrayList<String>();
		Main.jumper = new ArrayList<String>();
		Main.sniper = new ArrayList<String>();
		Main.kitfreeze = new ArrayList<String>();
		Main.dwarf = new ArrayList<String>();
		Main.skeleton = new ArrayList<String>();
		Main.urgal = new ArrayList<String>();
		Main.robinhood = new ArrayList<String>();
		Main.phantom = new ArrayList<String>();
		Main.soldier = new ArrayList<String>();
		Main.cookiemonster = new ArrayList<String>();
		Main.tank = new ArrayList<String>();
		Main.viper = new ArrayList<String>();
		Main.backpacker = new ArrayList<String>();
		Main.snail = new ArrayList<String>();
		Main.stomper = new ArrayList<String>();
		Main.fisherman = new ArrayList<String>();
		Main.kangaroo = new ArrayList<String>();
		Main.kangacd = new ArrayList<String>();
		Main.hulk = new ArrayList<String>();
		Main.milkman = new ArrayList<String>();
		Main.berserker = new ArrayList<String>();
		Main.camel = new ArrayList<String>();
		Main.frosty = new ArrayList<String>();
		Main.monk = new ArrayList<String>();
		Main.anchor = new ArrayList<String>();
		Main.poseidon = new ArrayList<String>();
		Main.timelord = new ArrayList<String>();
		Main.turtle = new ArrayList<String>();
		Main.vampire = new ArrayList<String>();
		Main.spectre = new ArrayList<String>();
		Main.specialist = new ArrayList<String>();
		Main.cultivator = new ArrayList<String>();
		Main.switcher = new ArrayList<String>();
		Main.healer = new ArrayList<String>();
		Main.darkmage = new ArrayList<String>();
		Main.reaper = new ArrayList<String>();
		Main.cooldown5 = new ArrayList<String>();
		Main.sonic = new ArrayList<String>();
		Main.lavaman = new ArrayList<String>();
		Main.golem = new ArrayList<String>();
		Main.pyro = new ArrayList<String>();
		Main.viking = new ArrayList<String>();
		Main.gladiator = new ArrayList<String>();
		Main.dubstep = new ArrayList<String>();
		Main.soupmaster = new ArrayList<String>();
		Main.lifeline = new ArrayList<String>();
		Main.archer = new ArrayList<String>();
		Main.snowman = new ArrayList<String>();
		Main.buildon = new ArrayList<String>();
		Main.buildoff = new ArrayList<String>();
		Main.flash = new ArrayList<String>();
		Main.zombie = new ArrayList<String>();
		Main.rider = new ArrayList<String>();
		Main.neo = new ArrayList<String>();
		Main.gambler = new ArrayList<String>();
		Main.grappler = new ArrayList<String>();
		Main.endermage = new ArrayList<String>();
		Main.launcher = new ArrayList<String>();
		Main.bomber = new ArrayList<String>();
		Main.vacuum = new ArrayList<String>();
		Main.freeze = new ArrayList<String>();
		Main.freezing = new ArrayList<String>();
	}

	public Main() {
		this.streak = new HashMap<String, Integer>();
		this.queue = new HashMap<String, Integer>();
		this.kills = new HashMap<String, Integer>();
		this.godlike = new HashMap<String, Integer>();
		this.data = DataFiles.getInstance();
		this.monkCooldownMessage = "§cVoce pode monkar denovo em %s segundos!";
		this.monkedMessage = "§1Monkado!";
		this.monkStaff = new HashMap<ItemStack, Long>();
		this.stomperStaff = new HashMap<ItemStack, Long>();
		this.sendThroughInventory = true;
		this.cooldownmonk = 15;
		this.monkItemId = Material.BLAZE_ROD.getId();
	}

	public static int dinheirorandom(final int min, final int max) {
		final int range = max - min;
		return min + (int) (Math.random() * range);
	}

	private boolean setupEconomy() {
		if (this.getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		final RegisteredServiceProvider<Economy> rsp = (RegisteredServiceProvider<Economy>) this.getServer()
				.getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		Main.econ = (Economy) rsp.getProvider();
		return Main.econ != null;
	}

	public void onEnable() {
		this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[StyleUtils] > Enabled");
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		this.data.setup((Plugin) this);
		this.saveConfig();
		this.reloadConfig();
		this.setup();
		this.registerCommands();
		this.registerEvents();
		this.setupEconomy();
		this.config = this.getConfig();
		this.config.options().copyDefaults(true);
		if (this.config.getBoolean("ResetConfig", true)) {
			this.config.set("ResetConfig", (Object) false);
			this.saveConfig();
		} else if (this.config.getBoolean("ResetConfig", false)) {
			this.saveConfig();
		}
		this.config.set("ResetConfig", (Object) false);
		this.config.set("Test", (Object) true);
		this.saveConfig();
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		final int interval = this.getConfig().getInt("timehour") * 60 * 60 + this.getConfig().getInt("timemin") * 60
				+ this.getConfig().getInt("timesec");
		Main.tid = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) this, (Runnable) new Runnable() {
			@Override
			public void run() {
				try {
					Main.this.broadcastMessage("plugins/StyleSkills/messages.txt");
				} catch (IOException ex) {
				}
			}
		}, 0L, (long) (interval * 20));
	}

	@SuppressWarnings("resource")
	public void broadcastMessage(final String fileName) throws IOException {
		String title = this.getConfig().getString("title");
		final FileInputStream fs = new FileInputStream(fileName);
		final BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		for (int i = 0; i < Main.currentLine; ++i) {
			br.readLine();
		}
		String line = br.readLine();
		line = line.replaceAll("$n", "\n");
		title = title.replaceAll("$n", "\n");
		Bukkit.getServer().broadcastMessage("§4[§6StylePvP§4] " + ChatColor.AQUA + line);
		final LineNumberReader lnr = new LineNumberReader(new FileReader(new File(fileName)));
		lnr.skip(Long.MAX_VALUE);
		final int lastLine = lnr.getLineNumber();
		if (Main.currentLine + 1 == lastLine + 1) {
			Main.currentLine = 0;
		} else {
			++Main.currentLine;
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("report")) {
			if (args.length < 1) {
				sender.sendMessage("§cUse: /report [jogador] [motivo]");
			} else {
				final String ReportName = args[0];
				String ReportReson = "";
				for (int i = 1; i <= args.length - 1; ++i) {
					ReportReson = String.valueOf(ReportReson) + args[i];
					if (i != args.length - 1) {
						ReportReson = String.valueOf(ReportReson) + " ";
					}
				}
				this.getLogger().info(
						String.valueOf(sender.getName()) + " Reportou " + ReportName + " Por \"" + ReportReson + "\"");
				sender.sendMessage("§cJogador reportado com sucesso se ouver moderadores online verao seu report!");
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = this.getServer().getOnlinePlayers()).length,
						j = 0; j < length; ++j) {
					final Player player = onlinePlayers[j];
					if (player.hasPermission("derp.report.receber")) {
						if (ReportReson != "") {
							player.sendMessage("§a" + sender.getName() + "§c Reportou §a" + ReportName + "§a Por \"§a"
									+ ReportReson + "§a\"");
						} else {
							player.sendMessage(
									"§a" + sender.getName() + "§c Reportou §a" + ReportName + "§a Sem Razao!");
						}
					}
				}
			}
			return true;
		}
		return false;
	}

	public static String format(final String s) {
		return s.replace("§", "§");
	}

	public void setup() {
	}

	public void registerCommands() {
		this.getCommand("magico").setExecutor((CommandExecutor) new Freeze(this));
		this.getCommand("head").setExecutor((CommandExecutor) new head(this));
		this.getCommand("eventordm").setExecutor((CommandExecutor) new CommandEvento(this));
		this.getCommand("s").setExecutor((CommandExecutor) new StaffChat());
		this.getCommand("tell").setExecutor((CommandExecutor) new CommandTell());
		this.getCommand("r").setExecutor((CommandExecutor) new CommandTell());
		this.getCommand("list").setExecutor((CommandExecutor) new CommandList(this));
		this.getCommand("chat").setExecutor((CommandExecutor) new ComandosChat(this));
		this.getCommand("anchor").setExecutor((CommandExecutor) new Anchor(this));
		this.getCommand("archer").setExecutor((CommandExecutor) new Archer(this));
		this.getCommand("monk").setExecutor((CommandExecutor) new Monk(this));
		this.getCommand("kangaroo").setExecutor((CommandExecutor) new Kangaroo(this));
		this.getCommand("fisherman").setExecutor((CommandExecutor) new Fisherman(this));
		this.getCommand("timelord").setExecutor((CommandExecutor) new Timelord(this));
		this.getCommand("snail").setExecutor((CommandExecutor) new Snail(this));
		this.getCommand("phantom").setExecutor((CommandExecutor) new Phantom(this));
		this.getCommand("pvp").setExecutor((CommandExecutor) new PvP(this));
		this.getCommand("frosty").setExecutor((CommandExecutor) new Frosty(this));
		this.getCommand("tank").setExecutor((CommandExecutor) new Tank(this));
		this.getCommand("viper").setExecutor((CommandExecutor) new Viper(this));
		this.getCommand("rider").setExecutor((CommandExecutor) new Rider(this));
		this.getCommand("backpacker").setExecutor((CommandExecutor) new Backpacker(this));
		this.getCommand("milkman").setExecutor((CommandExecutor) new Milkman(this));
		this.getCommand("specialist").setExecutor((CommandExecutor) new Specialist(this));
		this.getCommand("cookiemonster").setExecutor((CommandExecutor) new CookieMonster(this));
		this.getCommand("vampire").setExecutor((CommandExecutor) new Vampire(this));
		this.getCommand("hulk").setExecutor((CommandExecutor) new Hulk(this));
		this.getCommand("berserker").setExecutor((CommandExecutor) new Berserker(this));
		this.getCommand("camel").setExecutor((CommandExecutor) new Camel(this));
		this.getCommand("switcher").setExecutor((CommandExecutor) new Switcher(this));
		this.getCommand("grappler").setExecutor((CommandExecutor) new Grappler1(this));
		this.getCommand("turtle").setExecutor((CommandExecutor) new Turtle(this));
		this.getCommand("thor").setExecutor((CommandExecutor) new Thor(this));
		this.getCommand("endermage").setExecutor((CommandExecutor) new Endermage(this));
		this.getCommand("neo").setExecutor((CommandExecutor) new Neo(this));
		this.getCommand("stomper").setExecutor((CommandExecutor) new Stomper(this));
		this.getCommand("urgal").setExecutor((CommandExecutor) new Urgal(this));
		this.getCommand("gambler").setExecutor((CommandExecutor) new Gambler(this));
		this.getCommand("spectre").setExecutor((CommandExecutor) new Spectre(this));
		this.getCommand("salamander").setExecutor((CommandExecutor) new Salamander(this));
		this.getCommand("poseidon").setExecutor((CommandExecutor) new Poseidon(this));
		this.getCommand("macaco").setExecutor((CommandExecutor) new Macaco(this));
		this.getCommand("chemist").setExecutor((CommandExecutor) new Chesmist(this));
		this.getCommand("pyro").setExecutor((CommandExecutor) new Pyro(this));
		this.getCommand("kits").setExecutor((CommandExecutor) new GUI(this));
		this.getCommand("kit").setExecutor((CommandExecutor) new GUI(this));
		this.getCommand("kitvip").setExecutor((CommandExecutor) new GUIVIP(this));
		this.getCommand("build").setExecutor((CommandExecutor) new CommandBuild());
		this.getCommand("kitreset").setExecutor((CommandExecutor) new KitReset(this));
		this.getCommand("lag").setExecutor((CommandExecutor) new CommandLag());
		this.getCommand("vida").setExecutor((CommandExecutor) new CommandVida(this));
		this.getCommand("anuncio").setExecutor((CommandExecutor) new CommandBroadcast());
		this.getCommand("fake").setExecutor((CommandExecutor) new CommandFake(this));
		this.getCommand("tempo").setExecutor((CommandExecutor) new CommandTempo(this));
		this.getCommand("voar").setExecutor((CommandExecutor) new CommandVoar());
		this.getCommand("tag").setExecutor((CommandExecutor) new CommandTags());
		this.getCommand("limparinv").setExecutor((CommandExecutor) new CommandClear());
		this.getCommand("gm").setExecutor((CommandExecutor) new Commandgm());
		this.getCommand("kick").setExecutor((CommandExecutor) new CommandKick());
		this.getCommand("msg").setExecutor((CommandExecutor) new Commandmsg());
		this.getCommand("ping").setExecutor((CommandExecutor) new CommandPing());
		this.getCommand("tp").setExecutor((CommandExecutor) new CommandTp());
		this.getCommand("say").setExecutor((CommandExecutor) new CommandSay());
		this.getCommand("suicide").setExecutor((CommandExecutor) new CommandSuicide(this));
		this.getCommand("admin").setExecutor((CommandExecutor) new CommandAdmin(this));
		this.getCommand("invis").setExecutor((CommandExecutor) new CommandAdmin(this));
		this.getCommand("upi").setExecutor((CommandExecutor) new CommandUp(this));
		this.getCommand("inv").setExecutor((CommandExecutor) new CommandInvSee(this));
		this.getCommand("gladiator").setExecutor((CommandExecutor) new Gladiator(this));
		this.getCommand("launcher").setExecutor((CommandExecutor) new Launcher(this));
		this.getCommand("robinhood").setExecutor((CommandExecutor) new RobinHood(this));
		this.getCommand("vacuum").setExecutor((CommandExecutor) new Vacuum(this));
		this.getCommand("spawn").setExecutor((CommandExecutor) new Warps(this));
		this.getCommand("fps").setExecutor((CommandExecutor) new Warps(this));
		this.getCommand("earlyhg").setExecutor((CommandExecutor) new Warps(this));
		this.getCommand("main").setExecutor((CommandExecutor) new Warps(this));
		this.getCommand("challenge").setExecutor((CommandExecutor) new Warps(this));
		this.getCommand("rdm").setExecutor((CommandExecutor) new Warps(this));
		this.getCommand("mdr").setExecutor((CommandExecutor) new Warps(this));
		this.getCommand("viking").setExecutor((CommandExecutor) new Viking(this));
		this.getCommand("shop").setExecutor((CommandExecutor) new CommandShop(this));
		this.getCommand("sniper").setExecutor((CommandExecutor) new Sniper(this));
		this.getCommand("jumper").setExecutor((CommandExecutor) new Jumper(this));
	}

	public void registerEvents() {
		Bukkit.getServer().getPluginManager().registerEvents((Listener) this, (Plugin) this);
		final PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents((Listener) new LeaveListener(this.getConfig()), (Plugin) this);
		pm.registerEvents((Listener) new JoinListener(this.getConfig()), (Plugin) this);
		pm.registerEvents((Listener) new StaffChat(), (Plugin) this);
		pm.registerEvents((Listener) new ChatColorPlayer(this), (Plugin) this);
		pm.registerEvents((Listener) new PlayerDropItem(this), (Plugin) this);
		pm.registerEvents((Listener) new SemCoisas(this), (Plugin) this);
		pm.registerEvents((Listener) new SignSopas(this), (Plugin) this);
		pm.registerEvents((Listener) new DropItens(this), (Plugin) this);
		pm.registerEvents((Listener) new PlayerRespawn(), (Plugin) this);
		pm.registerEvents((Listener) new CommandBuild(), (Plugin) this);
		pm.registerEvents((Listener) new Sopa(this), (Plugin) this);
		pm.registerEvents((Listener) new Anchor(this), (Plugin) this);
		pm.registerEvents((Listener) new Archer(this), (Plugin) this);
		pm.registerEvents((Listener) new Monk(this), (Plugin) this);
		pm.registerEvents((Listener) new Kangaroo(this), (Plugin) this);
		pm.registerEvents((Listener) new Launcher(this), (Plugin) this);
		pm.registerEvents((Listener) new Fisherman(this), (Plugin) this);
		pm.registerEvents((Listener) new Timelord(this), (Plugin) this);
		pm.registerEvents((Listener) new Snail(this), (Plugin) this);
		pm.registerEvents((Listener) new Phantom(this), (Plugin) this);
		pm.registerEvents((Listener) new Frosty(this), (Plugin) this);
		pm.registerEvents((Listener) new Tank(this), (Plugin) this);
		pm.registerEvents((Listener) new Viper(this), (Plugin) this);
		pm.registerEvents((Listener) new Rider(this), (Plugin) this);
		pm.registerEvents((Listener) new Backpacker(this), (Plugin) this);
		pm.registerEvents((Listener) new Milkman(this), (Plugin) this);
		pm.registerEvents((Listener) new Specialist(this), (Plugin) this);
		pm.registerEvents((Listener) new CookieMonster(this), (Plugin) this);
		pm.registerEvents((Listener) new BlockJump(this), (Plugin) this);
		pm.registerEvents((Listener) new Vampire(this), (Plugin) this);
		pm.registerEvents((Listener) new Hulk(this), (Plugin) this);
		pm.registerEvents((Listener) new Berserker(this), (Plugin) this);
		pm.registerEvents((Listener) new Camel(this), (Plugin) this);
		pm.registerEvents((Listener) new Switcher(this), (Plugin) this);
		pm.registerEvents((Listener) new Turtle(this), (Plugin) this);
		pm.registerEvents((Listener) new Thor(this), (Plugin) this);
		pm.registerEvents((Listener) new Endermage(this), (Plugin) this);
		pm.registerEvents((Listener) new Neo(this), (Plugin) this);
		pm.registerEvents((Listener) new Gambler(this), (Plugin) this);
		pm.registerEvents((Listener) new ArmorIncre(this), (Plugin) this);
		pm.registerEvents((Listener) new Spectre(this), (Plugin) this);
		pm.registerEvents((Listener) new Salamander(this), (Plugin) this);
		pm.registerEvents((Listener) new Poseidon(this), (Plugin) this);
		pm.registerEvents((Listener) new Macaco(this), (Plugin) this);
		pm.registerEvents((Listener) new NoPlugins(), (Plugin) this);
		pm.registerEvents((Listener) new Stomper(this), (Plugin) this);
		pm.registerEvents((Listener) new Demoman(), (Plugin) this);
		pm.registerEvents((Listener) new GUI(this), (Plugin) this);
		pm.registerEvents((Listener) new GUIVIP(this), (Plugin) this);
		pm.registerEvents((Listener) new Grappler1(this), (Plugin) this);
		pm.registerEvents((Listener) new Gladiator(this), (Plugin) this);
		pm.registerEvents((Listener) new RobinHood(this), (Plugin) this);
		pm.registerEvents((Listener) new Vacuum(this), (Plugin) this);
		pm.registerEvents((Listener) new DamageListener(this), (Plugin) this);
		pm.registerEvents((Listener) new CommandShop(this), (Plugin) this);
		pm.registerEvents((Listener) new KillStreaks(this), (Plugin) this);
		pm.registerEvents((Listener) new Freeze(this), (Plugin) this);
		pm.registerEvents((Listener) new Viking(this), (Plugin) this);
		pm.registerEvents((Listener) new Sniper(this), (Plugin) this);
		pm.registerEvents((Listener) new Jumper(this), (Plugin) this);
	}

	@EventHandler
	public void joinEvents(final PlayerJoinEvent event) {
		Main.used.remove(event.getPlayer().getName());
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSignChange(final SignChangeEvent event) {
		final String CHAR = this.getConfig().getString("ColoredSigns.char");
		if (event.getPlayer().hasPermission("coloredsigns.format")) {
			if (event.getLine(0).contains(CHAR)) {
				event.setLine(0, event.getLine(0).replaceAll("(" + CHAR + "([a-fk-or0-9A-FK-OR]))", "§$2"));
			}
			if (event.getLine(1).contains(CHAR)) {
				event.setLine(1, event.getLine(1).replaceAll("(" + CHAR + "([a-fk-or0-9A-FK-OR]))", "§$2"));
			}
			if (event.getLine(2).contains(CHAR)) {
				event.setLine(2, event.getLine(2).replaceAll("(" + CHAR + "([a-fk-or0-9A-FK-OR]))", "§$2"));
			}
			if (event.getLine(3).contains(CHAR)) {
				event.setLine(3, event.getLine(3).replaceAll("(" + CHAR + "([a-fk-or0-9A-FK-OR]))", "§$2"));
			}
		}
	}

	@EventHandler
	public void onquit(final PlayerQuitEvent event) {
		final Player p = event.getPlayer();
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
		Main.sniper.remove(p.getName());
		Main.jumper.remove(p.getName());
		Main.reload.remove(p.getName());
	}

	@EventHandler
	public void onDeath(final PlayerDeathEvent event) {
		final Player p = event.getEntity();
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
		Main.reload.remove(p.getName());
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
		Main.sniper.remove(p.getName());
		Main.jumper.remove(p.getName());
		p.setExp(0.0f);
		p.setLevel(0);
		if (p.getKiller() instanceof Player) {
			final Player killer = p.getKiller();
			final int r = dinheirorandom(80, 120);
			killer.sendMessage(ChatColor.GREEN + "[StylePvP] " + ChatColor.GOLD + "Voce ganhou " + r + " por matar "
					+ p.getName() + ".");
			Main.econ.depositPlayer(killer.getName(), (double) r);
		}
	}

	@EventHandler
	public void onChat(final PlayerChatEvent e) {
		String message = e.getMessage();
		message = message.replaceAll("§", "§");
		e.setMessage(message);
		String msg = e.getMessage();
		msg = msg.replace(":/", "\u32db ");
		msg = msg.replace("<3", "\u2764");
		msg = msg.replace("-->", "\u27a1");
		msg = msg.replace("<--", "\u2b05");
		msg = msg.replace("(y)", "\u2714");
		msg = msg.replace("(n)", "\u2716");
		msg = msg.replace("(copyright)", "©");
		msg = msg.replace("(tm)", "\u2122");
		msg = msg.replace("(flocon)", "\u2746");
		msg = msg.replace("(star)", "\u2730");
		msg = msg.replace("(music)", "\u266b");
		msg = msg.replace("(!)", "\u26a0");
		e.setMessage(msg);
	}

	@EventHandler
	public void onChat2(final AsyncPlayerChatEvent e) {
		String message = e.getMessage();
		message = message.replaceAll("§", "§");
		e.setMessage(message);
		String msg = e.getMessage();
		msg = msg.replace("%", "\u32db ");
		msg = msg.replace("<3", "\u2764");
		msg = msg.replace("-->", "\u27a1");
		msg = msg.replace("<--", "\u2b05");
		msg = msg.replace("(y)", "\u2714");
		msg = msg.replace("(n)", "\u2716");
		msg = msg.replace("(copyright)", "©");
		msg = msg.replace("(tm)", "\u2122");
		msg = msg.replace("(flocon)", "\u2746");
		msg = msg.replace("(star)", "\u2730");
		msg = msg.replace("(music)", "\u266b");
		msg = msg.replace("(!)", "\u26a0");
		e.setMessage(msg);
	}
}
