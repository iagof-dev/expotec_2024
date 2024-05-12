package br.com.iagofragnan.models;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.time.Duration;
import java.time.LocalTime;

public class scoreboard {


    public static boolean isSbCreated() {
        return isSbCreated;
    }

    public static void setSbCreated(boolean value) {
        isSbCreated = value;
    }

    public static boolean isSbPlayingCreated() {
        return isSbPlayingCreated;
    }

    public static void setSbPlayingCreated(boolean value) {
        isSbPlayingCreated = value;
    }

    public static Scoreboard getSb() {
        return sb;
    }

    public static void setSb(Scoreboard value) {
        sb = value;
    }

    public static Scoreboard getSbPlaying() {
        return sbPlaying;
    }

    public static void setSbPlaying(Scoreboard value) {
        sbPlaying = value;
    }

    public static ScoreboardManager getM() {
        return m;
    }

    public static void setM(ScoreboardManager value) {
        m = value;
    }

    public enum states{ Idle, Playing};
    private static Scoreboard sb;
    private static Scoreboard sbPlaying;
    private static ScoreboardManager m;

    private static boolean isSbCreated = false;
    private static boolean isSbPlayingCreated = false;




}
