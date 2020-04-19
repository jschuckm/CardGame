package coms362.cards.fiftytwo.sp;

import coms362.cards.abstractcomp.Rules;
import coms362.cards.fiftytwo.P52GameFactory;
import coms362.cards.fiftytwo.PickupRules;

public class SP_GameFactory extends P52GameFactory {
	@Override
	public Rules createRules() {
		return new SP_PickupRules();
	}
}
