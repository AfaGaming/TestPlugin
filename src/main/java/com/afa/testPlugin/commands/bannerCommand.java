package com.afa.testPlugin.commands;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.List;

public class bannerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            ItemStack item = new ItemStack(Material.GREEN_BANNER);
            BannerMeta meta = (BannerMeta) item.getItemMeta();
            List<Pattern> patterns = new ArrayList<>();
            patterns.add(new Pattern(DyeColor.RED, PatternType.HALF_VERTICAL));
            patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE));
            patterns.add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
            meta.setPatterns(patterns);
            item.setItemMeta(meta);
            ((Player) commandSender).getInventory().addItem(item);
        }
        return false;
    }
}
