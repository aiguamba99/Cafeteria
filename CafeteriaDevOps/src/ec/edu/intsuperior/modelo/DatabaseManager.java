package ec.edu.intsuperior.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/cafeteria";
    private static final String USER = "root"; // Cambia por tu usuario de MySQL
    private static final String PASSWORD = "root"; // Cambia por tu contraseña de MySQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
