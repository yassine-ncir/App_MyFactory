package apps.app_myfactory.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DB_URL = "jdbc:sqlite:AppMyDB.db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static  Connection cnx;

    public Connection getConnectionDB() throws SQLException {
        try {
            cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection DB initialized successfully");
        }catch (SQLException e) {
            System.out.println("Connection DB failed, "+e.getMessage());
        }
        return cnx;
    }

    public static void closeConnection() {
        try {
            if (cnx != null) {
                cnx.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing database: " + e.getMessage());
        }
    }

}
