package com.capitainfoxy;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {
        getLogger().info("RegisterSystem plugin enabled!");
        databaseManager = new DatabaseManager(this);
        databaseManager.initializeDatabase();
        this.getCommand("register").setExecutor(new RegisterCommand(databaseManager));
        this.getCommand("login").setExecutor(new LoginCommand(databaseManager));
    }

    @Override
    public void onDisable() {
        getLogger().info("RegisterSystem plugin disabled.");
        if (databaseManager != null) {
            databaseManager.closeConnection();
        }
    }
}
