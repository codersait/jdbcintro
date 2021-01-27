package com.codersait;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteDemo {
    public static void main(String[] args) {

        try (Connection connection = DbHelper.getConnection()) {
            String sql = "DELETE FROM person WHERE id = ? ";
            var statement = connection.prepareStatement(sql);
            statement.setInt(1,1002);
            statement.executeUpdate();
            System.out.println("record deleted");
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }

    }
}
