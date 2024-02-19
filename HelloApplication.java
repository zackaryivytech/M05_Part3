package com.example.m05_part3;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //Create text
        Text text = new Text("Color Changing Text");

        // Create ScrollBars
        ScrollBar scrollBarRed = new ScrollBar();
        ScrollBar scrollBarGreen = new ScrollBar();
        ScrollBar scrollBarBlue = new ScrollBar();
        ScrollBar scrollBarOpacity = new ScrollBar();

        //Set Values
        scrollBarRed.setMax(1);
        scrollBarGreen.setMax(1);
        scrollBarBlue.setMax(1);
        scrollBarOpacity.setMax(1);
        scrollBarOpacity.setValue(1);

        //Add mouse event listeners
        scrollBarRed.valueProperty().addListener((observable, oldValue, newValue) ->
                text.setFill(new Color(scrollBarRed.getValue(), scrollBarGreen.getValue(), scrollBarBlue.getValue(), scrollBarOpacity.getValue())));

        scrollBarGreen.valueProperty().addListener((observable, oldValue, newValue) ->
                text.setFill(new Color(scrollBarRed.getValue(), scrollBarGreen.getValue(), scrollBarBlue.getValue(), scrollBarOpacity.getValue())));

        scrollBarBlue.valueProperty().addListener((observable, oldValue, newValue) ->
                text.setFill(new Color(scrollBarRed.getValue(), scrollBarGreen.getValue(), scrollBarBlue.getValue(), scrollBarOpacity.getValue())));

        scrollBarOpacity.valueProperty().addListener((observable, oldValue, newValue) ->
                text.setFill(new Color(scrollBarRed.getValue(), scrollBarGreen.getValue(), scrollBarBlue.getValue(), scrollBarOpacity.getValue())));


        //Create Labels
        Label labelRed = new Label("Red");
        Label labelGreen = new Label("Green");
        Label labelBlue = new Label("Blue");
        Label labelOpacity = new Label("Opacity");

        //Add Nodes
        VBox vbox1 = new VBox();
        vbox1.getChildren().add(labelRed);
        vbox1.getChildren().add(scrollBarRed);

        vbox1.getChildren().add(labelGreen);
        vbox1.getChildren().add(scrollBarGreen);

        vbox1.getChildren().add(labelBlue);
        vbox1.getChildren().add(scrollBarBlue);

        vbox1.getChildren().add(labelOpacity);
        vbox1.getChildren().add(scrollBarOpacity);

        vbox1.getChildren().add(text);


        Pane root = new Pane();
        root.getChildren().add(vbox1);

        Scene scene = new Scene(root, 320, 240);

        stage.setTitle("Color changer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}