package com.richrail;

import com.richrail.builder.RollingComponentBuilder;
import com.richrail.domain.*;
import com.richrail.observer.RichRail;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.RichRailListener;
import parser.RichRailParser;

import java.util.ArrayList;

public class RichRailCli implements RichRailListener {

    /*
        new train tr1; // response is “train tr1 created”
        new wagon wg1; // response is “wagon wg1 created with 20 seats”
        new wagon wg2 numseats 15; // response is “wagon wg2 created with 15 seats”
        add wg1 to tr1; // response: “wagon wg1 added to train tr1”
        getnumseats train tr1; // response: “number of seats in train tr1: 20”
        getnumseats wagon wg2; // response: “number of seats in wagon wg2: 15”
        delete train tr1; // response: “train tr1 deleted”
        delete train tr2; // response: “train tr2 does not exist”
        remove wg1 from tr1; // response: “wagon wg1 removed from train tr1”
    */
    private RichRail richRail;

    RichRailCli(RichRail richRail) {
        this.richRail = richRail;
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
        String wagonName = ctx.ID().getText();

        RollingComponent rollingComponent = new RollingComponentBuilder()
                .setType(RollingComponentType.LOCOMOTIVE)
                .setId(wagonName)
                .build();

        Train train = new Train();
        train.addRollingComponent(rollingComponent);
        richRail.addTrain(train);
    }

    @Override
    public void exitNewtraincommand(RichRailParser.NewtraincommandContext ctx) {

    }

    @Override
    public void enterNewwagoncommand(RichRailParser.NewwagoncommandContext ctx) {
        String wagonName = ctx.ID().getText();

        RollingComponentBuilder rollingComponentBuilder = new RollingComponentBuilder()
                .setType(RollingComponentType.WAGON)
                .setId(wagonName);

        if (ctx.NUMBER() != null) {
            rollingComponentBuilder.setSeats(Integer.parseInt(ctx.NUMBER().getText()));
        }

        RollingComponent rollingComponent = rollingComponentBuilder.build();
        Train train = new Train();
        train.addRollingComponent(rollingComponent);

        richRail.addTrain(train);
    }

    @Override
    public void exitNewwagoncommand(RichRailParser.NewwagoncommandContext ctx) {

    }

    @Override
    public void enterAddcommand(RichRailParser.AddcommandContext ctx) {
        String from = ctx.ID(0).getText();
        String to = ctx.ID(1).getText();
        richRail.moveRollingComponent(from, to);

    }

    @Override
    public void exitAddcommand(RichRailParser.AddcommandContext ctx) {

    }

    @Override
    public void enterGetcommand(RichRailParser.GetcommandContext ctx) {
        String name = ctx.ID().toString();
        System.out.println(name);
        richRail.getSeatsById(name);
    }

    @Override
    public void exitGetcommand(RichRailParser.GetcommandContext ctx) {

    }

    @Override
    public void enterDelcommand(RichRailParser.DelcommandContext ctx) {
        // Replace to map Map<id, RollingComponent>
        richRail.removeTrainById(ctx.ID().getText());
    }

    @Override
    public void exitDelcommand(RichRailParser.DelcommandContext ctx) {

    }

    @Override
    public void enterRemcommand(RichRailParser.RemcommandContext ctx) {
        richRail.removeRollingComponentFromTrain(ctx.ID(0).toString());
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
}
