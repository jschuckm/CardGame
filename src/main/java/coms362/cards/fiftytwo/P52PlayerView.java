/**
 * 
 */
package coms362.cards.fiftytwo;

import java.io.IOException;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.View;
import coms362.cards.streams.Marshalls;
import coms362.cards.streams.RemoteTableGateway;

/**
 * @author Robert Ward
 *
 */
public class P52PlayerView implements View {

	private RemoteTableGateway remote;
	
	public P52PlayerView(int playerNum, RemoteTableGateway remote) {
		this.remote = remote;
	}
	
	public P52PlayerView(Player p){
		// TODO Auto-generated method stub		
	}

	public void apply(Move move) {
		move.apply(this);		
	}

	public void send(Marshalls event) throws IOException {
		remote.send(event);		
	}

}
