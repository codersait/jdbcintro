package com.codersait;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDemo {
    public static void main(String[] args) {
        
   // execute() : The method used for all types of SQL statements, and that is, returns a boolean value of TRUE or FALSE. If the method return TRUE, return the ResultSet object and FALSE returns the int value.

   // executeUpdate() : This method is used for execution of DML statement(INSERT, UPDATE and DELETE) which is return int value, count of the affected rows.

   // executeQuery() : This method is used to retrieve data from database using SELECT query. This method returns the ResultSet object that returns the data according to the query.

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
