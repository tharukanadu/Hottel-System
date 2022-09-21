package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FormController {


    public AnchorPane MainAnchorPane;
    public AnchorPane SecondAnchorPane;

    public void CustomerOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Customer.fxml"));
        Parent load = loader.load();
        SecondAnchorPane.getChildren().clear();
        SecondAnchorPane.getChildren().add(load);


    }

    public void RoomOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Rooms.fxml"));
        Parent load = loader.load();
        SecondAnchorPane.getChildren().clear();
        SecondAnchorPane.getChildren().add(load);


    }

    public void MealPackageOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/MealPackage.fxml"));
        Parent load = loader.load();
        SecondAnchorPane.getChildren().clear();
        SecondAnchorPane.getChildren().add(load);

    }

    public void ReseverARroomOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/ReseverRoom.fxml"));
        Parent load = loader.load();
        SecondAnchorPane.getChildren().clear();
        SecondAnchorPane.getChildren().add(load);

    }
}
