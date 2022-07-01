package com.example.projectta3;

import com.example.Avabilities.Turn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TurnsRegisteredItemCLR {

    @FXML
    private Label Emergency;

    @FXML
    private Label TurnNumber;

    @FXML
    private Label UserName;

    @FXML
    private Label Visited;

    @FXML
    private AnchorPane boxTurn;

    public TurnsRegisteredItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TurnsRegisteredItem.fxml"));
            loader.setController(this);
            boxTurn = loader.load();
        }
        catch (Exception e) {

        }
    }

    public void setTurn(Turn turn) {

        TurnNumber.setText(turn.getTurnNumber());
        UserName.setText(turn.getUserName());
        Emergency.setText(turn.isEmergency()+"");
        Visited.setText(turn.isVisited()+"");
    }

    public Node getView() {
        return boxTurn;
    }

}
