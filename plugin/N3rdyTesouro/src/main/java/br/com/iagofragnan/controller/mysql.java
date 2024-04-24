package br.com.iagofragnan.controller;

import java.sql.Time;

import static br.com.iagofragnan.models.mysql.*;

public class mysql {

    public void registerPlayer(String playerName){
        Insert("INSERT INTO players VALUES (default, '" + playerName + "');");
    }

    public int getPlayerId(){
        return 0;
    }

    public void registerTime(int playerId, Time time_per_round, Time time_per_game){
        Insert("INSERT INTO rounds VALUES (default, " + playerId + ", " + time_per_round + ", " + time_per_game + ");");
    }

}
