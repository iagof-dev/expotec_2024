package br.com.iagofragnan.commands;

import br.com.iagofragnan.controller.hologram;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class api implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        hologram hl = new hologram();
        hl.createRanking();
        return true;
    }
}
