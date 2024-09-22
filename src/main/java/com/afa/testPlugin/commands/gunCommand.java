package com.afa.testPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class gunCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            ItemStack item = new ItemStack(Material.DIAMOND_HOE, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.RED + "Gun");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GREEN + "Right-click to shoot!");
            meta.setLore(lore);
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
            player.getInventory().setItemInMainHand(item);
            player.sendMessage(ChatColor.GREEN + "You have been given a gun. Have fun!");
        }
        return false;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getHand().equals(EquipmentSlot.HAND)) {
            if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                Player player = e.getPlayer();
                ItemStack item = new ItemStack(Material.DIAMOND_HOE, 1);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "Gun");
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(ChatColor.GREEN + "Right-click to shoot!");
                meta.setLore(lore);
                meta.setUnbreakable(true);
                item.setItemMeta(meta);
                if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().equals(item)) {
                    player.launchProjectile(Arrow.class, player.getLocation().getDirection());
                    player.sendMessage(ChatColor.GREEN + "You shot an arrow.");
                }
            }
        }
    }
}
