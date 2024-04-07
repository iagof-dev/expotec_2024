package br.com.iagofragnan;


import com.fazecast.jSerialComm.SerialPort;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class arduino {

    static SerialPort porta;
    static String PortCOM = "COM4";

    public static boolean ArduinoIsWorking = false;
    HashMap<String, String> signals = new HashMap<>();
    static OutputStream SerialOut;


    public static boolean VerifyConnection(){
        porta = SerialPort.getCommPort(PortCOM);
        boolean result = porta.openPort();
        if (result){
            SerialOut = porta.getOutputStream();
            Bukkit.getConsoleSender().sendMessage("§b ARDUINO | Porta conex\u00e3o estabilizada.");
            ArduinoIsWorking = true;
            return true;
        }

        Bukkit.getConsoleSender().sendMessage("§d ARDUINO | Erro! n\u00e3o há conex\u00e3o com porta serial");
        return false;
    }

    public static void SendSignal(String value){

        if(!ArduinoIsWorking){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Arduino n\u00e3o encontrado/configurado, pulando funç\u00e3o...");
            for(Player players : Bukkit.getServer().getOnlinePlayers())
                players.sendTitle(ChatColor.RED + "Arduino n\u00e3o configurado", "Por favor verifique e reinicie o servidor", 5, 200, 5);
            return;
        }

        try {
            SerialOut.write(value.getBytes());
            SerialOut.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            //Bukkit.getConsoleSender().sendMessage("Arduino Finalizado");
        }


    }

    public static void TestDevice(){
        String signal = "Z";
        Bukkit.getConsoleSender().sendMessage("Testando dispositivo na porta " + PortCOM);
        SendSignal(signal);
        Bukkit.getConsoleSender().sendMessage("Teste finalizado.");


    }




}
