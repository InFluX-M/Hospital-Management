package com.example.projectta3;

import com.example.Avabilities.MyDate;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class BussinessDateCell extends ListCell<MyDate> {


    public final BussinessDateItemCLR bussinessDateItemCLR = new BussinessDateItemCLR();
    final Node view = bussinessDateItemCLR.getView();

    @Override
    protected void updateItem(MyDate date, boolean b) {
        super.updateItem(date, b);

        if(b) {
            setGraphic(null);
        }
        else {
            bussinessDateItemCLR.setBussinessDate(date);
            setGraphic(view);
        }
    }

}
