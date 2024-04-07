package br.com.iagofragnan.commands;

import br.com.iagofragnan.arduino;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class debug implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        arduino.SendSignal(args[0]);

        return true;
    }
}
