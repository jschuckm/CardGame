package coms362.cards.abstractcomp;

import java.io.IOException;

import coms362.cards.streams.Marshalls;

public interface View {

	void apply(Move move);

	void send(Marshalls event) throws IOException;

}
