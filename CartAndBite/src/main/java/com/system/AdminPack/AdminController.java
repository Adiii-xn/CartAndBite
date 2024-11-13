package com.system.AdminPack;

import com.system.LoginAndCreate.LoginAcc;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class AdminController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    protected void manageAccount(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/system/AdminPack/AdminAccountFX.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    private void loadScene(ActionEvent event, String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(LoginAcc.class.getResource(fxmlPath)));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    //Dashboard
    @FXML
    Button dashboardButton;

    @FXML
    protected void adminDashboard(ActionEvent event) throws IOException {

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), dashboardButton);
        scaleTransition.setFromX(1);   // Original size
        scaleTransition.setFromY(1);   // Original size
        scaleTransition.setToX(1.1);   // Scale to 1.1 times
        scaleTransition.setToY(1.1);

        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminDashboard/AdminDashboardFX.fxml"));  // After animation, load new scene
        scaleTransition.play();
    }


    //Products
    @FXML
    Button productButton;

    @FXML
    protected void adminProducts(ActionEvent event) throws IOException {


        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), productButton);
        scaleTransition.setFromX(1);   // Original size
        scaleTransition.setFromY(1);   // Original size
        scaleTransition.setToX(1.1);   // Scale to 1.1 times
        scaleTransition.setToY(1.1);

        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminProduct/AdminProductsFX.fxml"));  // After animation, load new scene
        scaleTransition.play();
    }


    //Rider
    @FXML
    Button riderButton;

    @FXML
    protected void adminRiders(ActionEvent event) throws IOException {

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), riderButton);
        scaleTransition.setFromX(1);   // Original size
        scaleTransition.setFromY(1);   // Original size
        scaleTransition.setToX(1.1);   // Scale to 1.1 times
        scaleTransition.setToY(1.1);

        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminRider/AdminRidersFX.fxml"));  // After animation, load new scene
        scaleTransition.play();
    }


    //Inventory
    @FXML
    Button inventoryButton;

    @FXML
    protected void adminInventory(ActionEvent event) throws IOException {

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), inventoryButton);
        scaleTransition.setFromX(1);   // Original size
        scaleTransition.setFromY(1);   // Original size
        scaleTransition.setToX(1.1);   // Scale to 1.1 times
        scaleTransition.setToY(1.1);

        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminInventory/AdminInventoryFX.fxml"));  // After animation, load new scene
        scaleTransition.play();
    }


    //Reports
    @FXML
    Button reportButton;

    @FXML
    protected void adminReports(ActionEvent event) throws IOException {

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), reportButton);
        scaleTransition.setFromX(1);   // Original size
        scaleTransition.setFromY(1);   // Original size
        scaleTransition.setToX(1.1);   // Scale to 1.1 times
        scaleTransition.setToY(1.1);

        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminReport/AdminReportsFX.fxml"));  // After animation, load new scene
        scaleTransition.play();
    }
}