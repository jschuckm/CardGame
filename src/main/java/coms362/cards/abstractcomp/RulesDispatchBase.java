package coms362.cards.abstractcomp;

import events.inbound.CardEvent;
import events.inbound.DealEvent;
import events.inbound.EndPlay;
import events.inbound.GameRestartEvent;
import events.inbound.InitGameEvent;
import events.inbound.SelectGame;

public class RulesDispatchBase implements RulesDispatch {

	@Override
	public Move apply(CardEvent e, Table table, Player player) {
		throw new RuntimeException("Event not supported " + e.toString());
	}

	@Override
	public Move apply(DealEvent e, Table table, Player player) {
		throw new RuntimeException("Event not supported " + e.toString());
	}

	@Override
	public Move apply(EndPlay e, Table table, Player player) {
		throw new RuntimeException("Event not supported " + e.toString());
	}

	@Override
	public Move apply(InitGameEvent e, Table table, Player player) {
		throw new RuntimeException("Event not supported " + e.toString());
	}

	@Override
	public Move apply(SelectGame e, Table table, Player player) {
		throw new RuntimeException("Event not supported " + e.toString());
	}

	@Override
	public Move apply(GameRestartEvent e, Table table, Player player) {
		throw new RuntimeException("Event not supported " + e.toString());
	}
}
