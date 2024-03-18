package com.example.lab3;

import Data.CarData;
import Data.DataClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Window2Controller implements Initializable {

    private CarData carData;

    @FXML
    private Label brandLabel;
    @FXML
    private Label modelLabel;
    @FXML
    private Label rentTermLabel;

    @FXML
    private Button sendButton;
    public CarData getCarData() {
        return carData;
    }

    public void setCarData(CarData carData) {
        this.carData = carData;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getData(new ActionEvent());
    }
    @FXML
    void getData(ActionEvent event) {
        brandLabel.setText(carData.getBrand());
        modelLabel.setText(carData.getModel());
        rentTermLabel.setText(Integer.toString(carData.getRentDuration()) + " days");
    }
}
