package service;

import model.entity.CompletedTask;
import repository.CompletedTaskRepository;

import java.sql.SQLException;

public class CompletedTaskService {

    CompletedTaskRepository completedTaskRepository = new CompletedTaskRepository();

    public void addCompletedTask(CompletedTask taskDTO) {

        CompletedTask task = new CompletedTask(
                taskDTO.getDate(),
                taskDTO.getTitle(),
                taskDTO.getDescription()
        );

        try {
            completedTaskRepository.addCompletedTask(task);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
