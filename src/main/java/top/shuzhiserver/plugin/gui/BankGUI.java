package top.shuzhiserver.plugin.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import top.shuzhiserver.plugin.Main;
import top.shuzhiserver.plugin.config.Config;

public class BankGUI {
    public static final Inventory inv = Bukkit.createInventory(null,9,"银行");
    static{
        ItemStack item = new ItemStack(Material.EMERALD,1);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.clear();
        lore.add("初始化");
        meta.setDisplayName("初始化");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(0,item);
        item = new ItemStack(Material.EMERALD,1);
        meta = item.getItemMeta();
        lore.clear();
        lore.add("1绿宝石=100元钱,(不支持)1下界合金碇=1000元钱");
        meta.setDisplayName("存钱");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(1,item);
        item = new ItemStack(Material.EMERALD,1);
        meta = item.getItemMeta();
        lore.clear();
        lore.add("1绿宝石=100元钱,(不支持)1下界合金碇=1000元钱");
        meta.setDisplayName("取钱");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(2,item);
        item = new ItemStack(Material.EMERALD,1);
        meta = item.getItemMeta();
        lore.clear();
        lore.add("内测功能");
        meta.setDisplayName("转账");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(3,item);
        item = new ItemStack(Material.GLASS_PANE,1);
        meta = item.getItemMeta();
        lore.clear();
        lore.add("你银行里的存款数量");
        meta.setDisplayName("");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(8,item);
    }
    private static int getIndex(String nick){
        for(int i=0;i<Config.GUI.BANK.size();i++){
            if(Objects.equals(Config.GUI.BANK.get(i).split(" ")[0], nick)){
                return i;
            }
        }
        return -1;
    }
    public static void open(Player player){
        player.openInventory(inv);
        FileConfiguration config = Main.getInstance().getConfig();
        String nick = player.getName();
        if (getIndex(nick)!=-1){
            ItemStack item = new ItemStack(Material.BARRIER,1);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();
            lore.clear();
            lore.add("初始化");
            meta.setDisplayName("最好不要按下此按键，否则您的账户余额将归零");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(0,item);
            item = new ItemStack(Material.GLASS_PANE,1);
            meta = item.getItemMeta();
            lore.clear();
            lore.add("你银行里的存款数量");
            meta.setDisplayName(Config.GUI.BANK.get(getIndex(nick)).split(" ")[1]);
            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.setItem(8,item);
        }
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onClick(InventoryClickEvent e){
                e.setCancelled(true);
                if(player.equals(e.getWhoClicked())&&inv.equals(e.getClickedInventory())){
                    e.setCancelled(true);
                    if(inv.equals(e.getClickedInventory())){
                        switch (e.getSlot()) {
                            case 0 -> {
                                if(getIndex(nick)!=-1){
                                    String tmp = nick + " 0";
                                    Config.GUI.BANK.set(getIndex(nick),tmp);
                                }
                                else{
                                    String tmp = nick + " 0";
                                    Config.GUI.BANK.add(tmp);
                                }
                                return;
                            }
                            case 1 -> {
                                if (player.getItemInHand().getType() == Material.EMERALD) {
                                    int amt = player.getItemInHand().getAmount();
                                    Main.getInstance().getServer().getConsoleSender().sendMessage(String.valueOf(amt));
                                    amt *= 100;
                                    int money = Integer.parseInt(Config.GUI.BANK.get(getIndex(nick)).split(" ")[1]);
                                    money += amt;
                                    Config.GUI.BANK.set(getIndex(nick), nick+" " + (money));
                                    player.getItemInHand().setAmount(0);
                                } /*else if (player.getItemInHand().getType() == Material.NETHERITE_INGOT) {
                                    int amt = player.getItemInHand().getAmount();
                                    amt *= 1000;
                                    int money = config.getInt(nick);
                                    money += amt;
                                    config.set(nick, money);
                                } */else {
                                    player.sendMessage(Main.parseColor("&c你手里的不是可存的东西"));
                                }
                                return;
                            }
                            case 2 -> {
                                int money = Integer.parseInt(Config.GUI.BANK.get(getIndex(nick)).split(" ")[1]);
                                // int net_ingot = money / 1000;
                                int emerald = money/100;
                                Main.getInstance().getServer().getConsoleSender().sendMessage(String.valueOf(emerald));
                                // ItemStack itemStack = new ItemStack(Material.NETHERITE_INGOT,net_ingot);
                                // player.getInventory().addItem(itemStack);
                                ItemStack itemStack = new ItemStack(Material.EMERALD,emerald);
                                player.getInventory().addItem(itemStack);
                                Config.GUI.BANK.set(getIndex(nick),nick + " 0");
                            }
                            case 3 -> {
                                player.closeInventory();
                                CollectionGUI.open(player);
                            }
                        }
                        Main.saveConfiguration();
                    }
                }
                Main.saveConfiguration();
            }
            @EventHandler
            public void onDrag(InventoryDragEvent e){
                if(player.equals(e.getWhoClicked())&&inv.equals(e.getInventory())){
                    e.setCancelled(true);
                    Main.saveConfiguration();
                }
            }
            @EventHandler
            public void onClose(InventoryCloseEvent e){
                if (player.equals(e.getPlayer()) && inv.equals(e.getInventory())){
                    HandlerList.unregisterAll(this);
                    Main.saveConfiguration();
                }
            }
        },Main.getInstance());
    }
    public static boolean pay(int money,String nick){
        FileConfiguration config = Main.getInstance().getConfig();
        int all_money = Integer.parseInt(Config.GUI.BANK.get(getIndex(nick)).split(" ")[1]);
        if(all_money-money<0){
            return false;
        }else{
            Config.GUI.BANK.set(getIndex(nick), nick+" " + (all_money - money));
            Main.saveConfiguration();
            return true;
        }
    }
    public static boolean collection(int money,String nick){
        FileConfiguration config = Main.getInstance().getConfig();
        int all_money = Integer.parseInt(Config.GUI.BANK.get(getIndex(nick)).split(" ")[1]);
        all_money += money;
        Config.GUI.BANK.set(getIndex(nick), nick+" " + (all_money));
        Main.saveConfiguration();
        return true;
    }
}