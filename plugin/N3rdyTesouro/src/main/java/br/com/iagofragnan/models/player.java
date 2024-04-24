package br.com.iagofragnan.models;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.Time;
import java.time.LocalTime;

public class player {


    private static Player obj_player;
    private static World obj_world;
    private static String player_name;
    private int chests = 0;
    private int rounds = 0;


    public static World getWorld() {
        return obj_world;
    }

    public static void setWorld(World new_obj_world) {
        player.obj_world = new_obj_world;
    }


    public static String getPlayerName() {
        return player_name;
    }

    public void setPlayerName(String newPlayerName) {
        player_name = newPlayerName;
    }

    public int getChests() {
        return chests;
    }

    public void addChests(int newChestValue) {
        chests += newChestValue;
    }


    public static Player getPlayerObj() {
        return obj_player;
    }

    public static void setPlayerObj(Player NewPlayer) {
        obj_player = NewPlayer;
    }

    public int getRounds() {
        return rounds;
    }

    public void addRounds(int newRoundsValue) {
        rounds += newRoundsValue;
    }
}
