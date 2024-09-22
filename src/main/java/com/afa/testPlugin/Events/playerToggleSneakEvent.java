package com.afa.testPlugin.Events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class playerToggleSneakEvent implements Listener {
    //    // DISABLED AS THIS GETS ANNOYING
    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent e) {
        Player player = e.getPlayer();
        // FIREWORK
//        Firework firework = player.getWorld().spawn(player.getLocation(), Firework.class);
//        FireworkMeta meta = (FireworkMeta) firework.getFireworkMeta();
//        meta.addEffect(FireworkEffect.builder().withColor(Color.RED).withColor(Color.LIME).with(Type.CREEPER).withFlicker().build());
//        meta.setPower(1);
//        firework.setFireworkMeta(meta);

        // SOUND
//        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_GUITAR, 1.0F, 1.0F);
        player.playEffect(new Location(Bukkit.getWorld("world"), -11, 140, 41), Effect.RECORD_PLAY, Material.MUSIC_DISC_11);
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy("§aYou are sneaking!"));

        // Per-player blocks & signs
        if (e.isSneaking() && player.getTargetBlockExact(5) != null) {
            if (player.getTargetBlockExact(5).getType().equals(Material.OAK_SIGN)) {
                player.sendSignChange(player.getTargetBlockExact(5).getLocation(), new String[]{
                        player.getName(),
                        "is special!",
                        "Btw, only you",
                        "can see this!"
                });
            } else {
                player.sendBlockChange(player.getTargetBlockExact(5).getLocation(), Material.LAVA.createBlockData());

            }
        }
    }
}
