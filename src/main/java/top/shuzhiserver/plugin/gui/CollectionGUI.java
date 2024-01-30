package top.shuzhiserver.plugin.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import top.shuzhiserver.plugin.Main;

import java.util.ArrayList;
import java.util.List;

public class CollectionGUI {
    public static final Inventory inv;
    public static String to="";
    public static String from="";
    static{inv = Bukkit.createInventory(null,27,"转账");}
    public static void open(Player player){
        from = player.getName();
        player.sendMessage("请输入对方名称(聊天框):");
        Bukkit.getPluginManager().registerEvents(new Listener(){
            @EventHandler
            public void onChat(PlayerChatEvent event){
                if(event.getPlayer().equals(player)){
                    to = event.getMessage();
                    player.sendMessage("请在弹出的窗口中输入您要转账的金额");
                    KeyBoardGUI.open(player,CollectionGUI::collect);
                    HandlerList.unregisterAll(this);
                }
            }
        },Main.getInstance());
    }
    public static void collect(String num){
        Player playerfrom = Bukkit.getPlayerExact(from);
        assert playerfrom != null;
        if(BankGUI.collection(Integer.parseInt(num),to)&&BankGUI.pay(Integer.parseInt(num),from)) {
            playerfrom.sendMessage("已经向" + to + "转账" + num);
            if (Bukkit.getPlayerExact(to) != null) {
                Player playerto = Bukkit.getPlayerExact(to);
                playerto.sendMessage(to + "给你转账" + num);
            } else {
                return;
            }
        }else{
            playerfrom.sendMessage("转账失败");
        }
    }
}
