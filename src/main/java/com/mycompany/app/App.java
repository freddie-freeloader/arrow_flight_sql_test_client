package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:arrow-flight-sql://sqlflite:31337?useEncryption=true&user=sqlflite_username&password=sqlflite_password&disableCertificateVerification=true");) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT \"c_custkey\" FROM \"main\".\"customer\" LIMIT 10;");
            // Get status of the connection
            System.out.println("Connection status: " + connection.isClosed());
            // Process the result set
            while (resultSet.next()) {
                System.out.println("c_custkey: " + resultSet.getInt("c_custkey"));
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }
}
