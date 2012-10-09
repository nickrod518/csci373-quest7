package edu.unca.nrodrigu.Quest6;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
 * This is a sample CommandExectuor
 */
public class Quest6CommandExecutor implements CommandExecutor {
	@SuppressWarnings("unused")
	private final Quest6 plugin;

	/*
	 * This command executor needs to know about its plugin from which it came
	 * from
	 */
	public Quest6CommandExecutor(Quest6 plugin) {
		this.plugin = plugin;
	}

	/*
	 * On command set the sample message
	 */
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("You didn't enter any arguments.");
			return false;
		} else if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
			return false;
			// the cake will appear on the ground but not
			// necessarily where the player is looking
		} else if (args[0].equalsIgnoreCase("cake")) {
			Player fred = (Player) sender;
			Location loc = fred.getLocation();
			World w = loc.getWorld();
			loc.setX(loc.getX() + 1);
			Block b = w.getBlockAt(loc);
			b.setTypeId(92);
			return true;
			// changes the next 10 blocks below player to air
		} else if (args[0].equalsIgnoreCase("pit")) {
			Player fred = (Player) sender;
			Location loc = fred.getLocation();
			World w = loc.getWorld();
			for (int i = 0; i < 10; i++) {
				loc.setY(loc.getY() - 1);
				Block b = w.getBlockAt(loc);
				b.setTypeId(0);
			}
			return true;
		} else {
			return false;
		}
	}

}