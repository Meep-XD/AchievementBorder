package me.meep_xd.achievementborder;

import me.meep_xd.achievementborder.commands.ResetBorder;
import org.bukkit.plugin.java.JavaPlugin;

public final class AchievementBorder extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Events(this), this);

        getCommand("resetborder").setExecutor(new ResetBorder(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
