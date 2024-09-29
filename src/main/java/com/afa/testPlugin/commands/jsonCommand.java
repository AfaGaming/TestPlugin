package com.afa.testPlugin.commands;

import com.afa.testPlugin.JSONfiles.Data;
import com.afa.testPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.IOException;

public class jsonCommand implements CommandExecutor {
    Main main;

    public jsonCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            Object object = main.getJsonManager().readJson(new File(new File(main.getDataFolder(), "data"), "afa.json"), Data.class);
            Bukkit.getLogger().info(object.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
