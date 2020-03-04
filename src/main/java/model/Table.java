package model;

import java.util.Random;

import coms362.cards.fiftytwo.Move;

public interface Table {

	void addPile(Pile pile);
	void addPlayer(Player p);
	
	void apply(Move move);
	Pile getPile(String string);
	void removeFromPile(String string, Card c);
	void addToPile(String string, Card c);
	int addToScore(Player p, int i);
	Random getRandom();
}
