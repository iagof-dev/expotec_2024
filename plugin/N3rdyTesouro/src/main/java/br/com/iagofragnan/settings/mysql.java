package br.com.iagofragnan.settings;

public class mysql {

    private static String address;
    private static Integer port;
    private static String user;
    private static String pass;
    private static String database;
    private static String table;

    public String getAddress() {
        return address;
    }

    public static void setAddress(String newAddress) {
        address = newAddress;
    }

    public Integer getPort() {
        return port;
    }

    public static void setPort(Integer newPort) {
      port = newPort;
    }

    public String getUser() {
        return user;
    }

    public static void setUser(String newUser) {
        user = newUser;
    }

    public String getPass() {
        return pass;
    }

    public static void setPass(String newPass) {
        pass = newPass;
    }

    public String getDatabase() {
        return database;
    }

    public static void setDatabase(String newDatabase) {
        database = newDatabase;
    }

    public String getTable() {
        return table;
    }

    public static void setTable(String newTable) {
        table = newTable;
    }
}
