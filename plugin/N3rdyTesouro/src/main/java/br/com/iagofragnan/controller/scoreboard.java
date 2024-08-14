package br.com.iagofragnan.controller;

import br.com.iagofragnan.models.timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.time.Duration;
import java.time.LocalTime;

import static br.com.iagofragnan.models.scoreboard.*;
import static br.com.iagofragnan.models.scoreboard.getM;
import static br.com.iagofragnan.models.scoreboard.getSb;


public class scoreboard {

    public scoreboard() {
        try{
            setSb(Bukkit.getScoreboardManager().getNewScoreboard()) ;
            setSbPlaying(Bukkit.getScoreboardManager().getNewScoreboard());
            setM(Bukkit.getScoreboardManager());
        }
        catch(Exception e){
            Bukkit.getLogger().severe(e.getMessage());
        }
    }

    public boolean createScoreboard(Player p, states state){
        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        switch(state) {
            default:
            case Idle:
                createLobbyScoreboard(p);
                break;
            case Playing:
                createPlayingScoreboard(p);
                break;
        }
        return true;
    }


    private void createLobbyScoreboard(Player p) {
        if (getM() == null) return;

        if(isSbCreated()){
            p.setScoreboard(getSb());
            return;
        }

        Objective objective = getSb().registerNewObjective("ranking", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.BOLD + "Expotec 2024");
        objective.getScore("Ca\u00e7a ao Tesouro").setScore(5);
        objective.getScore(ChatColor.RED + " ").setScore(4);
        objective.getScore("Melhor Tempo:").setScore(3);
        api api = new api();
        objective.getScore(ChatColor.GOLD + api.getTopOne()[0] + ChatColor.WHITE + " - " + api.getTopOne()[1]).setScore(2);
        objective.getScore(ChatColor.WHITE + " ").setScore(1);
        objective.getScore(ChatColor.GRAY + "iagofragnan.com.br").setScore(0);
        p.setScoreboard(getSb());
        setSbCreated(true);
    }

    private void createPlayingScoreboard(Player p) {
        if (getM() == null) return;

        if(isSbPlayingCreated()){
            p.setScoreboard(getSbPlaying());
            return;
        }

        Objective objective = getSbPlaying().registerNewObjective("playing", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.BOLD + "Expotec 2024");
        objective.getScore("Ca\u00e7a ao Tesouro").setScore(8);
        objective.getScore(ChatColor.RED + " ").setScore(7);
        objective.getScore("Melhor Tempo:").setScore(6);
        objective.getScore(ChatColor.GOLD + "N3rdyDev" + ChatColor.WHITE + " - 00:00:00").setScore(5);
        objective.getScore(ChatColor.DARK_RED + " ").setScore(4);
        objective.getScore(ChatColor.GREEN + "Seu Tempo:").setScore(3);
        //TEMPO AQUI
        objective.getScore(ChatColor.WHITE + " ").setScore(1);
        objective.getScore(ChatColor.GRAY + "iagofragnan.com.br").setScore(0);

        Team tm1 = getSbPlaying().registerNewTeam("team1");

        String teamkey = ChatColor.GREEN.toString();

        tm1.addEntry(teamkey);
        tm1.setSuffix("00:00:00");
        objective.getScore(teamkey).setScore(2);

        setSbPlayingCreated(true);
        p.setScoreboard(getSbPlaying());
        updatePlayingScoreboard(p);
    }


    public void updatePlayingScoreboard(Player p){
        if(p.getScoreboard().getTeam("team1") == null) createScoreboard(p, states.Playing);

        Duration duration = Duration.between(timer.getStartTime(), LocalTime.now());
        long totalSeconds = duration.getSeconds();
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;
        int nanos = duration.getNano();
        int milliseconds = nanos / 1000000;

        String value = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);

        Scoreboard oldSB = p.getScoreboard();
        Team tm1 = oldSB.getTeam("team1");

        if(tm1 == null) {
            createPlayingScoreboard(p);
            tm1 = oldSB.getTeam("team1");

        }

        tm1.setSuffix(ChatColor.GREEN + value);


    }
}
