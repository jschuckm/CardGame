package coms362.cards.war;


import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.RulesDispatch;
import coms362.cards.abstractcomp.RulesDispatchBase;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.CreatePlayerCmd;
import coms362.cards.fiftytwo.DealCommand;
import coms362.cards.fiftytwo.DropEventCmd;
import coms362.cards.fiftytwo.PartyRole;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupMove;
import coms362.cards.fiftytwo.SetQuorumCmd;
import events.inbound.CardEvent;
import events.inbound.ConnectEvent;
import events.inbound.DealEvent;
import events.inbound.Event;
import events.inbound.EventUnmarshallers;
import events.inbound.GameRestartEvent;
import events.inbound.InitGameEvent;
import events.inbound.NewPartyEvent;
import events.inbound.SetQuorumEvent;
import model.Card;
import model.Quorum;

public class WarRules extends RulesDispatchBase
implements Rules, RulesDispatch {

	public WarRules(){
		registerEvents();
	}

	public Move eval(Event nextE, Table table, Player player) {
		return nextE.dispatch(this, table, player);
	}


	public Move apply(CardEvent e, Table table, Player player){
		
		Card c = table.getPile("Player 1 FaceDown").getCard(e.getId());
		Card d = table.getPile("Player 2 FaceDown").getCard(e.getId());
		if ( c == null){
			if(d==null) {
				return new DropEventCmd();
			}else {
				return new WarFlipCard(d,table,player,table.getPile("Player 2 FaceDown"));
			}
		}else {
			return new WarFlipCard(c,table, player,table.getPile("Player 1 FaceDown"));
		}
	}

	public Move apply(DealEvent e, Table table, Player player){
		return new WarDealCommand(table, player);
	}

	public Move apply(InitGameEvent e, Table table, Player player){
		return new WarInitCmd(table.getPlayerMap());
	}

	public Move apply(NewPartyEvent e, Table table, Player player){
		if (e.getRole() == PartyRole.player){
			return new CreatePlayerCmd( e.getPosition(), e.getSocketId());
		}
		return new DropEventCmd();
	}

	public Move apply(SetQuorumEvent e, Table table, Player player){
		return new SetQuorumCmd(new Quorum(2,2));
	}

	public Move apply(ConnectEvent e, Table table, Player player){

		Move rval = new DropEventCmd();
		System.out.println("Rules apply ConnectEvent "+e);
		if (! table.getQuorum().exceeds(table.getPlayers().size()+1)){
			if (e.getRole() == PartyRole.player){
				rval =  new CreatePlayerCmd( e.getPosition(), e.getSocketId());
			}
		}
		System.out.println("PickupRules connectHandler rval = "+rval);
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

