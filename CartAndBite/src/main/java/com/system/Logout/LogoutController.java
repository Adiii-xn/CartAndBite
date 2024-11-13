package com.system.Logout;

import com.system.LoginAndCreate.LoginAcc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class LogoutController {

    private Stage parentStage;  // Reference to the parent (AdminDashboard) stage

    // Setter method to set the parent stage
    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }

    // "Yes" button action: Close AdminDashboard and open Login screen
    @FXML
    public void LogYes(ActionEvent event) throws IOException {
        Yes(event);
    }

    // "No" button action: Close the logout confirmation popup
    @FXML
    public void LogNo(ActionEvent event) throws IOException {
        No(event);
    }




    public void Yes(ActionEvent event) throws IOException {
        // Close the parent (AdminDashboard) stage
        if (parentStage != null) {
            parentStage.close();  // Close the AdminDashboard stage
        }

        // Create an instance of LoginAcc and call its methods to launch the login screen
        LoginAcc loginApp = new LoginAcc();
        loginApp.start(new Stage());  // Launch the login screen (using the start method of LoginAcc)
    }


    public void No(ActionEvent event) throws IOException {
        // Close the current (logout confirmation) stage
        Stage logoutStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        logoutStage.close();
    }
}