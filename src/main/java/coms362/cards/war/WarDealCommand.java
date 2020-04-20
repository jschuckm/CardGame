package coms362.cards.war;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.app.ViewFacade;
import coms362.cards.fiftytwo.DealButton;
import coms362.cards.fiftytwo.HideButtonRemote;
import events.remote.CreateRemote;
import events.remote.UpdateRemote;
import model.Card;
import model.Pile;

public class WarDealCommand implements Move {
	private Table table;
	private Player player;

	public WarDealCommand(Table table, Player player) {
		this.table = table;
		this.player = player;
	}

	public void apply(Table table) {
		// TODO Auto-generated method stub

	}

	public void apply(ViewFacade views) {

        try {
        	String remoteId = views.getRemoteId(DealButton.kSelector);
        	views.send(new HideButtonRemote(remoteId));
        	Pile p1 = table.getPile("Player 1 FaceDown");
        	if (p1 == null) {
        		return;
        	}
            for (Card c : p1.cards.values()) {
            	String outVal="";
            	views.send(new CreateRemote(c));
            	views.send(new UpdateRemote(c));
                System.out.println(outVal);
	        }
            Pile p2 = table.getPile("Player 2 FaceDown");
        	if (p2 == null) {
        		return;
        	}
            for (Card d : p2.cards.values()) {
            	String outVal="";
            	views.send(new CreateRemote(d));
            	views.send(new UpdateRemote(d));
                System.out.println(outVal);
	        }
        }catch (Exception e) {
	            e.printStackTrace();
        }
	}
}

