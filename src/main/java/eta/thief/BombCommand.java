package eta.thief;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.plugin.java.JavaPlugin;

public class BombCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public BombCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cPlayers only§r");
            return true;
        }

        Location loc = player.getLocation().add(0, 1, 0);

        if (args.length == 0) {
            spawnFireball(loc, 20);
            return true;
        }

        switch (args[0].toLowerCase()) {

            case "heavy" -> spawnFireball(loc, 50);

            case "atomic" -> spawnFireball(loc, 80);

            case "tnt" -> {
                player.getWorld().spawn(loc, TNTPrimed.class, tnt -> {
                    tnt.setFuseTicks(40);
                });
            }

            default -> player.sendMessage("§cUsage: /bomb [heavy|atomic|tnt]§r");
        }

        return true;
    }

    private void spawnFireball(Location loc, float power) {
        Fireball fireball = loc.getWorld().spawn(loc, Fireball.class);
        fireball.setYield(power);
        fireball.setIsIncendiary(true);
    }
}