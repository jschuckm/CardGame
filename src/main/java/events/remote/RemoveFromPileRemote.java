package events.remote;

import coms362.cards.streams.Marshalls;
import model.Card;

public class RemoveFromPileRemote implements Marshalls {

	private Card c;

	public RemoveFromPileRemote(String string, Card c) {
		this.c = c;
	}

	public String marshall() {
		return String.format(
			"discardPile.addCard(allCards[%d]);\n"
			+ "discardPile.render();\n", 
			c.getId()
		);
	}

}

/*
try {
    remote.sendString("discardPile.addCard(allCards[" + id + "])");
    remote.sendString("discardPile.render()");
} catch (Exception e) {
    e.printStackTrace();
}
*/