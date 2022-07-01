package com.example.Avabilities;

import com.example.projectta3.DoctorSearchCell;
import com.example.projectta3.Main;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchDoctorPatient implements Initializable {


    @FXML
    private JFXListView<Doctor> listDoctors;

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
    void exit(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    private TextField inputUserName;

    @FXML
    void Speciality(MouseEvent event) {

        ArrayList<Doctor> specialDoctor = new ArrayList<>();

        for (Doctor hospitalDoctor : Main.myHospital.getDoctorManager().getDoctors()) {
            if (hospitalDoctor.getSpeciality().equals(inputUserName.getText())) {
                specialDoctor.add(hospitalDoctor);
            }
        }

        ObservableList<Doctor> doctors = FXCollections.observableArrayList(
                specialDoctor
        );

        listDoctors.setItems(doctors);
        listDoctors.setCellFactory(param -> new DoctorSearchCell());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

}
