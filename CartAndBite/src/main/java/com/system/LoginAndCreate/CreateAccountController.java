package com.system.LoginAndCreate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class CreateAccountController {



    LoginAndCreateData data = new LoginAndCreateData();


    @FXML
    private TextField CreateFirstNField, CreateLastNField, CreateUNField;
    @FXML
    private TextField CreateMobileField;
    @FXML
    private TextField CreateAddressField;
    @FXML
    private PasswordField CreatePWField;
    @FXML
    private PasswordField CreateConfirmPWField;


    @FXML
    private void getStarted(){
        String firstname = CreateFirstNField.getText();
        String lastname = CreateLastNField.getText();
        String username = CreateUNField.getText();
        String password = CreatePWField.getText();
        String mobile = CreateMobileField.getText();
        String address = CreateAddressField.getText();

        String confirmPassword = CreateConfirmPWField.getText();

        if (fieldEmpty(username, firstname, lastname, mobile, address, password)){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();


        }else if (password.equals(confirmPassword)) {
             data.insertCustomer(firstname, lastname, username, password, mobile, address);


        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password not match");
            alert.setHeaderText(null);
            alert.setContentText("Confirming password not match. Please try again.");
            alert.showAndWait();

            CreatePWField.clear();
            CreateConfirmPWField.clear();
        }


    }





    //Switch To Login
    @FXML
    protected void switchToLoginAcc(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/system/LoginAndCreate/LoginAccFX.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //Field is Empty
    public boolean fieldEmpty(String username, String firstname, String lastname, String mobileNumber, String address, String password){

        if (username.isEmpty() || firstname.isEmpty() || lastname.isEmpty() || mobileNumber.isEmpty() || address.isEmpty() || password.isEmpty()){
            return true;
        }
        return false;
    }


    //Clear All Field
    public void clearAllField(){

        CreateUNField.clear();
        CreateFirstNField.clear();
        CreateLastNField.clear();
        CreateMobileField.clear();
        CreateAddressField.clear();
        CreatePWField.clear();
        CreateConfirmPWField.clear();
    }

}
