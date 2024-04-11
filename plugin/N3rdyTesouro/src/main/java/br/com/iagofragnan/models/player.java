package br.com.iagofragnan.models;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.sql.Time;
import java.time.LocalTime;

public class player {


    private static Player obj_player;
    private static World obj_world;
    private String player_name;
    private int chests;
    private LocalTime StartTime;
    private LocalTime EndTime;

    public static World getWorld() {
        return obj_world;
    }

    public static void setWorld(World new_obj_world) {
        player.obj_world = new_obj_world;
    }


    public String getPlayerName() {
        return player_name;
    }

    public void setPlayerName(String player_name) {
        this.player_name = player_name;
    }

    public int getChests() {
        return chests;
    }

    public void setChests(int chests) {
        this.chests = chests;
    }

    public LocalTime getStartTime() {
        return StartTime;
    }

    public void setStartTime(LocalTime time) {
        this.StartTime = time;
        this.EndTime = time.plusMinutes(5);
    }

    public static Player getPlayerObj() {
        return obj_player;
    }

    public static void setPlayerObj(Player NewPlayer) {
        obj_player = NewPlayer;
    }

    public LocalTime getEndTime() {
        return EndTime;
    }
}
