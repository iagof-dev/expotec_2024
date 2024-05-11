<<<<<<< HEAD
package br.com.iagofragnan.models;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class scoreboard {

    public scoreboard(){
    }

    public static void createScoreboard(Player p) {
        if (p == null || !p.isOnline()) {
            return; // Always check if player is valid and online
        }

        try {
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            if (manager == null) {
                p.sendMessage("Controlador não encontrado.");
                return;
            }
            Scoreboard sb = manager.getNewScoreboard();
            Objective objective = sb.registerNewObjective("scoreboard", "dummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(p.getDisplayName());
            p.setScoreboard(sb);
            Bukkit.getLogger().info(ChatColor.GOLD + "Scoreboard created.");
        } catch (Exception e) {
            Bukkit.getLogger().warning("Erro ao criar scoreboard para: " + p.getName() + ": " + e.getMessage());
        }
    }


    public static void update(){

    }


}
=======
package br.com.iagofragnan.models;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class scoreboard {

    public scoreboard(){
    }

    public static void createScoreboard(Player p) {
        if (p == null || !p.isOnline()) {
            return; // Always check if player is valid and online
        }

        try {
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            if (manager == null) {
                p.sendMessage("Controlador não encontrado.");
                return;
            }
            Scoreboard sb = manager.getNewScoreboard();
            Objective objective = sb.registerNewObjective("scoreboard", "dummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(p.getDisplayName());
            p.setScoreboard(sb);
            Bukkit.getLogger().info(ChatColor.GOLD + "Scoreboard created.");
        } catch (Exception e) {
            Bukkit.getLogger().warning("Erro ao criar scoreboard para: " + p.getName() + ": " + e.getMessage());
        }
    }


    public static void update(){

    }


}
>>>>>>> 1b13af6f01d7e8715a26ffe1599171301399c2db
