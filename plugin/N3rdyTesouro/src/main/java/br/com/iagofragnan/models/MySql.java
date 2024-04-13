package br.com.iagofragnan.models;

import org.bukkit.Bukkit;

import java.sql.*;
import java.util.Date;

public class mysql {

    static String user = br.com.iagofragnan.settings.mysql.getUser();
    static String pass = br.com.iagofragnan.settings.mysql.getPass();
    static Integer port = br.com.iagofragnan.settings.mysql.getPort();
    static String address = br.com.iagofragnan.settings.mysql.getAddress();
    static String table = br.com.iagofragnan.settings.mysql.getTable();
    static String database = br.com.iagofragnan.settings.mysql.getDatabase();
    static String url = "jdbc:mysql://"+ address + ":" + port + "/" + database;
    static Connection connection;

    public static void mysql(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void Query(String sql){
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        }
    }

    public static void registrarJogador(){


        String sql = "INSERT INTO" + table + " VALUES (default, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
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
