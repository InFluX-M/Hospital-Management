package com.example.projectta3;

import com.example.Avabilities.Equipment;
import com.example.projectta3.Main;
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

public class EquipmentRequestServantCLR implements Initializable {

    @FXML
    private TextField inputDescription;

    @FXML
    private TextField inputObject;

    @FXML
    private TextField inputReason;

    @FXML
    private Label statue;

    @FXML
    void back(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainServant.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void Request(MouseEvent event) {

        Equipment equipment = new Equipment(inputObject.getText(), inputReason.getText(), inputDescription.getText());
        Main.myHospital.getServantManager().addEquipmentRequest(equipment);

        statue.setText("Equipment Requested Successfully... :)");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
