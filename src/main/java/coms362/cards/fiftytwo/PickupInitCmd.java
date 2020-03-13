package coms362.cards.fiftytwo;

import java.io.IOException;
import java.util.Random;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import events.remote.CreatePile;
import model.Card;
import model.Location;
import model.Pile;

public class PickupInitCmd implements Move {

	public void apply(Table table){
		Pile discard = new Pile("discardPile", new Location(500,359));
		Random random = table.getRandom();
        try {
            int cardCounter = 0;
            for (String suit : Card.suits) {
                for (int i = 1; i <= 13; i++) {
                    Card card = new Card();
                    card.setId(cardCounter++);
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

	public void apply(View view) {
    	try {
			view.send(new CreatePile(new Pile("discardPile", new Location(500,359))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
