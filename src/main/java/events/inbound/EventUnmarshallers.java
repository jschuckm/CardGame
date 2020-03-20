package events.inbound;

import java.util.HashMap;
import java.util.Map;

public class EventUnmarshallers {
	
	private Map<String, Class<EventFactory>> registry = new HashMap<String, Class<EventFactory >>();

	
	private static EventUnmarshallers instance = null;
	
	private EventUnmarshallers (){
	
	}
	
	public static synchronized  EventUnmarshallers getInstance(){
		if (instance == null) {
			instance = new EventUnmarshallers();
		}
		System.out.println("Creating registry "+instance);
		return instance;
	}
	
	public void registerHandler(String eventName, Class< EventFactory> klass){
		registry.put(eventName, klass);
		System.out.println("registering event "+eventName);
	}

	public Class<EventFactory> getHandler(String eventName){
		return registry.get(eventName); 		
	}
}
