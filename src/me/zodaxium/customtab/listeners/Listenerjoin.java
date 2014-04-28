package me.zodaxium.customtab.listeners;

import me.zodaxium.customtab.CustomTab;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Listenerjoin implements Listener{

	CustomTab plugin;
	
	public Listenerjoin(CustomTab plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		plugin.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable(){
			@Override
			public void run(){ plugin.update(); }
		}, 5);
	}
}
