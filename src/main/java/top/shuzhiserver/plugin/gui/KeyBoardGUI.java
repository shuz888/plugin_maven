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

import top.shuzhiserver.plugin.FuncPoint;
import top.shuzhiserver.plugin.Main;

import java.util.ArrayList;
import java.util.List;

public class KeyBoardGUI {
    public static final Inventory inv;
    public static String input;
    static{
        input = "";
        inv = Bukkit.createInventory(null,18,"键盘");
        ItemStack itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add("按键\"1\"");
        itemMeta.setDisplayName("1");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(0,itemStack);
        itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("按键\"2\"");
        itemMeta.setDisplayName("2");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(1,itemStack);
        itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("按键\"3\"");
        itemMeta.setDisplayName("3");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(2,itemStack);
        itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("按键\"4\"");
        itemMeta.setDisplayName("4");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(3,itemStack);
        itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("按键\"5\"");
        itemMeta.setDisplayName("5");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(4,itemStack);
        itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("按键\"6\"");
        itemMeta.setDisplayName("6");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(5,itemStack);
        itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("按键\"7\"");
        itemMeta.setDisplayName("7");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(6,itemStack);
        itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("按键\"8\"");
        itemMeta.setDisplayName("8");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(7,itemStack);
        itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("按键\"9\"");
        itemMeta.setDisplayName("9");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(8,itemStack);
        itemStack = new ItemStack(Material.CHERRY_BUTTON,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("按键\"0\"");
        itemMeta.setDisplayName("0");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(9,itemStack);
        itemStack = new ItemStack(Material.GLASS_PANE,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("你当前已经输入的数字");
        itemMeta.setDisplayName(" ");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(17,itemStack);
        itemStack = new ItemStack(Material.GREEN_STAINED_GLASS,1);
        itemMeta = itemStack.getItemMeta();
        lore.clear();
        lore.add("确认");
        itemMeta.setDisplayName("确认");
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(16,itemStack);
    }
    private static void refresh(){
        ItemStack itemStack = new ItemStack(Material.GLASS_PANE,1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("你当前已经输入的数字");
        itemMeta.setDisplayName(input);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(17,itemStack);
    }
    public static void open(Player player, FuncPoint func){
        input = "";
        player.openInventory(inv);
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onClick(InventoryClickEvent e){
                e.setCancelled(true);
                if(player.equals(e.getWhoClicked())&&inv.equals(e.getClickedInventory())){
                    e.setCancelled(true);
                    if(inv.equals(e.getClickedInventory())){
                        switch (e.getSlot()) {
                            case 0 -> {
                                input+="1";
                                refresh();
                                return;
                            }
                            case 1 -> {
                                input+="2";
                                refresh();
                                return;
                            }
                            case 2 -> {
                                input+="3";
                                refresh();
                                return;
                            }
                            case 3 -> {
                                input+="4";
                                refresh();
                                return;
                            }
                            case 4 -> {
                                input+="5";
                                refresh();
                                return;
                            }
                            case 5 -> {
                                input+="6";
                                refresh();
                                return;
                            }
                            case 6 -> {
                                input+="7";
                                refresh();
                                return;
                            }
                            case 7 -> {
                                input+="8";
                                refresh();
                                return;
                            }
                            case 8 -> {
                                input+="9";
                                refresh();
                                return;
                            }
                            case 9 -> {
                                input+="0";
                                refresh();
                                return;
                            }
                            case 16 -> {
                                refresh();
                                func.run(input);
                                return;
                            }
                        }
                    }
                }
            }
            @EventHandler
            public void onDrag(InventoryDragEvent e){
                if(player.equals(e.getWhoClicked())&&inv.equals(e.getInventory())){
                    e.setCancelled(true);
                }
            }
            @EventHandler
            public void onClose(InventoryCloseEvent e){
                if (player.equals(e.getPlayer()) && inv.equals(e.getInventory())){
                    HandlerList.unregisterAll(this);
                }
            }
        },Main.getInstance());
    }
}
