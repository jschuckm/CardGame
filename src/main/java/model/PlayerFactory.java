package model;

import coms362.cards.abstractcomp.Player;

public interface PlayerFactory {

	Player createPlayer(Integer position, String socketId);

}
