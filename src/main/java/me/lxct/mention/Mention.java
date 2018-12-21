package me.lxct.mention;

import org.bstats.bukkit.Metrics;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static me.lxct.mention.Variable.checkUpdates;
import static me.lxct.mention.Variable.loadVariables;

public class Mention extends JavaPlugin implements Listener {

    static Mention plugin;

    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        loadVariables();
        //noinspection unused
        Metrics metrics = new Metrics(this); // METRICS
        if (checkUpdates) {
            new AsyncUpdateChecker(this).checkForUpdate(); // Add AsyncUpdateChecker (Thx Benz56)
        }
        getCommand("mention").setExecutor(new MentionCommand());
        getServer().getPluginManager().registerEvents(new OnPlayerChat(), this);
    }
}
