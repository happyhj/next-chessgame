package pieces;

import java.util.List;

import pieces.Piece.Color;
import pieces.Piece.Type;
import junit.framework.TestCase;

public class EmptyTest extends TestCase {
	
	public void testGetPossibleMovesOfEmptyPiece() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);		
		Empty empty = new Empty(Color.WHITE, position);		
		List<Position> emptyPiecePossibleMoves = empty.getPossibleMoves();		
		assertEquals(0, emptyPiecePossibleMoves.size());	
	}
	
	
}
