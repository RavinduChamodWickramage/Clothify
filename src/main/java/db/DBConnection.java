package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;

    private DBConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Clothify", "root", "19982001");
        } catch (SQLException e) {
            System.err.println("Database connection failed. Please check your credentials or database status.");
            throw new SQLException("Database connection failed", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException{
        return instance == null ? instance = new DBConnection() : instance;
    }
}
