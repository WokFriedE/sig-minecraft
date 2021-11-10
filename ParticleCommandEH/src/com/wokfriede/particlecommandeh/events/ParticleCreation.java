package com.wokfriede.particlecommandeh.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleCreation implements Listener { //listener, looks for certain events
    private static Plugin plugin;

    public ParticleCreation(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public static void onSneak(PlayerToggleSneakEvent event){
     final Player player = event.getPlayer();
     new ParticleTask(player).runTaskTimer(plugin, 0,1);
    }
}
