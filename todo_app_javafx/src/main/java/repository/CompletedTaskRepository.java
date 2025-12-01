package repository;

import db.DBConnection;
import model.entity.CompletedTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompletedTaskRepository {

    public void addCompletedTask(CompletedTask task) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO completed_tasks (date, title, description) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,task.getDate());
        preparedStatement.setObject(2,task.getTitle());
        preparedStatement.setObject(3,task.getDescription());

        preparedStatement.executeUpdate();

    }

}
