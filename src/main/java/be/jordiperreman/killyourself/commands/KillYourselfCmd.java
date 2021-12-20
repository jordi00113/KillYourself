package be.jordiperreman.killyourself.commands;

import be.jordiperreman.killyourself.KillYourself;
import be.jordiperreman.killyourself.interfaces.ISubCommand;
import be.jordiperreman.killyourself.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillYourselfCmd extends CommandBase implements CommandExecutor, TabCompleter {
    protected Map<String, ISubCommand> commands = new HashMap<>();


    public KillYourselfCmd(KillYourself plugin) {
        super(plugin);
    }

    @Override
    public boolean doCommand(CommandSender sender, Command command, String[] args) {
        if (args.length != 0) {
            if (!commands.containsKey(args[0].toLowerCase())) {
                // No subcommand like that found
                sender.sendMessage(ChatUtil.color(cs.getCString("general.messages.sub_cmd_not_exist")));
                return true;
            }
            return commands.get(args[0]).doCommand(sender, command, args);
        } else {

            // When no subcommand or param is found
            if (!sender.hasPermission(getPermission())) {
                sender.sendMessage(ChatUtil.color(cs.getCString("general.messages.no_perm")));
                return true;
            }
            sender.sendMessage(ChatUtil.color("&e------ &rHelp KillYourself &e------ \n" +
                    "&r&6/killyourself author:&r Plugin author\n" +
                    "&r&6/killyourself reload:&r Reload plugin's configuration\n" +
                    "&r&6/killyourself version:&r Plugin version"));
            return true;
        }
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return new ArrayList<>(commands.keySet());
    }

    @Override
    public void registerSubCommands() {
        commands.put("author", new Author(this.plugin));
        commands.put("reload", new Reload(this.plugin));
        commands.put("version", new Version(this.plugin));
        commands.put("v", new Version(this.plugin));
    }

    public String getPermission() {
        return "killyourself.help";
    }

}