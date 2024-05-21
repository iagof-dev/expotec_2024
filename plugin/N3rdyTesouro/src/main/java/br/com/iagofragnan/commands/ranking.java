package br.com.iagofragnan.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ranking implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        if(args[0].equals("criar")){
            p.sendMessage("Criando holograma do ranking");
            br.com.iagofragnan.models.hologram.create();
            p.sendMessage("Tentando adicionar valores ao ranking");
            return true;
        }
        else if(args[0].equals("atualizar")){
            p.sendMessage("Tentando atualizar holograma de ranking");
            return true;
        }
        else if(args[0].equals("remover")){
            p.sendMessage("Tentando remover holograma de ranking");
            br.com.iagofragnan.models.hologram.delete();
            return true;
        }
        else{
            p.sendMessage(ChatColor.RED + "Erro!" + ChatColor.WHITE + " parametro não especificado.");
            return false;
        }

    }
}
