package com.capitainfoxy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCommand implements CommandExecutor {

    private DatabaseManager databaseManager;

    public RegisterCommand(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 2) {
            player.sendMessage("Usage: /register <username> <password>");
            return true;
        }

        String username = args[0];
        String password = args[1];

        if (databaseManager.registerUser(username, password)) {
            player.sendMessage("Successfully registered!");
        } else {
            player.sendMessage("Registration failed. Username may already be taken.");
        }

        return true;
    }
}
