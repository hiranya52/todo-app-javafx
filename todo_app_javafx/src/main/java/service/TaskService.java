package service;

import com.mysql.cj.protocol.Resultset;
import model.dto.CompletedTaskDTO;
import model.dto.TaskDTO;
import model.entity.CompletedTask;
import model.entity.Task;
import repository.TaskRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    TaskRepository taskRepository = new TaskRepository();


    private String getLastTaskID() {

        String lastTaskId;
        try {
            lastTaskId = taskRepository.getLastTaskID();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (lastTaskId == null) {
            return "t1";
        }

        int numericPart = Integer.parseInt(lastTaskId.substring(1));
        numericPart++;

        return "t" + numericPart;
    }

    public void addTask(TaskDTO taskDTO) {

        String lastID = getLastTaskID();

        Task task = new Task(
                lastID,
                taskDTO.getDate(),
                taskDTO.getTitle(),
                taskDTO.getDescription()
        );

        try {
            taskRepository.addTask(task);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<TaskDTO> loadTasks() {

        List<TaskDTO> taskDTOS = new ArrayList<>();
        try {
            ResultSet rst = taskRepository.loadTasks();
            while (rst.next()){
                taskDTOS.add(
                        new TaskDTO(
                                rst.getString("date"),
                                rst.getString("title"),
                                rst.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         return taskDTOS;

    }


    public CompletedTaskDTO taskCompleted(String title) {

        try {
            ResultSet resultSet = (ResultSet) taskRepository.taskCompleted(title);

            if (resultSet.next()) {

                //-------------Call Delete Completed Task by passing the ID-------------//
                deleteCompletedTask(resultSet.getString("id"));

                return new CompletedTaskDTO(
                        resultSet.getString("date"),
                        resultSet.getString("title"),
                        resultSet.getString("description")
                );

            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteCompletedTask(String id) {

        System.out.println(id);

        try {
            taskRepository.deleteCompletedTask(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
