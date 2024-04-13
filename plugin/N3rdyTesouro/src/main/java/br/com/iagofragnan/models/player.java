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
    private int chests;
    private LocalTime StartTime;
    private LocalTime EndTime;

    private static Boolean loading = false;

    public static void setLoading(Boolean value){
        loading = value;
        if(loading){
            getPlayerObj().getInventory().setHelmet(new ItemStack(Material.PUMPKIN));
            getPlayerObj().updateInventory();
            return;
        }
        getPlayerObj().getInventory().clear();
        getPlayerObj().updateInventory();
    }


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
