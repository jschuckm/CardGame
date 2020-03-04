package coms362.cards.fiftytwo;

import model.Player;

public class PickupPlayer implements Player {

	private int score = 0;
	private int playerNum;
	
	public PickupPlayer(int i) {
		this.playerNum = i;
	}

	public int addToScore(int amount) {
		return score += amount;
	}

	public int getPlayerNum() {
		return playerNum;
	}


}
