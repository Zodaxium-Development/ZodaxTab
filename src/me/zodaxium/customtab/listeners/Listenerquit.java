package me.zodaxium.customtab.listeners;

import me.zodaxium.customtab.CustomTab;
import me.zodaxium.customtab.TabTask;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listenerquit implements Listener{

	CustomTab plugin;
	
	public Listenerquit(CustomTab plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		plugin.getServer().getScheduler().runTaskLater(plugin, new TabTask(plugin), 5);
	}
}
