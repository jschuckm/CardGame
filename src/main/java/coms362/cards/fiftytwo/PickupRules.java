package coms362.cards.fiftytwo;

import java.util.Collection;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.RulesDispatch;
import coms362.cards.abstractcomp.RulesDispatchBase;
import coms362.cards.abstractcomp.Table;
import events.inbound.CardEvent;
import events.inbound.ConnectEvent;
import events.inbound.DealEvent;
import events.inbound.EndPlay;
import events.inbound.Event;
import events.inbound.EventUnmarshallers;
import events.inbound.GameRestartEvent;
import events.inbound.InitGameEvent;
import events.inbound.NewPartyEvent;
import events.inbound.SetQuorumEvent;
import model.Card;
import model.Party;

public class PickupRules extends RulesDispatchBase
implements Rules, RulesDispatch {

	public PickupRules(){
		registerEvents();
	}

	public Move eval(Event nextE, Table table, Player player) {
		return nextE.dispatch(this, table, player);
	}


	public Move apply(CardEvent e, Table table, Player player){

		Card c = table.getPile("discardPile").getCard(e.getId());
		if ( c == null){
			return new DropEventCmd();
		}
		return new PickupMove(c, player);
	}
    //jacob Added to prevent error with inbuilt test.
    public Move apply(EndPlay e, Table table, Player player){

        return new EndPlayMove();
    }
   
	public Move apply(DealEvent e, Table table, Player player){
		return new DealCommand(table, player);
	}

	public Move apply(InitGameEvent e, Table table, Player player){
		Player p1 = table.getPlayer((Integer) 1);
		Player p2 = table.getPlayer((Integer) 2);

		return new PickupInitCmd( p1, p2);
	}

	public Move apply(NewPartyEvent e, Table table, Player player){
		if (e.getRole() == PartyRole.player){
			return new CreatePlayerCmd( e.getPosition(), e.getSocketId());
		}
		return new DropEventCmd();
	}

	public Move apply(SetQuorumEvent e, Table table, Player player){
		return new SetQuorumCmd(e.getQuorum());
	}

	public Move apply(ConnectEvent e, Table table, Player player){

		Move rval = new DropEventCmd();
		System.out.println("Rules apply ConnectEvent "+e);
		if (table.getQuorum().meets(table.getPlayers().size()+1)){
			if (e.getRole() == PartyRole.player){
				rval =  new CreatePlayerCmd( e.getPosition(), e.getSocketId());
			}
		}
		System.out.println("Rules rval = "+rval);
		return rval;
	}

	/**
	 * We rely on Rules to register the appropriate input events with
	 * the unmarshaller. This avoids excessive complexity in the
	 * abstract factory and there is a natural dependency between
	 * the rules and the game input events.
	 */
	private void registerEvents() {

		EventUnmarshallers handlers = EventUnmarshallers.getInstance();
		handlers.registerHandler(InitGameEvent.kId, (Class) InitGameEvent.class);
		handlers.registerHandler(DealEvent.kId, (Class) DealEvent.class);
		handlers.registerHandler(CardEvent.kId, (Class) CardEvent.class);
		handlers.registerHandler(GameRestartEvent.kId, (Class) GameRestartEvent.class);
		handlers.registerHandler(NewPartyEvent.kId, (Class) NewPartyEvent.class);
	}






}
