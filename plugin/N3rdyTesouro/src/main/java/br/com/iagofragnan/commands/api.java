package br.com.iagofragnan.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class api implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        br.com.iagofragnan.controller.api api = new br.com.iagofragnan.controller.api();
        api.getRanking();

        switch (args[0]) {
            case "ranking":
                String data = api.getRanking();
                sender.sendMessage(data);
                break;
            case "rankingholo":
                String datahol = api.getRanking();
                sender.sendMessage(datahol);
                break;
            case "inserir":
                api.insertOnRanking(args[1], args[2], args[3]);
                break;
        }
        return true;
    }
}
