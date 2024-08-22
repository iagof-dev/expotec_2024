package br.com.iagofragnan.models;

import com.fazecast.jSerialComm.SerialPort;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import static br.com.iagofragnan.models.player.*;

public class arduino {
    static SerialPort porta;
    static String PortCOM = br.com.iagofragnan.settings.arduino.getPortCom();
    public static boolean isWorking = false;
    HashMap<String, String> signals = new HashMap<>();
    static OutputStream SerialOut;

    public static boolean VerifyConnection(){
        porta = SerialPort.getCommPort(PortCOM);
        boolean result = porta.openPort();
        if (result){
            SerialOut = porta.getOutputStream();
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "ARDUINO | Conex\u00e3o estabilizada ("+ PortCOM +").");
            isWorking = true;
        }
        else
            Bukkit.getConsoleSender().sendMessage( ChatColor.RED + "ARDUINO | Erro! n\u00e3o h\u00e1 conex\u00e3o com porta serial ("+ PortCOM +")");
        return isWorking;
    }

    public static void SendSignal(String value){
        if(!isWorking){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Arduino n\u00e3o encontrado/configurado, pulando fun\u00e7\u00e3o...");
                if(getPlayerObj() != null)
                    getPlayerObj().sendTitle(ChatColor.RED + "Arduino n\u00e3o configurado", "Por favor verifique e reinicie o servidor", 5, 200, 5);
            return;
        }
        try {
            SerialOut.write(value.getBytes());
            SerialOut.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void TestDevice(){
        String signal = "Z";
        Bukkit.getConsoleSender().sendMessage("Testando dispositivo (" + PortCOM + ").");
        SendSignal(signal);
        Bukkit.getConsoleSender().sendMessage("Teste finalizado.");
    }

    public static String last_cmd = "A";
    public static void SendSignalByDistance(double distance){
        String signal = "A";
        if(distance <=1){
            //W = WIN
            signal = "W";
        }
        if(distance > 1 && distance <= 5){
            //S = SO CLOSE
            signal = "S";
        }
        if(distance > 5 && distance <= 8){
            //C = CLOSE
            signal = "C";
        }
        if(distance > 9 && distance <= 12){
            //M = MEDIUM
            signal = "M";
        }
        if(distance > 12 && distance <= 25){
            //F = FAR
            signal = "F";
        }
        if(distance > 25){
            //D = DISABLE ALL
            signal = "D";
        }

        if(last_cmd.equals(signal)) return;

        last_cmd = signal;
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "DEBUG | Enviando sinal (" + signal + ")");
        arduino.SendSignal(signal);
    }




}
