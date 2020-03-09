package coms362.cards.fiftytwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import model.Card;
import model.Pile;
import model.Player;
import model.Table;

public class TableBase implements Table {
	
	private Map<String,Pile> piles = new HashMap<String,Pile>();
	private Map<Integer, Player> players = new HashMap<Integer, Player>();
	private Random rng = new Random();
	
	public void addPile(Pile pile) {
		piles.put(pile.getName(), pile);
	}

	public void addPlayer(Player p) {
		players.put(p.getPlayerNum(), p);
	}

	public void apply(Move move) {
		move.apply(this);
	}

	public Pile getPile(String name) {
		return piles.get(name);
	}

	public void removeFromPile(String name, Card c) {
		Pile target = piles.get(name);
		if (target != null){
			target.cards.remove(c.getId());
		}
	}

	public void addToPile(String name, Card c) {
		Pile target = piles.get(name);
		if (target != null){
			target.cards.put(c.getId(), c);
		}
	}

	public int addToScore(Player p, int i) {
		Player playn = players.get(p.getPlayerNum());
		if (playn != null) {
			return playn.addToScore(i);
		}
		return 0;
	}

	public Random getRandom() {
		return rng;
	}


}
