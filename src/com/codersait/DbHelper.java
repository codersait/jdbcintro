package com.codersait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private static final String dbUser = "jdbcuser";
    private static final String dbPassword = "12345";
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/jdbcintro";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public static void showErrorMessage(SQLException exception){
        System.out.println("Error: "+ exception.getMessage());
        System.out.println("Error Code: "+ exception.getErrorCode());
    }


}