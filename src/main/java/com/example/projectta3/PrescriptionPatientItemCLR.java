package com.example.projectta3;

import com.example.Avabilities.Medicine;
import com.example.Avabilities.Prescription;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PrescriptionPatientItemCLR {

    Prescription prescription;

    @FXML
    private Label DoctorID;

    @FXML
    private Label NumOfMedicines;

    @FXML
    private Label Time;

    @FXML
    private Label TurnNumber;

    @FXML
    void click(MouseEvent event) {

        for(Medicine medicine : prescription.getMedicines()) {
            System.out.println(medicine.getName() + " " +medicine.getPrice());
        }

    }

    @FXML
    private AnchorPane boxPrescription;

    public PrescriptionPatientItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PrescriptionPatientItem.fxml"));
            loader.setController(this);
            boxPrescription = loader.load();
        }
        catch (Exception e) {

        }
    }
    public void setPrescription(Prescription prescription) {

        this.prescription = prescription;

        TurnNumber.setText(prescription.getNumber());
        DoctorID.setText(prescription.getDoctorID());
        Time.setText(prescription.getDate().toString(true));
        NumOfMedicines.setText(prescription.getMedicines().size()+"");
    }

    public Node getView() {
        return boxPrescription;
    }


}
