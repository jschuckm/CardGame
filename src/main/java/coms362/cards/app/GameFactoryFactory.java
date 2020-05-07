package coms362.cards.app;

import java.util.Arrays;
import java.util.List;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.sp.SP_GameFactory;
import coms362.cards.war.WarFactory;


public class GameFactoryFactory {

	String gameIds[] = {"PU52MP", "PU52","WAR"};
	List<String> supported = Arrays.asList(gameIds);

	public GameFactory getGameFactory(String selector){
		if(selector.compareTo(gameIds[2])==0) {
			return new WarFactory();
		}
		if(selector.compareTo(gameIds[1])==0) {
			return new SP_GameFactory();
		}
		return new P52GameFactory();
	}

	public boolean isValidSelection(String gameId) {
		return supported.contains(gameId);
	}
}
