package coms362.cards.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import coms362.cards.fiftytwo.P52PlayerView;
import coms362.cards.fiftytwo.PickupInitCmd;
import coms362.cards.fiftytwo.PickupPlayer;
import coms362.cards.fiftytwo.Rules;
import coms362.cards.fiftytwo.View;
import coms362.cards.streams.InBoundQueue;
import coms362.cards.streams.RemoteTableGateway;
import events.remote.SetupTable;
import model.Player;
import model.Table;

public class MatchController {
	
	private RemoteTableGateway remote;
	private List<View> views = new ArrayList<View>();
	private Table table;
	private Rules rules;
	private InBoundQueue inQ;
	
	public MatchController(
			InBoundQueue inQ, 
			Table table, Rules rules, 
			RemoteTableGateway remote
		)
	{
		this.inQ = inQ;
		this.table = table;
		this.rules = rules;	
		this.remote = remote;
	}

	public void start(){
		//this is match setup ... it depends on which game
		//was selected. We initialize for a new match of 
		//already selected game
		try {
			View  p1View = new P52PlayerView(1, remote);
			views.add(p1View); // might be more or fewer views each match
	
			p1View.send(new SetupTable());
			Player player = new PickupPlayer(1); //ditto for players
			
			// initialize the local model for Pu52 match
			table.apply(new PickupInitCmd());
			p1View.apply(new PickupInitCmd());
			
			PlayController mainloop = new PlayController(inQ, rules);
			mainloop.play(table, player, views);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					

	}
}
