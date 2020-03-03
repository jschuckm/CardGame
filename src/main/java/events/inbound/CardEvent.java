package events.inbound;

public class CardEvent extends Event {
	
	private String id;

	public CardEvent(String cardId) {
		this.id = cardId;
	}
	
	public String getId(){
		return id;
	}

}
