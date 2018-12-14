package com.richrail;

import com.richrail.domain.Locomotive;
import com.richrail.domain.Train;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.RichRailListener;
import parser.RichRailParser;

import java.util.ArrayList;

public class RichRailCli implements RichRailListener {
    private final ArrayList<Train> trains;

    RichRailCli(ArrayList<Train> trains) {
        this.trains = trains;
    }

    @Override
    public void enterCommand(RichRailParser.CommandContext ctx) {

    }

    @Override
    public void exitCommand(RichRailParser.CommandContext ctx) {

    }

    @Override
    public void enterNewcommand(RichRailParser.NewcommandContext ctx) {
    }

    @Override
    public void exitNewcommand(RichRailParser.NewcommandContext ctx) {

    }

    @Override
    public void enterNewtraincommand(RichRailParser.NewtraincommandContext ctx) {
        Train train = new Train();
//        train.setLocomotive(new Locomotive(ctx.ID().toString()));
        trains.add(train);
    }

    @Override
    public void exitNewtraincommand(RichRailParser.NewtraincommandContext ctx) {

    }

    @Override
    public void enterNewwagoncommand(RichRailParser.NewwagoncommandContext ctx) {

    }

    @Override
    public void exitNewwagoncommand(RichRailParser.NewwagoncommandContext ctx) {

    }

    @Override
    public void enterAddcommand(RichRailParser.AddcommandContext ctx) {

    }

    @Override
    public void exitAddcommand(RichRailParser.AddcommandContext ctx) {

    }

    @Override
    public void enterGetcommand(RichRailParser.GetcommandContext ctx) {

    }

    @Override
    public void exitGetcommand(RichRailParser.GetcommandContext ctx) {

    }

    @Override
    public void enterDelcommand(RichRailParser.DelcommandContext ctx) {
        for (Train train : trains) {
            // Replace to map Map<id, RollingComponent>
//            if (train.locomotive.id.equals(ctx.ID().toString()))
//                trains.remove(train);
        }
    }

    @Override
    public void exitDelcommand(RichRailParser.DelcommandContext ctx) {

    }

    @Override
    public void enterRemcommand(RichRailParser.RemcommandContext ctx) {

    }

    @Override
    public void exitRemcommand(RichRailParser.RemcommandContext ctx) {

    }

    @Override
    public void enterType(RichRailParser.TypeContext ctx) {

    }

    @Override
    public void exitType(RichRailParser.TypeContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }

    public ArrayList<Train> getResult() {
        return trains;
    }
}
