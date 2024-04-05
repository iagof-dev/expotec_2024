package br.com.iagofragnan;


import com.fazecast.jSerialComm.*;
import org.bukkit.Bukkit;

public class arduino {

    public static void GetAllPorts(){
        //SerialPort[] ports = SerialPort.getCommPorts();
        //System.out.println("Todas as portas:\n" + ports.toString());

        SerialPort port = SerialPort.getCommPort("COM4");
        port.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
        port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (port.openPort()){
            Bukkit.getConsoleSender().sendMessage("§b ARDUINO | Porta esta aberta e conectada.");
        }
        if (!port.openPort()){
            Bukkit.getConsoleSender().sendMessage("§d ARDUINO | Erro! não há conexão com porta serial");
        }


    }




}
