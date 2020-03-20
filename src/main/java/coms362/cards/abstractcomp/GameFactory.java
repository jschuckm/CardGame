package coms362.cards.abstractcomp;

import coms362.cards.fiftytwo.PartyRole;
import coms362.cards.streams.RemoteTableGateway;

/**
 * The interface through which the various controllers acquire game specific components. 
 * 
 * @author RWard
 *
 */
public interface GameFactory {
	public Rules createRules();
	public Table createTable();
	public Player createPlayer(PartyRole role, int pos);
	public View createView(PartyRole role, int num, RemoteTableGateway gw);
}
