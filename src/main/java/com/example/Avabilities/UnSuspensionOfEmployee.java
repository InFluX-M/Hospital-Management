package com.example.Avabilities;

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

public class UnSuspensionOfEmployee implements Initializable {

    @FXML
    private JFXButton UnSuspened;

    @FXML
    private JFXButton backButton;

    @FXML
    private TextField inputID;

    @FXML
    private Label statue;

    @FXML
    void UnSuspened(MouseEvent event) {

        String ID = inputID.getText();
        Main.myHospital.searchEmployee(ID).setNumberOfWeeklyAbsences(0);
        Main.myHospital.searchEmployee(ID).setSuspension(false);

        statue.setText("UnSuspension Successfully... :)");

    }

    @FXML
    void back(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SuspensionOfEmployeesAdmin.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
