package com.example.projectta3;

import com.example.Avabilities.DailyWeekTurn;
import com.example.Avabilities.Turn;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class GetTurnPatientCLR {

    @FXML
    private TextField inputDoctorID;

    @FXML
    private JFXListView<Turn> listGetTurn;

    @FXML
    void Search(MouseEvent event) {

        ArrayList<DailyWeekTurn> WTurns = Main.myHospital.getDoctorManager().getFreeTurns(inputDoctorID.getText());
        ArrayList<Turn> turnsTemp = new ArrayList<>();

        for(DailyWeekTurn dailyWeekTurn : WTurns) {
            turnsTemp.addAll(dailyWeekTurn.getDailyTurns());
        }

        ObservableList<Turn> turns = FXCollections.observableArrayList(turnsTemp);

        listGetTurn.setItems(turns);
        listGetTurn.setCellFactory(param -> new GetTurnPatientCell());
    }

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

}
