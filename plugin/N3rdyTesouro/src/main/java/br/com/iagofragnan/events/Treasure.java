package br.com.iagofragnan.events;

import br.com.iagofragnan.arduino;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Treasure implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public int DetectTreasure(PlayerMoveEvent e){
        Player p = e.getPlayer();


        if(!arduino.ArduinoIsWorking) return 0;



        Bukkit.getScheduler().scheduleSyncDelayedTask(br.com.iagofragnan.main.getThePlugin(), new Runnable() {
            public void run() {

            }
        }, 20L);
        return 0;
    }

    public void CalcDistance(double dist){




    }

}
