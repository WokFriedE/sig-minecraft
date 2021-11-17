package com.wokfriede.particlecommandeh.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleCommands implements CommandExecutor {
    private static Plugin plugin;

    public ParticleCommands(JavaPlugin plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) { //alows for the use of command executor
        //first thing --> check if the person running is a player
        if(!(sender instanceof Player))
            return true; // can work without {} for one line

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("toggleParticleEH")){//checking meta data
            if (player.hasMetadata("toggleParticleEH")) {
                player.removeMetadata("toggleParticleEH", plugin);
            }
            else{
                player.setMetadata("toggleParticleEH", new FixedMetadataValue(plugin, 0));
            }
        }

        return false;
    }
}
