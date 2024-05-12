package br.com.iagofragnan.commands;

import br.com.iagofragnan.controller.game;
import br.com.iagofragnan.models.arduino;
import br.com.iagofragnan.models.player;
import br.com.iagofragnan.models.timer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.Duration;
import java.time.LocalTime;

public class distance implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {




        if(!arduino.isWorking || player.getPlayerObj() == null) {
            commandSender.sendMessage( ChatColor.RED + "Arduino não está funcionando ou Jogador inválido.");
            return true;
        }


        Player p = player.getPlayerObj();
        int radius = 60;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    Block block = p.getWorld().getBlockAt(p.getLocation().add(x, y, z));
                    if (block.getType() == Material.CHEST) {
                        double distance = p.getLocation().distance(block.getLocation());
                        arduino.SendSignalByDistance(distance);
                        commandSender.sendMessage("Distancia: " + distance);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
