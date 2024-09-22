package com.afa.testPlugin.Events;

import com.afa.testPlugin.commands.MenuCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;
import java.util.Random;

public class MenuListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        MenuCommand menuCommand = new MenuCommand();
        if (e.getView().getTitle().equals(ChatColor.RED.toString() + ChatColor.BOLD + "Tools Menu!")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
                Player player = (Player) e.getWhoClicked();
                switch (e.getRawSlot()) {
                    case 0:
                        break;
                    case 20:
                        // random tp
                        Random random = new Random();
                        Player target = (Player) Bukkit.getOnlinePlayers().toArray()[random.nextInt(Bukkit.getOnlinePlayers().size())];
                        player.teleport(target);
                        player.playSound(player, Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
                        player.sendMessage(ChatColor.GREEN + "You teleported to %player%.".replace("%player%", target.getName()));
                        break;
                    case 22:
                        // kill yourself
                        player.setHealth(0);
                        player.sendMessage(ChatColor.RED + "You killed yourself.");
                        break;
                    case 24:
                        // clear inventory
                        player.closeInventory();
                        player.getInventory().clear();
                        player.sendMessage(ChatColor.RED + "You cleared your inventory.");
                        return;
                    default:
                        return;
                }
                player.closeInventory();
            }
        }
    }
}
