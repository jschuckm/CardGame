package events.remote;

import coms362.cards.streams.Marshalls;

public class SetBottomPlayerTextRemote implements Marshalls {
	
	public String player="Host";
	
	public SetBottomPlayerTextRemote(String name) {
		player = name;
	}

	public String marshall() {
		return String.format("$('#current-player').text('%s')", player);
	}

	public String stringify() {
		return "SetBottomPlayerText "+player;
	}

}
