package com.example.projectta3;

import com.example.Avabilities.Doctor;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class DoctorSearchCell extends ListCell<Doctor> {


    public final DoctorSearchItemCLR doctorSearchItemCLR = new DoctorSearchItemCLR();
    final Node view = doctorSearchItemCLR.getView();

    @Override
    protected void updateItem(Doctor doctor, boolean b) {
        super.updateItem(doctor, b);

        if(b) {
            setGraphic(null);
        }
        else {
            doctorSearchItemCLR.setDoctor(doctor);
            setGraphic(view);
        }
    }

}
