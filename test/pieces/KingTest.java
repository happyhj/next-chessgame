package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class KingTest extends TestCase {
	public void testGetPossibleMovesOfKing() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);		
		King king = new King(Color.WHITE, position);		
		List<Position> kingPossibleMoves = king.getPossibleMoves();		

		assertEquals(8, kingPossibleMoves.size());	
	}
}
