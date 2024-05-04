package br.com.iagofragnan.commands;

import br.com.iagofragnan.models.player;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class end implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        player.getPlayerObj().sendMessage("Deletando a ultima arena.");
        br.com.iagofragnan.models.arena.DeleteLastArena();
        br.com.iagofragnan.models.player.setSetupNameFinished(false);
        Location spawn = new Location(player.getWorld(), 0, 66, 0);
        player.getPlayerObj().teleport(spawn);

        return true;
    }

}
