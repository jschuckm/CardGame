package coms362.cards;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import coms362.cards.fiftytwo.P52GameFactory;
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

