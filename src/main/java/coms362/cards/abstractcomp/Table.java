package coms362.cards.abstractcomp;

import java.util.Collection;
import java.util.Random;

import model.Card;
import model.Party;
import model.Pile;
import model.Quorum;

public interface Table {

	void addPile(Pile pile);
	void addPlayer(Player p);
	
	Pile getPile(String string);
	void removeFromPile(String string, Card c);
	void addToPile(String string, Card c);
	int addToScore(Player p, int i);
	boolean isMatchOver();
	void setMatchOver(boolean over);
	Random getRandom();
	Party getHost();
	boolean partiesReady();
	Player getCurrentPlayer();
	void setQuorum(Quorum quorum);
	public Quorum getQuorum();
	public Collection<Player> getPlayers();
	public void createPlayer(Integer pos, String socketId);
	public Player lookupPlayer(String socketId);
	public Player getPlayer(Integer pos);
}
