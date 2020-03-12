package events.inbound;

import coms362.cards.fiftytwo.Move;
import coms362.cards.fiftytwo.Rules;
import model.Player;
import model.Table;

public class CardEvent implements Event {
	
	private String id;

	public CardEvent(String cardId) {
		this.id = cardId;
	}
	
	public String getId(){
		return id;
	}

}
