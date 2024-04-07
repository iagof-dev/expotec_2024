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
    public void DetectTreasure(PlayerMoveEvent e){
        Player p = e.getPlayer();


        if(!arduino.ArduinoIsWorking) return;


        int radius = 50;

        Bukkit.getScheduler().scheduleSyncDelayedTask(br.com.iagofragnan.main.getThePlugin(), new Runnable() {
            public void run() {
                    for (int x = -radius; x <= radius; x++) {
                        for (int y = -radius; y <= radius; y++) {
                            for (int z = -radius; z <= radius; z++) {
                                Block block = p.getWorld().getBlockAt(p.getLocation().add(x, y, z));
                                if (block.getType() == Material.CHEST) {
                                    double distance = p.getLocation().distance(block.getLocation());
                                    String signal = "A";
                                    if(distance <=1){
                                        //W
                                        signal = "W";
                                    }
                                    if(distance > 1 && distance <= 3){
                                        //S
                                        signal = "S";
                                    }
                                    if(distance > 3 && distance <= 7){
                                        //C
                                        signal = "C";
                                    }
                                    if(distance > 7 && distance <= 12){
                                        //M
                                        signal = "M";
                                    }
                                    if(distance > 12 && distance <= 25){
                                        //F
                                        signal = "F";
                                    }
                                    if(distance > 25){
                                        signal = "D";
                                    }

                                    arduino.SendSignal(signal);

                                    break;
                                }
                            }
                        }
                    }
            }
        }, 20L);

    }

    public void CalcDistance(double dist){




    }

}
