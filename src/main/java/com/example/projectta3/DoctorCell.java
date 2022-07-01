package com.example.projectta3;

import com.example.Avabilities.Doctor;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class DoctorCell extends ListCell<Doctor> {

    public final DoctorItemCLR doctorItemCLR = new DoctorItemCLR();
    final Node view = doctorItemCLR.getView();

    @Override
    protected void updateItem(Doctor doctor, boolean b) {
        super.updateItem(doctor, b);

        if(b) {
            setGraphic(null);
        }
        else {
            doctorItemCLR.setDoctor(doctor);
            setGraphic(view);
        }
    }

}
