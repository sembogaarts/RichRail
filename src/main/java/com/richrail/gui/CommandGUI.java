package com.richrail.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CommandGUI {
    private Label commandLabel;
    private TextField commandTextfield;
    private Button executeBtn;
    private HBox commandHb;

    public CommandGUI() {
        commandLabel = new Label("Command");
        commandTextfield = new TextField();
        executeBtn = new Button("Execute");
        commandHb = new HBox();
        commandHb.getChildren().addAll(commandLabel, commandTextfield, executeBtn);
        commandHb.setSpacing(10);
    }

    public void setOnExecuteAction(EventHandler<ActionEvent> eventHandler) {
        executeBtn.setOnAction(eventHandler);
    }

    public HBox getCommandGUIBox() {
        return commandHb;
    }

    public String getInputText() {
        return commandTextfield.getText();
    }
}
