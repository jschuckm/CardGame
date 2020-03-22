package coms362.cards.abstractcomp;

import events.inbound.CardEvent;
import events.inbound.ConnectEvent;
import events.inbound.DealEvent;
import events.inbound.EndPlay;
import events.inbound.GameRestartEvent;
import events.inbound.InitGameEvent;
import events.inbound.NewPartyEvent;
import events.inbound.SelectGame;
import events.inbound.SetQuorumEvent;

public interface RulesDispatch {
	
	public Move apply(CardEvent e, Table table, Player player);
	
	public Move apply(DealEvent e, Table table, Player player);

	public Move apply(EndPlay e, Table table, Player player);

	public Move apply(InitGameEvent e, Table table, Player player);

	public Move apply(SelectGame e, Table table, Player player);

	public Move apply(GameRestartEvent e, Table table, Player player);

	public Move apply(NewPartyEvent e, Table table, Player player);
	
	public Move apply(ConnectEvent e, Table table, Player player);

	public Move apply(SetQuorumEvent e, Table table, Player player);
	
}
