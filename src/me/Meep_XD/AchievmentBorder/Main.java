package me.Meep_XD.AchievmentBorder;

import org.bukkit.plugin.java.JavaPlugin;

import me.Meep_XD.AchievmentBorder.commands.ResetBorder;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		plugin = this;
		this.saveDefaultConfig();
		this.getServer().getPluginManager().registerEvents(new MyEvents(), this);
		
		this.getCommand("resetborder").setExecutor(new ResetBorder());
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Main plugin;

}
