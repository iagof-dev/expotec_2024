package br.com.iagofragnan.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.LocalTime;

public class timer implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;

        if (args[0].equals("start")){
            p.sendMessage("Iniciando timer");
            br.com.iagofragnan.models.timer.setStartTime(LocalTime.now());
            br.com.iagofragnan.models.timer.setIsRunning(true);
        }
        else if(args[0].equals("end") || args[0].equals("stop")){
            p.sendMessage("Timer finalizado");
            br.com.iagofragnan.models.timer.setEndTime(LocalTime.now());
            br.com.iagofragnan.models.timer.setIsRunning(false);

            int minutos = (br.com.iagofragnan.models.timer.getEndTime().getMinute() - br.com.iagofragnan.models.timer.getStartTime().getMinute());
            int segundos = (br.com.iagofragnan.models.timer.getEndTime().getSecond() - br.com.iagofragnan.models.timer.getStartTime().getSecond());
            int milisegundos = (br.com.iagofragnan.models.timer.getEndTime().getNano() - br.com.iagofragnan.models.timer.getStartTime().getNano());

            p.sendMessage("Ótimo! seu tempo foi: " + minutos + "min, " + segundos + "seg, e " + Math.floor(milisegundos) + "ms");
            p.sendMessage("Inicio: " + br.com.iagofragnan.models.timer.getStartTime());
            p.sendMessage("Final: " + br.com.iagofragnan.models.timer.getEndTime());

        }
        else{
            p.sendMessage(ChatColor.RED + "Erro!");
        }

        return true;
    }
}
