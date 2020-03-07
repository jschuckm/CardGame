package coms362.cards.fiftytwo;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import events.inbound.CardEvent;
import events.inbound.DealEvent;
import events.inbound.Event;
import model.Card;

public class PickupRules implements Rules {
	
	//TODO: find a fix for this. 
	public Move eval(Event nextE, Table table, Player player) {
		if (nextE instanceof CardEvent)
			return apply((CardEvent) nextE, table, player);
		else if (nextE instanceof DealEvent)
			return apply((DealEvent) nextE, table, player);
		else
			return new EndPlayMove();
	}
	
	//TODO: find better way to lookup pile.
	private Move apply(CardEvent e, Table table, Player player){
		Card c = table.getPile("discardPile").getCard(e.getId());
		if ( c == null){
			return new DropEventCmd();
		}
		return new PickupMove(c, player);		
	}
	
	private Move apply(DealEvent e, Table table, Player player){
		return new DealCommand(table, player);
	}

}
