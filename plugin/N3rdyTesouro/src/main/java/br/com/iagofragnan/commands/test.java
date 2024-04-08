package br.com.iagofragnan.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static br.com.iagofragnan.models.player.*;

public class test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(getObj_player() != null)
            getObj_player().sendTitle("Verificando arduino.", "caso nao de nenhum sinal, verificar", 10, 50, 10);

        br.com.iagofragnan.arduino.TestDevice();
        return true;
    }
}
