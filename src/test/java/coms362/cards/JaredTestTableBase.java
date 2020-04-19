package coms362.cards;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

import org.junit.Before;
import org.junit.Test;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.app.PlayController;
import coms362.cards.fiftytwo.LoggingView;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.streams.InBoundQueue;
import events.inbound.DealEvent;
import events.inbound.EndPlay;
import model.Card;
import model.Location;
import model.Pile;
import model.TableBase;

/**
 * This class tests the TableBase.java class in model.
 * 
 * @author Jared Schuckman 
 */
public class JaredTestTableBase {
	TableBase test;
	@Before
	public void beforeEachTestMethod(){
        test = new TableBase(new P52GameFactory());
    }
	/**
	 ** This test checks adding and getting piles in TableBase.   
	 **/
	@Test	
	public void testAddPile() {
		Pile testPile1 = new Pile("test1",new Location());
		Pile testPile2 = new Pile("test2",new Location());
		test.addPile(testPile1);
		test.addPile(testPile2);
		assertEquals(test.getPile("test1"),testPile1);
		assertEquals(test.getPile("test2"),testPile2);
	}
	
	

}

