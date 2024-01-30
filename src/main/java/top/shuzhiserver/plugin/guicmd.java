package top.shuzhiserver.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.shuzhiserver.plugin.config.Config;
import top.shuzhiserver.plugin.gui.MainGUI;

public class guicmd implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String label,  String[] args) {
        if(sender instanceof Player){
            if(Boolean.TRUE.equals(Config.GUI.ENABLE.getOrDefault())) {
                MainGUI.open((Player) sender);
            }else{
                sender.sendMessage(Main.parseColor("&c管理员暂未启用GUI,如果你为管理员请将配置文件中gui--enable选项改为true"));
            }
        }
        return true;
    }
}
