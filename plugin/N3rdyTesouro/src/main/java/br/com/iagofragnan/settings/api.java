package br.com.iagofragnan.settings;

public class api {
    private static boolean apiEnable;
    private static String apiURL;


    public static boolean isApiEnabled() {
        return apiEnable;
    }

    public static void setApiEnable(boolean value) {
        apiEnable = value;
    }

    public static String getApiURL() {
        return apiURL;
    }

    public static void setApiURL(String value) {
        apiURL = value;
    }
}
