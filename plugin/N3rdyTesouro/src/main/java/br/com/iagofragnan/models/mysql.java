<<<<<<< HEAD:plugin/N3rdyTesouro/src/main/java/br/com/iagofragnan/models/MySql.java
package br.com.iagofragnan.models;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

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
    static Connection connection = null;

    static void init(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Erro na conexão com MySql:\n" + e.getMessage());
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void Insert(String sql){
        init();
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
=======
package br.com.iagofragnan.models;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

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
    static Connection connection = null;

    static void init(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Erro na conexão com MySql:\n" + e.getMessage());
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void Insert(String sql){
        init();
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
>>>>>>> 1b13af6f01d7e8715a26ffe1599171301399c2db:plugin/N3rdyTesouro/src/main/java/br/com/iagofragnan/models/mysql.java
