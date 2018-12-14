package com.richrail.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;


public class WagonGUI {
    Label wagonLabel;
    Button wagonAddBtn;
    Button wagonRemoveBtn;
    ChoiceBox<String> trainChoice;
    HBox wagonHb;

    public WagonGUI() {
        wagonLabel = new Label("Add wagon");
        wagonAddBtn = new Button("Add");
        wagonRemoveBtn = new Button("Remove");
        trainChoice = new ChoiceBox<>();
        wagonHb = new HBox();

        wagonHb.setSpacing(10);
        wagonHb.getChildren().addAll(wagonLabel, trainChoice, wagonAddBtn, wagonRemoveBtn);
    }

    public HBox getWagonGUIBox() {
        return wagonHb;
    }

    public void setOnAddAction(EventHandler<ActionEvent> eventHandler) {
        wagonAddBtn.setOnAction(eventHandler);
    }

    public void setOnRemoveAction(EventHandler<ActionEvent> eventHandler) {
        wagonRemoveBtn.setOnAction(eventHandler);
    }

    public void setChoiceItems(List<String> items) {
        ObservableList<String> test = FXCollections.observableList(items);
        trainChoice.setItems(test);
    }

    public int getChoiceboxIndex() {
        return trainChoice.getSelectionModel().getSelectedIndex();
    }
}
