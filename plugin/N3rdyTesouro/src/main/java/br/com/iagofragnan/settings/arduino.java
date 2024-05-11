package br.com.iagofragnan.settings;

public class arduino {

    private static String portCom;

    public static String getPortCom() {
        return portCom;
    }

    public static void setPortCom(String newPortCom) {
        portCom = newPortCom;
    }
}
