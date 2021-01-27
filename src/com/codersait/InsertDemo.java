package com.codersait;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertDemo {
    public static void main(String[] args) {

        try (Connection connection = DbHelper.getConnection()) {
            String sql = "INSERT INTO person(first_name,last_name,email,gender) VALUES (?,?,?,?)";
            var statement = connection.prepareStatement(sql);
            statement.setString(1,"Nilufer");
            statement.setString(2,"Gulec");
            statement.setString(3,"nil@nil.com");
            statement.setString(4,"Female");
            statement.executeUpdate();
            System.out.println("record inserted");
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }

    }
}
