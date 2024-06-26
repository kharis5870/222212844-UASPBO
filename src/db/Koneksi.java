package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kharis
 */
public class Koneksi {
    private static final String URL = "jdbc:sqlite:db_kantin.sqlite";
    private static Connection con = null;

    private Koneksi() {}

    public static Connection connectDB() {
        if (con == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(URL);
                System.out.println("Connection Successful");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Connection Failed: " + e.getMessage());
            }
        }
        return con;
    }
}
