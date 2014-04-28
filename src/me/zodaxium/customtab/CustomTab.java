package me.zodaxium.customtab;

import me.zodaxium.customtab.listeners.Listenerjoin;
import me.zodaxium.customtab.listeners.Listenerquit;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcsg.double0negative.tabapi.TabAPI;

public class CustomTab extends JavaPlugin{

	public void onEnable(){
		new Listenerjoin(this);
		new Listenerquit(this);
	}
	
	public String colorize(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public void update(){
		for(Player p : getServer().getOnlinePlayers()){
			TabAPI.resetTabList(p);
			
			/* Line 1 */
			TabAPI.setTabString(this, p, 0, 0, colorize("&9Minecraft"));
			TabAPI.setTabString(this, p, 0, 1, colorize("&9Zodaxium"));
			TabAPI.setTabString(this, p, 0, 2, colorize("&9Gaming"));
			
			/* Line 2 */
			TabAPI.setTabString(this, p, 1, 0, colorize("&7<-------------"));
			TabAPI.setTabString(this, p, 1, 1, colorize("&7--------------"));
			TabAPI.setTabString(this, p, 1, 2, colorize("&7------------->"));
			
			/* Other Lines */
			int y = 2;
			int x = 0;
			for(Player player : getServer().getOnlinePlayers()){
				if(x > 2){
					x = 0;
					y++;
					if(y == 20){
						break;
					}
				}
				TabAPI.setTabString(this, p, y, x, player.getDisplayName());
				x++;
			}
			/* Update Player */
			TabAPI.updatePlayer(p);
		}
	}
}
