package br.com.iagofragnan.events;

import br.com.iagofragnan.models.arena;
import br.com.iagofragnan.models.player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Treasure implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void InteractChest(PlayerInteractEvent e) {

        if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK) || !(e.getAction() == Action.LEFT_CLICK_BLOCK) && !(e.getClickedBlock().getType() == Material.CHEST)) return;

        Player p = player.getPlayerObj();

        p.sendTitle(ChatColor.GREEN + "BOA!", "Voc\u00ea encontrou o ba\u00fa! (0:00:00)", 10, 30, 10);


        Bukkit.getScheduler().scheduleSyncDelayedTask(br.com.iagofragnan.main.getThePlugin(), new Runnable() {
        public void run() {
            arena.DeleteLastArena();
            arena.CreateArena();
        }}, 30L);


        e.setCancelled(true);

    }

}
