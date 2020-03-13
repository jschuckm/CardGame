package events.inbound;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;

public class CardEvent implements Event {
	
	private String id;

	public CardEvent(String cardId) {
		this.id = cardId;
	}
	
	
	public String getId(){
		return id;
	}

}
