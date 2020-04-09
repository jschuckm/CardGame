package coms362.cards;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

import coms362.cards.fiftytwo.*;
import model.Card;
import org.junit.Test;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.app.PlayController;
import coms362.cards.streams.InBoundQueue;
import events.inbound.DealEvent;
import events.inbound.CardEvent;
import events.inbound.EndPlay;
import model.TableBase;
import model.Pile;

public class DakshTest {

    static final long expectedSig = 1427999153L;

    @Test
    public void test() {/*
        //set up game and match resources to provision play loop
        InBoundQueue inQ = new InBoundQueue();
        //pre-load the input stream with the input for this test
        inQ.add(new DealEvent());
        inQ.add(new CardEvent("2"));
        inQ.add(new CardEvent("3"));
        inQ.add(new CardEvent("4"));
        inQ.add(new EndPlay()); //artifice to stop the test

        List<View> views = new ArrayList<View>();
        //we keep a reference to the concrete type for later
        LoggingView  p1View = new LoggingView();
        views.add(p1View);

        Player player = new PickupPlayer(1); //ditto for players

        // initialize the local model for Pu52 match
        Table table = new TableBase();
        table.apply(new PickupInitCmd());
        Rules rules = new PickupRules();

        PlayController mainloop = new PlayController(inQ, rules);
        mainloop.play(table, player, views);


        CRC32 sig = new CRC32();
        String log = p1View.getLog();
        System.out.println(log);
        sig.update(log.getBytes());
        long sValue = sig.getValue();
        System.out.println(sValue);

        assertEquals(expectedSig, sValue);
        */
    }
    @Test
    public void checkScore(){
        /*
        Table table = new TableBase();
        table.apply(new PickupInitCmd());
        Player p = new PickupPlayer(1);
        Pile discard = table.getPile("discardPile");
        Card c = discard.getCard("" + 0);
        //PickupMove pickup = new PickupMove(c, p);
        table.apply(new PickupMove(c, p));
        assertEquals(p.addToScore(0), 0);
        */


    }

}
