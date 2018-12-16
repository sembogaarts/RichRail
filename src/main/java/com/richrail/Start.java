package com.richrail;

import com.richrail.domain.Locomotive;
import com.richrail.domain.Train;
import com.richrail.domain.Wagon;
import com.richrail.factory.RollingComponentDrawableFactory;
import com.richrail.gui.CommandGUI;
import com.richrail.gui.LoggerGUI;
import com.richrail.gui.TrainGUI;
import com.richrail.gui.WagonGUI;
import com.richrail.observer.GUITrainListener;
import com.richrail.observer.RichRail;
import com.richrail.observer.RichRailLogger;
import com.richrail.observer.StorageTrainListener;
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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Start extends Application {
    private Group main = new Group();
    private RollingComponentDrawableFactory rollingComponentDrawableFactory = new RollingComponentDrawableFactory();
    private TrainStorage trainStorage;
    private RichRail richRail;

    // Wagon
    /* GUI*/
    private WagonGUI wagonGUI = new WagonGUI();
    private TrainGUI trainGUI = new TrainGUI();

    // Command input
    private CommandGUI commandGUI = new CommandGUI();
    private LoggerGUI loggerGUI = new LoggerGUI();

//    nieuwe trein
//    trein selecteren
//    trein verwijdern
//
//    Extra wagon toevoegen
//    extra wAGON VERWIJDERE


    @Override
    public void start(Stage primaryStage) throws Exception {
        trainStorage = new FileTrainStorage("trains.json");
        richRail = new RichRailLogger(loggerGUI);
        richRail.registerTrainListener(new GUITrainListener(rollingComponentDrawableFactory, main));
        richRail.registerTrainListener(new StorageTrainListener(trainStorage));
        richRail.addAllTrains(trainStorage.loadTrains());

        GridPane root = new GridPane();
        root.setHgap(2);
        root.setVgap(3);

        commandGUI.setOnExecuteAction(event -> handleExecuteAntlr(commandGUI.getInputText()));

        wagonGUI.setChoiceItems(getTrainChoices());
        wagonGUI.setOnAddAction(event -> richRail.addRollingComponentToTrain(wagonGUI.getChoiceboxIndex(), new Wagon()));
        wagonGUI.setOnRemoveAction(event -> {
            richRail.removeLastRollingComponentOrTrain(wagonGUI.getChoiceboxIndex());
            wagonGUI.setChoiceItems(getTrainChoices());
        });


        trainGUI.setOnAddAction(event -> {
            Train train = new Train();
            Locomotive locomotive = new Locomotive(trainGUI.getInputText());
            train.addRollingComponent(locomotive);
            richRail.addTrain(train);

            wagonGUI.setChoiceItems(getTrainChoices());
        });

        // Logger

        root.add(main, 0, 1);
        root.add(trainGUI.getTrainGUIBox(), 0, 2);
        root.add(wagonGUI.getWagonGUIBox(), 0, 3);
        root.add(commandGUI.getCommandGUIBox(), 0, 4);
        root.add(loggerGUI.getLoggerGUIBox(), 0, 5);

        final Scene scene = new Scene(root, 1000, 1000, Color.WHITE);

        primaryStage.setTitle("RichRail");
        primaryStage.setScene(scene);

        primaryStage.show();
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
        RichRailCli listener = new RichRailCli(richRail);

        // Walk over ParseTree using Custom Listener that listens to enter/exit events
        walker.walk(listener, tree);
    }


    /*Find a nicer way of doing this*/
    public List<String> getTrainChoices() {
        List<Integer> list = Arrays.stream(IntStream.range(0, richRail.getTrains().size()).toArray()).boxed().collect(Collectors.toList());
        return list.stream().map(s -> String.valueOf(s + 1)).collect(Collectors.toList());
    }
}
