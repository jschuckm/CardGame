package coms362.cards.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.fiftytwo.P52PlayerView;
import coms362.cards.fiftytwo.PartyRole;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.streams.InBoundQueue;
import coms362.cards.streams.RemoteTableGateway;
import events.inbound.Event;
import events.inbound.InitGameEvent;
import events.remote.SetGameTitleRemote;
import events.remote.SetupTable;

public class MatchController {
	
	private RemoteTableGateway remote;
	private List<View> views = 
			new ArrayList<View>();
	private Table table;
	private Rules rules;
	private InBoundQueue inQ;
	private GameFactory factory;
	
	public MatchController(
			InBoundQueue inQ, 
			Table table, Rules rules, 
			RemoteTableGateway remote, 
			GameFactory factory
		)
	{
		this.inQ = inQ;
		this.table = table;
		this.rules = rules;	
		this.remote = remote;
		this.factory = factory;
	}

	public void start(){
		//this is match setup ... it depends on which game
		//was selected. We initialize for a new match of the
		//already selected game
			View  p1View = factory.createView(PartyRole.player, 1, remote);
			views.add(p1View); // might be more or fewer views each match
			Player player = factory.createPlayer(PartyRole.player, 1); //ditto for players
	
			Event terminal = null; 
			do {// initialize the local model for Pu52 match
				Move initCmd = rules.eval(new InitGameEvent(), table, player);
				table.apply(initCmd);
				p1View.apply(initCmd);
				
				PlayController mainloop = new PlayController(inQ, rules);
				terminal = mainloop.play(table, player, views);
			} while (terminal != null);
			
	}
}
