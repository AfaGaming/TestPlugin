package com.afa.testPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class TestUpdatesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta bookMeta = (BookMeta) book.getItemMeta();
            bookMeta.setTitle("Updates");
            bookMeta.setAuthor("Afa");
            bookMeta.addPage("Stuff for testing:\n\nSECTION 4\n1. setting resource packs\n2. Player Statistics\n3. Setting MOTD, Server Icon & Player Count\n\nCHALLENGE: Understand how the private message system works.");
            bookMeta.addPage("SECTION 5:\n1. Runnables\n2. GUIs (interaction + creation)\n3. Command tab complete\n4. Attribute Modifiers\n5. Block Data\n6. Per-player  signs and blocks\n7. Skulls\n8. Custom YML files\n9. Custom JSON files");
            bookMeta.addPage("HOW TO TEST:\n\nSection 4:\n1. Just join and wait for resource pack\n2. Yet to make it\n3. Server list ping event?");
            bookMeta.addPage("Section 5:\n1. idk check code\n2.use /menu\n3. use /fruit\n4. use /boost and /sethealth\n5.Right click on a glass pane, cake and rail\n6. shift while looking at a block. Do the same with an oak sign.\n7.use /skull (custom skulls don't work)");
            bookMeta.addPage("8. Look in plugin folder\n 9. Look in plugin folder.");

            book.setItemMeta(bookMeta);

            if (player.getName().equals("AfaGaming")) {
                player.getInventory().addItem(book);
            } else {
                player.sendMessage(ChatColor.RED + "Only AfaGaming can use this command!");
            }
        }
        return false;
    }
}
