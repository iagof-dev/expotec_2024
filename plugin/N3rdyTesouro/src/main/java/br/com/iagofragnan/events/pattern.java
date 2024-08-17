package br.com.iagofragnan.events;

import br.com.iagofragnan.main;
import br.com.iagofragnan.models.arduino;
import br.com.iagofragnan.models.player;
import br.com.iagofragnan.models.scoreboard.states;
import org.bukkit.Bukkit;
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
import org.bukkit.scheduler.BukkitRunnable;


public class pattern implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        player.setPlayerObj(e.getPlayer());
        new BukkitRunnable(){
            public void run(){
                br.com.iagofragnan.controller.scoreboard sb = new br.com.iagofragnan.controller.scoreboard();
                sb.createScoreboard(e.getPlayer(), br.com.iagofragnan.models.scoreboard.states.Idle);
            }
        }.runTaskLater(br.com.iagofragnan.main.getThePlugin(), 20L);

        player.setWorld(e.getPlayer().getWorld());
        e.getPlayer().getInventory().clear();
        e.getPlayer().setGameMode(GameMode.SURVIVAL);
        e.getPlayer().setFoodLevel(100);
        e.setJoinMessage("");
        e.getPlayer().getInventory().clear();
        e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), 0, 67, 0, 0, 0));

        br.com.iagofragnan.controller.hologram hl = new br.com.iagofragnan.controller.hologram();
        hl.createRanking();

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

        if(byblock.getType() == Material.SAND){
            e.setCancelled(false);
            return;
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void PlayerCommands(PlayerCommandPreprocessEvent e){

        //
        //      TIRAR COMENTARIO NO DIA DA EXPOTEC
        //

        //e.setCancelled(true);

        //e.getPlayer().sendMessage(ChatColor.RED + "Erro! " + ChatColor.WHITE + "Voc\u00ea n\u00e3o tem permiss\u00e3o usar de comandos.");
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
