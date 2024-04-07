package br.com.iagofragnan.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        for(Player players : Bukkit.getServer().getOnlinePlayers())
        {
            players.sendTitle("Verificando arduino.", "caso nao de nenhum sinal, verificar", 10, 50, 10);

        }

        br.com.iagofragnan.arduino.TestDevice();
        return true;
    }
}
