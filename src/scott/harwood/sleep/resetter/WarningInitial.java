package scott.harwood.sleep.resetter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.Random;

import static org.bukkit.util.NumberConversions.floor;

public class WarningInitial implements Runnable {
    String[] EarlyNights;
    List<String> LateNights;
    Plugin plugin;
    Long resetTime;
    public WarningInitial(Plugin plugin, String[] EarlyNights, List<String> LateNights,long resetTime) {
        this.EarlyNights = EarlyNights;
        this.LateNights = LateNights;
        this.resetTime = resetTime;
        this.plugin = plugin;
        Bukkit.getLogger().info("Asda " +EarlyNights[0]);
        Bukkit.getLogger().info(LateNights.toString());
    }
    @Override
    public void run() {
        List<World> worlds = plugin.getServer().getWorlds();
        Long time = worlds.get(0).getTime();
        if ((time < 12520 + resetTime) && time > (12520 - resetTime)) {
            for (Player P : Bukkit.getServer().getOnlinePlayers()) {
                long TimeAwake = P.getStatistic(Statistic.TIME_SINCE_REST);
                int daysAwake = floor(TimeAwake / 24000);
                if (daysAwake < 2) {
                    Bukkit.getLogger().info(String.valueOf(daysAwake));
                    P.sendMessage(ChatColor.GREEN.toString() + "[Phantoms B-Gone] " + P.getDisplayName() + " " + EarlyNights[daysAwake] + " (" + daysAwake + "/3)");
                } else {
                    Random r = new Random();
                    String message = LateNights.get(r.nextInt(LateNights.size()));
                    P.sendMessage(ChatColor.GREEN.toString() + "[Phantoms B-Gone] " + P.getDisplayName() + " " + message + " (" + daysAwake + "/3)");
                }
            }
        }
    }
}
