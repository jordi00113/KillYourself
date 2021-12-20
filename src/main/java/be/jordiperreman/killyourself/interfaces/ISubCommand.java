package be.jordiperreman.killyourself.interfaces;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ISubCommand {

    /**
     * Execute command logic.
     */
    boolean doCommand(CommandSender sender, Command command, String[] args);

    /**
     * Get the permission from the command.
     */
    String getPermission();

    List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args);
}
