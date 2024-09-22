package com.afa.testPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fruitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        // THIS COMMAND DOES NOTHING. ONLY PRACTICING TAB COMPLETE!
        return false;
    }
}
