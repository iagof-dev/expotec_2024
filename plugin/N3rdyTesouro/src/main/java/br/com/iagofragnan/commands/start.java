package br.com.iagofragnan.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class start implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        for(Player players : Bukkit.getServer().getOnlinePlayers())
        {
            players.sendTitle("Ca\u00e7a ao Tesouro", ChatColor.GRAY+"Feito por Iago Fragnan", 20, 50, 20);

            Bukkit.getScheduler().scheduleSyncDelayedTask(br.com.iagofragnan.main.getThePlugin(), new Runnable() {
                public void run() {
                    players.sendTitle("GITHUB", ChatColor.GRAY + "github.com/iagof-dev/", 20, 20, 20);
                }
            }, 50L);

            Bukkit.getScheduler().scheduleSyncDelayedTask(br.com.iagofragnan.main.getThePlugin(), new Runnable() {
                public void run() {
                    players.sendTitle("LinkedIn", ChatColor.GRAY+"linkedin.com/in/iago-fragnan/", 20, 20, 20);
                }
            }, 210L);

            Bukkit.getScheduler().scheduleSyncDelayedTask(br.com.iagofragnan.main.getThePlugin(), new Runnable() {
                public void run() {
                    players.sendTitle("PORTFOLIO", ChatColor.GRAY+"iagofragnan.com.br", 20, 20, 20);
                }
            }, 270L);




        }





        return true;
    }
}
