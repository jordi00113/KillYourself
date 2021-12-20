package be.jordiperreman.killyourself;

import be.jordiperreman.killyourself.commands.Kill;
import be.jordiperreman.killyourself.commands.KillYourselfCmd;
import be.jordiperreman.killyourself.interfaces.IConfigService;
import be.jordiperreman.killyourself.listeners.PlayerDeathMessage;
import be.jordiperreman.killyourself.services.ConfigService;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class KillYourself extends JavaPlugin {
    public final static Logger LOGGER = PluginLogger.getLogger("KillYourself");
    private final IConfigService configService = new ConfigService(this);

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerDeathMessage(this), this);

        //Loads config
        this.saveDefaultConfig();
        this.configService.loadConfig();

        Kill killcmd = new Kill(this);
        getCommand("kill").setExecutor(killcmd);
        getCommand("kill").setTabCompleter(killcmd);
        KillYourselfCmd killYourselfCmd = new KillYourselfCmd(this);
        getCommand("killyourself").setExecutor(killYourselfCmd);
        getCommand("killyourself").setTabCompleter(killYourselfCmd);
        killYourselfCmd.registerSubCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public IConfigService getConfigService() {
        return this.configService;
    }
}
