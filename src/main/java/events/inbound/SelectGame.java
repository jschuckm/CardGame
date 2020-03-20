package events.inbound;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.RulesDispatch;
import coms362.cards.abstractcomp.Table;

public class SelectGame implements Event {
	
	private String selection;
	
	public SelectGame (String gameId){
		selection = gameId;
	}
	
	public String getSelection(){
		return selection;
	}
	@Override
	public Move dispatch(RulesDispatch rules, Table table, Player player) {
		return rules.apply(this, table, player);
	}

}
