package coms362.cards.abstractcomp;

import java.util.Random;

import model.Card;
import model.Pile;

public interface Table {

	void addPile(Pile pile);
	void addPlayer(Player p);
	
	void apply(Move move);
	Pile getPile(String string);
	void removeFromPile(String string, Card c);
	void addToPile(String string, Card c);
	int addToScore(Player p, int i);
	boolean isMatchOver();
	void setMatchOver(boolean over);
	Random getRandom();
}
