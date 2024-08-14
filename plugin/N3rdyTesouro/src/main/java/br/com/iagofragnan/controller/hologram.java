package br.com.iagofragnan.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class hologram {

    static Hologram rankingHologram;

    public hologram(){
        if(DHAPI.getHologram("ranking") != null)
        {
            rankingHologram = DHAPI.getHologram("ranking");
        }
    }

    public void createRanking(){
        if(DHAPI.getHologram("ranking") != null)
        {
            updateRanking();
            return;
        }

        DHAPI.createHologram("ranking", new Location(br.com.iagofragnan.models.player.getWorld(),0, 75, 0), false);
        rankingHologram = DHAPI.getHologram("ranking");
        DHAPI.addHologramLine(rankingHologram, ChatColor.GREEN + "Lista dos Melhores Jogadores");


        api api = new api();
        String result = api.getRanking();


        Gson gson = new Gson();
        Type type = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> resultMap = gson.fromJson(result, type);
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        List<Map<String, Object>> dataList = gson.fromJson(gson.toJson(resultMap.get("DATA")), listType);
        Integer pos = 1;
        for (Map<String, Object> data : dataList) {
            String key = data.get("name").toString();
            String value = data.get("time_per_game").toString();
            DHAPI.addHologramLine(rankingHologram, ChatColor.GREEN + "" + pos + ". " + ChatColor.WHITE + key + ChatColor.GRAY + " | " + ChatColor.WHITE + value);
            pos++;
        }
    }

    public void deleteRanking(){
        DHAPI.removeHologram("ranking");
    }

    public void updateRanking(){
        deleteRanking();
        createRanking();
    }

}
