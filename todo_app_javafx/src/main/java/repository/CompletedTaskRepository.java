package repository;

import db.DBConnection;
import model.entity.CompletedTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompletedTaskRepository {


    public String getLastTaskID() throws SQLException {

        String lastTaskId = null;

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "SELECT id FROM completed_tasks ORDER BY id DESC LIMIT 1";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            lastTaskId = resultSet.getString(1);
        }

        return lastTaskId;

    }


    public void addCompletedTask(CompletedTask task) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO completed_tasks (id, date, title, description) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,task.getId());
        preparedStatement.setObject(2,task.getDate());
        preparedStatement.setObject(3,task.getTitle());
        preparedStatement.setObject(4,task.getDescription());

        preparedStatement.executeUpdate();

    }

    public ResultSet getAllCompletedTasks() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Select * From Completed_Tasks";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        return preparedStatement.executeQuery();

    }


}
