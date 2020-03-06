package coms362.cards.fiftytwo;

import events.inbound.CardEvent;
import events.inbound.DealEvent;
import events.inbound.Event;
import model.Card;
import model.Player;
import model.Table;

public class PickupRules implements Rules {
	
	//TODO: find a fix for this. 
	public Move eval(Event nextE, Table table, Player player) {
		if (nextE instanceof CardEvent)
			return eval((CardEvent) nextE, table, player);
		else if (nextE instanceof DealEvent)
			return eval((DealEvent) nextE, table, player);
		else
			return new EndPlayMove();
	}
	
	//TODO: find better way to lookup pile.
	public Move eval(CardEvent e, Table table, Player player){
		Card c = table.getPile("discardPile").getCard(e.getId());
		if ( c == null){
			return new DropEventCmd();
		}
		return new PickupMove(c, player);		
	}
	
	public Move eval(DealEvent e, Table table, Player player){
		return new DealCommand(table, player);
	}

}
