package eta.thief;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import net.md_5.bungee.api.ChatColor;

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

        if (msg.startsWith("_")) {
            msg = msg.substring(1);

            StringBuilder out = new StringBuilder();
            int colorIndex = 0;

            for (char c : msg.toCharArray()) {
                if (c == ' ') {
                    out.append(' ');
                    continue;
                }

                String color = colors[colorIndex % colors.length];
                out.append(ChatColor.of(color)).append(c);
                colorIndex++;
            }

            event.setMessage(out.toString());
            return;
        }

        if (msg.startsWith(">")) {
            event.setMessage(ChatColor.GREEN + msg);
            return;
        }

        if (msg.endsWith(" <") || msg.endsWith("<")) {
            event.setMessage(ChatColor.of("#BD5313") + msg);
        }
    }
}