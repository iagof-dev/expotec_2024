package br.com.iagofragnan.models;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class scoreboard {
    private ScoreboardManager manager;
    private Scoreboard scoreboard;
    private Objective objective;

    public scoreboard() {
        manager = Bukkit.getScoreboardManager();
        scoreboard = manager.getNewScoreboard();
        objective = scoreboard.registerNewObjective("scoreboard", "dummy"); 
    }

}
