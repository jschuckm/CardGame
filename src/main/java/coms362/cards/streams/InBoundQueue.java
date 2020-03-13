package coms362.cards.streams;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import events.inbound.Event;

/**
 * @author RWard
 * 
 * This blocking queue converts events that arrive spontaneously from an 
 * asynchronous source into a synchronously accessible input stream. 
 * 
 * We have added "pushback" semantics so that "internal events" created
 * by the business logic (not the external async source) can be pushed onto
 * the head of the queue, giving them precedence over any pending or future 
 * external async events.
 * 
 * Note that this queue can be easily pre-populated with events, making it 
 * a convenient driver for automated tests. 
 *
 */
public class InBoundQueue extends ArrayBlockingQueue<Event>{

	private Stack<Event> pushBack = new Stack<Event>();

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
		if (! pushBack.isEmpty()){
			return pushBack.pop();
		}
		Event rval = super.take();
		System.out.println("Taking from queue: "+rval.toString());
		return rval;
	}
	
	public void pushBack(Event e){
		pushBack.push(e); 
	}
	
	@Override
	public boolean isEmpty(){
		return pushBack.isEmpty() && super.isEmpty();
	}
}
