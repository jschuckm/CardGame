package coms362.events;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.RulesDispatch;
import coms362.cards.abstractcomp.Table;
import coms362.cards.app.GameController;
import events.inbound.Event;
import events.inbound.SysEvent;
import model.Game;

public class InvalidGameSelection implements Event, SysEvent {

	private String selection; 
	
	public InvalidGameSelection(String selection) {
		this.selection = selection;
	}

	@Override
	public void accept(GameController handler, Game game) {
		// TODO Auto-generated method stub

	}

	@Override
	public Move dispatch(RulesDispatch rules, Table table, Player player) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getMsg(){
		return String.format(
			"Invalid Game Selection (%s).%nPlease reconnect and try again.",
			selection
		);
	}

}
