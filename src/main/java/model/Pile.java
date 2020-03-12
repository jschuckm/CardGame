package model;

import java.util.HashMap;
import java.util.Map;

public class Pile {

	public String name;
	public String visible;
	public Map<Integer, Card> cards = new HashMap<Integer, Card>();
	private Location loc = new Location(0,0);
	
	public Pile (String name, Location loc){
		this.name = name;
		this.loc = loc;
	}

	public Location getLocation() {
		return loc;
	}
	
	public void addCard(Card c){
		cards.put(c.getId(), c);
	}

	public Card getCard(String id) {
		return cards.get(new Integer(id));
	}

	public String getName() {
		return name;
	}
}
