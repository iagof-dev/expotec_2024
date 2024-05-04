package br.com.iagofragnan.models;

import de.rapha149.signgui.SignGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class player {


    private static Player obj_player;
    private static World obj_world;
    private static String player_name;
    private int chests = 0;
    private int rounds = 0;


    private static boolean setupNameFinished = false;


    public static World getWorld() {
        return obj_world;
    }

    public static void setWorld(World new_obj_world) {
        player.obj_world = new_obj_world;
    }


    public static String getPlayerName() {
        return player_name;
    }

    public static void setPlayerName(String newPlayerName) {
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

    public static void initPlayerSignName(){
        Player p = player.getPlayerObj();


        SignGUI sign = SignGUI.builder()
                .setLine(1,  ChatColor.WHITE + "" + ChatColor.BOLD + "--------------")
                .setLine(2,  ChatColor.WHITE + "" + ChatColor.BOLD + "Seu nome acima")
                .setLine(3, ChatColor.WHITE + "" + ChatColor.BOLD + "para o Ranking")
                .setHandler((player, result) ->{
                    String name = result.getLine(0);
                    if (!(name.isEmpty())) {
                        br.com.iagofragnan.models.player.setPlayerName(name);
                        br.com.iagofragnan.models.arena.start();
                    }
                    return Collections.emptyList();
                })
                .build();
        sign.open(p);

        setSetupNameFinished(true);
    }

    public int getRounds() {
        return rounds;
    }

    public void addRounds(int newRoundsValue) {
        rounds += newRoundsValue;
    }


    public static boolean isSetupNameFinished() {
        return setupNameFinished;
    }

    public static void setSetupNameFinished(boolean newSNF) {
        setupNameFinished = newSNF;
    }
}
