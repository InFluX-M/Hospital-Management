package com.example.projectta3;

import com.example.projectta3.Main;
import com.example.Avabilities.Medicine;
import com.example.Avabilities.MyDate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterMedicineAdminCLR implements Initializable {

    @FXML
    private TextField inputUserName;
    @FXML
    private TextField inputStock;
    @FXML
    private TextField inputProductionDate;
    @FXML
    private TextField inputExpirationDate;
    @FXML
    private TextField inputPrice;

    @FXML
    private Label ID;
    @FXML
    private Label statue;

    @FXML
    void back(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainAdmin.fxml"));
            Stage s1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void register(MouseEvent event) {

        ID.setText(""+(Main.myHospital.getMedicines().size() + 1000000));

        String[] pr = inputProductionDate.getText().split(",");
        String[] ex = inputExpirationDate.getText().split(",");


        MyDate production = new MyDate(Integer.parseInt(pr[0]), Integer.parseInt(pr[1]), Integer.parseInt(pr[2]));
        MyDate expiration = new MyDate(Integer.parseInt(ex[0]), Integer.parseInt(ex[1]), Integer.parseInt(ex[2]));

        Medicine tempMed = new Medicine(Integer.toString(Main.myHospital.getMedicines().size() + 1000000)
                            , inputUserName.getText(), Integer.parseInt(inputStock.getText())
                            , Double.parseDouble(inputPrice.getText()), production, expiration);

        Main.myHospital.getAdminManager().addMedicine(tempMed);

        statue.setText("Medicine Added Successfully... :)");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
