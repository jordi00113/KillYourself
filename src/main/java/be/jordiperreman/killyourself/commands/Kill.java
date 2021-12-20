package be.jordiperreman.killyourself.commands;

import be.jordiperreman.killyourself.KillYourself;
import be.jordiperreman.killyourself.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Kill extends CommandBase implements CommandExecutor, TabCompleter {

    public Kill(KillYourself plugin) {
        super(plugin);
    }

    @Override
    public boolean doCommand(CommandSender sender, Command command, String[] args) {
        if (!sender.hasPermission(getPermission())) {
            sender.sendMessage(ChatUtil.color(cs.getCString("general.messages.no_perm")));
        } else {
            Player player = (Player) sender;
            player.setHealth(0);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return new ArrayList<>();
    }

    @Override
    public void registerSubCommands() {
    }

    public String getPermission() {
        return "killyourself.kill";
    }

}