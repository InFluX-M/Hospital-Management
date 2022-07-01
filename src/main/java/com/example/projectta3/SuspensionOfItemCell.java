package com.example.projectta3;

import com.example.Avabilities.Employee;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class SuspensionOfItemCell extends ListCell<Employee> {

    public final SuspensionOfDoctorItemCLR suspensionOfDoctorItemCLR = new SuspensionOfDoctorItemCLR();
    final Node view = suspensionOfDoctorItemCLR.getView();

    @Override
    protected void updateItem(Employee doctor, boolean b) {
        super.updateItem(doctor, b);

        if(b) {
            setGraphic(null);
        }
        else {
            suspensionOfDoctorItemCLR.setSuspensionOfDoctor(doctor);
            setGraphic(view);
        }
    }

}
