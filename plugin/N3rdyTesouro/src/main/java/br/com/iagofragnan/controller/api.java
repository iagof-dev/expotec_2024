package br.com.iagofragnan.controller;


import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.Scanner;

public class api {

    public static void getRanking() {
        try {
            URL urlObj = new URL(br.com.iagofragnan.settings.api.getApiURL() + "listar/ranking");
            HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                StringBuilder sb = new StringBuilder();
                Scanner scanner = new Scanner(connection.getInputStream());
                while (scanner.hasNext()) {
                    sb.append(scanner.nextLine());
                }
                System.out.println(sb);

            } else {
                System.out.println("Error in sending a GET request");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

    public static void getTopOne() {
        try {
            URL urlObj = new URL(br.com.iagofragnan.settings.api.getApiURL() + "listar/top");
            HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                StringBuilder sb = new StringBuilder();
                Scanner scanner = new Scanner(connection.getInputStream());
                while (scanner.hasNext()) {
                    sb.append(scanner.nextLine());
                }
                System.out.println(sb);

            } else {
                System.out.println("Error in sending a GET request");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

}
