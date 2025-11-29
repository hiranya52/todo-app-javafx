package repository;

import db.DBConnection;
import model.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class TaskRepository {

    public void addTask(Task task) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO tasks (date, title, description) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,task.getDate());
        preparedStatement.setObject(2,task.getTitle());
        preparedStatement.setObject(3,task.getDescription());

        preparedStatement.executeUpdate();

    }

    public ResultSet loadTasks() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Select * From Tasks";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        return preparedStatement.executeQuery();


    }

}
