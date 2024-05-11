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
