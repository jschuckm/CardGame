package events.inbound;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.RulesDispatch;
import coms362.cards.abstractcomp.Table;
import coms362.cards.socket.SocketEvent;

public class CardEvent implements Event, EventFactory {

	public static final String kId = "cardevent";
		
	public static Event createEvent(SocketEvent sktEvent){
		return new CardEvent( sktEvent.get("id").toString());		
	}
	
	private String id;
	
	public CardEvent(String cardId) {
		this.id = cardId;
	}	
	
	public String getId(){
		return id;
	}

	@Override
	public Move dispatch(RulesDispatch rules, Table table, Player player) {
		return rules.apply(this, table, player);
	}

}
