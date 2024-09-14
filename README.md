# RegisterSystem Plugin

## Overview

The **RegisterSystem** plugin is a simple registration and login system for Minecraft servers using the Bukkit API. This plugin allows players to register with a username and password, and log in using those credentials. Player data is stored securely in an SQLite database within the server files.

## Features

- Players can register with a username and password using the `/register` command.
- Players can log in with their credentials using the `/login` command.
- Data is stored in a local SQLite database (`users.db`), ensuring persistence across server restarts.
- Simple and lightweight, making it easy to set up on any Bukkit-based server.

## Requirements

- **Minecraft Server**: Bukkit/Spigot server (1.17.1 or compatible)
- **Java**: JDK 8 or higher

## Installation

1. Download the latest release of the plugin from the [Releases](https://github.com/CapitainFoxy/RegisterSystem/releases) page.
2. Place the downloaded `.jar` file into the `plugins` directory of your Minecraft server.
3. Restart your server to load the plugin.

## Configuration

No configuration is required for this plugin. The SQLite database will be automatically created in the plugin's data folder (`plugins/RegisterSystem/users.db`).

## Commands

### `/register <username> <password>`

Registers a new user with the specified username and password. 

### `/login <username> <password>`

Logs in an existing user with the specified username and password.

#### License

Show the [LICENSE](LICENSE) file!
