package br.com.iagofragnan.controller;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class hologram {

    static Hologram rankingHologram;

    public hologram(){
        if(DHAPI.getHologram("ranking") != null)
        {
            rankingHologram = DHAPI.getHologram("ranking");
        }
    }

    public static void createRanking(){
        if(DHAPI.getHologram("ranking") != null)
        {
            updateRanking();
            return;
        }

        LinkedHashMap<String, String> result = br.com.iagofragnan.controller.api.getRanking();
        DHAPI.createHologram("ranking", new Location(br.com.iagofragnan.models.player.getWorld(),0, 75, 0), false);
        rankingHologram = DHAPI.getHologram("ranking");
        DHAPI.addHologramLine(rankingHologram, ChatColor.GREEN + "Lista dos Melhores Jogadores");
        Integer pos = 1;
        for (Map.Entry<String, String> entry : result.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            DHAPI.addHologramLine(rankingHologram, ChatColor.GREEN + "" + pos + ". " + ChatColor.WHITE + key + ChatColor.GRAY + " | " + ChatColor.WHITE + value);
            pos++;
        }

    }

    public static void deleteRanking(){
        DHAPI.removeHologram("ranking");
    }

    public static void updateRanking(){
        deleteRanking();
        createRanking();
    }

}
