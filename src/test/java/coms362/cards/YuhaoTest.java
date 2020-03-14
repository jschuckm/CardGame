package coms362.cards;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

import org.junit.Test;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.app.PlayController;
import coms362.cards.fiftytwo.LoggingView;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.streams.InBoundQueue;
import events.inbound.DealEvent;
import events.inbound.CardEvent;
import events.inbound.EndPlay;
import model.TableBase;


public class YuhaoTest {
	static final int playerNum = 10;
	static final long expectedSig = 1585141778L;
	
	@Test
	public void firstTest() {
		//fail("Not yet implemented");
		
		InBoundQueue inQ2 = new InBoundQueue();
		inQ2.add(new DealEvent());
		inQ2.add(new CardEvent("1"));
		inQ2.add(new CardEvent("2"));
		inQ2.add(new CardEvent("3"));
		inQ2.add(new EndPlay());
		//System.out.println("inQ2:"+ inQ2);
		
		List<View> views = new ArrayList<View>();
		//we keep a reference to the concrete type for later
		LoggingView  p1View = new LoggingView();
		views.add(p1View);
		
		Player player2 = new PickupPlayer(10);
		int playNum = player2.getPlayerNum();
		System.out.println("expected:"+ playNum);
		
		Table table = new TableBase();
		table.apply(new PickupInitCmd());
		Rules rules = new PickupRules();
		PlayController mainloop = new PlayController(inQ2, rules);
		mainloop.play(table, player2, views);
		
		String log = p1View.getLog();
		System.out.println(log);
		
		assertEquals(playerNum, playNum);
		
		CRC32 sig = new CRC32();
		sig.update(log.getBytes());
		long sValue = sig.getValue();
		System.out.println(sValue);

		assertEquals(expectedSig, sValue);
				
	}
	
	
	@Test
	
	public void secondTest() {
		Table table2 = new TableBase();
		table2.apply(new PickupInitCmd());
		Player player3 = new PickupPlayer(2);
		
		for(int i = 0; i <= 51; i++)
		{
			assertEquals(player3.getPlayerNum(), 2); 
		}
		
	}
}




