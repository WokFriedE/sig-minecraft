package com.wokfriede.particlecommandeh.events;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleTask extends BukkitRunnable {
    private Player player; //spawn particles only on player and world
    private Location location;
    private double tick = 0;

    public ParticleTask(Player player) {
        this.player = player;//used to access player
        this.location = player.getLocation();
    }
//Math.exp(-0.1*tick) * Math.sin(tick) + 1.5;
    @Override
    public void run(){
        tick = tick + 0.1*Math.PI;

        for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
            double x = tick*Math.cos(theta);
            double y = 1;
            double z = tick*Math.sin(theta);
            location.add(x,y,z);
            player.spawnParticle(Particle.FIREWORKS_SPARK, location, 1);
            location.subtract(x,y,z);
        }

        if (tick < 20){
            this.cancel();
        }
    }
}
