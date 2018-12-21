package me.lxct.mention;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MentionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mention")) {
            if (args[0].equalsIgnoreCase("reload") || sender.hasPermission("mention.reload")) {
                Bukkit.getPluginManager().disablePlugin(Mention.plugin);
                Bukkit.getPluginManager().enablePlugin(Mention.plugin);
            }
        }
        return true;
    }
}
