package com.richrail;

import com.richrail.domain.Locomotive;
import com.richrail.domain.RollingComponent;
import com.richrail.domain.Train;
import com.richrail.domain.Wagon;
import com.richrail.factory.RollingComponentDrawableFactory;
import com.richrail.gui.TrainGUI;
import com.richrail.gui.WagonGUI;
import com.richrail.gui.drawable.RollingComponentDrawable;
import com.richrail.storage.FileTrainStorage;
import com.richrail.storage.TrainStorage;
import javafx.application.Application;
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
import parser.RichRailParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Start extends Application {
    private ArrayList<Train> trains = new ArrayList<>();
    private Group main;
    private RollingComponentDrawableFactory rollingComponentDrawableFactory;
    private TrainStorage trainStorage;
//    nieuwe trein
//    trein selecteren
//    trein verwijdern
//
//    Extra wagon toevoegen
//    extra wAGON VERWIJDERE


    @Override
    public void start(Stage primaryStage) throws Exception {
        rollingComponentDrawableFactory = new RollingComponentDrawableFactory();
        trainStorage = new FileTrainStorage("trains.json");
//        trains.addAll(trainStorage.loadTrains());

        main = new Group();
        GridPane root = new GridPane();
        root.setHgap(2);
        root.setVgap(3);

        loadData();

        // Command input
        Label commandLabel = new Label("Command");
        TextField commandTextfield = new TextField();
        Button executeBtn = new Button("Execute");
        HBox commandHb = new HBox();
        commandHb.getChildren().addAll(commandLabel, commandTextfield, executeBtn);
        commandHb.setSpacing(10);
        executeBtn.setOnAction(e -> handleExecuteAntlr(commandTextfield.getText()));


        // Wagon
        WagonGUI wagonGUI = new WagonGUI();
        wagonGUI.setChoiceItems(getTrainChoices());
        wagonGUI.setOnAddAction(event -> {
            Train train = trains.get(wagonGUI.getChoiceboxIndex());
            train.addRollingComponent(new Wagon("test"));
            repaint();
        });
        wagonGUI.setOnRemoveAction(event -> {
            Train train = trains.get(wagonGUI.getChoiceboxIndex());
            train.removeLastRollingComponent();
            repaint();
        });


        TrainGUI trainGUI = new TrainGUI();
        trainGUI.setOnAddAction(event -> {
            Train train = new Train();
            Locomotive locomotive = new Locomotive(trainGUI.getInputText());
            train.addRollingComponent(locomotive);
            trains.add(train);

            repaint();
            wagonGUI.setChoiceItems(getTrainChoices());
        });

        // Logger
        TextField logger = new TextField();


        root.add(main, 0, 1);
        root.add(trainGUI.getTrainGUIBox(), 0, 2);
        root.add(wagonGUI.getWagonGUIBox(), 0, 3);
        root.add(commandHb, 0, 4);
        root.add(logger, 0, 5);

        final Scene scene = new Scene(root, 1000, 1000, Color.WHITE);

        primaryStage.setTitle("RichRail");
        primaryStage.setScene(scene);

        primaryStage.show();

        repaint();

    }

    private void handleExecuteAntlr(String command) {
        CharStream lineStream = CharStreams.fromString(command);

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
    }


    public void loadData() {
        trains = new ArrayList<>();
        Train train1 = new Train();
        Train train2 = new Train();

        Locomotive locomotive = new Locomotive("asd");

        Wagon wagon1 = new Wagon("adas");
        Wagon wagon2 = new Wagon("adas");
        Wagon wagon3 = new Wagon("adas");

        train1.addRollingComponent(locomotive);
        train1.addRollingComponent(wagon1);
        train1.addRollingComponent(wagon2);
        train1.addRollingComponent(wagon3);

        train2.addRollingComponent(wagon1);
        train2.addRollingComponent(locomotive);
        train2.addRollingComponent(wagon1);

        trains.add(train1);
        trains.add(train2);

        trainStorage.saveTrains(trains);
    }

    private void repaint() {
        main.getChildren().clear();

        for (int i = 0; i < trains.size(); i++) {
            Train train = trains.get(i);
            Group trainGroup = new Group();

            // Offsets
            int offsetX = 160;
            int offsetY = 120 * i;

            // Draw the rollingcompontents
            for (int j = 0; j < train.getRollingComponents().size(); j++) {
                RollingComponent rollingComponent = train.getRollingComponents().get(j);
                RollingComponentDrawable rollingComponentDrawable = rollingComponentDrawableFactory.getRollingComponentDrawable(rollingComponent);

                Group rollingCompontentGroup = rollingComponentDrawable.draw(offsetX * (j + 1), offsetY);

                trainGroup.getChildren().add(rollingCompontentGroup);
            }

            main.getChildren().add(trainGroup);
        }
    }


    /*Find a nicer way of doing this*/
    public List<String> getTrainChoices() {
        List<Integer> list = Arrays.stream(IntStream.range(0, trains.size()).toArray()).boxed().collect(Collectors.toList());
        return list.stream().map(s -> String.valueOf(s + 1)).collect(Collectors.toList());
    }
}
