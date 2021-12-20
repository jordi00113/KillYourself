package be.jordiperreman.killyourself.listeners;

import be.jordiperreman.killyourself.KillYourself;
import be.jordiperreman.killyourself.interfaces.IConfigService;
import be.jordiperreman.killyourself.utils.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.PluginLogger;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PlayerDeathMessage implements Listener {
    public IConfigService cs;

    public PlayerDeathMessage(KillYourself plugin) {
        this.cs = plugin.getConfigService();
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void deathEvent(PlayerDeathEvent event) {
        // Check if the player just committed suicide.
        if(!Objects.equals(event.getDeathMessage(), String.format("%s died", event.getEntity().getName()))){
            return;
        }
        final List<String> deathMessages = cs.getCStringList("general.messages.death-message");
        final Random generator = new Random();
        final int randomIndex = generator.nextInt(deathMessages.size());
        PluginLogger.getLogger("KillYourself").warning(event.getDeathMessage());
        event.setDeathMessage(ChatUtil.color(String.format(deathMessages.get(randomIndex), event.getEntity().getName())));
    }
}
