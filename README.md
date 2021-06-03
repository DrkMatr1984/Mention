# Mention
A mention plugin for Spigot. Simple, fast & easy.

## How it works ?
Just put the name of a player in the chat and it will turn into `@player` !

## Commands / Permissions
```
Commands: 
/mention reload => Reload the plugin

Permissions:
mention.ignore => Ignore @mention
mention.everyone => Use @everyone
mention.reload => Use /mention reload
mention.update => Check for updates
```

## Config
```
# Mention by Lxct
# Placeholders :
# %PLAYER% => The one who has mentioned
# %TARGET% => The one who was mentioned
# Minecraft color code is obviously supported.

version: 1.0

symbol: "@" # @Name
color: "&6"
sendActionBar: true # Send a message in the action bar to the mentioned player
sendChatMessage: false # Send a message in the chat to the mentioned player
sendSound: true # Send a sound to the mentioned player
soundName: "ENTITY_PLAYER_LEVELUP" # List available at https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Sound.html
soundVolume: 1 # Volume (1 seems like a good value..)
soundPitch: 0 # Change Pitch of the sound (0 = default)
checkUpdates: true # Check for updates
metrics: true # Send anonymous stats (Please set this to true) <3

reload: "&aMention successfully reloaded!"
actionBarMessage: "&a&l%PLAYER% mentioned you!"
chatMessage: "&a&l%PLAYER% mentioned you!"
update: "&a[Mention]&7 A new update is available at&a"
updateFail: "&a[Mention]&c Update checker failed!"
```

## Compilation
Bash/Zsh linux terminal :

```
git clone https://github.com/Lxct/Mention.git
cd Mention
sudo mvn clean install
```
The jar is in the `target/` folder.

## Contact
Add me on Discord => Lxct#9971
I'd like to hear your comments ! <3


## Info
Spigot Link: [https://www.spigotmc.org/resources/mention.63390/](https://www.spigotmc.org/resources/mention.63390/)  
Github Link: [https://github.com/Lxct/Mention](https://github.com/Lxct/Mention)
