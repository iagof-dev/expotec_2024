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

    public static World getObj_world() {
        return obj_world;
    }

    public static void setObj_world(World new_obj_world) {
        player.obj_world = new_obj_world;
    }


    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
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

    public static Player getObj_player() {
        return obj_player;
    }

    public static void setObj_player(Player NewPlayer) {
        obj_player = NewPlayer;
    }

    public LocalTime getEndTime() {
        return EndTime;
    }
}
