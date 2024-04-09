package br.com.iagofragnan.events;

import br.com.iagofragnan.models.player;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Pattern implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        player.setObj_player(e.getPlayer());
        player.setObj_world(e.getPlayer().getWorld());
        e.getPlayer().getInventory().clear();
        e.getPlayer().setGameMode(GameMode.SURVIVAL);
        e.getPlayer().setFoodLevel(100);
        e.setJoinMessage("");
        e.getPlayer().getInventory().clear();
        e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), 0, 67, 0, 0, 0));
    }

    @EventHandler
    public void PlayerHunger(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        e.setQuitMessage("");
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void EntityDamage(EntityDamageEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void PlayerBuild(BlockDamageEvent e){
        if(e.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        Block byblock = e.getBlock();
        switch(byblock.getType()){
            case SAND:
                e.setCancelled(false);
                break;
            default:
                e.setCancelled(true);
                break;
        }
    }

    @EventHandler
    public void PlayerCommands(PlayerCommandPreprocessEvent e){

        //
        //      DESCOMENTAR NO DIA DA EXPOTEC
        //

        //e.setCancelled(true);
    }

    @EventHandler
    public void PlayerDrop(PlayerDropItemEvent e){
        if(e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SPADE){
            e.setCancelled(true);
        }

    }
    @EventHandler
    public void ItemsDropped(ItemSpawnEvent e){
        e.getEntity().remove();
    }

}
