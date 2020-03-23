package model;

public class Button {
    private String id;
    private String evtName;
    private String label;
    private Location location;

    public Button(String id, String evtName, String label, Location location) {
        this.id = id;
        this.evtName = evtName;
        this.label = label;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvtName() {
        return evtName;
    }

    public void setEvtName(String evtName) {
        this.evtName = evtName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
