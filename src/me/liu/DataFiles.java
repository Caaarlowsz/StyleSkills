package me.liu;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class DataFiles {
	static DataFiles instance;
	Plugin p;
	FileConfiguration config;
	File cfile;
	FileConfiguration money;
	File moneyFile;

	static {
		DataFiles.instance = new DataFiles();
	}

	public static DataFiles getInstance() {
		return DataFiles.instance;
	}

	public void setup(final Plugin p) {
		this.cfile = new File(p.getDataFolder(), "config.yml");
		this.config = p.getConfig();
		if (!this.cfile.exists()) {
			this.config.options().copyDefaults(true);
		}
		this.saveConfig();
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
	}

	public FileConfiguration getConfig() {
		return this.config;
	}

	public void saveConfig() {
		try {
			this.config.save(this.cfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
		}
	}

	public void reloadConfig() {
		this.config = (FileConfiguration) YamlConfiguration.loadConfiguration(this.cfile);
	}

	public PluginDescriptionFile getDesc() {
		return this.p.getDescription();
	}
}
