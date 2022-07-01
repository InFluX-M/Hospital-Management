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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VisitPatientCLR implements Initializable {


    @FXML
    private Label name;
    @FXML
    private Label turnNumber;
    @FXML
    private JFXButton visitButton;

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
    void exit(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    void visit(MouseEvent event) {

        Main.myHospital.getDoctorManager().getDoctors().get(Main.myHospital.getDoctorManager().getDrIndex()).getSecretary()
                .visitedLastTurn();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("GivePrescriptionDoctor.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String temp = Main.myHospital.getDoctorManager().visitPatientInformation();

        if(temp.length() >= 1) {
            String[] informationTemp = temp.split(" ");

            turnNumber.setText(informationTemp[0]);
            name.setText(informationTemp[1]);
        }
        else
        {
            turnNumber.setText("The Patient Waiting List is Empty... :)");
            name.setText("");
            visitButton.setDisable(true);
        }


    }
}
