package repository;

import db.DBConnection;
import model.entity.CompletedTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

//    public String getLastTaskID() throws SQLException {
//
//        String lastTaskId = null;
//
//        Connection connection = DBConnection.getInstance().getConnection();
//
//        String SQL = "SELECT id FROM tasks ORDER BY id DESC LIMIT 1";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        if (resultSet.next()) {
//            lastTaskId = resultSet.getString(1);
//        }
//
//        return lastTaskId;
//
//    }

}
