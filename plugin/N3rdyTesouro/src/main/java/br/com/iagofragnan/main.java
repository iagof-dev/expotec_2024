<<<<<<< HEAD
package br.com.iagofragnan;

import br.com.iagofragnan.commands.signal;
import br.com.iagofragnan.events.pattern;
import br.com.iagofragnan.events.onTick;
import br.com.iagofragnan.events.treasure;
import br.com.iagofragnan.models.arduino;
import br.com.iagofragnan.settings.mysql;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;



import static br.com.iagofragnan.settings.arduino.*;

public class main extends JavaPlugin implements Listener {


    FileConfiguration config = getConfig();


    static Plugin plugin;
    @EventHandler
    public void onEnable(){
        plugin = this;
        setPortCom(config.getString("arduino.port"));


        if(config.getBoolean("mysql.enable")){
            Bukkit.getConsoleSender().sendMessage("N3rdyTesouro | MySql est\u00e1 ativado nas configura\u00e7\u00d5es");
            mysql.setEnabled(true);
            mysql.setAddress(config.getString("mysql.address"));
            mysql.setPort(config.getInt("mysql.port"));
            mysql.setUser(config.getString("mysql.user"));
            mysql.setPass(config.getString("mysql.pass"));
            mysql.setDatabase(config.getString("mysql.database"));
            mysql.setTable(config.getString("mysql.table"));
        }


        Bukkit.getConsoleSender().sendMessage("N3rdyTesouro |" + ChatColor.GREEN + "Inicializado!");
        Bukkit.getServer().getWorld("world").setStorm(false);
        Bukkit.getServer().getWorld("world").setTime(3000);

        getServer().getPluginManager().registerEvents(new pattern(), this);
        getServer().getPluginManager().registerEvents(new treasure(), this);

        arduino.VerifyConnection();
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            public void run() {
                arduino.TestDevice();
            }
        }, 40L);

        new BukkitRunnable(){
            @Override
            public void run(){
                onTick.OnTickEvent();
            }
        }.runTaskTimer(this, 0L, 5L); //15L

        this.getCommand("end").setExecutor(new br.com.iagofragnan.commands.end());
        this.getCommand("arena").setExecutor(new br.com.iagofragnan.commands.arena());
        this.getCommand("distance").setExecutor(new br.com.iagofragnan.commands.distance());
        this.getCommand("test").setExecutor(new br.com.iagofragnan.commands.test());
        this.getCommand("signal").setExecutor(new signal());
        this.getCommand("start").setExecutor(new br.com.iagofragnan.commands.start());
        this.getCommand("timer").setExecutor(new br.com.iagofragnan.commands.timer());
    }
    @EventHandler
    public void onLoad(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "N3rdyTesouro | Carregando configura\u00e7\u00d5es...");
        br.com.iagofragnan.models.protocollib.setProtocolManager(ProtocolLibrary.getProtocolManager());
        config.addDefault("arduino.port", "COM1");
        config.addDefault("mysql.enable", false);
        config.addDefault("mysql.address", "127.0.0.1");
        config.addDefault("mysql.user", "root");
        config.addDefault("mysql.pass", "123");
        config.addDefault("mysql.port", 3306);
        config.addDefault("mysql.database", "N3rdyTesouro");
        config.addDefault("mysql.table", "Jogadores");
        config.options().copyDefaults(true);
        saveConfig();




    }

    public static Plugin getThePlugin(){
        return plugin;
    }

}
=======
package br.com.iagofragnan;

import br.com.iagofragnan.commands.signal;
import br.com.iagofragnan.events.pattern;
import br.com.iagofragnan.events.onTick;
import br.com.iagofragnan.events.treasure;
import br.com.iagofragnan.models.arduino;
import br.com.iagofragnan.settings.mysql;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;



import static br.com.iagofragnan.settings.arduino.*;

public class main extends JavaPlugin implements Listener {


    FileConfiguration config = getConfig();


    static Plugin plugin;
    @EventHandler
    public void onEnable(){
        plugin = this;
        setPortCom(config.getString("arduino.port"));


        if(config.getBoolean("mysql.enable")){
            Bukkit.getConsoleSender().sendMessage("N3rdyTesouro | MySql est\u00e1 ativado nas configura\u00e7\u00d5es");
            mysql.setEnabled(true);
            mysql.setAddress(config.getString("mysql.address"));
            mysql.setPort(config.getInt("mysql.port"));
            mysql.setUser(config.getString("mysql.user"));
            mysql.setPass(config.getString("mysql.pass"));
            mysql.setDatabase(config.getString("mysql.database"));
            mysql.setTable(config.getString("mysql.table"));
        }


        Bukkit.getConsoleSender().sendMessage("N3rdyTesouro |" + ChatColor.GREEN + "Inicializado!");
        Bukkit.getServer().getWorld("world").setStorm(false);
        Bukkit.getServer().getWorld("world").setTime(3000);

        getServer().getPluginManager().registerEvents(new pattern(), this);
        getServer().getPluginManager().registerEvents(new treasure(), this);

        arduino.VerifyConnection();
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            public void run() {
                arduino.TestDevice();
            }
        }, 40L);

        new BukkitRunnable(){
            @Override
            public void run(){
                onTick.OnTickEvent();
            }
        }.runTaskTimer(this, 0L, 5L);

        this.getCommand("end").setExecutor(new br.com.iagofragnan.commands.end());
        this.getCommand("arena").setExecutor(new br.com.iagofragnan.commands.arena());
        this.getCommand("test").setExecutor(new br.com.iagofragnan.commands.test());
        this.getCommand("signal").setExecutor(new signal());
        this.getCommand("start").setExecutor(new br.com.iagofragnan.commands.start());
        this.getCommand("timer").setExecutor(new br.com.iagofragnan.commands.timer());
    }
    @EventHandler
    public void onLoad(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "N3rdyTesouro | Carregando configura\u00e7\u00d5es...");
        br.com.iagofragnan.models.protocollib.setProtocolManager(ProtocolLibrary.getProtocolManager());
        config.addDefault("arduino.port", "COM1");
        config.addDefault("mysql.enable", false);
        config.addDefault("mysql.address", "127.0.0.1");
        config.addDefault("mysql.user", "root");
        config.addDefault("mysql.pass", "123");
        config.addDefault("mysql.port", 3306);
        config.addDefault("mysql.database", "N3rdyTesouro");
        config.addDefault("mysql.table", "Jogadores");
        config.options().copyDefaults(true);
        saveConfig();




    }

    public static Plugin getThePlugin(){
        return plugin;
    }

}
>>>>>>> 1b13af6f01d7e8715a26ffe1599171301399c2db
