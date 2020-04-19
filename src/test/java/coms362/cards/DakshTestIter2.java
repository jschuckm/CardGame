package coms362.cards;

import static org.junit.Assert.*;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupMove;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.sp.SP_GameFactory;
import coms362.cards.fiftytwo.sp.SP_PickupInitCmd;
import model.Card;
import model.Location;

import model.TableBase;
import org.junit.Test;

import model.Pile;
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
        Move move = new SP_PickupInitCmd(table.getPlayerMap());
        move.apply(table);
        Pile discardPile = table.getPile("discardPile");
        for(int i = 1; i <= 13; i++) {
            Card c = discardPile.getCard(Integer.toString(i));
            PickupMove pickupMove = new PickupMove(c, player);
            pickupMove.apply(table);
            assertEquals(i , player.getScore());
        }
    }

}
