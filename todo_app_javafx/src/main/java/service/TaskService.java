package service;

import model.dto.TaskDTO;
import model.entity.Task;
import repository.TaskRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    TaskRepository taskRepository = new TaskRepository();

    public void addTask(TaskDTO taskDTO) {

        Task task = new Task(
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

}
