package com.codersait;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDemo {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        try (Connection connection = DbHelper.getConnection()) {
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery("SELECT id,first_name,last_name,email,gender FROM person");
            while (resultSet.next()) {
                persons.add(new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("gender")));
            }
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }
        System.out.println(persons);

    }
}
