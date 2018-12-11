package com.richrail;


import com.google.gson.Gson;
import com.richrail.model.Train;
import javafx.application.Application;
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

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.show();

        CharStream lineStream = CharStreams.fromString("new train tr1");

        // Tokenize / Lexical analysis
        Lexer lexer = new RichRailLexer(lineStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create Parse Tree
        RichRailParser parser = new RichRailParser(tokens);
        ParseTree tree = parser.command();

        // Create ParseTreeWalker and Custom Listener
        ParseTreeWalker walker = new ParseTreeWalker();
        RichRailListener listener = new RichRailCli();

        // Walk over ParseTree using Custom Listener that listens to enter/exit events
        walker.walk(listener, tree);


        Train train = new Train();
        Train train1 = new Train();

        ArrayList<Train> main = new ArrayList<>();

        main.add(train);
        main.add(train1);

        Gson gson = new Gson();

        System.out.println(gson.toJson(main));

    }
}
