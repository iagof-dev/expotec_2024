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
