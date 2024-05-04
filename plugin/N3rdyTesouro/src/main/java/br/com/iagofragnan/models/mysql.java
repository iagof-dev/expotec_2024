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
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void Insert(String sql){
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
