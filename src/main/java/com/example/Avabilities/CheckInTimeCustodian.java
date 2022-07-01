package com.example.Avabilities;

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

public class CheckInTimeCustodian implements Initializable {

    @FXML
    private TextField inputEntryTime;

    @FXML
    private TextField inputID;

    @FXML
    private Label statue;

    @FXML
    void back(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainCustodian.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void register(MouseEvent event) {

        String[] p = inputEntryTime.getText().split(",");

        MyDate now = Main.myHospital.getNowDate();
        MyDate entryDate = new MyDate(now.year, now.month, now.day,
                Integer.parseInt(p[0]), Integer.parseInt(p[1]));

        CheckIn_OutEmployee checkInTime = new CheckIn_OutEmployee(inputID.getText(),entryDate);
        Main.myHospital.getCustodianManager().addCheckInTime(checkInTime);

        statue.setText("Check-In Time Registered Successfully... :)");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
