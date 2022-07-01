package com.example.Avabilities;

import com.example.projectta3.Main;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class EquipmentItemController {


    @FXML
    private AnchorPane boxEquipment;

    @FXML
    private Label Description;

    @FXML
    private Label Object;

    @FXML
    private Label Reason;

    @FXML
    private Label Varification;

    @FXML
    private JFXButton check;


    @FXML
    void Check(MouseEvent event) {

        this.equipment.checked = true;
        this.equipment.verification = true;
        Main.myHospital.getServantManager().getEquipments().remove(equipment);
    }

    private Equipment equipment;

    public EquipmentItemController() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Equipment-Item.fxml"));
            loader.setController(this);
            boxEquipment = loader.load();
        }
        catch (Exception e) {

        }
    }
    public void setEquipment(Equipment equipment) {

        this.equipment = equipment;
        Object.setText(equipment.object);
        Reason.setText(equipment.reason);
        Description.setText(equipment.description);
        Varification.setText((equipment.verification)? "Yes" : "No");
    }

    public Node getView() {
        return boxEquipment;
    }

}
