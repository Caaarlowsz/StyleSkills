package me.liu;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.scheduler.BukkitTask;

public class Metrics {
	private final Plugin plugin;
	private final YamlConfiguration configuration;
	private final File configurationFile;
	private final String guid;
	private final boolean debug;
	private final Object optOutLock;
	private volatile BukkitTask task;

	public Metrics(final Plugin plugin) throws IOException {
		this.optOutLock = new Object();
		this.task = null;
		if (plugin == null) {
			throw new IllegalArgumentException("Plugin cannot be null");
		}
		this.plugin = plugin;
		this.configurationFile = this.getConfigFile();
		(this.configuration = YamlConfiguration.loadConfiguration(this.configurationFile)).addDefault("opt-out",
				(Object) false);
		this.configuration.addDefault("guid", (Object) UUID.randomUUID().toString());
		this.configuration.addDefault("debug", (Object) false);
		if (this.configuration.get("guid", (Object) null) == null) {
			this.configuration.options().header("http://mcstats.org").copyDefaults(true);
			this.configuration.save(this.configurationFile);
		}
		this.guid = this.configuration.getString("guid");
		this.debug = this.configuration.getBoolean("debug", false);
	}

	public boolean start() {
		synchronized (this.optOutLock) {
			if (this.isOptOut()) {
				// monitorexit(this.optOutLock)
				return false;
			}
			if (this.task != null) {
				// monitorexit(this.optOutLock)
				return true;
			}
			this.task = this.plugin.getServer().getScheduler().runTaskTimerAsynchronously(this.plugin,
					(Runnable) new Runnable() {
						private boolean firstPost = true;

						@Override
						public void run() {
							try {
								synchronized (Metrics.this.optOutLock) {
									if (Metrics.this.isOptOut() && Metrics.this.task != null) {
										Metrics.this.task.cancel();
										Metrics.access$2(Metrics.this, null);
									}
								}
								// monitorexit(Metrics.access$0(this.this$0))
								Metrics.this.postPlugin(!this.firstPost);
								this.firstPost = false;
							} catch (IOException e) {
								if (Metrics.this.debug) {
									Bukkit.getLogger().log(Level.INFO, "[Metrics] " + e.getMessage());
								}
							}
						}
					}, 0L, 18000L);
			// monitorexit(this.optOutLock)
			return true;
		}
	}

	public boolean isOptOut() {
		synchronized (this.optOutLock) {
			try {
				this.configuration.load(this.getConfigFile());
			} catch (IOException ex) {
				if (this.debug) {
					Bukkit.getLogger().log(Level.INFO, "[Metrics] " + ex.getMessage());
				}
				// monitorexit(this.optOutLock)
				return true;
			} catch (InvalidConfigurationException ex2) {
				if (this.debug) {
					Bukkit.getLogger().log(Level.INFO, "[Metrics] " + ex2.getMessage());
				}
				// monitorexit(this.optOutLock)
				return true;
			}
			// monitorexit(this.optOutLock)
			return this.configuration.getBoolean("opt-out", false);
		}
	}

	public void enable() throws IOException {
		synchronized (this.optOutLock) {
			if (this.isOptOut()) {
				this.configuration.set("opt-out", (Object) false);
				this.configuration.save(this.configurationFile);
			}
			if (this.task == null) {
				this.start();
			}
		}
		// monitorexit(this.optOutLock)
	}

	public void disable() throws IOException {
		synchronized (this.optOutLock) {
			if (!this.isOptOut()) {
				this.configuration.set("opt-out", (Object) true);
				this.configuration.save(this.configurationFile);
			}
			if (this.task != null) {
				this.task.cancel();
				this.task = null;
			}
		}
		// monitorexit(this.optOutLock)
	}

	public File getConfigFile() {
		final File pluginsFolder = this.plugin.getDataFolder().getParentFile();
		return new File(new File(pluginsFolder, "PluginMetrics"), "config.yml");
	}

	private void postPlugin(final boolean isPing) throws IOException {
		final PluginDescriptionFile description = this.plugin.getDescription();
		final String pluginName = description.getName();
		final boolean onlineMode = Bukkit.getServer().getOnlineMode();
		final String pluginVersion = description.getVersion();
		final String serverVersion = Bukkit.getVersion();
		final int playersOnline = Bukkit.getServer().getOnlinePlayers().length;
		final StringBuilder json = new StringBuilder(1024);
		json.append('{');
		appendJSONPair(json, "guid", this.guid);
		appendJSONPair(json, "plugin_version", pluginVersion);
		appendJSONPair(json, "server_version", serverVersion);
		appendJSONPair(json, "players_online", Integer.toString(playersOnline));
		final String osname = System.getProperty("os.name");
		String osarch = System.getProperty("os.arch");
		final String osversion = System.getProperty("os.version");
		final String java_version = System.getProperty("java.version");
		final int coreCount = Runtime.getRuntime().availableProcessors();
		if (osarch.equals("amd64")) {
			osarch = "x86_64";
		}
		appendJSONPair(json, "osname", osname);
		appendJSONPair(json, "osarch", osarch);
		appendJSONPair(json, "osversion", osversion);
		appendJSONPair(json, "cores", Integer.toString(coreCount));
		appendJSONPair(json, "auth_mode", onlineMode ? "1" : "0");
		appendJSONPair(json, "java_version", java_version);
		if (isPing) {
			appendJSONPair(json, "ping", "1");
		}
		json.append('}');
		final URL url = new URL("http://report.mcstats.org" + String.format("/plugin/%s", urlEncode(pluginName)));
		URLConnection connection;
		if (this.isMineshafterPresent()) {
			connection = url.openConnection(Proxy.NO_PROXY);
		} else {
			connection = url.openConnection();
		}
		final byte[] uncompressed = json.toString().getBytes();
		final byte[] compressed = gzip(json.toString());
		connection.addRequestProperty("User-Agent", "MCStats/7");
		connection.addRequestProperty("Content-Type", "application/json");
		connection.addRequestProperty("Content-Encoding", "gzip");
		connection.addRequestProperty("Content-Length", Integer.toString(compressed.length));
		connection.addRequestProperty("Accept", "application/json");
		connection.addRequestProperty("Connection", "close");
		connection.setDoOutput(true);
		if (this.debug) {
			System.out.println("[Metrics] Prepared request for " + pluginName + " uncompressed=" + uncompressed.length
					+ " compressed=" + compressed.length);
		}
		final OutputStream os = connection.getOutputStream();
		os.write(compressed);
		os.flush();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String response = reader.readLine();
		os.close();
		reader.close();
		if (response == null || response.startsWith("ERR") || response.startsWith("7")) {
			if (response == null) {
				response = "null";
			} else if (response.startsWith("7")) {
				response = response.substring(response.startsWith("7,") ? 2 : 1);
			}
			throw new IOException(response);
		}
	}

	public static byte[] gzip(final String input) {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gzos = null;
		try {
			gzos = new GZIPOutputStream(baos);
			gzos.write(input.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			if (gzos != null) {
				try {
					gzos.close();
				} catch (IOException ex) {
				}
			}
		} finally {
			if (gzos != null) {
				try {
					gzos.close();
				} catch (IOException ex2) {
				}
			}
		}
		if (gzos != null) {
			try {
				gzos.close();
			} catch (IOException ex3) {
			}
		}
		return baos.toByteArray();
	}

	private boolean isMineshafterPresent() {
		try {
			Class.forName("mineshafter.MineServer");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	private static void appendJSONPair(final StringBuilder json, final String key, final String value)
			throws UnsupportedEncodingException {
		boolean isValueNumeric = false;
		try {
			if (value.equals("0") || !value.endsWith("0")) {
				Double.parseDouble(value);
				isValueNumeric = true;
			}
		} catch (NumberFormatException e) {
			isValueNumeric = false;
		}
		if (json.charAt(json.length() - 1) != '{') {
			json.append(',');
		}
		json.append(escapeJSON(key));
		json.append(':');
		if (isValueNumeric) {
			json.append(value);
		} else {
			json.append(escapeJSON(value));
		}
	}

	private static String escapeJSON(final String text) {
		final StringBuilder builder = new StringBuilder();
		builder.append('\"');
		for (int index = 0; index < text.length(); ++index) {
			final char chr = text.charAt(index);
			switch (chr) {
			case '\"':
			case '\\': {
				builder.append('\\');
				builder.append(chr);
				break;
			}
			case '\b': {
				builder.append("\\b");
				break;
			}
			case '\t': {
				builder.append("\\t");
				break;
			}
			case '\n': {
				builder.append("\\n");
				break;
			}
			case '\r': {
				builder.append("\\r");
				break;
			}
			default: {
				if (chr < ' ') {
					final String t = "000" + Integer.toHexString(chr);
					builder.append("\\u" + t.substring(t.length() - 4));
					break;
				}
				builder.append(chr);
				break;
			}
			}
		}
		builder.append('\"');
		return builder.toString();
	}

	private static String urlEncode(final String text) throws UnsupportedEncodingException {
		return URLEncoder.encode(text, "UTF-8");
	}

	static /* synthetic */ void access$2(final Metrics metrics, final BukkitTask task) {
		metrics.task = task;
	}
}
