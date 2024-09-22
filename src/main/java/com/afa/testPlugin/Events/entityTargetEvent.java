package com.afa.testPlugin.Events;

import com.afa.testPlugin.Main;
import com.afa.testPlugin.commands.vanishCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class entityTargetEvent implements Listener {
    private Main main;
    public entityTargetEvent(Main main) {
        this.main = main;
    }
    @EventHandler
    public void onMobTarget(EntityTargetEvent e) {
        if (e.getTarget() instanceof Player) {
            Player target = (Player) e.getTarget();
            vanishCommand vanishCommand = new vanishCommand(main);
            if (vanishCommand.vanished.contains(target.getUniqueId())) {
                e.setCancelled(true);
            }
        }
    }
}
