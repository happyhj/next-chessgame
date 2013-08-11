package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class BishopTest extends TestCase {
	public void testGetPossibleMovesOfBishop() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);		
		Bishop bishop = new Bishop(Color.WHITE, position);		
		List<Position> bishopPossibleMoves = bishop.getPossibleMoves();		

		assertEquals(11, bishopPossibleMoves.size());	
	}
}
