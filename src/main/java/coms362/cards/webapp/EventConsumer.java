package coms362.cards.webapp;

import cards.streams.InBoundQueue;
import cards.streams.RemoteTableGateway;
import coms362.cards.socket.CardSocket;
import coms362.cards.socket.CardSocketListener;
import coms362.cards.socket.SocketEvent;
import events.inbound.CardEvent;
import events.inbound.DealEvent;
import events.inbound.Event;

public class EventConsumer implements CardSocketListener {
    private InBoundQueue q; 
    private CardSocket cardSocket;

    public EventConsumer(InBoundQueue q) {
    	this.q = q;
    }

    public void onConnect() {
        System.out.println("onConnect");
    }

    public void onReceive(SocketEvent event) {
    	Event e = createEvent(event);
    	if (e != null){
    		q.add(e);
    	}
    	//otherwise, drop it on the floor.     	
    }
    
    // TODO: move to injected Event factory. 
    private Event createEvent(SocketEvent e){
    	Object eventObj = e.get("event");
        if (eventObj == null) {
        	return null;
        }
        String eventName = (String) eventObj;
        System.out.println(eventName);
        if ("dealevent".equals(eventName)) {
            return new DealEvent();
        } else if ("cardevent".equals(eventName)) {
            return new CardEvent(e.get("id").toString());
        } else {
        	//drop it on the floor
        	System.err.println("Unable to process socket event " + e.toString());
        }
        return null;          
            
    }

    public void setCardSocket(CardSocket cardSocket) {
        this.cardSocket = cardSocket;
        RemoteTableGateway.getInstance().setSocket(cardSocket.getRemote());
    }

}
