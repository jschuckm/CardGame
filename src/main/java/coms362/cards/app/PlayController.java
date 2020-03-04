package coms362.cards.app;

import java.util.List;
import java.util.Random;

import coms362.cards.fiftytwo.Move;
import coms362.cards.fiftytwo.Rules;
import coms362.cards.fiftytwo.View;
import coms362.cards.streams.InBoundQueue;
import events.inbound.Event;
import model.Player;
import model.Table;

public class PlayController {

	private InBoundQueue inQ; 
	private Rules rules;
    
	public PlayController (InBoundQueue inQ, 
			Rules rules)
	{
		this.inQ = inQ;
		this.rules = rules; 
	}
	
	public void play(Table table, Player player, List<View> views){
		Event nextE;
		View p1View = views.get(0);
		try {
		
			while ((nextE = inQ.take()) != null){
				Move move = rules.eval(nextE, table, player);
				table.apply(move);
				p1View.apply(move);
			}
		} catch (InterruptedException e){
			System.err.println("Play terminated on exception: "+e.getMessage());
			// clean up for next match? 
		}

	}

}
