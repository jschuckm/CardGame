package coms362.cards.app;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.fiftytwo.PickupRules;
import coms362.cards.streams.InBoundQueue;
import coms362.cards.streams.RemoteTableGateway;
import model.TableBase;


public class GameController 
{
	
	private InBoundQueue inQ;
	private RemoteTableGateway remote; 
	private GameFactory factory;
    
	public GameController (InBoundQueue inQ, RemoteTableGateway gateway, GameFactory factory){
		this.inQ = inQ;
		this.remote = gateway;
		this.factory = factory;
	}
	
	
	public void run (){
	// TODO: add loop so that multiple matches can be played without 
	// reprovisioning game components. 
		//game setup -- this should eventually be the responsibility
		//of a top-level input loop and abstract factory. 
        System.out.println("Application Started");
		Rules rules = factory.createRules();

		Table table = factory.createTable();
		
		MatchController match = new MatchController(
			inQ, table, rules, remote, factory
			);
		match.start();
	} 
}
