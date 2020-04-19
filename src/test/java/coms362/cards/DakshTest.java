package coms362.cards;

import static org.junit.Assert.*;

import model.Card;
import model.Location;

import org.junit.Test;

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
        //c.setId(4);
        newPile.addCard(c);
        Card myCard = newPile.getCard("4");
        assertTrue(4 == myCard.getId());
    }

}
