package top.shuzhiserver.plugin.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopGUI {
    public static final Inventory inv;
    static{
        inv = Bukkit.createInventory(null,9,"商店");
    }
}
