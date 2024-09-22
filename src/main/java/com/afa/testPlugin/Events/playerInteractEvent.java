package com.afa.testPlugin.Events;

import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Rail;
import org.bukkit.block.data.type.Cake;
import org.bukkit.block.data.type.GlassPane;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class playerInteractEvent implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            BlockState state = e.getClickedBlock().getState();
            BlockData data = state.getBlockData();
            if (data instanceof Cake) {
                ((Cake) data).setBites(2);
            } else if (data instanceof GlassPane) {
                ((GlassPane) data).setWaterlogged(true);
            } else if (data instanceof Rail) {
                ((Rail) data).setShape(Rail.Shape.NORTH_WEST);
            }
            state.setBlockData(data);
            state.update();
        }
    }
}
