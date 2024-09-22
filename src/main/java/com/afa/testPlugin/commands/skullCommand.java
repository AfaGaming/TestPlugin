package com.afa.testPlugin.commands;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class skullCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length == 1) {
                switch (args[0].toLowerCase()) {
                    case "player":
                        ItemStack is = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta meta = (SkullMeta) is.getItemMeta();
                        meta.setOwningPlayer(player);
                        is.setItemMeta(meta);
                        player.getInventory().addItem(is);
                        player.sendMessage(ChatColor.GREEN + "Here's your skull!");
                        break;
                    case "custom":
                        if (player.getName().equals("AfaGaming")) {
                            player.sendMessage(ChatColor.RED + "Functionality not implemented yet because I'm lazy. Refer to lecture 54 in the Spigot Plugin Development Course in order to do this.");
                        } else {
                            player.sendMessage(ChatColor.RED + "Functionality not implemented yet because I'm lazy.");
                        }
                        break;
                    default:
                        player.sendMessage(ChatColor.RED + "Invalid usage: /skull <player/custom>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage: /skull <player/custom>");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> results = new ArrayList<>();
        if (args.length == 1) {
            results.add("player");
            results.add("custom");
            return StringUtil.copyPartialMatches(args[0], results, new ArrayList<>());
        }
        return new ArrayList<>();
    }
}
