package com.example.projectta3;

import com.example.Avabilities.Turn;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class WeeklyTurnCell extends ListCell<Turn> {

    public final TurnsRegisteredItemCLR turnsRegisteredItemCLR = new TurnsRegisteredItemCLR();
    final Node view = turnsRegisteredItemCLR.getView();

    @Override
    protected void updateItem(Turn turn, boolean b) {
        super.updateItem(turn, b);

        if(b) {
            setGraphic(null);
        }
        else {
            turnsRegisteredItemCLR.setTurn(turn);
            setGraphic(view);
        }
    }

}
