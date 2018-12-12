package com.richrail;

import com.google.gson.Gson;
import com.richrail.models.Locomotive;
import com.richrail.models.Train;
import com.richrail.models.Wagon;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.RichRailLexer;
import parser.RichRailListener;
import parser.RichRailParser;

import java.util.ArrayList;


public class Start extends Application {
    ArrayList<Train> trains;
    Group main;

    @Override
    public void start(Stage primaryStage) throws Exception {
        main = new Group();
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        Button execute_btn = new Button("Execute");
        main.prefHeight(1000);

        Label label1 = new Label("Command");
        TextField textField = new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);
        execute_btn.setOnAction(e -> {
            CharStream lineStream = CharStreams.fromString(textField.getText());

            // Tokenize / Lexical analysis
            Lexer lexer = new RichRailLexer(lineStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Create Parse Tree
            RichRailParser parser = new RichRailParser(tokens);
            ParseTree tree = parser.command();

            // Create ParseTreeWalker and Custom Listener
            ParseTreeWalker walker = new ParseTreeWalker();
            RichRailCli listener = new RichRailCli(trains);

            // Walk over ParseTree using Custom Listener that listens to enter/exit events
            walker.walk(listener, tree);
            trains = listener.getResult();
            repaint();
        });

        TextField logger = new TextField();

        root.add(main, 0, 1);
        root.add(hb, 0, 2);
        root.add(execute_btn, 1, 2);
        root.add(logger, 0, 3);

        final Scene scene = new Scene(root, 1000, 1000, Color.WHITE);

        primaryStage.setTitle("RichRail");
        primaryStage.setScene(scene);

        primaryStage.show();


        loadData();
        repaint();
    }

    public void loadData() {
        trains = new ArrayList<>();
        Train train1 = new Train();
        Train train2 = new Train();

        Locomotive locomotive = new Locomotive("asd");

        train1.setLocomotive(locomotive);
        train2.setLocomotive(locomotive);

        Wagon wagon1 = new Wagon("adas");
        Wagon wagon2 = new Wagon("adas");
        Wagon wagon3 = new Wagon("adas");

        train1.addWagon(wagon1);
        train1.addWagon(wagon3);
        trains.add(train1);

        train2.addWagon(wagon2);
        trains.add(train2);


        Gson gson = new Gson();

        System.out.println(gson.toJson(trains));

    }


    private void repaint() {
        main.getChildren().clear();
        for (int i = 0; i < trains.size(); i++) {
            Train train = trains.get(i);
            System.out.println(train);
            main.getChildren().add(train.draw(0, 120 * i));

        }

    }
}
