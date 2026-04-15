package eta.thief.motd;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class MotdTask {

    private final JavaPlugin plugin;
    private int index = 0;

    private final List<String> motds = List.of(
            "§f[ §6§lDayReaver §r§6Anarchy §f]\n§b§orul3z 4 f0r n3rdz",
            "§f[ §6§lDayReaver §r§6Anarchy §f]\n§4ETAGamer §b§ois best",
            "§f[ §6§lDayReaver §r§6Anarchy §f]\n§b§oreaving them days",
            "§f[ §6§lDayReaver §r§6Anarchy §f]\n§b§od0nt g3t h4xx0r3d",
            "§f[ §6§lDayReaver §r§6Anarchy §f]\n§b§oI know your base coords."
    );

    public MotdTask(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void start() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {

            Bukkit.getServer().setMotd(motds.get(index));

            index++;
            if (index >= motds.size()) index = 0;

        }, 0L, 20L * 20);
    }
}