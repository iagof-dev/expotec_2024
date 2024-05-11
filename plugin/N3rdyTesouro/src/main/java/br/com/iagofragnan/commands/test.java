package br.com.iagofragnan.commands;

import br.com.iagofragnan.models.arduino;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static br.com.iagofragnan.models.player.*;

public class test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(getPlayerObj() != null)
            getPlayerObj().sendTitle("Verificando arduino.", null, 10, 50, 10);
        arduino.TestDevice();
        return true;
    }
}
