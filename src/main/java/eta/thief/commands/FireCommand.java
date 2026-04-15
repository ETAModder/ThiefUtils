package eta.thief.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class FireCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) return true;

        Location base = player.getLocation();

        for (int x = -4; x <= 4; x++) {
            for (int z = -4; z <= 4; z++) {

                Location loc = base.clone().add(x, 0, z);

                if (loc.getBlock().getType().isAir()) {
                    loc.getBlock().setType(Material.FIRE);
                }
            }
        }

        return true;
    }
}