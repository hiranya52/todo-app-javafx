package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    void btnLogInOnAction(ActionEvent event) {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.equals("sehi") && password.equals("1234")){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Login");
            alert.setContentText("Username or Password is incorrect.");
            alert.show();
        }

    }

}
