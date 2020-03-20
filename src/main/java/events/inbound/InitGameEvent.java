package events.inbound;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.RulesDispatch;
import coms362.cards.abstractcomp.Table;

public class InitGameEvent implements Event {

	public static final String kId = "InitGameEvent";

	@Override
	public Move dispatch(RulesDispatch rules, Table table, Player player) {
		return rules.apply(this, table, player);
	}

}
