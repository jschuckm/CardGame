package coms362.cards;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

import coms362.cards.fiftytwo.*;
import model.Card;
import model.Location;

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
/**
 * 
 * @author Daksh Goel
 *
 */
public class DakshTest {

    @Test
    public void checkCardFromPile(){
        Pile newPile = new Pile("Test Pile", new Location(0, 0));
        Card c = new Card();
        c.setId(4);
        newPile.addCard(c);
        Card myCard = newPile.getCard("4");
        assertTrue(4 == myCard.getId());
    }

}
