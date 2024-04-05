package br.com.iagofragnan;

import com.fazecast.jSerialComm.*;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import br.com.iagofragnan.arduino;
public class main extends JavaPlugin implements Listener {

    @EventHandler
    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage("§aN3rdyTesouro | Inicializado!");

        arduino.GetAllPorts();


    }
    @EventHandler
    public void onLoad(){
        Bukkit.getConsoleSender().sendMessage("§eN3rdyTesouro | Carregando...");
    }
}
