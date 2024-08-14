package br.com.iagofragnan.models;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class hologram {

    static Hologram hologram;
    static String hologram_name = "ranking";
    static Location hologram_loc = new Location(br.com.iagofragnan.models.player.getWorld(), 0, 67 ,0);

    public static void create(){
        if(DHAPI.getHologram(hologram_name) != null)
        {
            hologram = DHAPI.getHologram(hologram_name);
            return;
        }

        DHAPI.createHologram(hologram_name, hologram_loc);
        DHAPI.addHologramLine(hologram, 0, "Ranking");
        Bukkit.getConsoleSender().sendMessage("N3rdy Tesouro | Holograma de Ranking criado!");
    }


    public static void insert(String line){
        DHAPI.addHologramLine(hologram, line);
    }

    public static void delete(){
        hologram.delete();
    }



}
