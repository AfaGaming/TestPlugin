//package com.afa.testPlugin;
//
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//public class teleportAcceptCommand implements CommandExecutor {
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
//        teleportAskCommand teleportAskCommand = new teleportAskCommand();
//        if (sender instanceof Player) {
//            Player player = (Player) sender;
//            if (args.length == 1) {
//                if (Bukkit.getPlayer(args[0]) != null) {
//                    if (teleportAskCommand.tpaReqs.values(Bukkit.getPlayer(args[0]).getUniqueId())) {
//                        Player tpaRequester = Bukkit.getPlayer(args[0]);
//                    }
//                } else {
//                    plaChatColor.RED + "Invalid Player."
//                }
//            } else {
//                player.sendMessage(ChatColor.RED + "Invalid usage: /tpaaccept <player>");
//            }
//        }
//        return false;
//    }
//}
