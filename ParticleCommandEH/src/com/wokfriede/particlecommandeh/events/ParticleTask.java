package com.wokfriede.particlecommandeh.events;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Particle.DustTransition;


public class ParticleTask extends BukkitRunnable {
    int initialColor = 150;
    private Player player; //spawn particles only on player and world
    private Location location;
    private double tick = 0;
    private int counters = 0;
    private int max = 50;
    private int min = 1;

    public ParticleTask(Player player) {
        this.player = player;//used to access player
        this.location = player.getLocation();
    }

    @Override
    public void run(){
        tick = tick + 0.1*Math.PI;
        counters = counters + 1;

        DustTransition dustTransitionR = new DustTransition(Color.fromRGB(initialColor,initialColor,initialColor), Color.fromRGB(255,0,0),5.0F);
        DustTransition dustTransitionG = new DustTransition(Color.fromRGB(initialColor,initialColor,initialColor), Color.fromRGB(0,255,0),5.0F);
        DustTransition dustTransitionB = new DustTransition(Color.fromRGB(initialColor,initialColor,initialColor), Color.fromRGB(0,0,255),5.0F);

        for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
            double x = tick*Math.cos(theta);
            double y = Math.exp(-0.1*tick) * Math.sin(tick) + 1.5;
            double z = tick*Math.sin(theta);
            location.add(x,y,z);

            switch (counters % 3){
                case 0:
                    player.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, 1,dustTransitionR);
                    break;
                case 1:
                    player.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, 1,dustTransitionG);
                    break;
                case 2:
                    player.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, 1,dustTransitionB);
                    break;
                default: break;
            }
            location.subtract(x,y,z);
        }

        if (tick > 20){
            this.cancel();
        }
        else{
            counters = (int) (counters + Math.floor(Math.random()*(max-min+1)+min));
        }
    }
}
