package com.afa.testPlugin.commands;

import com.afa.testPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class vanishCommand implements CommandExecutor {
    private Main main;
    public vanishCommand(Main main) {
        this.main = main;
    }

    public List<UUID> vanished = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (vanished.contains(player.getUniqueId())) { // they are vanished
                vanished.remove(player.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.showPlayer(main, player);
                }
                player.sendMessage(ChatColor.RED + "You are no longer vanished.");
            } else {
                vanished.add(player.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.hidePlayer(main, player);
                }
                player.sendMessage(ChatColor.GREEN + "You are now vanished.");
            }
        }
        return false;
    }
}
