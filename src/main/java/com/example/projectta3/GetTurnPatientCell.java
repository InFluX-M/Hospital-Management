package com.example.projectta3;

import com.example.Avabilities.Turn;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class GetTurnPatientCell extends ListCell<Turn> {

    public final GetTurnPatientItemCLR getTurnPatientItemCLR = new GetTurnPatientItemCLR();
    final Node view = getTurnPatientItemCLR.getView();

    @Override
    protected void updateItem(Turn turn, boolean b) {
        super.updateItem(turn, b);

        if(b) {
            setGraphic(null);
        }
        else {
            getTurnPatientItemCLR.setTurn(turn);
            setGraphic(view);
        }
    }

}
