package com.example.Avabilities;

import com.example.projectta3.CrashItemCLR;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class CrashCell extends ListCell<Crash> {


    public final CrashItemCLR crashItemCLR = new CrashItemCLR();
    final Node view = crashItemCLR.getView();

    @Override
    protected void updateItem(Crash crash, boolean b) {
        super.updateItem(crash, b);

        if(b) {
            setGraphic(null);
        }
        else {
            crashItemCLR.setCrash(crash);
            setGraphic(view);
        }
    }

}
