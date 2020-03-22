package model;

public class Game {
	
	boolean isSelected = false;
	String selected = ""; 

	public boolean isSelected() {
		return isSelected;
	}
	
	public void setSelected(String selector){
		selected = selector;
		isSelected = true;
	}

	public String getSelection() {
		return selected;
	}

	public boolean partiesReady() {
		// TODO Auto-generated method stub
		return false;
	}

}
