package com.example.projectta3;

import com.example.Avabilities.MonthlyPaid;
import com.example.Avabilities.MyDate;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StatueServantCLR implements Initializable {

    @FXML
    private JFXButton GetPaid;

    @FXML
    private Label Checkout;

    @FXML
    private Label MonthlyIncome;

    @FXML
    private JFXListView<MyDate> listBussinessDate;

    @FXML
    void GetPaid(MouseEvent event) {
        Main.myHospital.getServantManager().getServants().
                get(Main.myHospital.getServantManager().getServantIndex()).registerGetPaid();
    }

    @FXML
    void back(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainServant.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void exit(MouseEvent event) {
        System.exit(1);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        MonthlyPaid monthlyPaid = Main.myHospital.getServantManager().getServants().
                get(Main.myHospital.getServantManager().getServantIndex()).getPaid();

        if(monthlyPaid.isCheckout()) GetPaid.setDisable(true);

        MonthlyIncome.setText(monthlyPaid.getMonthlyIncome()+"");
        Checkout.setText((monthlyPaid.isCheckout())? "True" : "False");

        ObservableList<MyDate> myDates = FXCollections.observableArrayList(
                Main.myHospital.getServantManager().getServants()
                        .get(Main.myHospital.getServantManager().getServantIndex()).getBusinessDates()
        );

        listBussinessDate.setItems(myDates);
        listBussinessDate.setCellFactory(param -> new BussinessDateCell());
    }

}
