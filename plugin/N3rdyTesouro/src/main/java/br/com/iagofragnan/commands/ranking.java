package br.com.iagofragnan.commands;

import br.com.iagofragnan.controller.api;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ranking implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        br.com.iagofragnan.controller.hologram hl = new br.com.iagofragnan.controller.hologram();
        Player p = (Player) sender;
        if(args[0].equals("criar")){
            p.sendMessage("Criando holograma do ranking");
            hl.createRanking();
            p.sendMessage("Tentando adicionar valores ao ranking");
        }
        else if(args[0].equals("atualizar")){
            p.sendMessage("Tentando atualizar holograma de ranking");
            hl.updateRanking();
        }
        else if(args[0].equals("remover")){
            p.sendMessage("Tentando remover holograma de ranking");
            hl.deleteRanking();
        }
        else{
            p.sendMessage(ChatColor.RED + "Erro!" + ChatColor.WHITE + " parametro não especificado.");
        }

        return true;

    }
}
