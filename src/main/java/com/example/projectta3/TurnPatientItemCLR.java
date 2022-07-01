package com.example.projectta3;

import com.example.Avabilities.Turn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TurnPatientItemCLR {

    @FXML
    private Label DoctorID;

    @FXML
    private Label Statue;

    @FXML
    private Label Time;

    @FXML
    private Label TurnNumber;

    @FXML
    private Label Emergency;

    @FXML
    private AnchorPane boxTurn;


    public TurnPatientItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TurnPatientItem.fxml"));
            loader.setController(this);
            boxTurn = loader.load();
        }
        catch (Exception e) {

        }
    }
    public void setTurn(Turn turn) {

        TurnNumber.setText(turn.getTurnNumber());
        DoctorID.setText(turn.getDoctorID());
        Statue.setText(turn.isVisited()+"");
        Time.setText(turn.getTurnTime().toString());
        Emergency.setText(turn.isEmergency()+"");
    }

    public Node getView() {
        return boxTurn;
    }


}
