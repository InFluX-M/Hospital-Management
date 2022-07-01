package com.example.projectta3;

import com.example.projectta3.Main;
import com.example.Avabilities.Secretary;
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

public class RegisterSecretaryDoctorCLR implements Initializable {

    @FXML
    private Label ID;
    @FXML
    private JFXButton backButton;
    @FXML
    private TextField inputDailyWorkDutyTime;
    @FXML
    private TextField inputEmail;
    @FXML
    private TextField inputFirstName;
    @FXML
    private TextField inputHourlyWages;
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
    private Label statue;

    @FXML
    void back(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainDoctor.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void register(MouseEvent event) {

        String doctorID = Main.myHospital.getDoctorManager().getDoctors().get(Main.myHospital.getDoctorManager().getDrIndex()).getID();

        Secretary secretary = new Secretary(inputFirstName.getText(), inputLastName.getText(), inputUserName.getText()
                , inputPassword.getText(), inputPhoneNumber.getText(), inputEmail.getText()
                ,Integer.toString(Main.myHospital.getDoctorManager().getDoctors().size() + 10000)
                , Integer.parseInt(inputDailyWorkDutyTime.getText()), Integer.parseInt(inputHourlyWages.getText()),doctorID);

        Main.myHospital.getDoctorManager().addSecretaryDr(secretary);
        statue.setText("Secretary Registered Successfully... :)");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setText("ID: "+(Main.myHospital.getSecretaryManager().getSecretaries().size() + 10000));
    }

}
