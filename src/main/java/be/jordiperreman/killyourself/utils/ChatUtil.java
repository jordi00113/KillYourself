package be.jordiperreman.killyourself.utils;

import org.bukkit.ChatColor;

public class ChatUtil {

    /**
     * Translates a string using an alternate color code character into a
     * string that uses the internal ChatColor.COLOR_CODE color code
     * character.
     *
     * @param string String with alternate color codes to be translated.
     * @return String with translated color codes.
     */
    public static String color(String string) {
        string += " &r";
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}