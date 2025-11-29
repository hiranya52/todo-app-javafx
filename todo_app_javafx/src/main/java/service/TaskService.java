package service;

import model.dto.TaskDTO;
import model.entity.Task;
import repository.TaskRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
