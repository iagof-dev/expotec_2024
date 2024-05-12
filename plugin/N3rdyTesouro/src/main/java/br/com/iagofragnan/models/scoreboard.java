package br.com.iagofragnan.models;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.time.Duration;
import java.time.LocalTime;

public class scoreboard {


    public enum states{ Idle, Playing};
    static Scoreboard sb;
    static Scoreboard sbPlaying;
    static ScoreboardManager m;

    static boolean isSbCreated = false;
    static boolean isSbPlayingCreated = false;

    public scoreboard() {
        try{
            sb = Bukkit.getScoreboardManager().getNewScoreboard();
            sbPlaying = Bukkit.getScoreboardManager().getNewScoreboard();
            m = Bukkit.getScoreboardManager();
        }
        catch(Exception e){
            Bukkit.getLogger().severe(e.getMessage());
        }
    }

    public static boolean createScoreboard(Player p, states state){
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


    private static void createLobbyScoreboard(Player p) {
        if (m == null) return;

        if(isSbCreated){
            p.setScoreboard(sb);
            return;
        }

        Objective objective = sb.registerNewObjective("ranking", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.BOLD + "Expotec 2024");
        objective.getScore("Ca\u00e7a ao Tesouro").setScore(5);
        objective.getScore(ChatColor.RED + " ").setScore(4);
        objective.getScore("Melhor Tempo:").setScore(3);
        objective.getScore(ChatColor.GOLD + "N3rdyDev" + ChatColor.WHITE + " - 00:00:00").setScore(2);
        objective.getScore(ChatColor.WHITE + " ").setScore(1);
        objective.getScore(ChatColor.GRAY + "iagofragnan.com.br").setScore(0);
        p.setScoreboard(sb);
        isSbCreated = true;
    }

    private static void createPlayingScoreboard(Player p) {
        if (m == null) return;


        if(isSbPlayingCreated){
            p.setScoreboard(sbPlaying);
            return;
        }


        Objective objective = sbPlaying.registerNewObjective("playing", "dummy");
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

        Team tm1 = sbPlaying.registerNewTeam("team1");

        String teamkey = ChatColor.GREEN.toString();

        tm1.addEntry(teamkey);
        tm1.setSuffix("00:00:00");
        objective.getScore(teamkey).setScore(2);

        isSbPlayingCreated = true;
        p.setScoreboard(sbPlaying);
    }


    public static void updatePlayingScoreboard(Player p){
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

        tm1.setSuffix(ChatColor.GREEN + value);


    }


}
