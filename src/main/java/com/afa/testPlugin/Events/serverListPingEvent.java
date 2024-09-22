package com.afa.testPlugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

public class serverListPingEvent implements Listener {
    @EventHandler
    public void onServerListPing(ServerListPingEvent e) {
        e.setMaxPlayers(42000);
        e.setMotd(ChatColor.translateAlternateColorCodes('&', "&bAf'a test server (1.21)\n&f&lJoin now"));
        try {
            e.setServerIcon(Bukkit.loadServerIcon(new File("icon.png")));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
