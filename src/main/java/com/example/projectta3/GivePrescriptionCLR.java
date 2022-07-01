package com.example.projectta3;

import com.example.projectta3.Main;
import com.example.Avabilities.Turn;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GivePrescriptionCLR {

    @FXML
    private TextField inputMedicines;
    @FXML
    private JFXButton registerButton;

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
    void register(MouseEvent event) {

        String[] medicinesTemp = inputMedicines.getText().split(",");
        ArrayList<String> medicines = new ArrayList<>();

        medicines.addAll(Arrays.asList(medicinesTemp));
        Turn lastTurn = Main.myHospital.getDoctorManager().getDoctors().get(Main.myHospital.getDoctorManager().getDrIndex()).getSecretary()
                        .visitPatient();

        Main.myHospital.getDoctorManager().givePrescription(lastTurn, medicines);

    }


}
