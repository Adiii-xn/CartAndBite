package com.system.LoginAndCreate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginAcc extends Application {

    Scene scene;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        stage.initStyle(StageStyle.UNDECORATED);

        loadScene(stage, "/com/system/LoginAndCreate/LoginAccFX.fxml", "Login");


        KeyCombination ctrlN = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
        stage.addEventFilter(KeyEvent.KEY_PRESSED, event -> {

            if (ctrlN.match(event)) {
                try {

                    loadScene(stage, "/com/system/LoginAndCreate/LoginAdminFX.fxml", "Admin Login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                event.consume();
            }

        });

        stage.show();
    }


    //LOAD SCENE
    private void loadScene(Stage stage, String fxmlPath, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginAcc.class.getResource(fxmlPath));
        Parent root = fxmlLoader.load();
        scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(title);
    }


}