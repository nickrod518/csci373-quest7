package edu.unca.nrodrigu.Quest6;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/*
 * This is a sample event listener
 */
public class Quest6Listener implements Listener {
	@SuppressWarnings("unused")
    private final Quest6 plugin;

    /*
     * This listener needs to know about the plugin which it came from
     */
    public Quest6Listener(Quest6 plugin) {
        // Register the listener
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        
        this.plugin = plugin;
    }
    
    /*
     * if player is walking on liquid, change to stone
     */
    public void jesus(PlayerMoveEvent event) {
    	Location loc = event.getPlayer().getLocation();
    	World w = loc.getWorld();
    	loc.setY(loc.getY() - 1);
    	Block b = w.getBlockAt(loc);
    	if (b.isLiquid())
    		b.setTypeId(1);
    }
}