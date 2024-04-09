package br.com.iagofragnan.models;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.Random;

import static br.com.iagofragnan.models.player.getObj_player;
import static br.com.iagofragnan.models.player.getObj_world;

public class arena {

    private static Location Arena_StartPOS;
    private static Location Arena_EndPOS;


    public static void CreateArena(){
        //MAX Random Location
        int Max_X = 999999;
        int Max_Y = 64;
        int Max_Z = 999999;
        Random rnd = new Random();
        Location RandomLocation = new Location(player.getObj_world(),rnd.nextInt(0, Max_X), Max_Y, rnd.nextInt(0, Max_Z), 1, 1);


        //Size of the arena
        int size_x = 40;
        int size_y = 13;
        int size_z = 40;

        //Generate random chest by RandomLocation
        int ChestRandomSeed_X = rnd.nextInt(RandomLocation.getBlockX(), RandomLocation.getBlockX() + size_x);
        int ChestRandomSeed_Y = rnd.nextInt(Max_Y, Max_Y + 5);
        int ChestRandomSeed_Z = rnd.nextInt(RandomLocation.getBlockZ(), RandomLocation.getBlockZ() + size_z);


        for (int k = RandomLocation.getBlockY(); k < (RandomLocation.getBlockY() + size_y); k++) {
            for (int i = RandomLocation.getBlockX(); i < (RandomLocation.getBlockX() + size_x); i++) {
                for (int j = RandomLocation.getBlockZ(); j < (RandomLocation.getBlockZ() + size_z); j++) {
                    Location PlaceBlock = new Location(player.getObj_world(), i, k, j);

                    //SE Y FOR 64 (BASE)
                    if(k == Max_Y){
                        PlaceBlock.getBlock().setType(Material.BARRIER);
                    }
                    if(k > Max_Y && k <= (Max_Y + 5)){
                        if (i == RandomLocation.getBlockX() || i == (RandomLocation.getBlockX() + size_x - 1) || j == RandomLocation.getBlockZ() || j == (RandomLocation.getBlockZ() + size_z - 1)) {
                            PlaceBlock.getBlock().setType(Material.BARRIER);
                            setArena_StartPOS(PlaceBlock);
                        } else {
                            PlaceBlock.getBlock().setType(Material.SAND);
                        }
                    }
                    if(k > (Max_Y + 5) && k <= (Max_Y + 8)){
                        if (i == RandomLocation.getBlockX() || i == (RandomLocation.getBlockX() + size_x - 1) || j == RandomLocation.getBlockZ() || j == (RandomLocation.getBlockZ() + size_z - 1)) {
                            PlaceBlock.getBlock().setType(Material.BARRIER);
                            setArena_EndPOS(PlaceBlock);
                        }
                        else{
                            PlaceBlock.getBlock().setType(Material.AIR);
                        }
                    }
                }
            }
        }


        //Setting up the chest
        Location chest = new Location(getObj_world(), ChestRandomSeed_X, ChestRandomSeed_Y, ChestRandomSeed_Z);
        chest.getBlock().setType(Material.CHEST);

        //      [debug]
        Bukkit.getConsoleSender().sendMessage("Arena gerada em X: " + RandomLocation.getX() + ", Y: " + RandomLocation.getY() + ", Z: " + RandomLocation.getZ());
        Bukkit.getConsoleSender().sendMessage("Bau definido em X: " + chest.getX() + ", Y: " + chest.getY() + ", Z: " + chest.getZ());

        Location TeleportLocation = new Location(player.getObj_world(), (RandomLocation.getX() + (RandomLocation.getX() + Max_X))/2, Max_Y, (RandomLocation.getZ() + (RandomLocation.getZ() + Max_Z))/2);
        getObj_player().teleport(TeleportLocation);
    }


    public static void DeleteLastArena(){
        Bukkit.getConsoleSender().sendMessage("Tentando deletar arena antiga");
        for (int k = getArena_StartPOS().getBlockY(); k < getArena_EndPOS().getBlockY(); k++) {
                for (int i = getArena_StartPOS().getBlockX(); i < getArena_EndPOS().getBlockX(); i++) {
                        for (int j = getArena_StartPOS().getBlockZ(); j < getArena_EndPOS().getBlockZ(); j++) {
                            Location remove = new Location(player.getObj_world(), i, k, j);
                            remove.getBlock().setType(Material.AIR);
                        } 
                }
        }
        Bukkit.getConsoleSender().sendMessage("Função finalizada");
        
    }



    public Location getArena_StartPOS() {
        return Arena_StartPOS;
    }

    public static void setArena_StartPOS(Location arena_StartPOS) {
        Arena_StartPOS = arena_StartPOS;
    }

    public Location getArena_EndPOS() {
        return Arena_EndPOS;
    }

    public static void setArena_EndPOS(Location arena_EndPOS) {
        Arena_EndPOS = arena_EndPOS;
    }
}
