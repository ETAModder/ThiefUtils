package eta.thief.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class FillCommand implements CommandExecutor {

    private final Material material;

    public FillCommand(String type) {
        this.material = switch (type.toLowerCase()) {
            case "tnt" -> Material.TNT;
            case "sponge" -> Material.SPONGE;
            case "air" -> Material.AIR;
            default -> Material.STONE;
        };
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) return true;

        Location base = player.getLocation();

        for (int x = -4; x <= 4; x++) {
            for (int y = -4; y <= 4; y++) {
                for (int z = -4; z <= 4; z++) {

                    Location loc = base.clone().add(x, y, z);
                    loc.getBlock().setType(material);
                }
            }
        }

        return true;
    }
}