package coms362.cards.fiftytwo;

import java.util.Random;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import events.inbound.DealEvent;
import events.remote.CreateButtonRemote;
import events.remote.CreatePile;
import events.remote.SetBottomPlayerTextRemote;
import events.remote.SetGameTitleRemote;
import events.remote.SetupTable;
import model.Button;
import model.Card;
import model.Location;
import model.Pile;

public class PickupInitCmd implements Move {
	private int nextId;
	Player p1;
	Player p2;

	public PickupInitCmd(Player p1, Player p2) {
	    nextId = 0;
		this.p1 = p1;
		this.p2 = p2;
	}

	public void apply(Table table){
		Pile discard = new Pile("discardPile", new Location(500,359));
		Random random = table.getRandom();
        try {
            for (String suit : Card.suits) {
                for (int i = 1; i <= 13; i++) {
                    Card card = new Card();
                    card.setId(nextId++);
                    card.setSuit(suit);
                    card.setNumber(i);
                    card.setX(random.nextInt(200) + 100);
                    card.setY(random.nextInt(200) + 100);
                    card.setRotate(random.nextInt(360));
                    card.setFaceUp(random.nextBoolean());
                    discard.cards.put(card.getId(), card);
                }
            }
            table.addPile( discard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void apply(ViewFacade view) {
		view.send(new SetupTable());
		view.send(new SetGameTitleRemote("52 Card Pickup"));
		view.send(new SetBottomPlayerTextRemote("Dealer", p1));
		view.send(new SetBottomPlayerTextRemote("Player", p2));
		view.send(new CreatePile(new Pile("discardPile", new Location(500,359))));
		String id = ""; 
		DealButton dealButton = new DealButton("DEAL", new Location(0, 0));
		view.register(dealButton); //so we can find it later. 
		view.send(new CreateButtonRemote(dealButton));
		//view.send(new CreateButtonRemote(Integer.toString(getNextId()), "reset", "RestartGame", "Reset", new Location(500,0)));
		//view.send(new CreateButtonRemote(Integer.toString(getNextId()), "clear", "ClearTable", "Clear Table", new Location(500,0)));
	}
	
	private int getNextId() {
	    return nextId++;
	}
}
