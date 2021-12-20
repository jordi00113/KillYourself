package be.jordiperreman.killyourself.commands;

import be.jordiperreman.killyourself.KillYourself;
import be.jordiperreman.killyourself.interfaces.ISubCommand;
import be.jordiperreman.killyourself.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Version extends KillYourselfCmd implements ISubCommand {

    public Version(KillYourself plugin) {
        super(plugin);
    }

    @Override
    public boolean doCommand(CommandSender sender, Command command, String[] args) {
        if (!sender.hasPermission(getPermission())) {
            sender.sendMessage(ChatUtil.color(cs.getCString("general.messages.no_perm")));
            return true;
        }
        sender.sendMessage(ChatUtil.color(cs.getCString("general.messages.prefix") + String.format(cs.getCString("general.messages.version"), plugin.getDescription().getVersion())));
        return true;
    }

    @Override
    public String getPermission() {
        return "killyourself.version";
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}