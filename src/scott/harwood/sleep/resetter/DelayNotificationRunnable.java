package scott.harwood.sleep.resetter;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class DelayNotificationRunnable implements Runnable {
    Player p;
    public DelayNotificationRunnable(Player p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.sendMessage(ChatColor.GREEN.toString() + "[Phantoms B-Gone] " + p.getDisplayName() + " The Phantoms R-Gone");
    }

}
