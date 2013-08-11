package pieces;

import java.util.List;

public interface PieceOperations {	

	public char getSymbol();
	public Piece leave();
	public Piece move(Position target);
	public boolean isSameTeam(Object obj);
	public abstract List<Position> getPossibleMoves();
	
	public int hashCode();
	public boolean equals(Object obj);
	public String toString();
}
