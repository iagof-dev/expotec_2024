package br.com.iagofragnan.controller;

import br.com.iagofragnan.models.arena;
import br.com.iagofragnan.models.player;
import br.com.iagofragnan.models.scoreboard;
import br.com.iagofragnan.models.timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.time.LocalTime;

import static br.com.iagofragnan.models.timer.setIsRunning;

public class game {

    private static boolean playing = false;
    private static Integer rounds = 0;

    public static void start(){
        Player p = player.getPlayerObj();
        hologram hl = new hologram();
        hl.updateRanking();

        p.sendTitle("Ca\u00e7a ao Tesouro", ChatColor.GRAY+"Feito por Iago Fragnan", 20, 50, 20);

        Bukkit.getScheduler().scheduleSyncDelayedTask(br.com.iagofragnan.main.getThePlugin(), new Runnable() {
            public void run() {
                arena.CreateArena();
            }
        }, 100L);
    }
    public static void end(){
        game.setPlaying(false);
        br.com.iagofragnan.models.arena.DeleteLastArena();
        br.com.iagofragnan.models.player.setSetupNameFinished(false);
        Location spawn = new Location(player.getWorld(), 0, 66, 0);
        player.getPlayerObj().teleport(spawn);
        timer.setEndTime(LocalTime.now());
        setIsRunning(false);
        br.com.iagofragnan.models.arduino.SendSignal("D");
        mysql.registerTime(player.getPlayerName(), getRounds(),timer.getStartTime(), timer.getEndTime());
        player.setPlayerName(null);
        player.setSetupNameFinished(false);
        br.com.iagofragnan.controller.scoreboard sb = new br.com.iagofragnan.controller.scoreboard();
        sb.createScoreboard(player.getPlayerObj(), scoreboard.states.Idle);
        arena.DeleteLastArena();
        game.resetRounds();
        hologram hl = new hologram();
        hl.updateRanking();
    }


    public static Integer getRounds() {
        return rounds;
    }

    public static void addRounds(Integer value) {
        rounds += value;
    }

    public static void resetRounds() {
        rounds = 0;
    }

    public static boolean isPlaying() {
        return playing;
    }

    public static void setPlaying(boolean value) {
        playing = value;
    }
}
