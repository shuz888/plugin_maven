package top.shuzhiserver.plugin;

import cc.carm.lib.configuration.core.source.ConfigurationProvider;
import cc.carm.lib.mineconfiguration.bukkit.MineConfiguration;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import top.shuzhiserver.plugin.config.Config;

import java.util.Objects;
import java.util.Random;

public final class Main extends JavaPlugin implements Listener {
    private static Main instance;
    private static ConfigurationProvider<?> configProvider;
    @Override
    public void onLoad(){
        instance=this;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        loadConfiguration();
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("dhmt").setExecutor(new command());
        getCommand("gui").setExecutor(new guicmd());
        /*
        FileConfiguration config = this.getConfig();
        config.addDefault("playerjoin", "default");
        config.addDefault("bedenter", "default");
        config.addDefault("placetnt", "default");
        config.options().copyDefaults(true);
        saveConfig();
        getServer().getConsoleSender().sendMessage("[自制插件] Enabled!");
        */
        getServer().getConsoleSender().sendMessage("[自制插件] Enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }
    @EventHandler
    public void onVillagerDamageByPlayer(EntityDamageByEntityEvent event){
        return;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration config = this.getConfig();
        if (Objects.equals(Config.PLAYERJOIN.getOrDefault(), "pass")){
            return ;
        }
        Player player = event.getPlayer();
        World world = Bukkit.getWorld("world");
        Location l = player.getLocation();
        Random r = new Random();
        String nick = player.getPlayerProfile().getName();
        String UID = player.getUniqueId().toString();
        if(Config.VIP_LIST.contains(UID)){
            player.sendMessage("欢迎" + ChatColor.GOLD + "VIP:" + ChatColor.RESET + nick + "进服！");
            player.sendMessage("VIP进服赠送铁碇*1");
            player.getInventory().addItem(new ItemStack(Material.IRON_INGOT,1));
        }else {
            player.sendMessage("欢迎你进服!");
        }
    }
    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event) {
        FileConfiguration config = this.getConfig();
        Player p = event.getPlayer();
        World w = event.getPlayer().getWorld();
        w.setClearWeatherDuration(1000000000);
        if (Objects.equals(Config.BEDENTER.getOrDefault(), "default")) {
            p.chat("今夜将在睡梦中度过...");
        } else if (Objects.equals(Config.BEDENTER.getOrDefault(), "pass")) {
            return;
        } else {
            p.chat(Objects.requireNonNull(Config.BEDENTER.getOrDefault()));
        }
        w.setTime(1000);
    }
    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        event.setCancelled(true);
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        FileConfiguration config = this.getConfig();
        Block b = event.getBlockPlaced();
        if (b.getType()== Material.TNT){
            b.setType(Material.AIR);
            if (Objects.equals(Config.PLACETNT.getOrDefault(), "default")) {
                event.getPlayer().banPlayerIP("恶意放置" + ChatColor.RED + "TNT" + ChatColor.RESET + ",请找腐竹解ban!");
            } else if (Objects.equals(Config.PLACETNT.getOrDefault(), "pass")) {
                ;
            } else {
                event.getPlayer().banPlayerIP(Main.parseColor(Objects.requireNonNull(Config.PLACETNT.get())));
            }
        }
    }
    public static void loadConfiguration(){
        configProvider = MineConfiguration.from(instance,"config.yml");
        configProvider.initialize(Config.class);
    }
    public static void saveConfiguration(){
        try {
            configProvider.save();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Main getInstance(){
        return instance;
    }
    public static String parseColor(String s){
        return s.replace("&","§").replace("§§","&");
    }
}
