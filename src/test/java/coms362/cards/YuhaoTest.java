package coms362.cards;

import static org.junit.Assert.*;

import org.junit.Test;
import model.Card;
import model.Location;

import model.Button;

/**
 * 
 * @author Yuhao
 *
 */
public class YuhaoTest {
	
	@Test
    public void checkButton(){

		Button newButton = new Button("00001", "1", "1", new Location (1,1));
		newButton.setEvtName("test");
        newButton.setLabel("00001");

        assertTrue("test" == newButton.getEvtName());
        assertTrue("00001" == newButton.getLabel());
    }
	
	@Test
    public void checkCard(){

		Card newCard = new Card();
		newCard.setX(1);
		newCard.setY(1);
		
        assertTrue(1 == newCard.getX());
        assertTrue(1 == newCard.getY());
    }
}





