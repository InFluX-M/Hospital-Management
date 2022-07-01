package com.example.projectta3;

import com.example.projectta3.Main;
import com.example.Avabilities.Turn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GetTurnPatientItemCLR implements Initializable{

    @FXML
    private Label Day;

    @FXML
    private Label Time;

    @FXML
    private Label TurnNumber;

    @FXML
    private AnchorPane boxTurn;
    @FXML
    private ComboBox<String> emergency;

    @FXML
    void Reserve(MouseEvent event) {

        boolean t;
        if(emergency.getValue().equals("True")) {
            t = true;
        }
        else {
            t = false;
        }
        Main.myHospital.getDoctorManager().getTurn(turn.getDoctorID(), turn.getTurnNumber(), t);

    }

    public void setEmergency() {

        emergency.getItems().addAll(
                "True","False"
        );
    }


    private Turn turn;

    public GetTurnPatientItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GetTurnPatientItem.fxml"));
            loader.setController(this);
            boxTurn = loader.load();
        }
        catch (Exception e) {

        }
    }

    public void setTurn(Turn turn) {

        this.turn = turn;
        Day.setText(turn.getTurnTime().dailyWeek()+"");
        TurnNumber.setText(turn.getTurnNumber());
        Time.setText(turn.getTurnTime().toString());
    }

    public Node getView() {
        return boxTurn;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEmergency();
    }
}
