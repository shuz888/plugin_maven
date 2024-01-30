package top.shuzhiserver.plugin.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGUI {
    public static final Inventory inv;
    public static final Inventory trashinv;
    public static final Inventory warpsinv;
    static{
        inv = Bukkit.createInventory(null,18,"菜单");
        trashinv = Bukkit.createInventory(null,9,"垃圾箱");
        warpsinv = Bukkit.createInventory(null,9,"地标");
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.parseColor("&c关闭"));
        item.setItemMeta(meta);
        inv.setItem(8,item);
        item = new ItemStack(Material.DIAMOND_SWORD,1);
        meta = item.getItemMeta();
        meta.setDisplayName(Main.parseColor("&7自杀"));
        item.setItemMeta(meta);
        inv.setItem(0,item);
        item = new ItemStack(Material.CACTUS,1);
        meta = item.getItemMeta();
        meta.setDisplayName("垃圾桶");
        List<String> lore = new ArrayList<String>();
        lore.add(Main.parseColor("&c请谨慎操作！"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(1,item);
        item = new ItemStack(Material.CHEST,1);
        meta = item.getItemMeta();
        meta.setDisplayName("抽奖");
        lore.clear();
        lore.add(Main.parseColor("确保你手上有3个绿宝石！"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(2,item);
        item = new ItemStack(Material.MAP,1);
        meta = item.getItemMeta();
        meta.setDisplayName("地标");
        lore.clear();
        lore.add(Main.parseColor("嘿！你要去哪里？"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(3,item);
        item = new ItemStack(Material.EMERALD,1);
        meta = item.getItemMeta();
        meta.setDisplayName("购买");
        lore.clear();
        lore.add(Main.parseColor(Main.parseColor("使用3绿宝石购买额外一点&c生命值")));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(4,item);
        item = new ItemStack(Material.NETHERITE_INGOT,1);
        meta = item.getItemMeta();
        meta.setDisplayName("购买");
        lore.clear();
        lore.add(Main.parseColor(Main.parseColor("使用5下界合金锭购买&c鞘翅")));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(5,item);
        item = new ItemStack(Material.EMERALD,1);
        meta = item.getItemMeta();
        meta.setDisplayName("购买");
        lore.clear();
        lore.add(Main.parseColor(Main.parseColor("使用1绿宝石购买&c鞘翅的材料")));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(6,item);
        item = new ItemStack(Material.BARRIER,1);
        meta = item.getItemMeta();
        meta.setDisplayName("重新加载");
        lore.clear();
        lore.add(Main.parseColor("重新加载"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(7,item);
        item = new ItemStack(Material.EMERALD,1);
        meta = item.getItemMeta();
        meta.setDisplayName("银行");
        lore.clear();
        lore.add(Main.parseColor("银行"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(9,item);
        item = new ItemStack(Material.GRASS_BLOCK,1);
        inv.setItem(10,item);

    }
    public static void open(Player player){
        player.openInventory(inv);
        Bukkit.getPluginManager().registerEvents(new Listener(){
            @EventHandler
            public void onClick(InventoryClickEvent e){
                e.setCancelled(true);
                if (player.equals(e.getWhoClicked()) && inv.equals(e.getClickedInventory())){
                    e.setCancelled(true);
                    if(inv.equals(e.getClickedInventory())){
                        switch (e.getSlot()) {
                            case 8 -> {
                                player.closeInventory();
                                return;
                            }
                            case 7 -> {
                                player.closeInventory();
                                Bukkit.reload();
                                return;
                            }
                            case 0 -> {
                                player.setHealth(0);
                                return;
                            }
                            case 1 -> {
                                player.openInventory(trashinv);
                                return;
                            }
                            case 2 -> {
                                int amt = player.getItemInHand().getAmount();
                                ItemStack itemS = new ItemStack(Material.EMERALD);
                                if (itemS.equals(player.getItemInHand()) || amt-3<0){
                                    player.sendMessage("你手上没有足够的绿宝石！(3个)");
                                }
                                amt-=3;
                                player.getItemInHand().setAmount(amt);
                                Random r = new Random();
                                int jiang = r.nextInt(100);
                                if (jiang <= 30) {
                                    ItemStack itemStack = new ItemStack(Material.EMERALD, 3);
                                    player.getInventory().addItem(itemStack);
                                } else if (jiang <= 60) {
                                    ItemStack itemStack = new ItemStack(Material.IRON_INGOT, 3);
                                    player.getInventory().addItem(itemStack);
                                } else if (jiang <= 70) {
                                    player.giveExpLevels(100);
                                } else if (jiang <= 80) {
                                    ItemStack itemStack = new ItemStack(Material.GOLD_INGOT, 3);
                                    player.getInventory().addItem(itemStack);
                                } else if (jiang <= 90) {
                                        ItemStack itemStack = new ItemStack(Material.GOLDEN_APPLE, 1);
                                        player.getInventory().addItem(itemStack);
                                } else if (jiang <= 95) {
                                    ItemStack itemStack = new ItemStack(Material.ANCIENT_DEBRIS, 1);
                                    player.getInventory().addItem(itemStack);
                                } else {
                                    ItemStack itemStack = new ItemStack(Material.DIAMOND, 1);
                                    player.getInventory().addItem(itemStack);
                                }
                                if (Config.VIP_LIST.contains(player.getUniqueId().toString())){
                                    player.sendMessage("VIP抽奖特权:每次抽奖赠送1绿宝石!");
                                    ItemStack itemStack = new ItemStack(Material.EMERALD, 3);
                                    player.getInventory().addItem(itemStack);
                                }
                                return;
                            }
                            case 3 -> warpsGUI.open(player);
                            case 4 -> {
                                if (player.getItemInHand().getType() == Material.EMERALD){
                                    if (player.getItemInHand().getAmount()-3>=0){
                                        int amt = player.getItemInHand().getAmount();
                                        amt-=3;
                                        player.getItemInHand().setAmount(amt);
                                        double tmp = player.getMaxHealth();
                                        tmp+=2;
                                        player.setMaxHealth(tmp);
                                    }
                                    else {
                                        player.sendMessage(Main.parseColor("&c你手里没有足够的绿宝石"));
                                        boolean bankpay = BankGUI.pay(300, player.getName());
                                        if(bankpay){
                                            player.sendMessage("已从您的银行支付");
                                            double tmp = player.getMaxHealth();
                                            tmp+=2;
                                            player.setMaxHealth(tmp);
                                        }else{
                                            player.sendMessage("无法从银行账户支付");
                                        }
                                    }
                                } else {
                                    player.sendMessage(Main.parseColor("&c你手里不是的绿宝石"));
                                    boolean bankpay = BankGUI.pay(300, player.getName());
                                    if(bankpay){
                                        player.sendMessage("已从您的银行支付");
                                        double tmp = player.getMaxHealth();
                                        tmp+=2;
                                        player.setMaxHealth(tmp);
                                    }else{
                                        player.sendMessage("无法从银行账户支付");
                                    }
                                }
                            }
                            case 5 -> {
                                if (player.getItemInHand().getType() == Material.NETHERITE_INGOT){
                                    if (player.getItemInHand().getAmount()-5>=0){
                                        player.sendMessage("此项物品的购买只能从银行支付");
                                    }
                                    else {
                                        // player.sendMessage(Main.parseColor("&c你手里没有足够的绿宝石"));
                                        boolean bankpay;
                                        if (Config.VIP_LIST.contains(player.getUniqueId().toString())){
                                            bankpay = BankGUI.pay(4600,player.getName());
                                        }
                                        else {bankpay = BankGUI.pay(5000, player.getName());}
                                        if(bankpay){
                                            player.sendMessage("已从您的银行支付");
                                            ItemStack itemStack = new ItemStack(Material.ELYTRA,1);
                                            player.getInventory().addItem(itemStack);
                                        }else{
                                            player.sendMessage("无法从银行账户支付");
                                        }
                                    }
                                } else {
                                    player.sendMessage(Main.parseColor("&c你手里不是的绿宝石"));
                                    boolean bankpay;
                                    if (Config.VIP_LIST.contains(player.getUniqueId().toString())){
                                        bankpay = BankGUI.pay(4600,player.getName());
                                    }
                                    else {bankpay = BankGUI.pay(5000, player.getName());}
                                    if(bankpay){
                                        player.sendMessage("已从您的银行支付");
                                        ItemStack itemStack = new ItemStack(Material.ELYTRA,1);
                                        player.getInventory().addItem(itemStack);
                                    }else{
                                        player.sendMessage("无法从银行账户支付");
                                    }
                                }
                            }
                            case 6 -> {
                                if (player.getItemInHand().getType() == Material.EMERALD){
                                    if (player.getItemInHand().getAmount()-1>=0){
                                        int amt = player.getItemInHand().getAmount();
                                        amt-=1;
                                        player.getItemInHand().setAmount(amt);
                                        ItemStack itemStack = new ItemStack(Material.FIREWORK_ROCKET,10);
                                        player.getInventory().addItem(itemStack);
                                    }
                                    else {
                                        player.sendMessage(Main.parseColor("&c你手里没有足够的绿宝石"));
                                        boolean bankpay = BankGUI.pay(100, player.getName());
                                        if(bankpay){
                                            player.sendMessage("已从您的银行支付");
                                            ItemStack itemStack = new ItemStack(Material.FIREWORK_ROCKET,10);
                                            player.getInventory().addItem(itemStack);
                                        }else{
                                            player.sendMessage("无法从银行账户支付");
                                        }
                                    }
                                } else {
                                    player.sendMessage(Main.parseColor("&c你手里不是的绿宝石"));
                                    boolean bankpay = BankGUI.pay(100, player.getName());
                                    if(bankpay){
                                        player.sendMessage("已从您的银行支付");
                                        ItemStack itemStack = new ItemStack(Material.FIREWORK_ROCKET,10);
                                        player.getInventory().addItem(itemStack);
                                    }else{
                                        player.sendMessage("无法从银行账户支付");
                                    }
                                }
                            }
                            case 9 -> {
                                BankGUI.open(player);
                            }
                            case 10 ->{
                                ItemStack itemStack = new ItemStack(Material.GRASS_BLOCK,1);
                                player.getInventory().addItem(itemStack);
                            }
                        }
                    }
                }
            }
            @EventHandler
            public void onDrag(InventoryDragEvent e){
                if (player.equals(e.getWhoClicked()) && inv.equals(e.getInventory())){
                    e.setCancelled(true);
                }
            }
            @EventHandler
            public void onClose(InventoryCloseEvent e){
                trashinv.clear();
                if (player.equals(e.getPlayer()) && inv.equals(e.getInventory())){
                    HandlerList.unregisterAll(this);
                }
            }
        },Main.getInstance());
    }
}
