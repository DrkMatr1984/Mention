package me.lxct.mention;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static me.lxct.mention.Variable.failUpdate;
import static me.lxct.mention.Variable.updateMsg;

class AsyncUpdateChecker {

    private final JavaPlugin javaPlugin;
    private final String localPluginVersion;
    private String spigotPluginVersion;

    //Constants. Customize to your liking.
    private static final int ID = 63390; //The ID of your resource. Can be found in the resource URL.
    private static final String ERR_MSG = failUpdate;
    private static final String UPDATE_MSG = updateMsg + " https://www.spigotmc.org/resources/" + ID + "/updates";
    //PermissionDefault.FALSE == OPs need the permission to be notified.
    //PermissionDefault.TRUE == all OPs are notified regardless of having the permission.
    private static final Permission UPDATE_PERM = new Permission("mention.update", PermissionDefault.TRUE);

    AsyncUpdateChecker(final JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
        this.localPluginVersion = javaPlugin.getDescription().getVersion();
    }

    void checkForUpdate() {
        //The request is executed asynchronously as to not block the main thread.
        Bukkit.getScheduler().runTaskAsynchronously(this.javaPlugin, () -> {
            //Request the current version of your plugin on SpigotMC.
            try {
                HttpsURLConnection connection = (HttpsURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=" + ID).openConnection();
                connection.setRequestMethod("GET");
                this.spigotPluginVersion = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
            } catch (IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ERR_MSG));
                return;
            }

            //Check if the requested version is the same as the one in your plugin.yml.
            if (this.localPluginVersion.equals(this.spigotPluginVersion)) return;

            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', UPDATE_MSG));

            //Register the PlayerJoinEvent
            Bukkit.getScheduler().runTask(this.javaPlugin, () -> Bukkit.getPluginManager().registerEvents(new Listener() {
                @EventHandler(priority = EventPriority.MONITOR)
                public void onPlayerJoin(PlayerJoinEvent event) {
                    Player player = event.getPlayer();
                    if (!player.hasPermission(UPDATE_PERM)) return;
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', UPDATE_MSG));
                }
            }, this.javaPlugin));
        });
    }
}