package com.example.lab3;

import Data.CarData;
import Data.DataClass;
import Data.SingletonCar;
import Utility.InputFormatting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Window1Controller implements Initializable {
    private CarData carData;

    @FXML
    private ChoiceBox<String> brandSelection;

    @FXML
    private ChoiceBox<String> modelSelection;

    @FXML
    private TextField termInput;
    @FXML
    private Button sendButton;

    public int rentPeriod;

    private String[] brands = {"Audi", "BMW", "Mercedes"};
    private String[][] models = {
            {"A1", "A3", "A4", "A5", "A6", "A7", "A8"},
            {"1 Series", "2 Series", "3 Series", "4 Series", "5 Series", "6 Series", "7 Series"},
            {"A Class", "B Class", "C Class", "E Class", "S Class"}
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brandSelection.getItems().addAll(brands);
        brandSelection.setOnAction(this::getBrandSelection);

        InputFormatting.formatToInt(termInput);
        termInput.setOnAction(this::getTermInput);

//        sendButton.setOnAction(this::rentCar);
    }

    private void getBrandSelection(ActionEvent event) {
        if (Objects.equals(brandSelection.getValue(), "Audi")) {
            modelSelection.getItems().clear();
            modelSelection.getItems().addAll(models[0]);
        } else if (Objects.equals(brandSelection.getValue(), "BMW")) {
            modelSelection.getItems().clear();
            modelSelection.getItems().addAll(models[1]);
        } else if (Objects.equals(brandSelection.getValue(), "Mercedes")) {
            modelSelection.getItems().clear();
            modelSelection.getItems().addAll(models[2]);
        }
    }

    private void getTermInput(ActionEvent event) {
        rentPeriod = Integer.parseInt(termInput.getText());
    }

    @FXML
    void rentCar(ActionEvent event) throws IOException {
        SingletonCar singletonCar = SingletonCar.getInstance();
        carData = singletonCar.getCarData();
        carData.setBrand(brandSelection.getValue());
        carData.setModel(modelSelection.getValue());
        carData.setRentDuration(Integer.parseInt(termInput.getText()));

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("window2.fxml"));

        Window2Controller window2Controller = new Window2Controller();
        window2Controller.setCarData(carData);
        fxmlLoader.setController(window2Controller);

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("output");
        stage.setScene(scene);
        stage.show();
    }
}