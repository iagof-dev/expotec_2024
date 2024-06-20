package br.com.iagofragnan.controller;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.time.Duration;
import java.time.LocalTime;


public class mysql {

    public static void registerTime(String playerName, Integer gameQuantity, LocalTime startTime, LocalTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        long totalSeconds = duration.getSeconds();
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;
        int nanos = duration.getNano();
        int milliseconds = nanos / 1000000;

        String sql_TimePerGame = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);

        long totalMinPerGame = minutes / gameQuantity;
        long totalSecPerGame = seconds / gameQuantity;
        int millisPerGame = milliseconds / gameQuantity;

        String sql_TimePerRound = String.format("%02d:%02d:%02d.%03d", hours, totalMinPerGame, totalSecPerGame, millisPerGame);

        if(br.com.iagofragnan.settings.mysql.isEnabled()){
            String sql = "INSERT INTO players VALUES (default, '" + playerName + "', '" + sql_TimePerRound + "', '" + sql_TimePerGame + "')";
            br.com.iagofragnan.models.mysql.Insert(sql);
        }
        else{
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "MySql desativado, pulando função de salvar.");
        }
        if(br.com.iagofragnan.settings.api.isApiEnabled()){

        }
        else{
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Api desativada, pulando função de salvar.");
        }

    }
}
