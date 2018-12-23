package me.lxct.mention;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static me.lxct.mention.Functions.colorize;
import static me.lxct.mention.Functions.formatMsg;
import static me.lxct.mention.Functions.isVanished;
import static me.lxct.mention.Variable.*;

public class OnPlayerChat implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerChat(AsyncPlayerChatEvent event) {
        String msg = event.getMessage().toUpperCase();
        String message = event.getMessage();
        vPlayer = event.getPlayer();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (msg.contains(player.getName().toUpperCase()) && !player.hasPermission("mention.ignore") && !isVanished(player)) {
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
                if (msg.contains(symbol + player.getName().toUpperCase())) {
                    message = message.replaceAll(symbol + "(?i)" + player.getName(), colorize(color + symbol + player.getName() + "&r"));
                } else if (msg.contains(player.getName().toUpperCase())) {
                    message = message.replaceAll("(?i)" + player.getName(), colorize(color + symbol + player.getName() + "&r"));
                }
            }
        }
        if (msg.contains(symbol + "EVERYONE") && event.getPlayer().hasPermission("mention.everyone")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
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
            }
            message = message.replaceAll(symbol + "(?i)everyone", colorize(color + symbol + "everyone" + "&r"));
        }
        if (msg.contains(symbol + "HERE") && event.getPlayer().hasPermission("mention.everyone")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
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
            }
            message = message.replaceAll(symbol + "(?i)here", colorize(color + symbol + "here" + "&r"));
        }
        event.setMessage(message);
    }
}