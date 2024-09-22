package com.afa.testPlugin.TabComplete;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class fruitTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        List<String> results = new ArrayList<>();
        if (args.length == 1) {
            results.add("Pear");
            results.add("Apple");
            results.add("Grape");
            return StringUtil.copyPartialMatches(args[0], results, new ArrayList<>());
        } else if (args.length == 2) {
            for (Player loopplayer : Bukkit.getOnlinePlayers()) {
                results.add(loopplayer.getName());
            }
            return StringUtil.copyPartialMatches(args[1], results, new ArrayList<>());
        }
        return new ArrayList<>();
    }
}
