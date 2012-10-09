package edu.unca.nrodrigu.Quest6;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/*
 * This is a sample event listener
 */
public class Quest6Listener implements Listener {
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
     * Send the sample message to all players that join
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(this.plugin.getConfig().getString("sample.message"));
    }
    
    /*
     * if player is walking on liquid, change to stone
     */
    public void onPlayerMove(PlayerMoveEvent event) {
    	Location loc = event.getPlayer().getLocation();
    	World w = loc.getWorld();
    	loc.setY(loc.getY() - 1);
    	Block b = w.getBlockAt(loc);
    	if (b.isLiquid())
    		b.setTypeId(1);
    }
    
    /*
     * blocks turn to gold when clicked
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        Player fred = event.getPlayer();
		Location loc = fred.getLocation();
		World w = loc.getWorld();
		loc.setX(loc.getX() + 1);
		Block b = w.getBlockAt(loc);
		b.setTypeId(92);
    }
}