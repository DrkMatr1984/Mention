package me.lxct.mention;

import static me.lxct.mention.Variable.*;

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
}
