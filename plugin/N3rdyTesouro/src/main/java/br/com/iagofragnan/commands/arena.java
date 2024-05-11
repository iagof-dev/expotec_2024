<<<<<<< HEAD
package br.com.iagofragnan.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class arena implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        br.com.iagofragnan.models.arena.CreateArena();
        return true;
    }
}
=======
package br.com.iagofragnan.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class arena implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        br.com.iagofragnan.models.arena.CreateArena();
        return true;
    }
}
>>>>>>> 1b13af6f01d7e8715a26ffe1599171301399c2db
