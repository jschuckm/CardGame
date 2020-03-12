package coms362.cards.fiftytwo;

import events.inbound.CardEvent;
import events.inbound.Event;
import model.Player;
import model.Table;

public interface Rules {

	Move eval(Event nextE, Table table, Player player);

}
