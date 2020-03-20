package coms362.cards.fiftytwo;

import coms362.cards.abstractcomp.GameFactory;
import coms362.cards.abstractcomp.Player;
import coms362.cards.abstractcomp.Rules;
import coms362.cards.abstractcomp.Table;
import coms362.cards.abstractcomp.View;
import coms362.cards.streams.RemoteTableGateway;
import model.TableBase;

public class P52GameFactory implements GameFactory {

	@Override
	public Rules createRules() {
		return new PickupRules();
	}

	@Override
	public Table createTable() {
		return new TableBase();
	}

	@Override
	public View createView(PartyRole role, int num, RemoteTableGateway gw ) {
		return new P52PlayerView(num, gw);
	}

	@Override
	public Player createPlayer( PartyRole role, int num ) {
		return new PickupPlayer(num);
	}

}
