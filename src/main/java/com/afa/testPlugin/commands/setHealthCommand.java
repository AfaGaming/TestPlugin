package com.afa.testPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setHealthCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        //   /sethealth <number of hearts> [<player>]
        if (sender instanceof Player) {
            int numberOfHearts = 0;
            Player player = (Player) sender;
            if (args.length == 1) {
                try {
                    numberOfHearts = Integer.parseInt(args[0]);
                } catch (NumberFormatException exx) {
                    player.sendMessage(ChatColor.RED + "Invalid usage: /setheath <number of hearts> [<player>]");
                }
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(numberOfHearts*2);
            } else if (args.length == 2) {
                try {
                    numberOfHearts = Integer.parseInt(args[0]);
                } catch (NumberFormatException exx) {
                    player.sendMessage(ChatColor.RED + "Invalid usage: /setheath <number of hearts> [<player>]");
                }
                if (Bukkit.getPlayer(args[1]) !=null ) {
                    Bukkit.getPlayer(args[1]).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(numberOfHearts*2);
                } else {
                    player.sendMessage(ChatColor.RED + "That isn't a valid player.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage: /sethealth <number of hearts> [<player>]");
            }
        } else {
            Bukkit.getLogger().info("Only players can use this command.");
        }
        return false;
    }
}
