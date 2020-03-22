package coms362.cards.app;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coms362.cards.abstractcomp.View;
import coms362.cards.abstractcomp.ViewFactory;
import coms362.cards.fiftytwo.PartyRole;
import coms362.cards.streams.Marshalls;
import coms362.cards.streams.RemoteTableGateway;

public class ViewFacade {
	
	private ViewFactory factory; 
	private List<View> views = new ArrayList<View>();

	public ViewFacade(ViewFactory factory) {
		this.factory = factory;
	}

	public View createView(PartyRole role, Integer pos, String socketId, RemoteTableGateway gw) {
		// TODO Auto-generated method stub
		if (role == PartyRole.player) {
			View v = factory.createView(role, pos, socketId, gw);
			views.add(v);
			return v;
		}
		// todo: define a view for the host and other roles. 
		return null; 
	}

	public View getDefaultView() {
		return views.get(0);
	}

	public void send(Marshalls cmd) {
		Iterator<View> iter = views.iterator();
		while (iter.hasNext()) {
			View next = iter.next();
			try {
				next.send(cmd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}		
	}

	public void add(View view) {
		views.add(view);		
	}

	
}
