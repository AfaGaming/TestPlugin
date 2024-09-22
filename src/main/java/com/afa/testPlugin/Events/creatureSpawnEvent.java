package com.afa.testPlugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class creatureSpawnEvent implements Listener {
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        Entity entity = e.getEntity();
        if (entity.getType() == EntityType.CREEPER) {
            e.setCancelled(true);
            Bukkit.getLogger().info(e.getSpawnReason().toString());
        }
    }
}
