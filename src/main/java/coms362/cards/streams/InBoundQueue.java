package coms362.cards.streams;

import java.util.concurrent.ArrayBlockingQueue;

import events.inbound.Event;

public class InBoundQueue extends ArrayBlockingQueue<Event>{

	public InBoundQueue() {
		super(1024);
	}
	
	@Override
	public boolean add(Event e){
		System.out.println("Queue Adding :"+e.toString());
		return super.add( e);
	}
	
	@Override
	public Event take() throws InterruptedException{		
		Event rval = super.take();
		System.out.println("Taking from queue: "+rval.toString());
		return rval;
	}
	
}
