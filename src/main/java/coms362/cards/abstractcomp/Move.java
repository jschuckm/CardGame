package coms362.cards.abstractcomp;

import java.util.List;

import coms362.cards.app.ViewFacade;

public interface Move {
	
	public void apply(Table table);
	
	default public boolean isMatchEnd(){
		return false;
	}
	
	public void apply(ViewFacade views);
	
}
