package org.vysteria.litebanspatch;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LitebansPatch extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.print("VysteriaLiteBansPatch - Enabled Version 1.0");
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().toLowerCase().startsWith("/litebans sqlexec")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis command has been disabled by your server administrator."));
        }
    }
}
