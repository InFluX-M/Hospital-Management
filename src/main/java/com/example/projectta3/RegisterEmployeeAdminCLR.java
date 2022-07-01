package com.example.projectta3;

import com.example.Avabilities.Custodian;
import com.example.Avabilities.Doctor;
import com.example.projectta3.Main;
import com.example.Avabilities.Servant;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterEmployeeAdminCLR implements Initializable {

    @FXML
    private Label ID;

    @FXML
    private JFXButton backButton;
    @FXML
    private TextArea inputBiography;
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
    private TextField inputSpeciality;
    @FXML
    private TextField inputUserName;
    @FXML
    private Label labelRegister;
    @FXML
    private JFXButton registerButton;
    @FXML
    private ComboBox<String> comboRules;
    @FXML
    private Label statue;


    @FXML
    void rule(MouseEvent event) {

//        switch (comboRules.getValue()) {
//            case "Doctor" -> labelRegister.setText("ID: " + (Main.myHospital.getDoctorManager().getDoctors().size() + 1000));
//            case "Servant" -> labelRegister.setText("ID: " + (Main.myHospital.getDoctorManager().getDoctors().size() + 100000));
//            case "Custodian" -> labelRegister.setText("ID: " + (Main.myHospital.getDoctorManager().getDoctors().size() + 1000000));
//        }

    }

    @FXML
    void back(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainAdmin.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void register(MouseEvent event) {

        switch (comboRules.getValue()) {

            case "Doctor":
                ID.setText("ID: "+(Main.myHospital.getDoctorManager().getDoctors().size() + 1000));
                Doctor doctor = new Doctor(inputFirstName.getText(), inputLastName.getText(), inputUserName.getText()
                        , inputPassword.getText(), inputPhoneNumber.getText(), inputEmail.getText()
                        ,Integer.toString(Main.myHospital.getDoctorManager().getDoctors().size() + 1000)
                        , Integer.parseInt(inputDailyWorkDutyTime.getText()), Integer.parseInt(inputHourlyWages.getText())
                        , inputSpeciality.getText(), inputBiography.getText());

                Main.myHospital.getAdminManager().addDoctor(doctor);
                statue.setText("Doctor Registered Successfully... :)");

                break;

            case "Servant":
                ID.setText("ID: "+(Main.myHospital.getServantManager().getServants().size() + 100));
                Servant servant = new Servant(inputFirstName.getText(), inputLastName.getText(), inputUserName.getText()
                        , inputPassword.getText(), inputPhoneNumber.getText(), inputEmail.getText()
                        ,Integer.toString(Main.myHospital.getServantManager().getServants().size() + 100)
                        , Integer.parseInt(inputDailyWorkDutyTime.getText()), Integer.parseInt(inputHourlyWages.getText()));

                Main.myHospital.getAdminManager().addServant(servant);
                statue.setText("Servant Registered Successfully... :)");
                break;

            case "Custodian":
                ID.setText("ID: "+(1400));
                Custodian custodian = new Custodian(inputFirstName.getText(), inputLastName.getText(), inputUserName.getText()
                        , inputPassword.getText(), inputPhoneNumber.getText(), inputEmail.getText()
                        ,Integer.toString(1400)
                        , Integer.parseInt(inputDailyWorkDutyTime.getText()), Integer.parseInt(inputHourlyWages.getText()));

                Main.myHospital.getAdminManager().addCustodian(custodian);
                statue.setText("Custodian Registered Successfully... :)");
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setComboRules();
    }

    public void setComboRules() {

        comboRules.getItems().addAll(
                "Doctor","Servant","Custodian"
        );
    }

}
