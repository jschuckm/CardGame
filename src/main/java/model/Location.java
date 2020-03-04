package model;

public class Location {
	
	int x = 0; 
	int y = 0; 
	
	public Location( ) {
		
	}

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y; 
	}

}
