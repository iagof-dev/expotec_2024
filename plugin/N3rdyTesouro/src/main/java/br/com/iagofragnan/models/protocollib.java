package br.com.iagofragnan.models;

import com.comphenix.protocol.ProtocolManager;

public class protocollib {
    private static ProtocolManager protocolManager;

    public static ProtocolManager getProtocolManager() {
        return protocolManager;
    }

    public static void setProtocolManager(ProtocolManager newPM) {
        protocolManager = newPM;
    }
}
