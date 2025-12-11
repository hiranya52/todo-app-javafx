package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.dto.TaskDTO;
import model.entity.CompletedTask;
import service.CompletedTaskService;
import service.TaskService;

import java.util.List;

public class DashboardController {

    TaskService taskService = new TaskService();

    CompletedTaskService completedTaskService = new CompletedTaskService();

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
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<?> tblCompletedTask;

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

//    private void loadTasks(){
//        List<TaskDTO> tasks =  taskService.loadTasks();
//
//        TextField[] fields = { txtField_1,txtField_2,txtField_3,txtField_4,txtField_5,txtField_6 };
//
//        for (int i=0; i<6; i++){
//            txtField_1.clear();
//            txtField_2.clear();
//            txtField_3.clear();
//            txtField_4.clear();
//            txtField_5.clear();
//            txtField_6.clear();
//        }
//
//        for (int i=0; i<6; i++){
//            if(tasks.get(i) != null){
//                fields[i].setText(tasks.get(i).getTitle());
//            }
//        }
//    }

    private void loadTasks() {
        List<TaskDTO> tasks = taskService.loadTasks();

        TextField[] fields = { txtField_1, txtField_2, txtField_3, txtField_4, txtField_5, txtField_6 };
        CheckBox[] checkboxes = { chk_1, chk_2, chk_3, chk_4, chk_5, chk_6 };

        for (int i = 0; i < fields.length; i++) {
            fields[i].clear();
            checkboxes[i].setSelected(false);
        }
        for (int i = 0; i < tasks.size() && i < fields.length; i++) {
            fields[i].setText(tasks.get(i).getDescription());
//            checkboxes[i].setSelected(tasks.get(i).isCompleted());
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

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void chk_1(ActionEvent event) {
        if (chk_1.isSelected()){

            CompletedTask task = taskService.taskCompleted(txtField_1.getText());

            System.out.println(task);

//            taskService.deleteCompletedTask(task.getTitle());

//            completedTaskService.addCompletedTask(task);

//            loadTasks();

        }
    }

    @FXML
    void chk_2(ActionEvent event) {
        if (chk_2.isSelected()){



        }
    }

    @FXML
    void chk_3(ActionEvent event) {

    }

    @FXML
    void chk_4(ActionEvent event) {

    }

    @FXML
    void chk_5(ActionEvent event) {

    }

    @FXML
    void chk_6(ActionEvent event) {

    }

}
