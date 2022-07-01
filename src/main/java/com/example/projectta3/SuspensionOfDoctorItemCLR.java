package com.example.projectta3;

import com.example.Avabilities.Employee;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SuspensionOfDoctorItemCLR {

    @FXML
    private Label DailyWorkDutyTime;

    @FXML
    private Label HourlyWages;

    @FXML
    private Label ID;

    @FXML
    private Label Name;

    @FXML
    private Label NumberOfWeeklyAbsences;

    @FXML
    private JFXButton Suspened;

    @FXML
    private AnchorPane boxCrash;

    @FXML
    void Check(MouseEvent event) {
        doctor.setSuspension(true);
    }

    private Employee doctor;

    public SuspensionOfDoctorItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SuspensionOfDoctorItem.fxml"));
            loader.setController(this);
            boxCrash = loader.load();
        }
        catch (Exception e) {

        }
    }
    public void setSuspensionOfDoctor(Employee doctor) {

        this.doctor = doctor;
        ID.setText(doctor.getID());
        Name.setText(doctor.getFirstName()+" "+doctor.getLastName());
        HourlyWages.setText(doctor.getHourlyWages()+"");
        NumberOfWeeklyAbsences.setText(doctor.getNumberOfWeeklyAbsences()+"");
        DailyWorkDutyTime.setText(doctor.getDailyWorkDutyTime()+"");
    }

    public Node getView() {
        return boxCrash;
    }

}
