package events.inbound;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.RulesDispatch;
import coms362.cards.abstractcomp.Table;

public interface Event {
	public Move dispatch (RulesDispatch rules, Table table, Player player);
}
