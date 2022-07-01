package com.example.projectta3;

import com.example.Avabilities.Crash;
import com.example.projectta3.Main;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CrashItemCLR {


    @FXML
    private AnchorPane boxCrash;

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

        this.crash.checked = true;
        this.crash.confirmation = true;
        Main.myHospital.getServantManager().getCrashes().remove(crash);
    }

    private Crash crash;

    public CrashItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Crash-Item.fxml"));
            loader.setController(this);
            boxCrash = loader.load();
        }
        catch (Exception e) {

        }
    }
    public void setCrash(Crash crash) {

        this.crash = crash;
        Object.setText(crash.object);
        Reason.setText(crash.reason);
        Description.setText(crash.description);
        Varification.setText((crash.confirmation)? "Yes" : "No");
    }

    public Node getView() {
        return boxCrash;
    }


}
