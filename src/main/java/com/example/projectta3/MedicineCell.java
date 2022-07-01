package com.example.projectta3;

import com.example.Avabilities.Medicine;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class MedicineCell extends ListCell<Medicine> {

    public final MedicineItemCLR medicineItemCLR = new MedicineItemCLR();
    final Node view = medicineItemCLR.getView();

    @Override
    protected void updateItem(Medicine medicine, boolean b) {
        super.updateItem(medicine, b);

        if(b) {
            setGraphic(null);
        }
        else {
            medicineItemCLR.setMedicine(medicine);
            setGraphic(view);
        }
    }

}
