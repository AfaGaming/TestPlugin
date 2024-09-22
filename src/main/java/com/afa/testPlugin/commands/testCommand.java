package com.afa.testPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class testCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Entity entity = Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), -21, 115, 4), EntityType.POLAR_BEAR);
            Entity player = Bukkit.getEntity(Bukkit.getPlayer("AfaGaming").getUniqueId());
            entity.addPassenger(player);
        }
        return false;
    }
}
