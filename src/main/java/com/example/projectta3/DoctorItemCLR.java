package com.example.projectta3;

import com.example.Avabilities.Doctor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class DoctorItemCLR {

    @FXML
    private Label ID;

    @FXML
    private Label Name;

    @FXML
    private Label Speciality;

    @FXML
    private AnchorPane boxDoctor;


    public DoctorItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctorItem.fxml"));
            loader.setController(this);
            boxDoctor = loader.load();
        }
        catch (Exception e) {

        }
    }
    public void setDoctor(Doctor doctor) {

        Name.setText(doctor.getFirstName() + doctor.getLastName());
        ID.setText(doctor.getID());
        Speciality.setText(doctor.getSpeciality());
    }

    public Node getView() {
        return boxDoctor;
    }

}
