package com.example.projectta3;

import com.example.Avabilities.Prescription;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class PrescriptionPatientCell extends ListCell<Prescription> {

    public final PrescriptionPatientItemCLR prescriptionPatientItemCLR = new PrescriptionPatientItemCLR();
    final Node view = prescriptionPatientItemCLR.getView();

    @Override
    protected void updateItem(Prescription prescription, boolean b) {
        super.updateItem(prescription, b);

        if(b) {
            setGraphic(null);
        }
        else {
            prescriptionPatientItemCLR.setPrescription(prescription);
            setGraphic(view);
        }
    }

}
