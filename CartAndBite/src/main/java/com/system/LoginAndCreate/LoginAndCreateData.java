package com.system.LoginAndCreate;

import java.sql.*;

public class LoginAndCreateData {

    private static String URL = "jdbc:mysql://localhost:3306/CartAndBite";
    private static String USER = "root";
    private static String PASSWORD = "";

    //Insert Data
    public void insertCustomer(String firstname, String lastname, String username, String password, String mobileNumber, String address) {

        String selectSQL = "SELECT customerID FROM customers ORDER BY customerID DESC LIMIT 1";
        String insertData = "INSERT INTO customers (customerID, firstname, lastname, username, password, mobileNumber, address) VALUES(?,?,?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement select = connection.prepareStatement(selectSQL);
            PreparedStatement insert = connection.prepareStatement(insertData);


            String newID = "C20240001";
            ResultSet rs = select.executeQuery();

            if (rs.next()) {
                String lastID = rs.getString("CustomerID");
                int parsing = Integer.parseInt(lastID.substring(1));
                parsing++;
                newID = "C" + parsing;

            }


            insert.setString(1, newID);
            insert.setString(2, firstname);
            insert.setString(3, lastname);
            insert.setString(4, username);
            insert.setString(5, password);
            insert.setString(6, mobileNumber);
            insert.setString(7, address);


            int rowInserted = insert.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Customer ID inserted successfully " + newID);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
