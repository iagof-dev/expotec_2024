package br.com.iagofragnan.commands;

import br.com.iagofragnan.models.scoreboard;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static br.com.iagofragnan.controller.scoreboard.createScoreboard;

public class sb implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player p = (Player) sender;
        br.com.iagofragnan.controller.scoreboard mysb = new br.com.iagofragnan.controller.scoreboard();

        if(args[0].equals("clobby")) {
            boolean result = createScoreboard(p, scoreboard.states.Idle);
            if(result){
                p.sendMessage("Scoreboard criada.");
            }
        }
        if(args[0].equals("cplaying")) {
            boolean result = createScoreboard(p, scoreboard.states.Playing);
            if(result){
                p.sendMessage("Scoreboard criada.");
            }
        }



        return true;
    }
}
