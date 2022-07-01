package com.example.projectta3;

import com.example.projectta3.Main;
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

public class EditInformationPatientCLR implements Initializable {

    @FXML
    private Label Email;

    @FXML
    private Label Username;

    @FXML
    private Label Name;

    @FXML
    private Label Password;

    @FXML
    private Label PhoneNumber;

    @FXML
    private JFXButton backButton;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputPassword;

    @FXML
    private TextField inputPhoneNumber;

    @FXML
    private Label labelRegister;

    @FXML
    private Label statue;

    @FXML
    void back(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainPateint.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }

    }

    @FXML
    void edit(MouseEvent event) {

        if(inputName.getText() != null) {
            Main.myHospital.getPatientManager().editInformationPatient("name", inputName.getText());

        }
        if(inputPassword.getText() != null) {
            Main.myHospital.getPatientManager().editInformationPatient("password", inputPassword.getText());

        }
        if(inputEmail.getText() != null) {
            Main.myHospital.getPatientManager().editInformationPatient("phoneNumber", inputEmail.getText());

        }
        if(inputPhoneNumber.getText() != null) {
            Main.myHospital.getPatientManager().editInformationPatient("email", inputPhoneNumber.getText());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] patientInformation = Main.myHospital.getPatientManager().patientInformation().split(" ");
        Username.setText(patientInformation[0]);
        Name.setText(patientInformation[1]);
        Password.setText(patientInformation[2]);
        PhoneNumber.setText(patientInformation[3]);
        Email.setText(patientInformation[4]);

    }
}
