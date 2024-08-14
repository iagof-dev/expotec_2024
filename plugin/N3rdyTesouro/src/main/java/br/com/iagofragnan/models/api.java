package br.com.iagofragnan.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;

public class api {
    public String makePostRequest(String endpoint, Map<String, String> data) {
        try {
            URL url = new URL(br.com.iagofragnan.settings.api.getApiURL() + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, String> entry : data.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            try (OutputStream os = conn.getOutputStream()) {
                os.write(postDataBytes);
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (Scanner scanner = new Scanner(conn.getInputStream())) {
                    return scanner.useDelimiter("\\A").next();
                }
            } else {
                return "{\"status\": \"error\",\"message\": \"Erro no servidor: " + responseCode + "\"}";
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String makeGetRequest(String endpoint){
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(br.com.iagofragnan.settings.api.getApiURL() + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.toString();
    }

}
