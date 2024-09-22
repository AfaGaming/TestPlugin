package com.afa.testPlugin.TabComplete;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class setHealthTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> results = new ArrayList<>();
        if (args.length == 2) {
            // return list of players
            for (Player loopplayer : Bukkit.getOnlinePlayers()) {
                results.add(loopplayer.getName());
            }
            return StringUtil.copyPartialMatches(args[1], results, new ArrayList<>());
        }
        return new ArrayList<>();
    }
}
