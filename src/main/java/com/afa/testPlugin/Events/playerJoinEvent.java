package com.afa.testPlugin.Events;

import com.afa.testPlugin.Main;
import com.afa.testPlugin.commands.vanishCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.UUID;

public class playerJoinEvent implements Listener {
    private Main main;
    public playerJoinEvent(Main main) {
        this.main = main;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        // server pack
        if (main.getConfig().getBoolean("resource-pack-enabled")) {
            e.getPlayer().setResourcePack("https://download850.mediafire.com/89jgqyujyd5g5nAt9UpEO7_Avvz1qPjOpHUol0rVQ3Db3dImheR2c8BYcjDp3xlLNL5Ph5_szawOWiRYv_wqYlFS6G0YKwHfrjd68k--vqcv6lWjrVLqHB3N9TvBbENL8Et3ZFQZ6FRKPlYiogELbIEx1yOfEAfRZbcM6PFSfgy0rg/w0r9s50vhsyg01b/minimalarmor.zip");
        }

        // potion effect
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 2, false, false, true));

        // sound
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

        // title
        e.getPlayer().sendTitle(ChatColor.GREEN + "Welcome", ChatColor.YELLOW + e.getPlayer().getName());

        //bossbar
        main.bossBar.addPlayer(e.getPlayer());
        main.bossBar.setProgress(0.75);

        // tab list
        String header = ChatColor.translateAlternateColorCodes('&', "&aWelcome, %player%").replace("%player%", e.getPlayer().getName());
        String footer = ChatColor.translateAlternateColorCodes('&', "&bYou are currently on &e%server%\n&dEnjoy your time!").replace("%server%", "afa's test server (1.21).");
        e.getPlayer().setPlayerListHeaderFooter(header, footer);

        // ensure vanish works
        vanishCommand vanishCommand = new vanishCommand(main);
        List<UUID> vanished = vanishCommand.vanished;
        for (UUID vanishedPlayerUUID : vanished) {
            e.getPlayer().hidePlayer(main, Bukkit.getPlayer(vanishedPlayerUUID));
        }
    }
}
