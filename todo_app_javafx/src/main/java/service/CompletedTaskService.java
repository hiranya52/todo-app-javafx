package service;

import model.dto.CompletedTaskDTO;
import model.dto.TaskDTO;
import model.entity.CompletedTask;
import repository.CompletedTaskRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    public List<CompletedTaskDTO> getAllCompletedTasks() {

        List<CompletedTaskDTO> tasks = new ArrayList<>();
        try {
            ResultSet rst = completedTaskRepository.getAllCompletedTasks();
            while (rst.next()){
                tasks.add(
                        new CompletedTaskDTO(
                                rst.getString("date"),
                                rst.getString("title"),
                                rst.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;

    }


}
