package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CompletedTaskDTO;
import model.dto.TaskDTO;
import service.CompletedTaskService;
import service.TaskService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    TaskService taskService = new TaskService();

    CompletedTaskService completedTaskService = new CompletedTaskService();

    ObservableList<CompletedTaskDTO> completedTaskDTOS = FXCollections.observableArrayList();

    @FXML
    private CheckBox chk_1;

    @FXML
    private CheckBox chk_2;

    @FXML
    private CheckBox chk_3;

    @FXML
    private CheckBox chk_4;

    @FXML
    private CheckBox chk_5;

    @FXML
    private CheckBox chk_6;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<CompletedTaskDTO> tblCompletedTask;
    @FXML
    private DatePicker txtDate;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtField_1;

    @FXML
    private JFXTextField txtField_2;

    @FXML
    private JFXTextField txtField_3;

    @FXML
    private JFXTextField txtField_4;

    @FXML
    private JFXTextField txtField_5;

    @FXML
    private JFXTextField txtField_6;

    @FXML
    private JFXTextField txtTitle;

    private void loadTasks(){
        List<TaskDTO> tasks =  taskService.loadTasks();

        TextField[] fields = { txtField_1,txtField_2,txtField_3,txtField_4,txtField_5,txtField_6 };

        for (int i=0; i<6; i++){
            fields[i].clear();
        }

        for (int i = 0; i < tasks.size() && i < fields.length; i++) {
            fields[i].setText(tasks.get(i).getTitle());
        }

    }


    @FXML
    void btnAddTaskOnAction(ActionEvent event) {
        String date = txtDate.getValue().toString();
        String title = txtTitle.getText();
        String description = txtDescription.getText();

        TaskDTO taskDTO = new TaskDTO(date,title,description);

        taskService.addTask(taskDTO);

        loadTasks();

        txtDate.setValue(null);
        txtTitle.clear();
        txtDescription.clear();

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

        tblCompletedTask.getItems().clear();

        List<CompletedTaskDTO> taskDTOS = completedTaskService.getAllCompletedTasks();

        for(CompletedTaskDTO completedTaskDTO : taskDTOS){
            completedTaskDTOS.add(completedTaskDTO);
        }

        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        tblCompletedTask.setItems(completedTaskDTOS);

    }

    @FXML
    void chk_1(ActionEvent event) {
        if (chk_1.isSelected()){

            TaskDTO task = taskService.taskCompleted(txtField_1.getText());

            CompletedTaskDTO completedTaskDTO = new CompletedTaskDTO(
                    task.getDate(),
                    task.getTitle(),
                    task.getDescription()
            );

            completedTaskService.addCompletedTask(completedTaskDTO);

            loadTasks();

            chk_1.setSelected(false);

        }
    }

    @FXML
    void chk_2(ActionEvent event) {
        if (chk_2.isSelected()){

            TaskDTO task = taskService.taskCompleted(txtField_2.getText());

            CompletedTaskDTO completedTaskDTO = new CompletedTaskDTO(
                    task.getDate(),
                    task.getTitle(),
                    task.getDescription()
            );

            completedTaskService.addCompletedTask(completedTaskDTO);

            loadTasks();

            chk_2.setSelected(false);

        }
    }

    @FXML
    void chk_3(ActionEvent event) {
        if (chk_3.isSelected()){

            TaskDTO task = taskService.taskCompleted(txtField_3.getText());

            CompletedTaskDTO completedTaskDTO = new CompletedTaskDTO(
                    task.getDate(),
                    task.getTitle(),
                    task.getDescription()
            );

            completedTaskService.addCompletedTask(completedTaskDTO);

            loadTasks();

            chk_3.setSelected(false);

        }
    }

    @FXML
    void chk_4(ActionEvent event) {
        if (chk_4.isSelected()){

            TaskDTO task = taskService.taskCompleted(txtField_4.getText());

            CompletedTaskDTO completedTaskDTO = new CompletedTaskDTO(
                    task.getDate(),
                    task.getTitle(),
                    task.getDescription()
            );

            completedTaskService.addCompletedTask(completedTaskDTO);

            loadTasks();

            chk_4.setSelected(false);

        }
    }

    @FXML
    void chk_5(ActionEvent event) {
        if (chk_5.isSelected()){

            TaskDTO task = taskService.taskCompleted(txtField_5.getText());

            CompletedTaskDTO completedTaskDTO = new CompletedTaskDTO(
                    task.getDate(),
                    task.getTitle(),
                    task.getDescription()
            );

            completedTaskService.addCompletedTask(completedTaskDTO);

            loadTasks();

            chk_5.setSelected(false);

        }
    }

    @FXML
    void chk_6(ActionEvent event) {
        if (chk_6.isSelected()){

            TaskDTO task = taskService.taskCompleted(txtField_6.getText());

            CompletedTaskDTO completedTaskDTO = new CompletedTaskDTO(
                    task.getDate(),
                    task.getTitle(),
                    task.getDescription()
            );

            completedTaskService.addCompletedTask(completedTaskDTO);

            loadTasks();

            chk_6.setSelected(false);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadTasks();

    }
}
