package coms362.cards.app;

import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.streams.InBoundQueue;
import coms362.cards.streams.RemoteTableGateway;
import model.TableBase;


public class FiftyTwo {
	
	private InBoundQueue inQ;
	private RemoteTableGateway remote; 
    
	public FiftyTwo (InBoundQueue inQ, RemoteTableGateway gateway){
		this.inQ = inQ;
		this.remote = gateway;
	}
	
	
	public void run (){
	// TODO: add loop so that multiple matches can be played without 
	// reprovisioning game components. 
		//game setup -- this should eventually be the responsibility
		//of a top-level input loop and abstract factory. 
		Rules rules = new PickupRules();
		Table table = new TableBase();
		
		MatchController match = new MatchController(
			inQ, table, rules, remote
			);
		match.start();
	} 
}
