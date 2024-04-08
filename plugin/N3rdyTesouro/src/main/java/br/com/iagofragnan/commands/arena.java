package br.com.iagofragnan.commands;

import br.com.iagofragnan.models.player;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

import static br.com.iagofragnan.models.player.getObj_player;
import static br.com.iagofragnan.models.player.getObj_world;


public class arena implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        Player p = (Player) sender;

        int Max_X = 999999;
        int Max_Y = 64;
        int Max_Z = 999999;

        Random rnd = new Random();
        Location RandomLocation = new Location(player.getObj_world(),rnd.nextInt(0, Max_X), Max_Y, rnd.nextInt(0, Max_Z), 1, 1);


        int size_x = 40;
        int size_y = 13;
        int size_z = 40;

        int ChestRandomSeed_X = rnd.nextInt(RandomLocation.getBlockX(), RandomLocation.getBlockX() + size_x);
        int ChestRandomSeed_Y = rnd.nextInt(Max_Y, Max_Y + 5);
        int ChestRandomSeed_Z = rnd.nextInt(RandomLocation.getBlockZ(), RandomLocation.getBlockZ() + size_z);


        for (int k = RandomLocation.getBlockY(); k < (RandomLocation.getBlockY() + size_y); k++) {
            for (int i = RandomLocation.getBlockX(); i < (RandomLocation.getBlockX() + size_x); i++) {
                for (int j = RandomLocation.getBlockZ(); j < RandomLocation.getBlockZ() + size_z; j++) {
                    Location PlaceBlock = new Location(player.getObj_world(), i, k, j);

                    //SE Y FOR 64 (BASE)
                    if(k == 64){
                        PlaceBlock.getBlock().setType(Material.BARRIER);
                    }
                    else if(k > 64 && k <= 69){
                        if (i == RandomLocation.getBlockX() || i == (RandomLocation.getBlockX() + size_x)) {
                            PlaceBlock.getBlock().setType(Material.BARRIER);
                        } else {
                            PlaceBlock.getBlock().setType(Material.SAND);
                        }
                    }
                    else if(k >= 70 && k <= 77){
                        if (i == RandomLocation.getBlockX() || i == (RandomLocation.getBlockX() + size_x) || j == RandomLocation.getBlockZ() || j == (RandomLocation.getBlockZ() + size_z)) {
                                PlaceBlock.getBlock().setType(Material.BARRIER);
                        }
                        else{
                            PlaceBlock.getBlock().setType(Material.AIR);
                        }
                    }
                }
            }
        }


        Location chest = new Location(getObj_world(), ChestRandomSeed_X, ChestRandomSeed_Y, ChestRandomSeed_Z);
        chest.getBlock().setType(Material.CHEST);


        Bukkit.getConsoleSender().sendMessage("Arena gerada em X: " + RandomLocation.getX() + ", Y: " + RandomLocation.getY() + ", Z: " + RandomLocation.getZ());
        Bukkit.getConsoleSender().sendMessage("Bau definido em X: " + chest.getX() + ", Y: " + chest.getY() + ", Z: " + chest.getZ());

        Location TeleportLocation = new Location(player.getObj_world(), (RandomLocation.getX() + (RandomLocation.getX() + Max_X))/2, Max_Y, (RandomLocation.getZ() + (RandomLocation.getZ() + Max_Z))/2);
        getObj_player().teleport(TeleportLocation);


        return false;
    }
}
