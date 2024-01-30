package top.shuzhiserver.plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(player.getInventory().contains(Material.BAMBOO)){
                ItemStack item = player.getInventory().getItem(0);
                try {
                    if (item.getAmount() == 10) {
                        player.getInventory().setItem(0,new ItemStack(Material.COAL,1));
                        return true;
                    } else if (item.getAmount() > 10) {
                        player.getInventory().setItem(0,new ItemStack(Material.COAL,item.getAmount()/10));
                        return true;
                    } else{
                        player.sendMessage("你的第1个物品栏里没有恰好50个竹子!");
                    }
                    return false;
                }
                catch (NullPointerException e){
                    sender.sendMessage("你的第1个物品栏里没有竹子!");
                    return false;
                }
            }
        }
        return false;
    }
}
