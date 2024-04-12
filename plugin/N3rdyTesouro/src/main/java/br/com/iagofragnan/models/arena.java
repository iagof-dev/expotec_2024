package br.com.iagofragnan.models;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static br.com.iagofragnan.models.player.*;

public class arena {

    // Max world coords to create arena limit
    static int Max_X = 999999;
    static int Max_Y = 64;
    static int Max_Z = 999999;

    //Size of the arena
    static int size_x = 40;
    static int size_y = 13;
    static int size_z = 40;

    private static Location Arena_StartPOS;
    private static Location Arena_EndPOS;


    public static void CreateArena(){
        Player p = player.getPlayerObj();
        p.resetTitle();
        if(p.hasPotionEffect(PotionEffectType.SPEED)){
            p.removePotionEffect(PotionEffectType.SPEED);
        }
        p.sendTitle("Gerando arena", "Aguarde estamos criando uma arena", 5, 5, 5);

        p.getInventory().clear();
        ItemStack shovel = new ItemStack(Material.DIAMOND_SPADE, 1);
        shovel.addEnchantment(Enchantment.DIG_SPEED, 1);
        shovel.addEnchantment(Enchantment.DURABILITY, 3);
        p.getInventory().addItem(shovel);

        Random rnd = new Random();
        Location randomLocation = new Location(player.getWorld(),rnd.nextInt(0, Max_X), Max_Y, rnd.nextInt(0, Max_Z), 1, 1);

        //Generate random chest by randomLocation
        int chestRandomSeed_X = rnd.nextInt((randomLocation.getBlockX() + 1), (randomLocation.getBlockX() + size_x) - 1);
        int chestRandomSeed_Y = rnd.nextInt((Max_Y + 1) , (Max_Y + 5));
        int chestRandomSeed_Z = rnd.nextInt((randomLocation.getBlockZ() + 1), (randomLocation.getBlockZ() + size_z) - 1);


        setArena_StartPOS(randomLocation);

        for (int k = randomLocation.getBlockY(); k < (randomLocation.getBlockY() + size_y); k++) {
            for (int i = randomLocation.getBlockX(); i < (randomLocation.getBlockX() + size_x); i++) {
                for (int j = randomLocation.getBlockZ(); j < (randomLocation.getBlockZ() + size_z); j++) {
                    Location placeBlock = new Location(player.getWorld(), i, k, j);

                    //SE Y FOR 64 (BASE)
                    if(k == Max_Y){
                        placeBlock.getBlock().setType(Material.BARRIER);
                    }
                    if(k > Max_Y && k <= (Max_Y + 5)){
                        if (i == randomLocation.getBlockX() || i == (randomLocation.getBlockX() + size_x - 1) || j == randomLocation.getBlockZ() || j == (randomLocation.getBlockZ() + size_z - 1)) {
                            placeBlock.getBlock().setType(Material.BARRIER);
                        } else {
                            placeBlock.getBlock().setType(Material.SAND);
                        }
                    }
                    if(k > (Max_Y + 5) && k <= (Max_Y + 8)){
                        if (i == randomLocation.getBlockX() || i == (randomLocation.getBlockX() + size_x - 1) || j == randomLocation.getBlockZ() || j == (randomLocation.getBlockZ() + size_z - 1)) {
                            placeBlock.getBlock().setType(Material.BARRIER);
                            setArena_EndPOS(placeBlock);

                        }
                        else{
                            placeBlock.getBlock().setType(Material.AIR);
                        }
                    }
                }
            }
        }

        //Setting up the chest
        Location chest = new Location(getWorld(), chestRandomSeed_X, chestRandomSeed_Y, chestRandomSeed_Z);
        chest.getBlock().setType(Material.CHEST);

        //      debug
        Bukkit.getConsoleSender().sendMessage("Arena gerada em X: " + randomLocation.getX() + ", Y: " + randomLocation.getY() + ", Z: " + randomLocation.getZ());
        Location TeleportLocation = new Location(player.getWorld(), randomLocation.getX() + size_x / 2.0, Max_Y + 7, randomLocation.getZ() + size_z / 2.0);
        p.teleport(TeleportLocation);
    }


    public static void DeleteLastArena(){
        try{
            Bukkit.getConsoleSender().sendMessage("Deletando arena antiga...");
            Player p = player.getPlayerObj();
            p.getInventory().clear();
            for (int k = getArena_StartPOS().getBlockY(); k <= getArena_EndPOS().getBlockY(); k++) {
                for (int i = getArena_StartPOS().getBlockX(); i <= getArena_EndPOS().getBlockX(); i++) {
                    for (int j = getArena_StartPOS().getBlockZ(); j <= getArena_EndPOS().getBlockZ(); j++) {
                        Location remove = new Location(player.getWorld(), i, k, j);
                        Material blockType = remove.getBlock().getType();
                        remove.getBlock().setType(Material.AIR);
                    }
                }
            }
        }
        finally{
            Bukkit.getConsoleSender().sendMessage("Arena deletada.");
        }

    }



    public static Location getArena_StartPOS() {
        return Arena_StartPOS;
    }

    public static void setArena_StartPOS(Location arena_StartPOS) {
        Arena_StartPOS = arena_StartPOS;
    }

    public static Location getArena_EndPOS() {
        return Arena_EndPOS;
    }

    public static void setArena_EndPOS(Location arena_EndPOS) {
        Arena_EndPOS = arena_EndPOS;
    }
}
