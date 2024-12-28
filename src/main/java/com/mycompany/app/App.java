package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Use
        // jdbc:arrow-flight-sql://localhost:31337?useEncryption=true&user=sqlflite_username&password=sqlflite_password&disableCertificateVerification=true
        try (Connection connection = DriverManager.getConnection(
                "jdbc:arrow-flight-sql://sqlflite:31337?useEncryption=true&user=sqlflite_username&password=sqlflite_password&disableCertificateVerification=true")) {
            // Get status of the connection
            System.out.println("Connection status: " + connection.isClosed());
            // Execute a query
            connection.createStatement().executeQuery("SELECT * FROM orders LIMIT 10");
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }
}
