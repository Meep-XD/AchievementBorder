package me.Meep_XD.AchievmentBorder.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.Meep_XD.AchievmentBorder.Main;

public class ResetBorder implements CommandExecutor {
	
	FileConfiguration config = Main.plugin.getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("resetborder")) {
			World world = Bukkit.getWorld("world");
			WorldBorder border = world.getWorldBorder();
			
			Player player = (Player) sender;
			
			if (player.hasPermission("setborder.use"))
			{
				border.setSize(config.getDouble("start_border_size"));
				border.setCenter(0.5, 0.5);
			}
		}
		return false;
	}
	
}
