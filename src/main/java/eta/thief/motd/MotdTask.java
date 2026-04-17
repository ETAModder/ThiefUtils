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
            "§f[ §6§lDayReaver §r§6Anarchy §f]\n§b§oI know your base coords.",
            "§f[ §6§lDayReaver §r§6Anarchy §f]\n§b§osince 2026",
            "§f[ §6§lDayReaver §r§6Anarchy §f]\n§b§os0n ! c@n pull yo IP in 12 s3conds",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§oi wonder if you noticed the subtle change in name",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§olovingly maintained by ETAGamer and DayReaver",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§ob3tter than superdboy_4",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§oALL HAIL ARROKOTH",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§oall roads lead to stach",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§ola maison de la best creative anarchy server on the market",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§oalso check out kaboom!",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§oYou're being watched.",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§owho am i (what's my name?)",
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§oim up creativing my anarchy rn"
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§ololrandom XD"
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§ojust released!"
            "§f[ §6§lDayRaever §r§6Anarchy §f]\n§b§oThe best 2b2d alternative."
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
