package com.WokFriedE.BestPlugin;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[BasePlugin]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[BasePlugin]: Plugin is disabled!");
    }
}
