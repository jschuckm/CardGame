package coms362.cards;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

import org.junit.Test;
import coms362.cards.fiftytwo.*;
import coms362.cards.fiftytwo.P52GameFactory;
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
import events.inbound.EndPlay;
import model.TableBase;
import model.Card;
import model.Location;
import model.Pile;

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
	
	
	}
