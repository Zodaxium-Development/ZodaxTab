package me.zodaxium.customtab;

import me.zodaxium.customtab.listeners.Listenerjoin;
import me.zodaxium.customtab.listeners.Listenerquit;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomTab extends JavaPlugin{

	public void onEnable(){
		new Listenerjoin(this);
		new Listenerquit(this);
	}
	
	public String colorize(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
