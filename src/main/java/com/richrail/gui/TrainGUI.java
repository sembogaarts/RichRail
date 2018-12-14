package com.richrail.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class TrainGUI {

    Label trainLabel;
    TextField trainTextfield;
    Button trainAddBtn;
    HBox trainHb;

    public TrainGUI() {
        trainLabel = new Label("Add train");
        trainTextfield = new TextField();
        trainAddBtn = new Button("Add");
        trainHb = new HBox();
        trainHb.getChildren().addAll(trainLabel, trainTextfield, trainAddBtn);
        trainHb.setSpacing(10);
    }

    public void setOnAddAction(EventHandler<ActionEvent> eventHandler) {
        trainAddBtn.setOnAction(eventHandler);
    }

    public HBox getTrainGUIBox() {
        return trainHb;
    }

    public String getInputText() {
        return trainTextfield.getText();
    }
}
