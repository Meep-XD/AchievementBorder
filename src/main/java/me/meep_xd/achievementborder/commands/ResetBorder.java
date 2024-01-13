package me.meep_xd.achievementborder.commands;

import me.meep_xd.achievementborder.AchievementBorder;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ResetBorder implements CommandExecutor {
    public ResetBorder(AchievementBorder plugin) {
        this.plugin = plugin;
        config = this.plugin.getConfig();
    }
    public AchievementBorder plugin;

    FileConfiguration config;

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
                sender.sendMessage(ChatColor.BLUE + "[AchievementBorder]" + ChatColor.GREEN + " World border reset!");

                Block block = world.getHighestBlockAt(0, 0).getRelative(BlockFace.DOWN);
                Location loc = new Location(world, block.getLocation().getX() + 0.5, block.getLocation().getY() + 2, block.getLocation().getZ() + 0.5);

                for(Player p : plugin.getServer().getOnlinePlayers()) {
                    p.teleport(loc);
                }
            }
        }
        return false;
    }
}
