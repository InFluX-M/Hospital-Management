package com.example.projectta3;

import com.example.Avabilities.Medicine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MedicineItemCLR {

    @FXML
    private Label Expiration;

    @FXML
    private Label Name;

    @FXML
    private Label Price;

    @FXML
    private Label Production;

    @FXML
    private Label Stock;

    @FXML
    private AnchorPane boxMedicine;

    public MedicineItemCLR() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Medicine-Item.fxml"));
            loader.setController(this);
            boxMedicine = loader.load();
        }
        catch (Exception e) {

        }
    }
    public void setMedicine(Medicine medicine) {

        Name.setText(medicine.getName());
        Price.setText(medicine.getPrice()+"");
        Production.setText(medicine.getProduction().toString(true));
        Expiration.setText(medicine.getExpiration().toString(true));
        Stock.setText(medicine.getStock()+"");
    }

    public Node getView() {
        return boxMedicine;
    }


}
