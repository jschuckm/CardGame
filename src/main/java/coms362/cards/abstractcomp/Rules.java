package coms362.cards.abstractcomp;

import events.inbound.Event;

public interface Rules {

	Move eval(Event nextE, Table table, Player player);

}
