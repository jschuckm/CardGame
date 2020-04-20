package coms362.cards.war;

import java.util.Map;
import java.util.Random;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.RulesDispatchBase;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.DealButton;
import events.remote.CreateButtonRemote;
import events.remote.CreatePile;
import events.remote.SetBottomPlayerTextRemote;
import events.remote.SetGameTitleRemote;
import events.remote.SetupTable;
import model.Card;
import model.Location;
import model.Pile;

public class WarInitCmd implements Move{
	Map<Integer, Player> players;
	String title = "Com S 362 War";

	public WarInitCmd(Map<Integer, Player> players) {
		this.players = players;
	}

	public void apply(Table table){
		Pile p1 = new Pile("Player 1 FaceDown", new Location(100,250));
		Pile p2 = new Pile("Player 2 FaceDown", new Location(500, 250));
		Pile p1up = new Pile("Player 1 FaceUp", new Location(100,150));
		Pile p2up = new Pile("Player 2 FaceUp", new Location(500,150));
		Random random = table.getRandom();
		//Todo: Implement shuffling to make who gets which cards random.
        try {
            for (String suit : Card.suits) {
                for (int i = 1; i <= 6; i++) {
                    Card card = new Card();
                    card.setSuit(suit);
                    card.setNumber(i);
                    card.setX(p1.getLocation().getX());
                    card.setY(p1.getLocation().getY());
                    card.setRotate(0);
                    card.setFaceUp(true);
                    p1.cards.put(card.getId(), card);
                }
            }
            for (String suit : Card.suits) {
                for (int i = 6; i <= 13; i++) {
                	Card card = new Card();
                    card.setSuit(suit);
                    card.setNumber(i);
                    card.setX(p2.getLocation().getX());
                    card.setY(p2.getLocation().getY());
                    card.setRotate(0);
                    card.setFaceUp(true);
                    p2.cards.put(card.getId(), card);
                }
            }
            table.addPile(p1);
            table.addPile(p2);
            table.addPile(p1up);
            table.addPile(p2up);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void apply(ViewFacade view) {
		view.send(new SetupTable());
		view.send(new SetGameTitleRemote(title));

		for (Player p : players.values()){
			String role = (p.getPlayerNum() == 1) ? "Dealer" : "Player "+p.getPlayerNum();
			view.send(new SetBottomPlayerTextRemote(role, p));
		}

		view.send(new CreatePile(new Pile("Player 1 FaceDown", new Location(500,359))));
		view.send(new CreatePile(new Pile("Player 2 FaceDown", new Location(500,100))));
		String id = "";
		DealButton dealButton = new DealButton("DEAL", new Location(0, 0));
		view.register(dealButton); //so we can find it later.
		view.send(new CreateButtonRemote(dealButton));
		//view.send(new CreateButtonRemote(Integer.toString(getNextId()), "reset", "RestartGame", "Reset", new Location(500,0)));
		//view.send(new CreateButtonRemote(Integer.toString(getNextId()), "clear", "ClearTable", "Clear Table", new Location(500,0)));
	}
}
