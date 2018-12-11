package com.richrail;


import com.google.gson.Gson;
import com.richrail.models.Train;
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

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Start extends javax.swing.JFrame implements ActionListener {
    private JPanel jPanel1;
    private JTextPane tpTextTrain;
    private JButton btnDeleteWagon3;
    private JButton btnDeleteWagon2;
    private JButton btnDeleteWagon1;
    private JButton jButton1;
    private JPanel pnlWagons;
    private JButton btnAddWagon2;
    private JButton btnAddWagon1;
    private JTextField tfCurrentTrain;
    private JButton btnDeleteTrain;
    private JButton btnChooseTrain;
    private JComboBox cbAllTrains;
    private JButton btnNewTrain;
    private JTextField tfNewTrain;
    private JPanel jPanel2;
    private JPanel drawPanel;

    private HashMap numberOfWagons;
    private int currentNumberOfWagons;
    private int currentTrain = -1;
    private int OFFSET = 100;
    private int TRAINLENGTH = 100;
    private ArrayList trains;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Start inst = new Start();
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
        });
    }

    public void antlrtest() {
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


//        Train train = new Train();
//        Train train1 = new Train();
//
//        main.add(train);
//        main.add(train1);
//
//        Gson gson = new Gson();
//
//        System.out.println(gson.toJson(main));

    }


    public Start() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            this.setTitle("PoorRail");
            GridBagLayout thisLayout = new GridBagLayout();
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            thisLayout.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1};
            thisLayout.rowHeights = new int[]{7, 7, 7, 7};
            thisLayout.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1};
            thisLayout.columnWidths = new int[]{7, 7, 7, 7};
            getContentPane().setLayout(thisLayout);
            {
                jPanel1 = new JPanel();
                jPanel1.setLayout(new BorderLayout());
                getContentPane().add(jPanel1, new GridBagConstraints(0, 0, 4, 2, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                {
                    drawPanel = new JPanel();
                    drawPanel.setBackground(Color.WHITE);
                    jPanel1.add(drawPanel, BorderLayout.CENTER);
                }
            }
            {
                jPanel2 = new JPanel();
                GridBagLayout jPanel2Layout = new GridBagLayout();
                //jPanel2.setLayout(null);
                jPanel2.setLayout(jPanel2Layout);
                getContentPane().add(jPanel2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                {
                    tpTextTrain = new JTextPane();
                    jPanel2.add(tpTextTrain, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    jPanel2.setBounds(10, 10, 100, 15);
                    jPanel2Layout.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1};
                    jPanel2Layout.rowHeights = new int[]{7, 7, 7, 7};
                    jPanel2Layout.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1};
                    jPanel2Layout.columnWidths = new int[]{7, 7, 7, 7};
                    tpTextTrain.setText("train name:");
                }
                {
                    tfNewTrain = new JTextField(20);
                    jPanel2.add(tfNewTrain, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                }
                {
                    btnNewTrain = new JButton();
                    jPanel2.add(btnNewTrain, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    btnNewTrain.setText("make new train");
                    btnNewTrain.addActionListener(this);
                }
                {
                    ComboBoxModel cbAllTrainsModel =
                            new DefaultComboBoxModel(
                                    new String[]{});
                    cbAllTrains = new JComboBox();
				/*	GridLayout cbAllTrainsLayout = new GridLayout(1, 1);
					cbAllTrainsLayout.setColumns(1);
					cbAllTrainsLayout.setHgap(5);
					//cbAllTrainsLayout.setVgap(5);
					cbAllTrains.setLayout(cbAllTrainsLayout);*/
                    jPanel2.add(cbAllTrains, new GridBagConstraints(1, 1, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
                    cbAllTrains.setModel(cbAllTrainsModel);
                }
                {
                    btnChooseTrain = new JButton();
                    jPanel2.add(btnChooseTrain, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    btnChooseTrain.setText("select train");
                    btnChooseTrain.addActionListener(this);
                }
                {
                    btnDeleteTrain = new JButton();
                    jPanel2.add(btnDeleteTrain, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    btnDeleteTrain.setText("delete train");
                    btnDeleteTrain.addActionListener(this);
                }
            }
            {
                pnlWagons = new JPanel();
                GridBagLayout jPanel3Layout = new GridBagLayout();
                getContentPane().add(pnlWagons, new GridBagConstraints(1, 2, 2, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
                jPanel3Layout.rowWeights = new double[]{0.1, 0.1, 0.1, 0.1};
                jPanel3Layout.rowHeights = new int[]{7, 7, 7, 7};
                jPanel3Layout.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1};
                jPanel3Layout.columnWidths = new int[]{7, 7, 7, 7};
                pnlWagons.setLayout(jPanel3Layout);
                pnlWagons.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
                {
                    tfCurrentTrain = new JTextField();
                    pnlWagons.add(tfCurrentTrain, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
                    tfCurrentTrain.setText("selected: ");
                }
                {
                    btnAddWagon1 = new JButton();
                    pnlWagons.add(btnAddWagon1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    btnAddWagon1.setText("add wagon 1");
                    btnAddWagon1.addActionListener(this);
                }
                {
                    btnAddWagon2 = new JButton();
                    pnlWagons.add(btnAddWagon2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    btnAddWagon2.setText("add wagon 2");
                    btnAddWagon2.addActionListener(this);
                }
                {
                    jButton1 = new JButton();
                    pnlWagons.add(jButton1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    jButton1.setText("add wagon 3");
                    jButton1.addActionListener(this);
                }
                {
                    btnDeleteWagon1 = new JButton();
                    pnlWagons.add(btnDeleteWagon1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    btnDeleteWagon1.setText("delete wagon 1");
                    btnDeleteWagon1.addActionListener(this);
                }
                {
                    btnDeleteWagon2 = new JButton();
                    pnlWagons.add(btnDeleteWagon2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    btnDeleteWagon2.setText("delete wagon 2");
                    btnDeleteWagon2.addActionListener(this);
                }
                {
                    btnDeleteWagon3 = new JButton();
                    pnlWagons.add(btnDeleteWagon3, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    btnDeleteWagon3.setText("delete wagon 3");
                    btnDeleteWagon3.addActionListener(this);
                }
            }
            pack();
            setSize(800, 600);
            numberOfWagons = new HashMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnNewTrain) {
            String train = tfNewTrain.getText();
            if (train != null && train.trim().length() > 0) {
                train = addTrain(train);
                currentTrain = cbAllTrains.getSelectedIndex();
                drawTrain(train);
            }
        } else if (event.getSource() == btnChooseTrain) {
            if (cbAllTrains.getItemCount() > 0) {
                String selection = (String) cbAllTrains.getSelectedItem();
                tfCurrentTrain.setText("selected: " + selection);
                int ti = cbAllTrains.getSelectedIndex();
                if (ti != currentTrain) {
                    numberOfWagons.put(currentTrain, currentNumberOfWagons);
                }
                currentTrain = ti;
                try {
                    currentNumberOfWagons = (Integer) numberOfWagons.get(currentTrain);
                } catch (Exception e) {
                    currentNumberOfWagons = 0;
                }
            }
        } else if (event.getSource() == btnDeleteTrain) {
            if (cbAllTrains.getItemCount() > 0) {
                String t = (String) cbAllTrains.getSelectedItem();
                cbAllTrains.removeItemAt(cbAllTrains.getSelectedIndex());
                numberOfWagons.remove(t);
                repaint();
                if ((String) cbAllTrains.getSelectedItem() != null) {
                    currentTrain = cbAllTrains.getSelectedIndex();
                    tfCurrentTrain.setText("selected: " + (String) cbAllTrains.getSelectedItem());
                } else {
                    currentTrain = 0;
                    tfCurrentTrain.setText("selected: ");
                }
            }
        } else if (event.getSource() == btnAddWagon1) {
            currentNumberOfWagons++;
            drawWagon("Wagon1");
        } else if (event.getSource() == btnAddWagon2) {
            currentNumberOfWagons++;
            drawWagon("Wagon2");
        } else if (event.getSource() == jButton1) {
            currentNumberOfWagons++;
            drawWagon("Wagon3");
        } else if (event.getSource() == btnDeleteWagon1) {
            repaint(30 + TRAINLENGTH, 80 + currentTrain * OFFSET, 1, 1);
        } else if (event.getSource() == btnDeleteWagon2) {
            repaint(30 + TRAINLENGTH, 80 + currentTrain * OFFSET, 1, 1);
        } else if (event.getSource() == btnDeleteWagon3) {
            repaint(30 + TRAINLENGTH, 80 + currentTrain * OFFSET, 1, 1);
        }
    }

    public String addTrain(String train) {
        String t = "";
        try {
            t = train.trim();
            for (int i = 0; i < cbAllTrains.getItemCount(); i++) {
                String cbTrain = (String) cbAllTrains.getItemAt(i);
                if (cbTrain.equalsIgnoreCase(t)) {
                    t = "";
                    break;
                }
            }
            if (t != "") {
                if (currentTrain >= 0) {
                    numberOfWagons.put(currentTrain, currentNumberOfWagons);
                }
                cbAllTrains.addItem(t);
                cbAllTrains.setSelectedItem(t);
                numberOfWagons.put(t, 0);
            }
        } catch (Exception e) {
        }
        return t;

    }

    public void drawAllTrains() {
        drawPanel.getGraphics().clearRect(0, 0, drawPanel.getHeight(), drawPanel.getWidth());
//        for (Train train : trains) {
//
//        }
    }

    public void drawTrain(String train) {
        if (train != "") {
            Train train1 = new Train(train);
            train1.draw(drawPanel, currentTrain * OFFSET);
        }

    }

    public void drawWagon(String wagon) {
        Graphics g = drawPanel.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(30 + currentNumberOfWagons * TRAINLENGTH, 80 + currentTrain * OFFSET, 80, 40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(35 + currentNumberOfWagons * TRAINLENGTH, 120 + currentTrain * OFFSET, 20, 20, 20, 20);
        g.fillRoundRect(80 + currentNumberOfWagons * TRAINLENGTH, 120 + currentTrain * OFFSET, 20, 20, 20, 20);
        g.drawString(wagon, 40 + currentNumberOfWagons * TRAINLENGTH, 105 + currentTrain * OFFSET);
    }
}
