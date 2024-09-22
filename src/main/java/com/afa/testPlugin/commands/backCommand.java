package com.afa.testPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class backCommand implements CommandExecutor, Listener {
    Location loc;
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        loc = e.getEntity().getLocation();
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        loc = e.getFrom();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (loc != null) {
                player.teleport(loc);
                player.sendMessage(ChatColor.GREEN + "You have been teleported to your previous location.");
            } else {
                player.sendMessage(ChatColor.RED + "Location not set!");
            }
        }
        return false;
    }
}
