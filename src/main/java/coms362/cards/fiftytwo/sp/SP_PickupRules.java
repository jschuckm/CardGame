package coms362.cards.fiftytwo.sp;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.fiftytwo.SetQuorumCmd;
import events.inbound.InitGameEvent;
import events.inbound.SetQuorumEvent;
import model.Quorum;

public class SP_PickupRules extends PickupRules {
	@Override
	public Move apply(InitGameEvent e, Table table, Player player){
		return new SP_PickupInitCmd(table.getPlayerMap());
	}
	@Override
	public Move apply(SetQuorumEvent e, Table table, Player player){
		return new SetQuorumCmd(new Quorum(1,1));
	}
}
