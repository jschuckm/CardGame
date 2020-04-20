package coms362.cards.war;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import events.remote.AddToPileRemote;
import events.remote.HideCardRemote;
import events.remote.RemoveFromPileRemote;
import events.remote.ShowCardRemote;
import events.remote.ShowPlayerScore;
import model.Card;
import model.Pile;

public class WarFlipCard implements Move {
	private Table table;
	private Player player;
	private Card card;
	private Pile pile;

	public WarFlipCard(Card c,Table tableIn, Player player, Pile pileIn) {
		this.table = tableIn;
		this.player = player;
		this.card = c;
		this.pile = pileIn;
	}
	@Override
	public void apply(Table table) {
		table.removeFromPile(pile.name, card);
		if(pile.name.equals("Player 1 FaceDown")) {
			table.addToPile("Player 1 Faceup", card);
		}else if(pile.name.equals("Player 2 FaceDown")) {
			table.addToPile("Player 2 FaceUp",card);
		}
		table.addToScore(player, 1);
	}

	@Override
	public void apply(ViewFacade view) {
		view.send(new HideCardRemote(card));
		view.send(new RemoveFromPileRemote(pile.name, card));
		if(pile.name.equals("Player 1 FaceDown")) {
			view.send(new AddToPileRemote("Player 1 Faceup", card));
		}else if(pile.name.equals("Player 2 FaceDown")) {
			view.send(new AddToPileRemote("Player 2 FaceUp",card));
		}
		
		view.send(new ShowCardRemote(card));
		view.send(new ShowPlayerScore(player, null));


	}

}
