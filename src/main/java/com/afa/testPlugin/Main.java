package com.afa.testPlugin;

import com.afa.testPlugin.Events.*;
import com.afa.testPlugin.JSONfiles.Data;
import com.afa.testPlugin.Managers.JsonManager;
import com.afa.testPlugin.Managers.YamlManager;
import com.afa.testPlugin.TabComplete.SchedulerTab;
import com.afa.testPlugin.TabComplete.fruitTab;
import com.afa.testPlugin.TabComplete.setHealthTab;
import com.afa.testPlugin.commands.*;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Date;

public final class Main extends JavaPlugin implements Listener, CommandExecutor {

    private JsonManager jsonManager;
    public JsonManager getJsonManager() { return jsonManager; }

    private YamlManager yamlManager;
    public YamlManager getYamlManager() { return yamlManager; }

    public BossBar bossBar;
    @Override
    public void onEnable() {
        // CREATING CUSTOM YML & JSON FILES
        try {
            if (!getDataFolder().exists()) { getDataFolder().mkdir(); }
            getYamlManager().createYamlFile("data.yml");
            getJsonManager().writeJson("data.json", new Data("Afa", true, new Date()));
            getJsonManager().writeJson("data.json", new Data("Stephen", false, new Date()));
        } catch (Exception ex) {
            Bukkit.getLogger().severe("There was an error with generating a custom YML file:");
            ex.printStackTrace();
        }

        bossBar = Bukkit.createBossBar(
                ChatColor.LIGHT_PURPLE + "This server is awesome!",
                BarColor.PINK,
                BarStyle.SOLID
        );

        // CONFIG
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // REGISTER COMMANDS
        this.getCommand("gun").setExecutor(new gunCommand());
        this.getCommand("back").setExecutor(new backCommand());
        this.getCommand("book").setExecutor(new bookCommand());
        this.getCommand("banner").setExecutor(new bannerCommand());
        this.getCommand("punish").setExecutor(new punishCommand());
        this.getCommand("whitelist").setExecutor(new whitelistCommand());
        this.getCommand("vanish").setExecutor(new vanishCommand(this));
        this.getCommand("clear").setExecutor(new clearCommand());
        this.getCommand("scheduler").setExecutor(new SchedulerCommand(this));
        this.getCommand("scheduler").setTabCompleter(new SchedulerTab());
        this.getCommand("menu").setExecutor(new MenuCommand());
        this.getCommand("fruit").setExecutor(new fruitCommand());
        this.getCommand("fruit").setTabCompleter(new fruitTab());
        this.getCommand("boost").setExecutor(new boostCommand());
        this.getCommand("sethealth").setExecutor(new setHealthCommand());
        this.getCommand("sethealth").setTabCompleter(new setHealthTab());
        this.getCommand("skull").setExecutor(new skullCommand());
        this.getCommand("testupdates").setExecutor(new TestUpdatesCommand());
//        getCommand("teleportask").setExecutor(new teleportAskCommand());
//        getCommand("teleportaccept").setExecutor(new teleportAcceptCommand());
//        getCommand("test").setExecutor(new testCommand());

        // REGISTER EVENTS
        Bukkit.getPluginManager().registerEvents(new backCommand(), this);
        Bukkit.getPluginManager().registerEvents(new playerToggleSneakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new gunCommand(), this);
        Bukkit.getPluginManager().registerEvents(new playerJoinEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new entityTargetEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new serverListPingEvent(), this);
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        Bukkit.getPluginManager().registerEvents(new playerInteractEvent(), this);
//        Bukkit.getPluginManager().registerEvents(new creatureSpawnEvent(), this);
    }
}