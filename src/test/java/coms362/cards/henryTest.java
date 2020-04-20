package coms362.cards;


import static org.junit.Assert.*;


import org.junit.Test;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import model.TableBase;

/**
 * 
 * @author Henry Kansanback
 *
 */
public class henryTest {

	static final long expectedSig = 4116877291L;


	@Test
	public void matchOverCheckViaPlayer() {
      Player player = new PickupPlayer(1);
      for(int i = 0; i < 51; i++)
      {
			assertTrue(player.addToScore(1) > 0);
      }

      }
	
	
	@Test
	public void matchOverCheckViaTable() {
	      Player player = new PickupPlayer(1);
	      Table table = new TableBase(new P52GameFactory());
	      table.addPlayer(player);
	      
	      for(int i = 0; i < 51; i++)
	      {
				assertTrue(table.addToScore(player, 1) > 0);
	      }		
	}
	
	//Iteration 2
	@Test
	public void catchMatchOver() {
		Player player = new PickupPlayer(1);
		Table table = new TableBase(new P52GameFactory());
	      table.addPlayer(player);
	      for(int i = 0; i < 51; i++)
	      {
	    	  table.addToScore(player, 1);
				assertTrue(player.getScore() > 0);
	      }
	
	}
	}
	
	
	
