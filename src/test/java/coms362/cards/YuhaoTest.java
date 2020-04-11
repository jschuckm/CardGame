package coms362.cards;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

import org.junit.Test;
import coms362.cards.fiftytwo.*;
import model.Card;
import model.Location;
import model.Pile;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.app.PlayController;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.streams.InBoundQueue;
import events.inbound.DealEvent;
import events.inbound.CardEvent;
import events.inbound.EndPlay;
import model.TableBase;

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
		newCard.setId(100);
		newCard.setX(1);
		newCard.setY(1);
		
        assertTrue(1 == newCard.getX());
        assertTrue(1 == newCard.getY());
        assertTrue(100 == newCard.getId());
    }
}





