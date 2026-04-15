package eta.thief;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String msg = event.getMessage();

        if (msg.startsWith("> ") || msg.startsWith(">")) {
            event.setMessage(ChatColor.GREEN + msg);
        }
    }
}