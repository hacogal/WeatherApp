package org.example.a1weatherdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/weatherDB"; // URL of the MySQL database
    private static final String USER = "root"; // Username for the database
    private static final String PASS = "Hacogal241293."; // Password for the database

    public Connection connect() {
        try {
            // Attempt to establish a connection to the database
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            // Throw a runtime exception with a custom message if a SQL error occurs
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
