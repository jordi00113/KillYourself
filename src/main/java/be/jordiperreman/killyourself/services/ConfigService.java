package be.jordiperreman.killyourself.services;


import be.jordiperreman.killyourself.KillYourself;
import be.jordiperreman.killyourself.interfaces.IConfigService;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigService implements IConfigService {

    public FileConfiguration file;
    public KillYourself plugin;

    public ConfigService(KillYourself main) {
        this.plugin = main;
        this.file = main.getConfig();
    }

    @Override
    public void loadConfig() {
        this.file.options().copyDefaults(true);
    }

    @Override
    public void reloadConfig(){
        this.plugin.reloadConfig();
        this.file = plugin.getConfig();
    }

    @Override
    public String getCString(String path) {
        return file.getString(path);
    }

    @Override
    public List<String> getCStringList(String path) {
        return file.getStringList(path);
    }


}