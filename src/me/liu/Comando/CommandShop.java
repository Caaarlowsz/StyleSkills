package me.liu.Comando;

import me.liu.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.enchantments.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.block.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.inventory.*;
import net.milkbowl.vault.economy.*;

public class CommandShop implements Listener, CommandExecutor
{
    private Main plugin;
    
    public CommandShop(final Main instance) {
        this.plugin = instance;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("shop")) {
            final Player p = (Player)sender;
            final ItemStack iron = new ItemStack(Material.THIN_GLASS);
            final ItemStack Sword = new ItemStack(Material.STONE_SWORD);
            final ItemMeta Swordmeta = Sword.getItemMeta();
            Swordmeta.setDisplayName(ChatColor.GREEN + "Espada de Pedra $2000");
            Sword.setItemMeta(Swordmeta);
            final ItemStack Sharp4 = new ItemStack(Material.STONE_SWORD);
            Sharp4.addEnchantment(Enchantment.DAMAGE_ALL, 4);
            final ItemMeta Sharp4meta = Sharp4.getItemMeta();
            Sharp4meta.setDisplayName(ChatColor.GREEN + "Sharp 4 $12000");
            Sharp4.setItemMeta(Sharp4meta);
            final ItemStack Sharp5 = new ItemStack(Material.STONE_SWORD);
            Sharp5.addEnchantment(Enchantment.DAMAGE_ALL, 5);
            final ItemMeta Sharp5meta = Sharp5.getItemMeta();
            Sharp5meta.setDisplayName(ChatColor.GREEN + "Sharp 5 $18000");
            Sharp5.setItemMeta(Sharp5meta);
            final ItemStack EXP = new ItemStack(Material.ENDER_PEARL);
            final ItemMeta EXPmeta = EXP.getItemMeta();
            EXPmeta.setDisplayName(ChatColor.GREEN + "EnderPearl $5200");
            EXP.setItemMeta(EXPmeta);
            final ItemStack Arco = new ItemStack(Material.BOW);
            final ItemMeta Arcometa = Arco.getItemMeta();
            Arcometa.setDisplayName(ChatColor.GREEN + "Arco $2500");
            Arco.setItemMeta(Arcometa);
            final ItemStack ArcoFor\u00e7a = new ItemStack(Material.BOW);
            ArcoFor\u00e7a.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
            final ItemMeta ArcoFor\u00e7ameta = ArcoFor\u00e7a.getItemMeta();
            ArcoFor\u00e7ameta.setDisplayName(ChatColor.GREEN + "For\u00e7a 5 $10000");
            ArcoFor\u00e7a.setItemMeta(ArcoFor\u00e7ameta);
            final ItemStack ArcoImpacto = new ItemStack(Material.BOW);
            ArcoImpacto.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
            final ItemMeta ArcoImpactometa = ArcoImpacto.getItemMeta();
            ArcoImpactometa.setDisplayName(ChatColor.GREEN + "Impacto 2 $6000");
            ArcoImpacto.setItemMeta(ArcoImpactometa);
            final ItemStack Flechas = new ItemStack(Material.ARROW);
            final ItemMeta Flechasmeta = Flechas.getItemMeta();
            Flechasmeta.setDisplayName(ChatColor.GREEN + "Flechas $250");
            Flechas.setItemMeta(Flechasmeta);
            final ItemStack po\u00e7\u00e3o = new ItemStack(Material.POTION);
            po\u00e7\u00e3o.setDurability((short)8265);
            final ItemMeta po\u00e7\u00e3ometa = po\u00e7\u00e3o.getItemMeta();
            po\u00e7\u00e3ometa.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de for\u00e7a $20000");
            po\u00e7\u00e3o.setItemMeta(po\u00e7\u00e3ometa);
            final ItemStack po\u00e7\u00e3o2 = new ItemStack(Material.POTION);
            po\u00e7\u00e3o2.setDurability((short)16457);
            final ItemMeta po\u00e7\u00e3o2meta = po\u00e7\u00e3o2.getItemMeta();
            po\u00e7\u00e3o2meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de for\u00e7a 2 $30000");
            po\u00e7\u00e3o2.setItemMeta(po\u00e7\u00e3o2meta);
            final ItemStack po\u00e7\u00e3o3 = new ItemStack(Material.POTION);
            po\u00e7\u00e3o3.setDurability((short)16428);
            final ItemMeta po\u00e7\u00e3o3meta = po\u00e7\u00e3o3.getItemMeta();
            po\u00e7\u00e3o3meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de dano $6000");
            po\u00e7\u00e3o3.setItemMeta(po\u00e7\u00e3o3meta);
            final ItemStack po\u00e7\u00e3o4 = new ItemStack(Material.POTION);
            po\u00e7\u00e3o4.setDurability((short)16418);
            final ItemMeta po\u00e7\u00e3o4meta = po\u00e7\u00e3o4.getItemMeta();
            po\u00e7\u00e3o4meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de velocidade II $12000");
            po\u00e7\u00e3o4.setItemMeta(po\u00e7\u00e3o4meta);
            final ItemStack po\u00e7\u00e3o5 = new ItemStack(Material.POTION);
            po\u00e7\u00e3o5.setDurability((short)16388);
            final ItemMeta po\u00e7\u00e3o5meta = po\u00e7\u00e3o5.getItemMeta();
            po\u00e7\u00e3o5meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de veneno $10000");
            po\u00e7\u00e3o5.setItemMeta(po\u00e7\u00e3o5meta);
            final Inventory shop = Bukkit.getServer().createInventory((InventoryHolder)p, 18, "§6§lStyle-Shop");
            shop.setItem(0, iron);
            shop.setItem(1, iron);
            shop.setItem(2, ArcoImpacto);
            shop.setItem(3, Sharp4);
            shop.setItem(4, Sword);
            shop.setItem(5, Sharp5);
            shop.setItem(6, ArcoFor\u00e7a);
            shop.setItem(7, iron);
            shop.setItem(8, iron);
            shop.setItem(9, iron);
            shop.setItem(10, Arco);
            shop.setItem(11, po\u00e7\u00e3o3);
            shop.setItem(12, po\u00e7\u00e3o);
            shop.setItem(13, po\u00e7\u00e3o2);
            shop.setItem(14, po\u00e7\u00e3o4);
            shop.setItem(15, po\u00e7\u00e3o5);
            shop.setItem(16, EXP);
            shop.setItem(17, iron);
            p.openInventory(shop);
        }
        return false;
    }
    
    @EventHandler
    public void shop(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final ItemStack iron = new ItemStack(Material.THIN_GLASS);
        final ItemStack Sword = new ItemStack(Material.STONE_SWORD);
        final ItemMeta Swordmeta = Sword.getItemMeta();
        Swordmeta.setDisplayName(ChatColor.GREEN + "Espada de Pedra $2000");
        Sword.setItemMeta(Swordmeta);
        final ItemStack Sharp4 = new ItemStack(Material.STONE_SWORD);
        Sharp4.addEnchantment(Enchantment.DAMAGE_ALL, 4);
        final ItemMeta Sharp4meta = Sharp4.getItemMeta();
        Sharp4meta.setDisplayName(ChatColor.GREEN + "Sharp 4 $12000");
        Sharp4.setItemMeta(Sharp4meta);
        final ItemStack Sharp5 = new ItemStack(Material.STONE_SWORD);
        Sharp5.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        final ItemMeta Sharp5meta = Sharp5.getItemMeta();
        Sharp5meta.setDisplayName(ChatColor.GREEN + "Sharp 5 $18000");
        Sharp5.setItemMeta(Sharp5meta);
        final ItemStack EXP = new ItemStack(Material.ENDER_PEARL);
        final ItemMeta EXPmeta = EXP.getItemMeta();
        EXPmeta.setDisplayName(ChatColor.GREEN + "EnderPearl $5200");
        EXP.setItemMeta(EXPmeta);
        final ItemStack Arco = new ItemStack(Material.BOW);
        final ItemMeta Arcometa = Arco.getItemMeta();
        Arcometa.setDisplayName(ChatColor.GREEN + "Arco $2500");
        Arco.setItemMeta(Arcometa);
        final ItemStack ArcoFor\u00e7a = new ItemStack(Material.BOW);
        ArcoFor\u00e7a.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
        final ItemMeta ArcoFor\u00e7ameta = ArcoFor\u00e7a.getItemMeta();
        ArcoFor\u00e7ameta.setDisplayName(ChatColor.GREEN + "For\u00e7a 5 $10000");
        ArcoFor\u00e7a.setItemMeta(ArcoFor\u00e7ameta);
        final ItemStack ArcoImpacto = new ItemStack(Material.BOW);
        ArcoImpacto.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
        final ItemMeta ArcoImpactometa = ArcoImpacto.getItemMeta();
        ArcoImpactometa.setDisplayName(ChatColor.GREEN + "Impacto 2 $6000");
        ArcoImpacto.setItemMeta(ArcoImpactometa);
        final ItemStack Flechas = new ItemStack(Material.ARROW);
        final ItemMeta Flechasmeta = Flechas.getItemMeta();
        Flechasmeta.setDisplayName(ChatColor.GREEN + "Flechas $250");
        Flechas.setItemMeta(Flechasmeta);
        final ItemStack po\u00e7\u00e3o = new ItemStack(Material.POTION);
        po\u00e7\u00e3o.setDurability((short)8265);
        final ItemMeta po\u00e7\u00e3ometa = po\u00e7\u00e3o.getItemMeta();
        po\u00e7\u00e3ometa.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de for\u00e7a $20000");
        po\u00e7\u00e3o.setItemMeta(po\u00e7\u00e3ometa);
        final ItemStack po\u00e7\u00e3o2 = new ItemStack(Material.POTION);
        po\u00e7\u00e3o2.setDurability((short)16457);
        final ItemMeta po\u00e7\u00e3o2meta = po\u00e7\u00e3o2.getItemMeta();
        po\u00e7\u00e3o2meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de for\u00e7a 2 $30000");
        po\u00e7\u00e3o2.setItemMeta(po\u00e7\u00e3o2meta);
        final ItemStack po\u00e7\u00e3o3 = new ItemStack(Material.POTION);
        po\u00e7\u00e3o3.setDurability((short)16428);
        final ItemMeta po\u00e7\u00e3o3meta = po\u00e7\u00e3o3.getItemMeta();
        po\u00e7\u00e3o3meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de dano $6000");
        po\u00e7\u00e3o3.setItemMeta(po\u00e7\u00e3o3meta);
        final ItemStack po\u00e7\u00e3o4 = new ItemStack(Material.POTION);
        po\u00e7\u00e3o4.setDurability((short)16418);
        final ItemMeta po\u00e7\u00e3o4meta = po\u00e7\u00e3o4.getItemMeta();
        po\u00e7\u00e3o4meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de velocidade II $12000");
        po\u00e7\u00e3o4.setItemMeta(po\u00e7\u00e3o4meta);
        final ItemStack po\u00e7\u00e3o5 = new ItemStack(Material.POTION);
        po\u00e7\u00e3o5.setDurability((short)16388);
        final ItemMeta po\u00e7\u00e3o5meta = po\u00e7\u00e3o5.getItemMeta();
        po\u00e7\u00e3o5meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de veneno $10000");
        po\u00e7\u00e3o5.setItemMeta(po\u00e7\u00e3o5meta);
        final Inventory shop = Bukkit.getServer().createInventory((InventoryHolder)p, 18, "§6§lStyle-Shop");
        shop.setItem(0, iron);
        shop.setItem(1, iron);
        shop.setItem(2, ArcoImpacto);
        shop.setItem(3, Sharp4);
        shop.setItem(4, Sword);
        shop.setItem(5, Sharp5);
        shop.setItem(6, ArcoFor\u00e7a);
        shop.setItem(7, iron);
        shop.setItem(8, iron);
        shop.setItem(9, iron);
        shop.setItem(10, Arco);
        shop.setItem(11, po\u00e7\u00e3o3);
        shop.setItem(12, po\u00e7\u00e3o);
        shop.setItem(13, po\u00e7\u00e3o2);
        shop.setItem(14, po\u00e7\u00e3o4);
        shop.setItem(15, po\u00e7\u00e3o5);
        shop.setItem(16, EXP);
        shop.setItem(17, iron);
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST)) {
            final Sign s = (Sign)e.getClickedBlock().getState();
            final String[] lines = s.getLines();
            if (lines.length > 2 && lines[1].equals("§4§lShop") && lines.length > 1 && lines[0].equals("§6§l[StylePvP]")) {
                p.openInventory(shop);
            }
        }
        if (p.getItemInHand().getType() == Material.EMERALD) {
            p.openInventory(shop);
        }
    }
    
    @EventHandler
    public void onSignChange(final SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("[StylePvP]")) {
            e.setLine(0, "§6§l[StylePvP]");
            e.setLine(1, "§4§lShop");
        }
    }
    
    @EventHandler
    public void inventoryclick(final InventoryClickEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase("§6§lStyle-Shop") && e.getRawSlot() < 18 && e.getRawSlot() > -1) {
            final ItemStack itemclicked = e.getCurrentItem();
            final ItemStack cursor = e.getCursor();
            e.setCancelled(true);
            if (cursor.getTypeId() == 0) {
                final Player p = (Player)e.getWhoClicked();
                final ItemStack Sword = new ItemStack(Material.STONE_SWORD);
                final ItemMeta Swordmeta = Sword.getItemMeta();
                Swordmeta.setDisplayName(ChatColor.GREEN + "Espada de Pedra $2000");
                Sword.setItemMeta(Swordmeta);
                final ItemStack Sharp4 = new ItemStack(Material.STONE_SWORD);
                Sharp4.addEnchantment(Enchantment.DAMAGE_ALL, 4);
                final ItemMeta Sharp4meta = Sharp4.getItemMeta();
                Sharp4meta.setDisplayName(ChatColor.GREEN + "Sharp 4 $12000");
                Sharp4.setItemMeta(Sharp4meta);
                final ItemStack Sharp5 = new ItemStack(Material.STONE_SWORD);
                Sharp5.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                final ItemMeta Sharp5meta = Sharp5.getItemMeta();
                Sharp5meta.setDisplayName(ChatColor.GREEN + "Sharp 5 $18000");
                Sharp5.setItemMeta(Sharp5meta);
                final ItemStack EXP = new ItemStack(Material.ENDER_PEARL);
                final ItemMeta EXPmeta = EXP.getItemMeta();
                EXPmeta.setDisplayName(ChatColor.GREEN + "EnderPearl $5200");
                EXP.setItemMeta(EXPmeta);
                final ItemStack Arco = new ItemStack(Material.BOW);
                final ItemMeta Arcometa = Arco.getItemMeta();
                Arcometa.setDisplayName(ChatColor.GREEN + "Arco $2500");
                Arco.setItemMeta(Arcometa);
                final ItemStack ArcoFor\u00e7a = new ItemStack(Material.BOW);
                ArcoFor\u00e7a.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
                final ItemMeta ArcoFor\u00e7ameta = ArcoFor\u00e7a.getItemMeta();
                ArcoFor\u00e7ameta.setDisplayName(ChatColor.GREEN + "For\u00e7a 5 $10000");
                ArcoFor\u00e7a.setItemMeta(ArcoFor\u00e7ameta);
                final ItemStack ArcoImpacto = new ItemStack(Material.BOW);
                ArcoImpacto.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
                final ItemMeta ArcoImpactometa = ArcoImpacto.getItemMeta();
                ArcoImpactometa.setDisplayName(ChatColor.GREEN + "Impacto 2 $6000");
                ArcoImpacto.setItemMeta(ArcoImpactometa);
                final ItemStack Flechas = new ItemStack(Material.ARROW);
                final ItemMeta Flechasmeta = Flechas.getItemMeta();
                Flechasmeta.setDisplayName(ChatColor.GREEN + "Flechas $250");
                Flechas.setItemMeta(Flechasmeta);
                final ItemStack po\u00e7\u00e3o = new ItemStack(Material.POTION);
                po\u00e7\u00e3o.setDurability((short)8265);
                final ItemMeta po\u00e7\u00e3ometa = po\u00e7\u00e3o.getItemMeta();
                po\u00e7\u00e3ometa.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de for\u00e7a $20000");
                po\u00e7\u00e3o.setItemMeta(po\u00e7\u00e3ometa);
                final ItemStack po\u00e7\u00e3o2 = new ItemStack(Material.POTION);
                po\u00e7\u00e3o2.setDurability((short)16457);
                final ItemMeta po\u00e7\u00e3o2meta = po\u00e7\u00e3o2.getItemMeta();
                po\u00e7\u00e3o2meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de for\u00e7a 2 $30000");
                po\u00e7\u00e3o2.setItemMeta(po\u00e7\u00e3o2meta);
                final ItemStack po\u00e7\u00e3o3 = new ItemStack(Material.POTION);
                po\u00e7\u00e3o3.setDurability((short)16428);
                final ItemMeta po\u00e7\u00e3o3meta = po\u00e7\u00e3o3.getItemMeta();
                po\u00e7\u00e3o3meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de dano $6000");
                po\u00e7\u00e3o3.setItemMeta(po\u00e7\u00e3o3meta);
                final ItemStack po\u00e7\u00e3o4 = new ItemStack(Material.POTION);
                po\u00e7\u00e3o4.setDurability((short)16418);
                final ItemMeta po\u00e7\u00e3o4meta = po\u00e7\u00e3o4.getItemMeta();
                po\u00e7\u00e3o4meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de velocidade II $12000");
                po\u00e7\u00e3o4.setItemMeta(po\u00e7\u00e3o4meta);
                final ItemStack po\u00e7\u00e3o5 = new ItemStack(Material.POTION);
                po\u00e7\u00e3o5.setDurability((short)16388);
                final ItemMeta po\u00e7\u00e3o5meta = po\u00e7\u00e3o5.getItemMeta();
                po\u00e7\u00e3o5meta.setDisplayName(ChatColor.GREEN + "Po\u00e7\u00e3o de veneno $10000");
                po\u00e7\u00e3o5.setItemMeta(po\u00e7\u00e3o5meta);
                if (itemclicked.equals((Object)Sword)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 2000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack Diamond = new ItemStack(Material.STONE_SWORD);
                        p.getInventory().addItem(new ItemStack[] { Diamond });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou uma espada de pedra!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)Sword)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 2000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack Diamond = new ItemStack(Material.STONE_SWORD);
                        p.getInventory().addItem(new ItemStack[] { Diamond });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou uma espada de pedra!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)Sharp4)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 12000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack Diamond = new ItemStack(Material.STONE_SWORD);
                        Diamond.addEnchantment(Enchantment.DAMAGE_ALL, 4);
                        p.getInventory().addItem(new ItemStack[] { Diamond });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou sharp 4 para sua espada!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)Sharp5)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 18000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack Diamond = new ItemStack(Material.STONE_SWORD);
                        Diamond.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                        p.getInventory().addItem(new ItemStack[] { Diamond });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou sharp 5 para sua espada!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)EXP)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 5200.0);
                    if (r.transactionSuccess()) {
                        for (int i = 0; i < 2; ++i) {
                            final ItemStack Diamond2 = new ItemStack(Material.ENDER_PEARL);
                            p.getInventory().addItem(new ItemStack[] { Diamond2 });
                        }
                        p.sendMessage(ChatColor.GREEN + "Voce comprou enderperals!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)Arco)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 2500.0);
                    if (r.transactionSuccess()) {
                        final ItemStack Diamond = new ItemStack(Material.BOW);
                        p.getInventory().addItem(new ItemStack[] { Diamond });
                        p.getInventory().addItem(new ItemStack[] { new ItemStack(262, 64) });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou um arco e flecha!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)po\u00e7\u00e3o3)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 6000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack po\u00e7\u00e3oa3 = new ItemStack(Material.POTION);
                        po\u00e7\u00e3oa3.setDurability((short)16428);
                        p.getInventory().addItem(new ItemStack[] { po\u00e7\u00e3oa3 });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou uma Po\u00e7ao de dano!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)po\u00e7\u00e3o4)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 12000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack po\u00e7\u00e3o4a = new ItemStack(Material.POTION);
                        po\u00e7\u00e3o4a.setDurability((short)16418);
                        p.getInventory().addItem(new ItemStack[] { po\u00e7\u00e3o4a });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou uma Po\u00e7\u00e3o de velocidade II!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)po\u00e7\u00e3o5)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 10000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack po\u00e7\u00e3o5a = new ItemStack(Material.POTION);
                        po\u00e7\u00e3o5a.setDurability((short)16388);
                        p.getInventory().addItem(new ItemStack[] { po\u00e7\u00e3o5a });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou uma Po\u00e7\u00e3o de veneno!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)ArcoFor\u00e7a)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 10000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack ArcoFor\u00e7aa = new ItemStack(Material.BOW);
                        ArcoFor\u00e7aa.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
                        p.getInventory().addItem(new ItemStack[] { ArcoFor\u00e7aa });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou for\u00e7a 5 para seu arco!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)ArcoImpacto)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 6000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack ArcoFor\u00e7aaa = new ItemStack(Material.BOW);
                        ArcoFor\u00e7aaa.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
                        p.getInventory().addItem(new ItemStack[] { ArcoFor\u00e7aaa });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou Impacto 2 para seu arco!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)Flechas)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 250.0);
                    if (r.transactionSuccess()) {
                        for (int i = 0; i < 64; ++i) {
                            final ItemStack Diamond2 = new ItemStack(Material.ARROW);
                            p.getInventory().addItem(new ItemStack[] { Diamond2 });
                        }
                        p.sendMessage(ChatColor.GREEN + "Voce comprou um pack de flechas!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)po\u00e7\u00e3o)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 20000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack po\u00e7\u00e3oa4 = new ItemStack(Material.POTION);
                        po\u00e7\u00e3oa4.setDurability((short)8265);
                        p.getInventory().addItem(new ItemStack[] { po\u00e7\u00e3oa4 });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou uma po\u00e7\u00e3o de for\u00e7a!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
                else if (itemclicked.equals((Object)po\u00e7\u00e3o2)) {
                    final EconomyResponse r = Main.econ.withdrawPlayer(p.getName(), 30000.0);
                    if (r.transactionSuccess()) {
                        final ItemStack po\u00e7\u00e3oaa = new ItemStack(Material.POTION);
                        po\u00e7\u00e3oaa.setDurability((short)16457);
                        p.getInventory().addItem(new ItemStack[] { po\u00e7\u00e3oaa });
                        p.getInventory().addItem(new ItemStack[] { po\u00e7\u00e3oaa });
                        p.sendMessage(ChatColor.GREEN + "Voce comprou po\u00e7\u00e3o de for\u00e7a II!");
                        p.closeInventory();
                        return;
                    }
                    p.sendMessage(ChatColor.RED + "Voce nao tem dinheiro suficiente.");
                }
            }
        }
    }
}
