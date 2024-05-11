<<<<<<< HEAD:plugin/N3rdyTesouro/src/main/java/br/com/iagofragnan/events/OnTick.java
package br.com.iagofragnan.events;

import br.com.iagofragnan.controller.game;
import br.com.iagofragnan.models.arduino;
import br.com.iagofragnan.models.player;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class onTick {


    public static void OnTickEvent(){


        if(!arduino.isWorking || !game.isPlaying() || player.getPlayerObj() == null) return;


        Player p = player.getPlayerObj();
        int radius = 60;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    Block block = p.getWorld().getBlockAt(p.getLocation().add(x, y, z));
                    if (block.getType() == Material.CHEST) {
                        double distance = p.getLocation().distance(block.getLocation());
                        arduino.SendSignalByDistance(distance);
                    }
                }
            }
        }

    }

}
=======
package br.com.iagofragnan.events;

import br.com.iagofragnan.models.arduino;
import br.com.iagofragnan.models.player;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class onTick {

    public static void OnTickEvent(){


        if(player.getPlayerObj() == null) return;
        if(!arduino.isWorking) return;

        Player p = player.getPlayerObj();
        int radius = 65;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    Block block = p.getWorld().getBlockAt(p.getLocation().add(x, y, z));
                    if (block.getType() == Material.CHEST) {
                        double distance = p.getLocation().distance(block.getLocation());
                        arduino.SendSignalByDistance(distance);
                    }
                }
            }
        }

    }

}
>>>>>>> 1b13af6f01d7e8715a26ffe1599171301399c2db:plugin/N3rdyTesouro/src/main/java/br/com/iagofragnan/events/onTick.java
