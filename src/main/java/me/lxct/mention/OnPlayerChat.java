package me.lxct.mention;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static me.lxct.mention.Functions.colorize;
import static me.lxct.mention.Functions.formatMsg;
import static me.lxct.mention.Variable.*;

public class OnPlayerChat implements Listener {
    @EventHandler
    public static void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().toUpperCase();
        vPlayer = event.getPlayer();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (message.contains(player.getName().toUpperCase()) && !player.hasPermission("mention.ignore")) {
                vTarget = player;
                if (useChat) {
                    player.sendMessage(formatMsg(chatMsg));
                }
                if (useActionBar) {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(formatMsg(actionBarMsg)));
                }
                if (playSound) {
                    player.playSound(player.getLocation(), sound, soundVolume, soundPitch);
                }
                if (message.contains(player.getName().toUpperCase())) {
                    event.setMessage(event.getMessage().replaceAll("(?i)" + player.getName(), colorize(color + symbol + player.getName() + "&r")));
                } else if (message.contains(symbol + player.getName().toUpperCase())) {
                    event.setMessage(event.getMessage().replaceAll(symbol + "(?i)" + player.getName(), colorize(color + symbol + player.getName() + "&r")));
                }
            }
        }
        if (message.contains(symbol + "EVERYONE") && event.getPlayer().hasPermission("mention.everyone")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (useChat) {
                    player.sendMessage(formatMsg(chatMsg));
                }
                if (useActionBar) {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(formatMsg(actionBarMsg)));
                }
                if (playSound) {
                    player.playSound(player.getLocation(), sound, soundVolume, soundPitch);
                }
            }
            event.setMessage(event.getMessage().replaceAll(symbol + "(?i)everyone", colorize(color + symbol + "everyone" + "&r")));
        } else if (message.contains(symbol + "HERE") && event.getPlayer().hasPermission("mention.everyone")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (useChat) {
                    player.sendMessage(formatMsg(chatMsg));
                }
                if (useActionBar) {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(formatMsg(actionBarMsg)));
                }
                if (playSound) {
                    player.playSound(player.getLocation(), sound, soundVolume, soundPitch);
                }
            }
            event.setMessage(event.getMessage().replaceAll(symbol + "(?i)here", colorize(color + symbol + "here" + "&r")));
        }
    }
}