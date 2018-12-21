package me.lxct.mention;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static me.lxct.mention.Functions.colorize;

class Variable {

    static String actionBarMsg;
    static String chatMsg;
    static String symbol;
    static String reloadMsg;
    static boolean checkUpdates;
    static String updateMsg;
    static String failUpdate;
    static String color;
    static Sound sound;
    static boolean useActionBar;
    static boolean useChat;
    static boolean playSound;
    static int soundPitch;
    static int soundVolume;
    // Tmp

    static Player vPlayer;
    static Player vTarget;

    static void loadVariables(){

        FileConfiguration configYml = Mention.plugin.getConfig();

        reloadMsg = configYml.getString("reload", "&aMention successfully reloaded!");
        checkUpdates = configYml.getBoolean("checkUpdates", true);
        updateMsg = configYml.getString("update", "&a[Mention]&7 A new update is available at&a");
        failUpdate = configYml.getString("updateFail", "&a[Mention]&c Update checker failed!");
        color = configYml.getString("color", "&6");
        actionBarMsg = configYml.getString("actionBarMessage", "&a&l%PLAYER% mentioned you!");
        chatMsg = configYml.getString("chatMessage", "&a&l%PLAYER% mentioned you!");
        symbol = configYml.getString("symbol", "@");
        sound = Sound.valueOf(configYml.getString("soundName", "ENTITY_PLAYER_LEVELUP"));
        useActionBar = configYml.getBoolean("sendActionBar", true);
        useChat = configYml.getBoolean("sendChatMessage", false);
        playSound = configYml.getBoolean("sendSound", true);
        soundPitch = configYml.getInt("soundPitch", 0);
        soundVolume = configYml.getInt("soundVolume", 1);

        if (!configYml.isString("color")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"color\" value is wrong!"));
        }
        if (!configYml.isString("reload")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"reload\" value is wrong!"));
        }
        if (!configYml.isString("update")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"update\" value is wrong!"));
        }
        if (!configYml.isString("updateFail")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"updateFail\" value is wrong!"));
        }
        if (!configYml.isString("actionBarMessage")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"actionBarMessage\" value is wrong!"));
        }
        if (!configYml.isString("chatMessage")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"chatMessage\" value is wrong!"));
        }
        if (!configYml.isString("symbol")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"symbol\" value is wrong!"));
        }
        if (!configYml.isBoolean("sendActionBar")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"sendActionBar\" value is wrong!"));
        }
        if (!configYml.isBoolean("sendChatMessage")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"sendChatMessage\" value is wrong!"));
        }
        if (!configYml.isBoolean("checkUpdates")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"checkUpdates\" value is wrong!"));
        }
        if (!configYml.isBoolean("sendSound")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"sendSound\" value is wrong!"));
        }
        if (!configYml.isInt("soundPitch")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"soundPitch\" value is wrong!"));
        }
        if (!configYml.isInt("soundVolume")) {
            Bukkit.getConsoleSender().sendMessage(colorize("[Mention] &4&lWARNING! \"soundVolume\" value is wrong!"));
        }
    }
}
