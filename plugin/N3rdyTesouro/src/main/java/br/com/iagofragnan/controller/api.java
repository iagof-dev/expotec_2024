package br.com.iagofragnan.controller;

import org.bukkit.Bukkit;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class api {

    public static LinkedHashMap<String, String> getRanking() {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(br.com.iagofragnan.settings.api.getApiURL() + "/listar/ranking/"))
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();

                JSONObject jsonResponse = new JSONObject(responseBody);
                JSONArray dataArray = jsonResponse.getJSONArray("DATA");

                if(dataArray.length() <= 0 || dataArray == null) {
                    Bukkit.getConsoleSender().sendMessage("Houve um erro na hora de obter dados da API.");
                }

                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObject = dataArray.getJSONObject(i);
                    int id = dataObject.getInt("id");
                    String name = dataObject.getString("name");
                    String timePerRound = dataObject.getString("time_per_round");
                    result.put(name, timePerRound);
                }
            }
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
