/*package me.lxct.mention;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static me.lxct.mention.Variable.symbol;

public class OnTabComplete implements Listener {
    @EventHandler
    public static void onTabComplete(TabCompleteEvent event) {
        String lastWord = event.getBuffer().substring(event.getBuffer().lastIndexOf(" ") + 1);
        if (lastWord.contains(symbol)) {
            ArrayList<String> playerNameList = new ArrayList<>(Arrays.asList(symbol + "everyone", symbol + "here"));
            for (Player player : Bukkit.getOnlinePlayers()) {
                playerNameList.add(symbol + player.getName());
            }
            ArrayList<String> completions = new ArrayList<>(playerNameList.size());
            StringUtil.copyPartialMatches(lastWord, playerNameList, completions);
            Collections.sort(completions); // Sort completions
            event.setCompletions(completions);
        }
    }
}
Fuck minecraft client changes... We cannot use tab complete anymore for chat messages...
*/