package coms362.cards.fiftytwo;

import coms362.cards.abstractcomp.Move;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import events.remote.CreateRemote;
import events.remote.UpdateRemote;
import model.Card;
import model.Pile;

public class DealCommand implements Move {
	private Table table;
	private Player player;
			
	public DealCommand(Table table, Player player) {
		this.table = table;
		this.player = player;
	}

	public void apply(Table table) {
		// TODO Auto-generated method stub
		
	}
	
	public void apply(View view) {

        try {
        	Pile local = table.getPile("discardPile");
        	if (local == null) {
        		return;
        	}
            for (Card c : local.cards.values()) {
            	String outVal="";
            	view.send(new CreateRemote(c));
            	view.send(new UpdateRemote(c));
                System.out.println(outVal);	            
	        }
        }catch (Exception e) {
	            e.printStackTrace();
        }
	}
}

