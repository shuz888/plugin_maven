package top.shuzhiserver.plugin.gui;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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
import java.util.Objects;
import java.util.Random;

public class warpsGUI {
    public static final Inventory warpsinv;
    static{
        warpsinv = Bukkit.createInventory(null,9,"地标");
        ItemStack item = new ItemStack(Material.BARRIER,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Main.parseColor("&c关闭"));
        List<String> lore = new ArrayList<>();
        lore.add(Main.parseColor("关闭"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        warpsinv.setItem(8,item);
        item = new ItemStack(Material.MAP,1);
        meta = item.getItemMeta();
        meta.setDisplayName(Main.parseColor("1"));
        lore.clear();
        lore.add(Main.parseColor(" "));
        meta.setLore(lore);
        item.setItemMeta(meta);
        warpsinv.setItem(0,item);
        item = new ItemStack(Material.MAP,1);
        meta = item.getItemMeta();
        meta.setDisplayName(Main.parseColor("2"));
        lore.clear();
        lore.add(Main.parseColor(" "));
        meta.setLore(lore);
        item.setItemMeta(meta);
        warpsinv.setItem(1,item);
    }
    public static void open(Player player){
        if (!Boolean.TRUE.equals(Config.GUI.WayPoints.ENABLE.getOrDefault())){
            player.sendMessage(Main.parseColor("&c管理员未启用WayPoints界面,如果你是管理员请将配置文件gui--way-points--enable选项改为true"));
            return ;
        }
        ArrayList<String> lore = new ArrayList<>();
        if (Objects.equals(Config.GUI.WayPoints.WayPoint1.ENABLE.getOrDefault(), true)){
            lore.clear();
            lore.add("x坐标:"+ Config.GUI.WayPoints.WayPoint1.X.getOrDefault());
            lore.add("y坐标:"+ Config.GUI.WayPoints.WayPoint1.Y.getOrDefault());
            lore.add("z坐标:"+ Config.GUI.WayPoints.WayPoint1.Z.getOrDefault());
            ItemStack itemStack = warpsinv.getItem(0);
            itemStack.setLore(lore);
            warpsinv.setItem(0,itemStack);
        }else{
            lore.clear();
            lore.add("管理员没有启用此路径点");
            ItemStack itemStack = warpsinv.getItem(0);
            itemStack.setType(Material.BARRIER);
            itemStack.setLore(lore);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("已禁用");
            warpsinv.setItem(0,itemStack);
        }
        if (Objects.equals(Config.GUI.WayPoints.WayPoint2.ENABLE.getOrDefault(), true)){
            lore.clear();
            lore.add("x坐标:"+ Config.GUI.WayPoints.WayPoint2.X.getOrDefault());
            lore.add("y坐标:"+ Config.GUI.WayPoints.WayPoint2.Y.getOrDefault());
            lore.add("z坐标:"+ Config.GUI.WayPoints.WayPoint2.Z.getOrDefault());
            ItemStack itemStack = warpsinv.getItem(1);
            itemStack.setLore(lore);
            warpsinv.setItem(1,itemStack);
        }else{
            lore.clear();
            lore.add("管理员没有启用此路径点");
            ItemStack itemStack = warpsinv.getItem(1);
            itemStack.setType(Material.BARRIER);
            itemStack.setLore(lore);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("已禁用");
            warpsinv.setItem(1,itemStack);
        }
        if (Objects.equals(Config.GUI.WayPoints.WayPoint3.ENABLE.getOrDefault(), true)){
            lore.clear();
            lore.add("x坐标:"+ Config.GUI.WayPoints.WayPoint3.X.getOrDefault());
            lore.add("y坐标:"+ Config.GUI.WayPoints.WayPoint3.Y.getOrDefault());
            lore.add("z坐标:"+ Config.GUI.WayPoints.WayPoint3.Z.getOrDefault());
            ItemStack itemStack = warpsinv.getItem(2);
            itemStack.setLore(lore);
            warpsinv.setItem(2,itemStack);
        }else{
            lore.clear();
            lore.add("管理员没有启用此路径点");
            ItemStack itemStack = warpsinv.getItem(2);
            itemStack.setType(Material.BARRIER);
            itemStack.setLore(lore);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("已禁用");
            warpsinv.setItem(2,itemStack);
        }
        player.openInventory(warpsinv);
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onClick(InventoryClickEvent e){
                if (player.equals(e.getWhoClicked()) && warpsinv.equals(e.getClickedInventory())){
                    e.setCancelled(true);
                    if(warpsinv.equals(e.getClickedInventory())){
                        switch (e.getSlot()) {
                            case 8 -> {
                                player.closeInventory();
                                return;
                            }
                            case 0 -> {
                                if(Boolean.TRUE.equals(Config.GUI.WayPoints.WayPoint1.ENABLE.getOrDefault())){
                                    player.teleport(new Location(player.getWorld(),(double)Config.GUI.WayPoints.WayPoint1.X.getOrDefault(),(double)Config.GUI.WayPoints.WayPoint1.Y.getOrDefault(),(double)Config.GUI.WayPoints.WayPoint1.Z.getOrDefault()));
                                }
                            }
                            case 1 -> {
                                if(Boolean.TRUE.equals(Config.GUI.WayPoints.WayPoint2.ENABLE.getOrDefault())){
                                    player.teleport(new Location(player.getWorld(),(double)Config.GUI.WayPoints.WayPoint2.X.getOrDefault(),(double)Config.GUI.WayPoints.WayPoint2.Y.getOrDefault(),(double)Config.GUI.WayPoints.WayPoint2.Z.getOrDefault()));
                                }
                            }
                            case 2 -> {
                                if(Boolean.TRUE.equals(Config.GUI.WayPoints.WayPoint3.ENABLE.getOrDefault())){
                                    player.teleport(new Location(player.getWorld(),(double)Config.GUI.WayPoints.WayPoint3.X.getOrDefault(),(double)Config.GUI.WayPoints.WayPoint3.Y.getOrDefault(),(double)Config.GUI.WayPoints.WayPoint3.Z.getOrDefault()));
                                }
                            }
                        }
                    }
                }
            }
            @EventHandler
            public void onDrag(InventoryDragEvent e){
                if (player.equals(e.getWhoClicked()) && warpsinv.equals(e.getInventory())){
                    e.setCancelled(true);
                }
            }
            @EventHandler
            public void onClose(InventoryCloseEvent e){
                if (player.equals(e.getPlayer()) && warpsinv.equals(e.getInventory())){
                    HandlerList.unregisterAll(this);
                }
            }
        }, Main.getInstance());
    }
}
