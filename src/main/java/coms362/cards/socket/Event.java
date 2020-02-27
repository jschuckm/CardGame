package coms362.cards.socket;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.util.ajax.JSON;

public class Event {
    Map map;

    public Event(String message) {
        JSON json = JSON.getDefault();
        try {
            map = (Map) json.parse(message);
        } catch (Exception e) {
            // ignore
        } finally {
            if (map == null) {
                map = new HashMap();
            }
        }
    }

    public Object get(String key) {
        System.out.println("LOOKING FOR: " + key + " with map " + map);
        return map.get(key);
    }
}
