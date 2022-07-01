package com.example.projectta3;

import com.example.Avabilities.Prescription;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class HistoryPrescriptionPatientCLR implements Initializable {

    @FXML
    private JFXListView<Prescription> listHistoryPrescriptions;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Prescription> prescriptions = FXCollections.observableArrayList(
                Main.myHospital.getPatientManager().historyPrescriptionsPatient()
        );

        listHistoryPrescriptions.setItems(prescriptions);
        listHistoryPrescriptions.setCellFactory(param -> new PrescriptionPatientCell());
    }

}
