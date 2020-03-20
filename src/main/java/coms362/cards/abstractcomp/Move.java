package coms362.cards.abstractcomp;

public interface Move {
	public void apply(Table table);
	public void apply(View view);
	default public boolean isMatchEnd(){
		return false;
	}
}
