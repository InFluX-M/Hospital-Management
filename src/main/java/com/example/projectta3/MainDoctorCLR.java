package com.example.projectta3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainDoctorCLR implements Initializable {


    @FXML
    void MedicineList(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MedicineListDoctor.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void RegisterSecretary(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("RegisterSecretaryDoctor.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void VisitPatient(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("VisitPatientDr.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        }
        catch (Exception e) {

        }
    }

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
    void exit(MouseEvent event) {
        System.exit(1);

    }

    @FXML
    void statue(MouseEvent event) {

        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("StatueDoctor.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root1);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

}
