package com.system.AdminPack.AdminRider;

import com.system.Logout.LogoutController;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class RiderController {

    public Stage stage;
    public Scene scene;

    @FXML
    private Button  addRiderBtn;


    @FXML
    protected void addRiderStage(ActionEvent event) {

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), addRiderBtn);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setOnFinished(e -> overlayAddRider(event, "/com/system/AdminPack/AdminRider/AddRider.fxml"));
        scaleTransition.play();

    }

    // Overlay stage (popup confirmation) for logout
    private void overlayAddRider(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Get the controller of the popup (LogoutController)
            AddRiderController addController = loader.getController();
            addController.setParentStage((Stage) addRiderBtn.getScene().getWindow());  // Pass the AdminDashboard stage

            Stage popupStage = new Stage();
            popupStage.setScene(new Scene(root));
            popupStage.initStyle(StageStyle.UNDECORATED);
            Stage parentStage = (Stage) addRiderBtn.getScene().getWindow();
            popupStage.initOwner(parentStage);
            popupStage.initModality(Modality.WINDOW_MODAL);

            double customOffsetX = 375;
            double customOffsetY = 150;
            popupStage.setX(parentStage.getX() + customOffsetX);
            popupStage.setY(parentStage.getY() + customOffsetY);
            popupStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }




}
