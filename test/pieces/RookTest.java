package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class RookTest extends TestCase {
	public void testGetPossibleMovesOfRook() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);		
		Rook rook = new Rook(Color.WHITE, position);		
		List<Position> rookPossibleMoves = rook.getPossibleMoves();		

		assertEquals(11, rookPossibleMoves.size());	
	}
}
