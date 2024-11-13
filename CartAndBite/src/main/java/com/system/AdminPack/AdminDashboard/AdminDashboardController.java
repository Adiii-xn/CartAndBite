package com.system.AdminPack.AdminDashboard;

import com.system.LoginAndCreate.LoginAcc;
import com.system.Logout.LogoutController;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class AdminDashboardController {

    public Stage stage;
    public Scene scene;
    private Parent root;

    @FXML
    Button dashboardButton;
    @FXML
    Button productButton;
    @FXML
    Button riderButton;
    @FXML
    Button inventoryButton;
    @FXML
    Button reportButton;
    @FXML
    private Button logoutButton;

    // Method to load new scenes after button animation
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

    // Method for Admin Dashboard button with animation
    @FXML
    protected void adminDashboard(ActionEvent event) throws IOException {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), dashboardButton);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminDashboard/AdminDashboardFX.fxml"));
        scaleTransition.play();
    }

    // Method for Admin Products
    @FXML
    protected void adminProducts(ActionEvent event) throws IOException {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), productButton);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminProduct/AdminProductsFX.fxml"));
        scaleTransition.play();
    }

    // Method for Admin Riders
    @FXML
    protected void adminRiders(ActionEvent event) throws IOException {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), riderButton);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminRider/AdminRidersFX.fxml"));
        scaleTransition.play();
    }

    // Method for Admin Inventory
    @FXML
    protected void adminInventory(ActionEvent event) throws IOException {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), inventoryButton);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminInventory/AdminInventoryFX.fxml"));
        scaleTransition.play();
    }

    // Method for Admin Reports
    @FXML
    protected void adminReports(ActionEvent event) throws IOException {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), reportButton);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setOnFinished(e -> loadScene(event, "/com/system/AdminPack/AdminReport/AdminReportsFX.fxml"));
        scaleTransition.play();
    }

    // Logout button action
    @FXML
    protected void adminLogout(ActionEvent event) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), logoutButton);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.setOnFinished(e -> overlayLogout(event, "/com/system/Logout/LogoutFX.fxml"));
        scaleTransition.play();
    }

    // Overlay stage (popup confirmation) for logout
    private void overlayLogout(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // (LogoutController)
            LogoutController logoutController = loader.getController();
            logoutController.setParentStage((Stage) logoutButton.getScene().getWindow());  // Pass the AdminDashboard stage

            Stage popupStage = new Stage();
            popupStage.setScene(new Scene(root));
            popupStage.initStyle(StageStyle.UNDECORATED);
            Stage parentStage = (Stage) logoutButton.getScene().getWindow();
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