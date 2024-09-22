package com.afa.testPlugin.commands;

import com.afa.testPlugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class SchedulerCommand implements CommandExecutor {
    private Main main;

    public SchedulerCommand(Main main) {
        this.main = main;
    }

    BukkitTask task;
    BukkitTask taskTwo;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length < 1) {
                taskTwo = Bukkit.getScheduler().runTaskLater(main, () -> {
                    for (Player loopplayer : Bukkit.getOnlinePlayers()) {
                        loopplayer.sendMessage(ChatColor.GREEN + "It has been 10 seconds since the scheduler command was run!");
                    }
                }, 200);

                int i = 0;
                task = Bukkit.getScheduler().runTaskTimer(main, () -> {
                    for (Player loopplayer : Bukkit.getOnlinePlayers()) {
                        loopplayer.sendMessage(ChatColor.GOLD + "It's been 15 seconds since the scheduler command was run and this task goes every second.");
                    }
                }, 300, 20);
            } else if (args.length == 1 && args[0].toLowerCase() == "cancel") {
                task.cancel();
                taskTwo.cancel();
                player.sendMessage(ChatColor.RED + "Task cancelled!");
            }
        }


        return false;
    }
}
