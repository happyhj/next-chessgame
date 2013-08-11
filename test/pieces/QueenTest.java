package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class QueenTest extends TestCase {
	public void testGetPossibleMovesOfQueen() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);		
		Queen queen = new Queen(Color.WHITE, position);		
		List<Position> queenPossibleMoves = queen.getPossibleMoves();		

		assertEquals(25, queenPossibleMoves.size());	
	}
}
