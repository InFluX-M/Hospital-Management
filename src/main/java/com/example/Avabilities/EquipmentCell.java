package com.example.Avabilities;

import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class EquipmentCell extends ListCell<Equipment> {


    public final EquipmentItemController equipmentItemController = new EquipmentItemController();
    final Node view = equipmentItemController.getView();

    @Override
    protected void updateItem(Equipment equipment, boolean b) {
        super.updateItem(equipment, b);

        if(b) {
            setGraphic(null);
        }
        else {
            equipmentItemController.setEquipment(equipment);
            setGraphic(view);
        }
    }

}
