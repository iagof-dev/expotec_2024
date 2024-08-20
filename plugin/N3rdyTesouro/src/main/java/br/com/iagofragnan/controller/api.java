package br.com.iagofragnan.controller;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.decentsoftware.holograms.api.DHAPI;
import org.bukkit.ChatColor;

import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class api {
    br.com.iagofragnan.models.api api;
    public api(){
        api = new br.com.iagofragnan.models.api();
    }

    public String getRanking() {
        return api.makeGetRequest("/listar/ranking/");
    }

    public String[] getTopOne(){
        String response = api.makeGetRequest("/listar/top");

        Gson gson = new Gson();
        Type type = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> resultMap = gson.fromJson(response, type);
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        List<Map<String, Object>> dataList = gson.fromJson(gson.toJson(resultMap.get("DATA")), listType);
        String[] result = new String[2];
        for (Map<String, Object> data : dataList) {
            result[0] = data.get("name").toString();
            result[1] = data.get("time_per_game").toString();
        }

        return result;
    }

    public String getMaximumTime(){

        String response = getRanking();
        if (response == null || response.isEmpty()) {
            throw new IllegalStateException("Resposta invalida ou nula da API");
        }

        Gson gson = new Gson();
        Type type = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> resultMap = gson.fromJson(response, type);
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        List<Map<String, Object>> dataList = gson.fromJson(gson.toJson(resultMap.get("DATA")), listType);
        Duration totalDuration = Duration.ZERO;
        for (Map<String, Object> data : dataList) {
            Duration duration = Duration.between(LocalTime.MIN, LocalTime.parse(data.get("time_per_game").toString()));
            totalDuration = totalDuration.plus(duration);
        }
        long hours = totalDuration.toHours();
        long minutes = totalDuration.toMinutesPart();
        long seconds = totalDuration.toSecondsPart();
        long millis = totalDuration.toMillisPart();
        String formattedTime = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, millis);
        br.com.iagofragnan.settings.ranking.setMaximumTime(formattedTime);
        return formattedTime;
    }

    public void insertOnRanking(String name, String time_per_round, String time_per_game){
        Map<String, String> data = new LinkedHashMap<>();
        data.put("name", name);
        data.put("time_per_round", time_per_round);
        data.put("time_per_game", time_per_game);
        api.makePostRequest("/inserir/", data);
    }

}
