package com.wokfriede.particlecommandeh;

import com.wokfriede.particlecommandeh.commands.ParticleCommands;
import com.wokfriede.particlecommandeh.events.ParticleCreation;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
/*
1. extend public class to java plugin
2. create on and off voids
 */
public class ParticleCommandEH extends JavaPlugin {
    @Override
    public void onEnable() { //when server turns on
        getServer().getPluginManager().registerEvents(new ParticleCreation(this), this); //registers plugin
        getCommand("toggleParticleEH").setExecutor(new ParticleCommands(this));//registers the command
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ParticleCommandEH]: Plugin is enabled"); //prints the command readout
    }

    @Override
    public void onDisable() { //when server turns off
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[ParticleCommandEH]: Plugin is disabled");
    }

}
