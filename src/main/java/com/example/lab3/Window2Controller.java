package com.example.lab3;

import Data.Car;
import Data.CarData;
import Data.OutputType;
import Data.SingletonCar;
import javafx.application.Platform;
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
    private Car pCar1;
    private Car pCar2;
    private Car pCar3;

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
        System.out.println("Test message in Window2Controller, l44, " + pCar.getBrand() + " " + pCar.getModel() + " " + pCar.getRentDuration());
    }

    public void setCar1Data(Car pCar1) {
        this.pCar1 = pCar;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getData();
    }

    private void setDataUsingAllVariables(ActionEvent actionEvent) {
        brandLabel.setText(pCar1.getBrand());
        modelLabel.setText(pCar2.getModel());
        rentTermLabel.setText(Integer.toString(pCar3.getRentDuration()) + " days");
    }

    private void getData() {
        //        getDataFromStage(new ActionEvent());
        if(OutputType.outputType == 1) {
            // Data gets passed using Window1Controller
            pCar = Window1Controller.getData();
            setData(new ActionEvent());
        } else if(OutputType.outputType == 2) {
            // Data gets passed using UserData
            pCar = (Car) Window1Controller.getStage().getUserData();
            setData(new ActionEvent());
        } else if(OutputType.outputType == 3) {
//             Data gets passed using Singleton
            pCar = SingletonCar.getCarData();
            setData(new ActionEvent());
        } else if(OutputType.outputType == 4) {
            // Data gets passed using one of each
            pCar1 = Window1Controller.getData();
            pCar2 = (Car) Window1Controller.getStage().getUserData();
            pCar3 = SingletonCar.getCarData();
            setDataUsingAllVariables(new ActionEvent());
        }
    }

    @FXML
    void setData(ActionEvent event) {
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
