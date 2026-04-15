package eta.thief;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class FastLavaListener implements Listener {

    private final JavaPlugin plugin;

    private final Set<String> processed = new HashSet<>();

    public FastLavaListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLavaFlow(BlockFromToEvent event) {

        if (event.getBlock().getType() != Material.LAVA) return;

        Block from = event.getBlock();
        Block to = event.getToBlock();

        String key = from.getLocation().toString() + "->" + to.getLocation().toString();

        if (processed.contains(key)) return;

        processed.add(key);

        Bukkit.getScheduler().runTask(plugin, () -> {

            if (from.getType() != Material.LAVA) return;

            from.getState().update(true, true);

        });

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            processed.remove(key);
        }, 20L);
    }
}