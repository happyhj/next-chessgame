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
	
	public void testGetPossibleMovesOfPawnAtStartingPoint() throws Exception {
		int startX = 4;
		int startY1 = 6;
		int startY2 = 1;

		Position position1 = new Position(startX, startY1);		
		Position position2 = new Position(startX, startY2);		

		Pawn wPawn1 = new Pawn(Color.WHITE, position2);		
		Pawn wPawn2 = new Pawn(Color.WHITE, position1);		

		Pawn bPawn1 = new Pawn(Color.BLACK, position1);		
		Pawn bPawn2 = new Pawn(Color.BLACK, position2);		

		List<Position> wPawnPossibleMoves1 = wPawn1.getPossibleMoves();		
		List<Position> wPawnPossibleMoves2 = wPawn2.getPossibleMoves();		
		
		assertEquals(2, wPawnPossibleMoves1.size());	
		assertEquals(position2.move(Direction.NORTH).move(Direction.NORTH), wPawnPossibleMoves1.get(1));	
		assertEquals(1, wPawnPossibleMoves2.size());	
		assertEquals(position1.move(Direction.NORTH), wPawnPossibleMoves2.get(0));	

		List<Position> bPawnPossibleMoves1 = bPawn1.getPossibleMoves();		
		List<Position> bPawnPossibleMoves2 = bPawn2.getPossibleMoves();		
		
		assertEquals(2, bPawnPossibleMoves1.size());	
		assertEquals(position1.move(Direction.SOUTH).move(Direction.SOUTH), bPawnPossibleMoves1.get(1));	
		assertEquals(1, bPawnPossibleMoves2.size());	
		assertEquals(position2.move(Direction.SOUTH), bPawnPossibleMoves2.get(0));			
	}
}
