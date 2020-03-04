package coms362.cards.fiftytwo;

import model.Table;

public interface Move {
	public void apply(Table table);
	public void apply(View view);
}
