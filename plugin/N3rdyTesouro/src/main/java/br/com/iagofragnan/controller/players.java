package br.com.iagofragnan.controller;

import br.com.iagofragnan.models.player;

import java.util.HashMap;

public class players {
    private HashMap<Integer, player> players;

    public HashMap<Integer, player> getAllPlayers() {
        return players;
    }

    public void addPlayer(player jogador) {
        this.players.put(this.players.size() + 1, jogador);
    }
}
