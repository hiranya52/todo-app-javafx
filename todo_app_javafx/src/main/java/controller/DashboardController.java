package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.dto.TaskDTO;
import service.TaskService;

import java.util.List;

public class DashboardController {

    TaskService taskService = new TaskService();

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

    @FXML
    void btnAddTaskOnAction(ActionEvent event) {
        String date = txtDate.getValue().toString();
        String title = txtTitle.getText();
        String description = txtDescription.getText();

        TaskDTO taskDTO = new TaskDTO(date,title,description);

        taskService.addTask(taskDTO);


        List<TaskDTO> tasks =  taskService.loadTasks();

        TextField[] fields = { txtField_1,txtField_2,txtField_3,txtField_4,txtField_5,txtField_6 };

        for (int i=0; i<6; i++){
            if(tasks.get(i) != null){
                fields[i].setText(tasks.get(i).getTitle());
            }
        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void chk_1(ActionEvent event) {

    }

    @FXML
    void chk_2(ActionEvent event) {

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
