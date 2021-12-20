package be.jordiperreman.killyourself.interfaces;

import java.util.List;

public interface IConfigService {

    /**
     * Load configuration.
     */
    void loadConfig();

    /**
     * Reload configuration.
     */
    void reloadConfig();

    /**
     * Get configuration String from config.yml.
     */
    String getCString(String path);

    /**
     * Get configuration List of Strings from config.yml.
     */
    List<String> getCStringList(String path);
}
