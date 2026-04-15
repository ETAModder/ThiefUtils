package eta.thief.chat;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final String[] colors = {
            "#F09EA7",
            "#F6CA94",
            "#FAFABE",
            "#C1EBC0",
            "#C7CAFF",
            "#CDABEB",
            "#F7B6D2"
    };

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        String msg = event.getMessage();

        // Rainbow mode
        if (msg.startsWith("_")) {
            msg = msg.substring(1);

            StringBuilder out = new StringBuilder();
            int i = 0;

            for (char c : msg.toCharArray()) {
                if (c == ' ') {
                    out.append(' ');
                    continue;
                }

                out.append(ChatColor.of(colors[i % colors.length])).append(c);
                i++;
            }

            event.setMessage(out.toString());
            return;
        }

        // Green greentext (keeps >)
        if (msg.startsWith(">")) {
            event.setMessage(ChatColor.GREEN + msg);
            return;
        }

        // Orange suffix (keeps <)
        if (msg.endsWith(" <") || msg.endsWith("<")) {
            event.setMessage(ChatColor.of("#BD5313") + msg);
        }
    }
}