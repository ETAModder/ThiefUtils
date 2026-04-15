package eta.thief;

import eta.thief.chat.ChatListener;
import eta.thief.commands.BombCommand;
import eta.thief.commands.BombTabCompleter;
import eta.thief.commands.FireCommand;
import eta.thief.commands.FillCommand;
import eta.thief.motd.MotdTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new ChatListener(), this);


        getCommand("bomb").setExecutor(new BombCommand());
        getCommand("bomb").setTabCompleter(new BombTabCompleter());

        getCommand("fire").setExecutor(new FireCommand());
        getCommand("fill-tnt").setExecutor(new FillCommand("tnt"));
        getCommand("fill-sponge").setExecutor(new FillCommand("sponge"));
        getCommand("fill-air").setExecutor(new FillCommand("air"));

        new MotdTask(this).start();
    }
}