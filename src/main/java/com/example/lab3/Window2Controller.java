package com.example.lab3;

import Data.Car;
import Data.CarData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Window2Controller implements Initializable {

    private Car pCar;

    @FXML
    private Label brandLabel;
    @FXML
    private Label modelLabel;
    @FXML
    private Label rentTermLabel;

    @FXML
    private Button sendButton;
    public Car getCarData() {
        return pCar;
    }

    public void setCarData(Car pCar) {
        this.pCar = pCar;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getData(new ActionEvent());
    }
    @FXML
    void getData(ActionEvent event) {
        brandLabel.setText(pCar.getBrand());
        modelLabel.setText(pCar.getModel());
        rentTermLabel.setText(Integer.toString(pCar.getRentDuration()) + " days");
    }

    @FXML
    void returnToWindow1(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("window1.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Input");
        stage.setScene(scene);
        stage.show();
    }
}
