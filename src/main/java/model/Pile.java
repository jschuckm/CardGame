package model;

public class Pile {

	public String name;
	public String visible;
	private Location loc = new Location(0,0);
	
	public Pile (String name, Location loc){
		this.name = name;
		this.loc = loc;
	}

	public Location getLocation() {
		return loc;
	}
}
