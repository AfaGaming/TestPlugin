package com.afa.testPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class bookCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) book.getItemMeta();
            meta.setTitle(ChatColor.RED + "My epic book!");
            meta.setAuthor(ChatColor.YELLOW + "Afa");
            meta.addPage(
                    ChatColor.BLUE + "Welcome to my book" +
                            "\n\n" + ChatColor.GREEN + "This book is about nothing."
            );
            book.setItemMeta(meta);
            player.getInventory().addItem(book);
            player.sendMessage(ChatColor.GREEN + "You have been given a book!");
        }
        return false;
    }
}
