package coms362.cards.app;

import java.util.Arrays;
import java.util.List;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.fiftytwo.P52GameFactory;

public class GameFactoryFactory {
	
	String gameIds[] = {"PU52MP", "PU52"};
	List<String> supported = Arrays.asList(gameIds);
	
	public GameFactory getGameFactory(String selector){
		return new P52GameFactory();
	}

	public boolean isValidSelection(String gameId) {
		return supported.contains(gameId);
	}
}
