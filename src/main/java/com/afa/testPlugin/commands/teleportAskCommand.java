//package com.afa.testPlugin;
//
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.UUID;
//
//public class teleportAskCommand implements CommandExecutor {
//    protected HashMap<UUID, List<UUID>> tpaReqs;
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
//        String usageError = ChatColor.RED + "Invalid usage: /tpa <player>";
//        if (sender instanceof Player) {
//            Player player = (Player) sender;
//            if (args.length == 1) {
//                if (Bukkit.getPlayer(args[0]) != null) {
//                    Player target = Bukkit.getPlayer(args[0]);
//                    List tpaReqsList = new ArrayList<UUID>();
//                    tpaReqsList.add(player.getUniqueId());
//                    tpaReqs.put(target.getUniqueId(), tpaReqsList);
//                    target.sendMessage(ChatColor.YELLOW + "" + player.getName() + " has requested to teleport to you. Do /tpaaccept <player> to accept.");
//                } else {
//                    player.sendMessage(ChatColor.RED + "Invalid player!");
//                }
//            } else {
//                player.sendMessage(usageError);
//            }
//        }
//        return false;
//    }
//}
