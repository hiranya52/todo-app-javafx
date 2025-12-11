package service;

import model.dto.CompletedTaskDTO;
import model.entity.CompletedTask;
import repository.CompletedTaskRepository;

import java.sql.SQLException;

public class CompletedTaskService {

    CompletedTaskRepository completedTaskRepository = new CompletedTaskRepository();

    private String getLastTaskID(){

        String lastTaskId;
        try {
            lastTaskId = completedTaskRepository.getLastTaskID();
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


    public void addCompletedTask(CompletedTaskDTO taskDTO) {

        CompletedTask task = new CompletedTask(
                getLastTaskID(),
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
