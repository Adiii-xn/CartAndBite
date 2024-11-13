package com.system.LoginAndCreate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.*;
import java.io.IOException;
import java.util.Objects;

public class LoginSwitchController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField adminUNField;
    @FXML
    private TextField adminPWField;


    @FXML
    protected void switchToCreateAcc(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/system/LoginAndCreate/CreateAccFX.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToLoginAcc(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/system/LoginAndCreate/LoginAccFX.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void loginToAdmin(ActionEvent event) throws IOException {

        String username = adminUNField.getText();
        String password = adminPWField.getText();

        if ("Admin".equals(username) && "Admin123".equals(password)) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/system/AdminPack/AdminDashboard/AdminDashboardFX.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect username or password. Please try again.");
            alert.showAndWait();
        }

    }
    

}
