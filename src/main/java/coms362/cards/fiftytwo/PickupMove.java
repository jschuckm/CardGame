package coms362.cards.fiftytwo;

import java.io.IOException;

import events.remote.AddToPileRemote;
import events.remote.HideCardRemote;
import events.remote.RemoveFromPileRemote;
import events.remote.ShowCardRemote;
import events.remote.UpdateTextRemote;
import model.Card;
import model.Player;
import model.Table;

public class PickupMove implements Move {
	
	private Card c;
	private Player p;
	
	public PickupMove(Card c, Player p){
		this.c = c;
		this.p = p; 
	}
	
	public void apply(Table table){
		table.removeFromPile("discardPile", c);
		table.addToPile("Tidy", c);
		table.addToScore(p, 1);
	}
	
	public void apply(View view){

		try {
			view.send(new HideCardRemote(c));
			view.send(new RemoveFromPileRemote("Random", c));
			view.send(new AddToPileRemote("Tidy", c));
			view.send(new ShowCardRemote(c));
			view.send(new UpdateTextRemote(p, 1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
