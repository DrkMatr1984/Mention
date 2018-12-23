package me.lxct.mention;

import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;

import static me.lxct.mention.Variable.vPlayer;
import static me.lxct.mention.Variable.vTarget;

class Functions {

    static String colorize(String string) {
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', string);
    }

    static String formatMsg(String string) { // Replace placeholders in messages.yml
        if (string.contains("%PLAYER%")) {
            string = string.replace("%PLAYER%", vPlayer.getName());
        }
        if (string.contains("%TARGET%")) {
            string = string.replace("%TARGET%", vTarget.getName());
        }
        return colorize(string);
    }

    static boolean isVanished(Player player) {
        for (MetadataValue meta : player.getMetadata("vanished")) {
            if (meta.asBoolean()) return true;
        }
        return false;
    }

}
