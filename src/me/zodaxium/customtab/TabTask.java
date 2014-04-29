package me.zodaxium.customtab;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.mcsg.double0negative.tabapi.TabAPI;

public class TabTask extends BukkitRunnable{
	
	CustomTab plugin;
	
	public TabTask(CustomTab plugin){
		this.plugin = plugin;
	}
	
	@Override
	public void run(){
		for(Player p : plugin.getServer().getOnlinePlayers()){
			TabAPI.resetTabList(p);
			
			/* Line 1 */
			TabAPI.setTabString(plugin, p, 0, 0, plugin.colorize("&9Minecraft"));
			TabAPI.setTabString(plugin, p, 0, 1, plugin.colorize("&9Zodaxium"));
			TabAPI.setTabString(plugin, p, 0, 2, plugin.colorize("&9Gaming"));
			
			/* Line 2 */
			TabAPI.setTabString(plugin, p, 1, 0, plugin.colorize("&7<-------------"));
			TabAPI.setTabString(plugin, p, 1, 1, plugin.colorize("&7--------------"));
			TabAPI.setTabString(plugin, p, 1, 2, plugin.colorize("&7------------->"));
			
			/* Other Lines */
			int y = 2;
			int x = 0;
			for(Player player : plugin.getServer().getOnlinePlayers()){
				if(x > 2){
					x = 0;
					y++;
					if(y == 20){
						break;
					}
				}
				TabAPI.setTabString(plugin, p, y, x, player.getDisplayName());
				x++;
			}
			/* Update Player */
			TabAPI.updatePlayer(p);
		}
	}
}
