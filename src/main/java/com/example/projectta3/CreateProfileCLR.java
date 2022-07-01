package com.example.projectta3;

import com.example.projectta3.Main;
import com.example.Avabilities.Patient;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateProfileCLR implements Initializable {

    @FXML
    private JFXButton backButton;

    @FXML
    private TextField inputEmail;
    @FXML
    private TextField inputFirstName;
    @FXML
    private TextField inputLastName;
    @FXML
    private TextField inputPassword;
    @FXML
    private TextField inputPhoneNumber;
    @FXML
    private TextField inputUserName;
    @FXML
    private Label labelRegister;
    @FXML
    private JFXButton registerButton;

    @FXML
    void back(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void register(MouseEvent event) {

        if (!Main.myHospital.getPatientManager().availableUserName(inputUserName.getText()))
            labelRegister.setText("This UserName already Exists... :(");
        else {
            Patient patient = new Patient(inputUserName.getText(), inputFirstName.getText(), inputLastName.getText(),
                    inputPassword.getText(), inputPhoneNumber.getText(), inputEmail.getText());

            Main.myHospital.getPatientManager().addPatient(patient);
            labelRegister.setText("Patient Registered Successfully... :)");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

}
