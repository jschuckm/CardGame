package coms362.cards;

import static org.junit.Assert.*;

import org.junit.Test;
import coms362.cards.fiftytwo.*;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import model.*;


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
	
	//iteration 2
	@Test
	public void checkFiftytwo(){

		Player player = new PickupPlayer(10, "new id");
		Pile pile = new Pile("new pile", new Location(0,0));
		Table table = new TableBase(new P52GameFactory());
	      table.addPile(pile);   
	      table.addPlayer(player);
	      for(int i = 0; i < 51; i++)
	      {   
	    	  Pile getPile = table.getPile("new pile");
	    	  assertTrue("new pile" == getPile.getName());
	    	  Player getPlayer = table.getPlayer(10);
				assertTrue(getPlayer.getSocketId() == "new id");
	      }
		
	}
}





