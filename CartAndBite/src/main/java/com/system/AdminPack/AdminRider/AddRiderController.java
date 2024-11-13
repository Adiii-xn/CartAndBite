package com.system.AdminPack.AdminRider;

import com.system.LoginAndCreate.LoginAcc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class AddRiderController {

    private Stage parentStage;

    // Setter method to set the parent stage
    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }


    // "No" button action: Close the logout confirmation popup
    @FXML
    public void CloseAddRider(ActionEvent event) throws IOException {
        close(event);
    }



    public void close(ActionEvent event) throws IOException {
        // Close the current (logout confirmation) stage
        Stage logoutStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        logoutStage.close();
    }
}
