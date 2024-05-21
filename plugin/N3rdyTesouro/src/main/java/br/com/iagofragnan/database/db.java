package br.com.iagofragnan.database;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;


public class db {

    static Connection con = br.com.iagofragnan.models.mysql.getConnection();
    static String table = br.com.iagofragnan.settings.mysql.getTable();

    public static void Query(String sql){
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        }
    }

    public static void registrarJogador(){
        String sql = "INSERT INTO" + table + " VALUES (default, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, br.com.iagofragnan.models.player.getPlayerName());
            stmt.setInt(2, 1);
            stmt.setTime(3, new Time(1));
            stmt.setInt(4, 0);
            stmt.executeUpdate();
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        }
    }
}
