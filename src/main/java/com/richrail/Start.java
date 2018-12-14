package com.richrail;

import com.google.gson.Gson;
import com.richrail.domain.Locomotive;
import com.richrail.domain.RollingComponent;
import com.richrail.domain.Train;
import com.richrail.domain.Wagon;
import com.richrail.factory.RollingComponentDrawableFactory;
import com.richrail.gui.drawable.RollingComponentDrawable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import java.util.List;


public class Start extends Application {
    ArrayList<Train> trains = new ArrayList<>();
    Group main;
    RollingComponentDrawableFactory rollingComponentDrawableFactory;

//    nieuwe trein
//    trein selecteren
//    trein verwijdern
//
//    Extra wagon toevoegen
//    extra wAGON VERWIJDERE


    @Override
    public void start(Stage primaryStage) throws Exception {
        rollingComponentDrawableFactory = new RollingComponentDrawableFactory();
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
        Label wagonLabel = new Label("Add wagon");
        Button wagonAddBtn = new Button("Add");
        Button wagonRemoveBtn = new Button("Remove");
        ChoiceBox<String> trainChoice = new ChoiceBox<>(getTrainChoices());
        HBox wagonHb = new HBox();

        wagonHb.getChildren().addAll(wagonLabel, trainChoice, wagonAddBtn, wagonRemoveBtn);
        wagonHb.setSpacing(10);
        wagonAddBtn.setOnAction(e -> {
//            Train train = trains.get(trainChoice.getSelectionModel().getSelectedIndex());
//            train.addWagon(new Wagon("test"));
            repaint();
        });
        wagonRemoveBtn.setOnAction(e -> {
//            Train train = trains.get(trainChoice.getSelectionModel().getSelectedIndex());
//            train.removeLastWagon();
            repaint();
        });


        // Train input
        Label trainLabel = new Label("Add train");
        TextField trainTextfield = new TextField();
        Button trainAddBtn = new Button("Add");
        HBox trainHb = new HBox();
        trainHb.getChildren().addAll(trainLabel, trainTextfield, trainAddBtn);
        trainHb.setSpacing(10);
        trainAddBtn.setOnAction(e -> {
//            Train train = new Train();
//            train.setLocomotive(new Locomotive(trainTextfield.getText()));
//            trains.add(train);
            repaint();
            trainChoice.setItems(getTrainChoices());
        });


        // Logger
        TextField logger = new TextField();
        root.add(main, 0, 1);
        root.add(trainHb, 0, 2);
        root.add(wagonHb, 0, 3);
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

        Locomotive locomotive = new Locomotive("asd");

        Wagon wagon1 = new Wagon("adas");
        Wagon wagon2 = new Wagon("adas");
        Wagon wagon3 = new Wagon("adas");

        train1.addRollingComponent(locomotive);
        train1.addRollingComponent(wagon1);
        train1.addRollingComponent(wagon2);
        train1.addRollingComponent(wagon3);

        Gson gson = new Gson();

        System.out.println(gson.toJson(trains));

    }


    private void repaint() {
        main.getChildren().clear();

        for (int i = 0; i < trains.size(); i++) {
            Train train = trains.get(i);

            // Offsets
            int offsetX = 160;
            int offsetY = 120 * i;

            // Create a new group for the train
            Group g = new Group();

            // Draw the rollingcompontents
            for (int j = 0; j < train.getRollingComponents().size(); j++) {
                RollingComponent rollingComponent = train.getRollingComponents().get(j);
                RollingComponentDrawable rollingComponentDrawable = rollingComponentDrawableFactory.getRollingComponentDrawable(rollingComponent);

                Group rollingCompontentGroup = rollingComponentDrawable.draw(offsetX * (j + 1), offsetY);

                main.getChildren().add(rollingCompontentGroup);
            }

            main.getChildren().add(g);
        }
    }

    public ObservableList<String> getTrainChoices() {
        List<String> list = new ArrayList<>();
//        trains.forEach(train -> list.add(train.locomotive.id));
        return FXCollections.observableArrayList(list);
    }
}
