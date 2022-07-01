package com.example.projectta3;

import com.example.Avabilities.Turn;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class TurnPatientCell extends ListCell<Turn> {

    public final TurnPatientItemCLR turnPatientItemCLR = new TurnPatientItemCLR();
    final Node view = turnPatientItemCLR.getView();

    @Override
    protected void updateItem(Turn turn, boolean b) {
        super.updateItem(turn, b);

        if(b) {
            setGraphic(null);
        }
        else {
            turnPatientItemCLR.setTurn(turn);
            setGraphic(view);
        }
    }

}
