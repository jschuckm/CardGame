package coms362.cards;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.CRC32;

import org.junit.Before;
import org.junit.Test;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.app.GameFactoryFactory;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.LoggingView;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.SetQuorumCmd;
import coms362.cards.fiftytwo.sp.SP_GameFactory;
import coms362.cards.fiftytwo.sp.SP_PickupRules;
import coms362.cards.streams.InBoundQueue;
import events.inbound.DealEvent;
import events.inbound.EndPlay;
import events.inbound.Event;
import events.inbound.InitGameEvent;
import events.inbound.SetQuorumEvent;
import model.Location;
import model.Pile;
import model.Quorum;
import model.TableBase;

/**
 * This class tests the TableBase.java class in model.
 * 
 * @author Jared Schuckman 
 */
public class JaredTestIter2SP_PickupRules {
	TableBase table;
	InBoundQueue inQ;
	Rules rules;
	ViewFacade views;
	LoggingView p1View;
	@Before
	public void beforeEachTestMethod(){
		//set up game and match resources to provision play loop 
		inQ = new InBoundQueue();
		//pre-load the input stream with the input for this test
		inQ.add(new InitGameEvent());
		inQ.add(new SetQuorumEvent(new Quorum(1,1)));
		
		views = new ViewFacade(null);
		//we keep a reference to the concrete type for later
		p1View = new LoggingView();
		views.add(p1View); 
		
		Map<Integer, Player> players = new HashMap<Integer,Player>();
		Player player =  new PickupPlayer(1) ;
		players.put( (Integer) 1, player);
		GameFactory spGameFact = new GameFactoryFactory().getGameFactory("PU52");
		table = new TableBase(spGameFact);
		rules = spGameFact.createRules();
    }
	/**
	 ** This applies InitGameEvent and Set QuorumCmd from SP_PickupRules.   
	 * @throws InterruptedException 
	 **/
	@Test	
	public void testSP_PickupRules() throws InterruptedException {
		Event e = inQ.take(); 
		Move cmd = rules.eval(e, table, table.getCurrentPlayer()  );
		cmd.apply(table);
		cmd.apply(views);
		assertNotNull(this.table.getPile("discardPile"));
		CRC32 sig = new CRC32();
		String log = p1View.getLog();
		sig.update(log.getBytes());
		long sValue = sig.getValue();
		assertEquals(1295823561L,sValue);
		e = inQ.take(); 
		cmd = rules.eval(e, table, table.getCurrentPlayer()  );
		cmd.apply(table);
		cmd.apply(views);
		assertNotNull(this.table.getQuorum());
	}
	
	

}


