package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_stock";
    private static final String USER = "root"; // change if your MySQL username is different
    private static final String PASSWORD = ""; // change if your MySQL has a password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
