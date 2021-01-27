package com.codersait;

import java.sql.Connection;
import java.sql.SQLException;

public class UpdateDemo {
    public static void main(String[] args) {

        try (Connection connection = DbHelper.getConnection()) {
            String sql = "UPDATE person SET gender = ?,email = ? WHERE id = ? ";
            var statement = connection.prepareStatement(sql);
            statement.setString(1,"fEmAlE");
            statement.setString(2,"email@email");
            statement.setInt(3,1002);
            statement.executeUpdate();
            System.out.println("record updated");
        } catch (SQLException exception) {
            DbHelper.showErrorMessage(exception);
        }

    }
}
