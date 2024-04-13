package br.com.iagofragnan.settings;

public class mysql {

    private static String address;
    private static Integer port;
    private static String user;
    private static String pass;
    private static String database;
    private static String table;

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String newAddress) {
        address = newAddress;
    }

    public static Integer getPort() {
        return port;
    }

    public static void setPort(Integer newPort) {
      port = newPort;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String newUser) {
        user = newUser;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String newPass) {
        pass = newPass;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String newDatabase) {
        database = newDatabase;
    }

    public static String getTable() {
        return table;
    }

    public static void setTable(String newTable) {
        table = newTable;
    }
}
