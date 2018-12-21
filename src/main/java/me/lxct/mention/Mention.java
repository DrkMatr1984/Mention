package me.lxct.mention;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static me.lxct.mention.Variable.loadVariables;

public class Mention extends JavaPlugin implements Listener {
    static Mention plugin;
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        loadVariables();
        getCommand("mention").setExecutor(new MentionCommand());
        getServer().getPluginManager().registerEvents(new OnPlayerChat(), this);
    }
}
