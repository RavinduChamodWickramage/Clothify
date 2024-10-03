package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;

    private DBConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Clothify", "root", "19982001");
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException{
        return instance == null ? instance = new DBConnection() : instance;
    }
}