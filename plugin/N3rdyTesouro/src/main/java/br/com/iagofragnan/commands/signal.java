<<<<<<< HEAD
package br.com.iagofragnan.commands;

import br.com.iagofragnan.models.arduino;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class signal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        arduino.SendSignal(args[0]);
        return true;
    }
}
=======
package br.com.iagofragnan.commands;

import br.com.iagofragnan.models.arduino;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class signal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        arduino.SendSignal(args[0]);
        return true;
    }
}
>>>>>>> 1b13af6f01d7e8715a26ffe1599171301399c2db
