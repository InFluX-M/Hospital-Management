package com.example.projectta3;

import com.example.projectta3.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Label statueLogin;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private ComboBox<String> comboRules;

    @FXML
    private TextField inputUserName;

    @FXML
    private Circle circle1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        Image img1 = new Image(getClass().getResource("hospital-logo-and-symbols-template-icons-vector.jpg").toExternalForm());
//        circle1.setFill(new ImagePattern(img1));

        setComboRules();

    }

    public void setComboRules() {

        comboRules.getItems().addAll(
             "Admin","Doctor","Patient","Secretary","Servant","Custodian"
        );
    }

    @FXML
    void createNewProfile(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("CreateNewProfile.fxml"));
            Stage s1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s1.setScene(scene);
            s1.show();
        }
        catch (IOException e) {

        }

    }

    @FXML
    void login(MouseEvent event) {

        String userName = inputUserName.getText();
        String password = inputPassword.getText();
        String rule = comboRules.getValue().toString();

        int loginStatue = Main.myHospital.login(userName, password, rule);

        switch (loginStatue) {

            case 0 -> {

                try {
                    Parent root = FXMLLoader.load(getClass().getResource("MainAdmin.fxml"));
                    Stage s1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    s1.setScene(scene);
                    s1.show();
                }
                catch (IOException e) {

                }

            }
            case 1 -> {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("MainDoctor.fxml"));
                    Stage s1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    s1.setScene(scene);
                    s1.show();
                }
                catch (IOException e) {

                }

            }
            case 2 -> {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("MainPateint.fxml"));
                    Stage s1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    s1.setScene(scene);
                    s1.show();
                }
                catch (IOException e) {

                }

            }
            case 3 -> {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("MainSecretary.fxml"));
                    Stage s1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    s1.setScene(scene);
                    s1.show();
                }
                catch (IOException e) {

                }

            }
            case 4 -> {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("MainServant.fxml"));
                    Stage s1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    s1.setScene(scene);
                    s1.show();
                }
                catch (IOException e) {

                }

            }
            case 5 -> {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("MainCustodian.fxml"));
                    Stage s1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    s1.setScene(scene);
                    s1.show();
                }
                catch (IOException e) {

                }

            }
            case 15 -> {
                statueLogin.setText("You Have Been Suspened... :(");
            }
            default -> {
                statueLogin.setText("Input Information is Wrong... :(");
            }
        }

    }
}

