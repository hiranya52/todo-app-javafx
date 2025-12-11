package repository;

import com.mysql.cj.protocol.Resultset;
import db.DBConnection;
import model.dto.TaskDTO;
import model.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class TaskRepository {


    public String getLastTaskID() throws SQLException {

        String lastTaskId = null;

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "SELECT id FROM tasks ORDER BY id DESC LIMIT 1";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            lastTaskId = resultSet.getString(1);
        }

        return lastTaskId;

    }

    public void addTask(Task task) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO tasks VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,task.getId());
        preparedStatement.setObject(2,task.getDate());
        preparedStatement.setObject(3,task.getTitle());
        preparedStatement.setObject(4,task.getDescription());

        preparedStatement.executeUpdate();

    }

//    public void deleteCompletedTask(String title) throws SQLException {
//
//        Connection connection = DBConnection.getInstance().getConnection();
//        String SQL = "DELETE FROM Tasks WHERE title = ?";
//
//        PreparedStatement ps = connection.prepareStatement(SQL);
//        ps.setString(1, title);
//
//    }

    public ResultSet loadTasks() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "Select * From Tasks";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        return preparedStatement.executeQuery();

    }

    public ResultSet taskCompleted(String title) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT id, date, title, description FROM tasks WHERE title = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, title);

        return preparedStatement.executeQuery();

    }

}
