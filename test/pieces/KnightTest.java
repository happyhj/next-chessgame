package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class KnightTest extends TestCase {
	public void testGetPossibleMovesOfKnight() throws Exception {
		int startX = 3;
		int startY = 4;
		Position position = new Position(startX, startY);		
		Knight knight = new Knight(Color.WHITE, position);		
		List<Position> knightPossibleMoves = knight.getPossibleMoves();		

		assertEquals(8, knightPossibleMoves.size());
		
		int startX2 = 0;
		int startY2 = 0;
		Position position2 = new Position(startX2, startY2);		
		Knight knight2 = new Knight(Color.WHITE, position2);		
		List<Position> knightPossibleMoves2 = knight2.getPossibleMoves();		

		assertEquals(2, knightPossibleMoves2.size());
	}
}
