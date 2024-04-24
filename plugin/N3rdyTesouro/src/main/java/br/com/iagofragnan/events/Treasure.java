package br.com.iagofragnan.events;

import br.com.iagofragnan.models.arena;
import br.com.iagofragnan.models.player;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class treasure implements Listener {


    static Boolean isFound = false;

    public static void setIsFound(Boolean value){
        isFound = value;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void InteractChest(PlayerInteractEvent e) {

        if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK) || !(e.getAction() == Action.LEFT_CLICK_BLOCK) && !(e.getClickedBlock().getType() == Material.CHEST)) return;

        if(isFound) return;

        setIsFound(true);

        Player p = player.getPlayerObj();

        Location loc = new Location(p.getWorld(), e.getClickedBlock().getX(), e.getClickedBlock().getY() + 1, e.getClickedBlock().getZ());


        p.sendTitle(ChatColor.GREEN + "BOA!", "Voc\u00ea encontrou o ba\u00fa! (0:00:00)", 10, 30, 10);
        e.getPlayer().playSound(p.getLocation(), Sound.BLOCK_NOTE_HARP, 1f, 1f);
        p.spawnParticle(Particle.VILLAGER_HAPPY, loc, 10);

        Bukkit.getScheduler().scheduleSyncDelayedTask(br.com.iagofragnan.main.getThePlugin(), new Runnable() {
        public void run() {
            arena.DeleteLastArena();
            arena.CreateArena();
        }}, 30L);


        e.setCancelled(true);

    }

}
