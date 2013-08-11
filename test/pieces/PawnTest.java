package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	public void testGetPossibleMovesOfPawn() throws Exception {
		int startX = 4;
		int startY = 5;
		Position position = new Position(startX, startY);		
		Pawn wPawn = new Pawn(Color.WHITE, position);		
		Pawn bPawn = new Pawn(Color.BLACK, position);		

		List<Position> wPawnPossibleMoves = wPawn.getPossibleMoves();		
		
		assertEquals(1, wPawnPossibleMoves.size());	
		assertEquals(position.move(Direction.NORTH), wPawnPossibleMoves.get(0));	

		List<Position> bPawnPossibleMoves = bPawn.getPossibleMoves();		
		
		assertEquals(1, bPawnPossibleMoves.size());	
		assertEquals(position.move(Direction.SOUTH), bPawnPossibleMoves.get(0));	
	}
}
