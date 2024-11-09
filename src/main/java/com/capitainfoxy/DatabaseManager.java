package com.capitainfoxy;
import org.bukkit.plugin.Plugin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DatabaseManager {
    private Connection connection;
    private Plugin plugin;
    public DatabaseManager(Plugin plugin) {
        this.plugin = plugin;
    }
    public void initializeDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + plugin.getDataFolder() + "/users.db");
            PreparedStatement statement = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS users (username TEXT PRIMARY KEY, password TEXT)"
            );
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            plugin.getLogger().severe("Could not connect to the database!");
            e.printStackTrace();
        }
    }
    public boolean registerUser(String username, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            plugin.getLogger().severe("Error registering user: " + e.getMessage());
            return false;
        }
    }
    public boolean loginUser(String username, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                return storedPassword.equals(password);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            plugin.getLogger().severe("Error logging in user: " + e.getMessage());
        }
        return false;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            plugin.getLogger().severe("Error closing the database connection: " + e.getMessage());
        }
    }
}
