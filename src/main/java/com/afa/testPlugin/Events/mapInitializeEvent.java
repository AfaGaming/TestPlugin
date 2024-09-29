package com.afa.testPlugin.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class mapInitializeEvent implements Listener {
    @EventHandler
    public void onMapInitialize(org.bukkit.event.server.MapInitializeEvent e) {
        MapView view = e.getMap();
        for (MapRenderer renderer : view.getRenderers()) {
            view.removeRenderer(renderer);
        }
        
    }
}
