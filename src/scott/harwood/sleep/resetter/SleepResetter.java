package scott.harwood.sleep.resetter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;

public class SleepResetter extends JavaPlugin {
    FileConfiguration config = this.getConfig();
    @Override
    public void onDisable() {
        HandlerList.unregisterAll(new SleepListener(this,config.getLong("BedDelay")));//remove by type
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new SleepListener(this,config.getLong("BedDelay")),this);
        String[] InitNights = new String[3];
        for (int i = 1; i<=3;i++) {
            InitNights[i-1] = config.getString(Integer.toString(i));
        }
        List<String> LateNights = config.getStringList("4");
        //target Time: 12520
        Long resetTime = config.getLong("ResetTime");
        this.getServer().getScheduler().scheduleSyncRepeatingTask(this,new WarningInitial(this,InitNights,LateNights,resetTime),1,resetTime);

        //if dt+ then it hasnt passed sunset yet
        //if dt- then it has passed. and delay =
    }
}
