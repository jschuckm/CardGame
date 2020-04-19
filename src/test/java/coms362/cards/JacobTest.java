package coms362.cards;

import static org.junit.Assert.*;

import java.util.zip.CRC32;

import org.junit.Test;

import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.PlayController;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.LoggingView;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.streams.InBoundQueue;
import events.inbound.DealEvent;
import events.inbound.EndPlay;
import events.inbound.CardEvent;
import coms362.cards.abstractcomp.Move;
import coms362.cards.fiftytwo.PickupInitCmd;
import model.TableBase;
import model.Pile;
/**
 * @author Jacob
 */
public class JacobTest {

    @Test
    public void standerdDeck(){
        Player player = new PickupPlayer(1); //ditto for players
        Player p2 = new PickupPlayer(2);
        Table table = new TableBase(new P52GameFactory());
        table.addPlayer(player);
        table.addPlayer(p2);
        Move move = new PickupInitCmd(table.getPlayerMap());
        move.apply(table);

        Pile discard = table.getPile("discardPile");
        assertTrue(discard.cards.size() == 52);
    }

}
