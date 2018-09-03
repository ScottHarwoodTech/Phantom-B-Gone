package scott.harwood.sleep.resetter;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class SleepListener implements Listener {
    @EventHandler
    public void PlayerBedEnterEvent(PlayerBedEnterEvent event)
    {
        Player p = event.getPlayer();
        Bukkit.getLogger().info(p.getName() + "slept");
        p.setStatistic(Statistic.TIME_SINCE_DEATH,0);
        Bukkit.getLogger().info("reset" + p.getName() + "'s sleep counter");
    }

}
