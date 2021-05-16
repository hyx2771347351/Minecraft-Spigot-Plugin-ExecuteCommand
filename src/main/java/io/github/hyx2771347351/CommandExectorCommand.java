package io.github.hyx2771347351;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandExectorCommand implements CommandExecutor {
    private ExecuteCommandFromSocket plugin;
    public CommandExectorCommand(ExecuteCommandFromSocket plugin) {
        this.plugin = plugin;
    }
    public boolean pluginInfo(CommandSender commandSender) {
        commandSender.sendMessage("CommandExecutor by _BIG_COOKIE_");
        commandSender.sendMessage("verison: v1.0-SNAPSHOT");
        commandSender.sendMessage("For help, type \"/commandexecutor help\"");
        return true;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("commandexecutor")) {
            switch (args[0]) {
                case "info":
                    return pluginInfo(commandSender);
            }
            return true;
        }
        return false;
    }
}
