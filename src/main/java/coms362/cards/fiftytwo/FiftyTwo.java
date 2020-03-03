package coms362.cards.fiftytwo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import cards.streams.InBoundQueue;
import cards.streams.RemoteTableGateway;
import events.inbound.CardEvent;
import events.inbound.DealEvent;
import events.inbound.Event;
import events.remote.CreatePile;
import events.remote.CreateRemote;
import events.remote.SetupTable;
import events.remote.UpdateRemote;
import model.Card;
import model.Location;
import model.Pile;

public class FiftyTwo {
	
    private String suits[] = {"h", "s", "d", "c"};
	private InBoundQueue inQ;
	private RemoteTableGateway remote; 
    private Random random = new Random();
    private List<Card> cards = new LinkedList<Card>();	
    
	public FiftyTwo (InBoundQueue inQ, RemoteTableGateway gateway){
		this.inQ = inQ;
		this.remote = gateway;
	}
	
	public void run (){
		initLocalDeck();
		Event nextE; 
		try {
			remote.send(new SetupTable());
			//TODO: this shoulld dispatch event to rules for 
			//behavior commands. 
			while ((nextE = inQ.take()) != null){
				if (nextE instanceof DealEvent){
					sendCards();
				} else if (nextE instanceof CardEvent){
					pickupCard(((CardEvent) nextE).getId());
				} else {
					System.err.println("FiftyTwo.run unable to process "+nextE.toString());
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//TODO: move these to command objects. 	
	private void initLocalDeck(){

	        try {
	            int cardCounter = 0;
	            for (String suit : suits) {
	                for (int i = 1; i <= 13; i++) {
	                    Card card = new Card();
	                    card.setId(cardCounter++);
	                    card.setSuit(suit);
	                    card.setNumber(i);
	                    card.setX(random.nextInt(200) + 100);
	                    card.setY(random.nextInt(200) + 100);
	                    card.setRotate(random.nextInt(360));
	                    card.setFaceUp(random.nextBoolean());
	                    cards.add(card);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
		
	
    private void sendCards() {
    	RemoteTableGateway gateway = remote;
        try {
        	gateway.send(new CreatePile(new Pile("discardPile", new Location(500,359))));

            for (Card c : cards) {
            	String outVal="";
            	gateway.send(new CreateRemote(c));
            	gateway.send(new UpdateRemote(c));
                System.out.println(outVal);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void pickupCard(String id){
        try {
            remote.sendString("discardPile.addCard(allCards[" + id + "])");
            remote.sendString("discardPile.render()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

}
