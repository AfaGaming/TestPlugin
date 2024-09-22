package com.afa.testPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class whitelistCommand implements CommandExecutor {
    List<Player> list = new ArrayList<Player>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 2) {
                switch (args[0].toLowerCase()) {
                    case "add":
                        if (!(Bukkit.getPlayer(args[2]) == null)) {
                            if (!list.contains(Bukkit.getPlayer(args[2]))) {
                                list.add(Bukkit.getPlayer(args[2]));
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aAdded &e%player% &ato the whitelist.".replace("%player%", player.getName())));
                            } else {
                                player.sendMessage(ChatColor.RED + "That player is already whitelisted.");
                            }
                        } else {
                            player.sendMessage("That is not a valid player.");
                        }
                        break;
                    case "remove":
                        break;
                    case "list":
                        break;
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage: /whitelist <add/remove/list> <player>");
            }
        }
        return false;
    }
}
