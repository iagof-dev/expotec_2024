package br.com.iagofragnan;

import com.fazecast.jSerialComm.*;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import br.com.iagofragnan.arduino;
public class main extends JavaPlugin implements Listener {


    static Plugin plugin;
    @EventHandler
    public void onEnable(){
        plugin = this;
        Bukkit.getConsoleSender().sendMessage("§aN3rdyTesouro | Inicializado!");
        Bukkit.getServer().getWorld("world").setStorm(false);
        Bukkit.getServer().getWorld("world").setTime(3000);

        getServer().getPluginManager().registerEvents(new br.com.iagofragnan.events.pattern(), this);
        getServer().getPluginManager().registerEvents(new br.com.iagofragnan.events.Treasure(), this);

        arduino.VerifyConnection();
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            public void run() {
                arduino.TestDevice();
            }
        }, 40L);

        this.getCommand("arena").setExecutor(new br.com.iagofragnan.commands.arena());
        this.getCommand("test").setExecutor(new br.com.iagofragnan.commands.test());
        this.getCommand("debug").setExecutor(new br.com.iagofragnan.commands.debug());
        this.getCommand("start").setExecutor(new br.com.iagofragnan.commands.start());


    }
    @EventHandler
    public void onLoad(){
        Bukkit.getConsoleSender().sendMessage("§eN3rdyTesouro | Carregando...");
    }

    public static Plugin getThePlugin(){
        return plugin;
    }

}
