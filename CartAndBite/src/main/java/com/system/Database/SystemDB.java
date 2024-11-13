package com.system.Database;

import java.sql.*;

public class SystemDB {

    public SystemDB(){
        createDatabase();
        createCustomerTable();
    }

    private static String URL = "jdbc:mysql://localhost:3306";
    private static String USER = "root";
    private static String PASSWORD = "";


    // Connection
    public static Connection connect(){
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful!");
            return connection;

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Create Database
    public void createDatabase(){
        String createDB = "CREATE DATABASE IF NOT EXISTS CartAndBite";

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(createDB)) {

            statement.executeUpdate();
            System.out.println("Database created successfully (or already exists)");
        } catch (SQLException e) {
            System.out.println("Create Database Error: " + e.getMessage());
        }
    }

    // Create Customer Table
    public void createCustomerTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS customers (" +
                "customerID VARCHAR(16) PRIMARY KEY, " + // Use VARCHAR for custom IDs
                "firstName VARCHAR(64), " +
                "lastName VARCHAR(64), " +
                "username VARCHAR(64) UNIQUE, " +
                "password VARCHAR(64), " +
                "mobileNumber VARCHAR(15), " +
                "address VARCHAR(100))";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CartAndBite", USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Create the table
            stmt.executeUpdate(createTable);
            System.out.println("Customer table created successfully!");
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }

}