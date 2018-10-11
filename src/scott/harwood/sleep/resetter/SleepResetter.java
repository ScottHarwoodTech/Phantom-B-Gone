package scott.harwood.sleep.resetter;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class SleepResetter extends JavaPlugin {
    @Override
    public void onDisable() {
        HandlerList.unregisterAll(new SleepListener());//remove by type
    }

    @Override
    public void onEnable() {
        // Copy default config
        getConfig().options().copyDefaults(true);
        saveConfig();
        getServer().getPluginManager().registerEvents(new SleepListener(),this);
    }
}
