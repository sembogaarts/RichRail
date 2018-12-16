package com.richrail.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class LoggerGUI {
    private Label loggerLabel;
    private TextArea loggerTextfield;
    private HBox loggerHb;

    public LoggerGUI() {
        loggerLabel = new Label("Logger");
        loggerTextfield = new TextArea();
        loggerHb = new HBox();
        loggerHb.getChildren().addAll(loggerLabel, loggerTextfield);
        loggerHb.setSpacing(10);
    }

    public void addInputText(String text) {
        String loggerText = String.format("%s%s%s", loggerTextfield.getText(), System.lineSeparator(), text);

        loggerTextfield.setText(loggerText);
    }

    public HBox getLoggerGUIBox() {
        return loggerHb;
    }
}
