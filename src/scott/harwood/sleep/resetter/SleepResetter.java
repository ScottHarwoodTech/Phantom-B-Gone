package scott.harwood.sleep.resetter;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import scott.harwood.sleep.resetter.SleepListener;
public class SleepResetter extends JavaPlugin {
    @Override
    public void onDisable() {
        this.getLogger().info("Stopping");
        HandlerList.unregisterAll(new SleepListener());//remove by type

    }

    @Override
    public void onEnable() {
        this.getLogger().info("PlugInStarting");
        getServer().getPluginManager().registerEvents(new SleepListener(),this);
    }
}
