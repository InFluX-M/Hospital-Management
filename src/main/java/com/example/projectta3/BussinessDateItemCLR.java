package com.example.projectta3;

import com.example.Avabilities.MyDate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class BussinessDateItemCLR {

    static int i=1;

    @FXML
    private AnchorPane BussinessDateItem;

    @FXML
    private Label Date;

    @FXML
    private Label Day;

    public BussinessDateItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BussinessDateItem.fxml"));
            loader.setController(this);
            BussinessDateItem = loader.load();
        }
        catch (Exception e) {

        }
    }
    public void setBussinessDate(MyDate date) {

        Day.setText((i++)+"");
        Date.setText(date.toString(true));
    }

    public Node getView() {
        return BussinessDateItem;
    }


}
