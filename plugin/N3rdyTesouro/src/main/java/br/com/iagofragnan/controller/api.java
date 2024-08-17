package br.com.iagofragnan.controller;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eu.decentsoftware.holograms.api.DHAPI;
import org.bukkit.ChatColor;

import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.nio.charset.StandardCharsets;
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

    public void insertOnRanking(String name, String time_per_round, String time_per_game){
        Map<String, String> data = new LinkedHashMap<>();
        data.put("name", name);
        data.put("time_per_round", time_per_round);
        data.put("time_per_game", time_per_game);
        api.makePostRequest("/inserir/", data);
    }




}
