package br.com.iagofragnan;


import com.fazecast.jSerialComm.SerialPort;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class arduino {

    static SerialPort porta;
    static String PortCOM = "COM4";

    static boolean OpenPort = false;

    static boolean LED_red = false;

    static OutputStream SerialOut;

    public static boolean VerifyConnection(){
        porta = SerialPort.getCommPort(PortCOM);
        boolean result = porta.openPort();
        if (result){
            SerialOut = porta.getOutputStream();
            Bukkit.getConsoleSender().sendMessage("§b ARDUINO | Porta conexão estabilizada.");
            OpenPort = true;
            return true;
        }

        Bukkit.getConsoleSender().sendMessage("§d ARDUINO | Erro! não há conexão com porta serial");
        return false;
    }

    public static void SendSignal(int distance){

        try {
            if(!LED_red){
                SerialOut.write("T".getBytes());
                SerialOut.flush();
                LED_red = true;
            }
            else{
                SerialOut.write("DA".getBytes());
                SerialOut.flush();
                LED_red = false;
            }

            Bukkit.getConsoleSender().sendMessage(SerialOut.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            Bukkit.getConsoleSender().sendMessage("Ccomando Finalizado");
        }


    }




}
