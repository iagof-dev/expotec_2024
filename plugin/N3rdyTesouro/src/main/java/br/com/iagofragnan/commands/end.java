<<<<<<< HEAD
package br.com.iagofragnan.commands;

import br.com.iagofragnan.controller.game;
import br.com.iagofragnan.models.player;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class end implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        game.end();
        return true;
    }

}
=======
package br.com.iagofragnan.commands;

import br.com.iagofragnan.controller.game;
import br.com.iagofragnan.models.player;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class end implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        game.end();
        return true;
    }

}
>>>>>>> 1b13af6f01d7e8715a26ffe1599171301399c2db
