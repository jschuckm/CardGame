package coms362.cards.abstractcomp;

import events.inbound.CardEvent;
import events.inbound.DealEvent;
import events.inbound.EndPlay;
import events.inbound.GameRestartEvent;
import events.inbound.InitGameEvent;
import events.inbound.SelectGame;

public interface RulesDispatch {
	
	public Move apply(CardEvent e, Table table, Player player);
	
	public Move apply(DealEvent e, Table table, Player player);

	public Move apply(EndPlay e, Table table, Player player);

	public Move apply(InitGameEvent e, Table table, Player player);

	public Move apply(SelectGame e, Table table, Player player);

	public Move apply(GameRestartEvent e, Table table, Player player);

}
