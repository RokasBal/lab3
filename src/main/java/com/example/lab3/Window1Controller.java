package com.example.lab3;

import Data.*;
import Utility.InputFormatting;
import Utility.RentingProxy;
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
//    private CarData carData;
    private static Stage stage;
    private Car pCar;
    private String vehicleType;

    @FXML
    private ChoiceBox<String> brandSelection;

    @FXML
    private ChoiceBox<String> modelSelection;
    @FXML
    private ChoiceBox<String> typeSelection;

    @FXML
    private TextField termInput;
    @FXML
    private Button sendButton;

    public int rentPeriod;

    private String[] vehicleTypes = {"Gas", "Hybrid", "EV"};
    private String[] brands = {"Audi", "BMW", "Mercedes"};
    private String[][] gasModels = {
            {"A4", "A6", "A8", "Q3", "Q5", "Q7"},
            {"3 Series", "5 Series", "X5", "X7"},
            {"C Class", "E Class", "S Class"}
    };

    private String[][] hybridModels = {
            {"Q5 TFSI e"},
            {"330e", "530e", "745e"},
            {"E 350e", "GLC 350e"}
    };

    private String[][] evModels = {
            {"e-tron", "e-tron GT"},
            {"i3", "i4", "i8"},
            {"EQC", "EQS"}
    };

    /*
    * Setting actions for drop down menus and formatting text field to only allow integer input.
    */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeSelection.getItems().addAll(vehicleTypes);
        typeSelection.setOnAction(this::getTypeSelection);

        brandSelection.setOnAction(this::getBrandSelection);

        InputFormatting.formatToInt(termInput);
        termInput.setOnAction(this::getTermInput);
    }

    /*
    * Method, which gets user input for vehicle brand selection and adds respective models to model selection drop down menu, based on selected vehicle type.
    */
    private void getBrandSelection(ActionEvent event) {
        if (Objects.equals(brandSelection.getValue(), "Audi")) {
            modelSelection.getItems().clear();
            if(Objects.equals(typeSelection.getValue(), "Gas"))
                modelSelection.getItems().addAll(gasModels[0]);
            else if(Objects.equals(typeSelection.getValue(), "Hybrid"))
                modelSelection.getItems().addAll(hybridModels[0]);
            else if(Objects.equals(typeSelection.getValue(), "EV"))
                modelSelection.getItems().addAll(evModels[0]);
        } else if (Objects.equals(brandSelection.getValue(), "BMW")) {
            modelSelection.getItems().clear();
            if(Objects.equals(typeSelection.getValue(), "Gas"))
                modelSelection.getItems().addAll(gasModels[1]);
            else if(Objects.equals(typeSelection.getValue(), "Hybrid"))
                modelSelection.getItems().addAll(hybridModels[1]);
            else if(Objects.equals(typeSelection.getValue(), "EV"))
                modelSelection.getItems().addAll(evModels[1]);
        } else if (Objects.equals(brandSelection.getValue(), "Mercedes")) {
            modelSelection.getItems().clear();
            if(Objects.equals(typeSelection.getValue(), "Gas"))
                modelSelection.getItems().addAll(gasModels[2]);
            else if(Objects.equals(typeSelection.getValue(), "Hybrid"))
                modelSelection.getItems().addAll(hybridModels[2]);
            else if(Objects.equals(typeSelection.getValue(), "EV"))
                modelSelection.getItems().addAll(evModels[2]);
        }
    }

    /*
    * Method, which gets the user's selection for vehicle type and "resets" brand selection drop down menu.
    */
    private void getTypeSelection(ActionEvent event) {
        if (Objects.equals(typeSelection.getValue(), "Gas")) {
            vehicleType = "Gas";
            brandSelection.getItems().clear();
            brandSelection.getItems().addAll(brands);
            modelSelection.getItems().clear();
        } else if (Objects.equals(typeSelection.getValue(), "Hybrid")) {
            vehicleType = "Hybrid";
            brandSelection.getItems().clear();
            brandSelection.getItems().addAll(brands);
            modelSelection.getItems().clear();
        } else if (Objects.equals(typeSelection.getValue(), "EV")) {
            vehicleType = "EV";
            brandSelection.getItems().clear();
            brandSelection.getItems().addAll(brands);
            modelSelection.getItems().clear();
        }
    }

    private void getTermInput(ActionEvent event) {
        rentPeriod = Integer.parseInt(termInput.getText());
    }

    /*
    * Menthod, responsible for transfering data to the secondary scene, activated upon pressing Rent button.
    */
    @FXML
    void rentCar(ActionEvent event) throws IOException {
        // Renting service proxy is created and rent method is called
        RentingProxy rentingProxy = RentingProxy.createProxy("1234");
        rentingProxy.rent();

        SingletonCar singletonCar = SingletonCar.getInstance(vehicleType, brandSelection.getValue(), modelSelection.getValue(), Integer.parseInt(termInput.getText()));
        pCar = singletonCar.getCarData();

        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("window2.fxml"));

        if(OutputType.outputType == 1) {
            // Passing data using Window1Controller
        } else if(OutputType.outputType == 2) {
            // Passing data using UserData
            stage.setUserData(pCar);
        } else if(OutputType.outputType == 4) {
            // Passing data using each of the requested options.
            stage.setUserData(pCar);
        }

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Overview");
        stage.setScene(scene);
        stage.show();
    }

    public static Car getData() {
        return SingletonCar.getCarData();
    }

    public static Stage getStage() {
        return stage;
    }

}