package com.afa.testPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // CREATING GUI
            Inventory inv = Bukkit.createInventory(null, 45, ChatColor.RED.toString() + ChatColor.BOLD + "Tools Menu!");

            // Random TP - Create Item
            ItemStack teleport = new ItemStack(Material.ENDER_PEARL);
            ItemMeta teleportMeta = teleport.getItemMeta();
            teleportMeta.setDisplayName(ChatColor.BLUE + "Random Teleport");
            teleportMeta.setLore(Arrays.asList(ChatColor.GRAY + "Teleports to a random player!"));
            teleport.setItemMeta(teleportMeta);
            inv.setItem(20, teleport); // puts the item in the GUI.

            // Kill Yourself - Create Item
            ItemStack killYourself = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta killYourselfMeta = killYourself.getItemMeta();
            killYourselfMeta.setDisplayName(ChatColor.RED + "Kill Yourself");
            killYourselfMeta.setLore(Arrays.asList(ChatColor.GRAY + "Kills you."));
            killYourself.setItemMeta(killYourselfMeta);
            inv.setItem(22, killYourself); // puts the item in the GUI.

            // Clear Inventory - Create Item
            ItemStack clear = new ItemStack(Material.BUCKET);
            ItemMeta clearMeta = clear.getItemMeta();
            clearMeta.setDisplayName(ChatColor.GOLD + "Clear Inventory");
            clearMeta.setLore(Arrays.asList(ChatColor.GRAY + "Clears your inventory."));
            clear.setItemMeta(clearMeta);
            inv.setItem(24, clear); // puts the item in the GUI.

            ItemStack close = new ItemStack(Material.BARRIER);
            ItemMeta closeMeta = close.getItemMeta();
            closeMeta.setDisplayName(ChatColor.RED + "Close");
            close.setItemMeta(closeMeta);
            inv.setItem(0, close);


            // FRAME
            ItemStack frame = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            for (int i : new int[]{1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44}) {
                inv.setItem(i, frame);
            }


            player.openInventory(inv); // opens the GUI for the player.
        }
        return false;
    }
}
