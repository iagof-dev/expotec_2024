package br.com.iagofragnan.events;

import br.com.iagofragnan.controller.game;
import br.com.iagofragnan.main;
import br.com.iagofragnan.models.arduino;
import br.com.iagofragnan.models.player;
import br.com.iagofragnan.controller.scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import static br.com.iagofragnan.controller.scoreboard.createScoreboard;
import static br.com.iagofragnan.models.player.getPlayerObj;

public class onTick {


    public static void OnTickEvent(){
        Player p = player.getPlayerObj();

        if(game.isPlaying()) scoreboard.updatePlayingScoreboard(p);

        if(!arduino.isWorking || !(game.isPlaying()) || player.getPlayerObj() == null) return;

        int radius = 40; //OG: 60

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
