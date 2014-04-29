package me.zodaxium.customtab.listeners;

import me.zodaxium.customtab.CustomTab;
import me.zodaxium.customtab.TabTask;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listenerjoin implements Listener{

	CustomTab plugin;
	
	public Listenerjoin(CustomTab plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		plugin.getServer().getScheduler().runTaskLater(plugin, new TabTask(plugin), 5);
	}
}
