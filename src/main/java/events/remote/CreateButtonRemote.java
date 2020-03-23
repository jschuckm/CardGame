package events.remote;

import coms362.cards.streams.Marshalls;
import model.Location;

public class CreateButtonRemote implements Marshalls {
    private String id;
    private String evtName;
    private String label;
    private Location loc;

    public CreateButtonRemote(String id, String evtName, String label, Location p) {
        this.id = id;
        this.evtName = evtName;
        this.label = label;
        loc = p;
    }

    public String marshall() {
        return String.format("cards362.createButton('%s', '%s', '%s', %d, %d);\n",
                id, evtName, label, loc.getX(), loc.getY());
    }

    public String stringify() {
        return "CreateButton " + label;
    }

}
