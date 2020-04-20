package coms362.cards;

import static org.junit.Assert.*;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.DealCommand;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupMove;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.sp.SP_GameFactory;
import model.Card;
import model.Location;

import model.TableBase;
import org.junit.Test;

import model.Pile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Daksh Goel
 *
 */

public class DakshTestIter2 {

    @Test
    public void checkSinglePlayerScore(){
        Player player = new PickupPlayer(1);
        Table table = new TableBase(new SP_GameFactory());
        table.addPlayer(player);
        Move move = new PickupInitCmd(table.getPlayerMap(),"Test Solitaire 52 Card Pickup");
        move.apply(table);
        Pile discardPile = table.getPile("discardPile");

        Set<Integer> cid = discardPile.cards.keySet();
        Iterator itr = cid.iterator();
        DealCommand deal = new DealCommand(table, player);
        deal.apply(table);
        for(int i = 1; i <= 52 && itr.hasNext(); i++) {
            Card c = discardPile.getCard(itr.next().toString());
            itr.remove();
            PickupMove pickupMove = new PickupMove(c, player);
            pickupMove.apply(table);
            assertEquals(i , player.getScore());
        }
    }

}
