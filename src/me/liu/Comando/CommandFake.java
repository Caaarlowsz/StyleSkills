package me.liu.Comando;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.liu.*;
import org.bukkit.*;

public class CommandFake implements CommandExecutor
{
    public CommandFake pl;
    
    public CommandFake(final CommandFake plugin) {
        this.pl = plugin;
    }
    
    public CommandFake(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Este comando s\u00f3 pode ser usado dentro do jogo!");
            return true;
        }
        if (!sender.hasPermission("style.fake")) {
            Permissions.semPermiassao((Player)sender);
            return true;
        }
        if (!command.getName().equalsIgnoreCase("fake")) {
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /fake <entrar,sair>");
            return true;
        }
        if (args[0].equalsIgnoreCase("entrar")) {
            Bukkit.broadcastMessage("§6[§2+§6]§7§o " + sender.getName() + " entrou");
            return true;
        }
        if (args[0].equalsIgnoreCase("sair")) {
            Bukkit.broadcastMessage("§6[§4-§6]§7§o " + sender.getName() + " saiu");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Usage: /fake <entrar,sair>");
        return true;
    }
}
