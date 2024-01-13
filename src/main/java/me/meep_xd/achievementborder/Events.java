package me.meep_xd.achievementborder;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {
    public Events(AchievementBorder plugin) {
        this.plugin = plugin;
        config = this.plugin.getConfig();
    }
    public AchievementBorder plugin;

    FileConfiguration config;

    World world = Bukkit.getWorld("world");
    WorldBorder border = world.getWorldBorder();

    @EventHandler
    public void setStartBorder(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            Block block = world.getHighestBlockAt(0, 0).getRelative(BlockFace.DOWN);

            Location loc = new Location(world, block.getLocation().getX() + 0.5, block.getLocation().getY(), block.getLocation().getZ() + 0.5);

            player.teleport(loc);
        }
    }

    @EventHandler
    public void borderEvent(PlayerAdvancementDoneEvent event) {
        if (!event.getAdvancement().getKey().getKey().contains("recipes")) {
            border.setSize(border.getSize() + config.getDouble("increment_border_size")*2);
        }
    }
}
