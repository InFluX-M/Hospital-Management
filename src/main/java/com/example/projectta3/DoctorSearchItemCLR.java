package com.example.projectta3;

import com.example.Avabilities.Doctor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class DoctorSearchItemCLR {

    @FXML
    private Label ID;

    @FXML
    private Label Name;

    @FXML
    private Label PhoneNumber;

    @FXML
    private AnchorPane boxDoctor;


    public DoctorSearchItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchDoctorItem.fxml"));
            loader.setController(this);
            boxDoctor = loader.load();
        }
        catch (Exception e) {

        }
    }
    public void setDoctor(Doctor doctor) {

        Name.setText(doctor.getFirstName() + doctor.getLastName());
        ID.setText(doctor.getID());
        PhoneNumber.setText(doctor.getPhoneNumber());
    }

    public Node getView() {
        return boxDoctor;
    }


}
