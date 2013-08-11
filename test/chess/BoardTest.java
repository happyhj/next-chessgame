package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Position;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + Board.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + Board.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		System.out.println(board.generateBoard());
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Piece sourcePiece = (Piece) board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}
	
	public void testNoMoveForEmptyPiece() throws Exception {
		board.initialize();
		Position source = new Position("a3");		
		Position target = new Position("a2");
		
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));		
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));		
		board.movePiece(source, target);
		// 빈 말을 움직이게 되면 move 후 target 위치가 empty가 되는데 이를 방지하기 때문에 Pawn이 그냥 존재한다.		
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));		
	}
	public void testNoMoveToInvalidPosition() throws Exception {
		board.initialize();
		Position source = new Position(0,6);
		Position target = new Position(0,8);
		
		assertEquals(new Pawn(Color.BLACK, source), board.findPiece(source));		
		board.movePiece(source, target);
		// 보드판 좌표 바깥으로 나갈려고 하면 이동을 방지한다.
		assertEquals(new Pawn(Color.BLACK, source), board.findPiece(source));		
	}
	public void testNoMoveToOurTeam() throws Exception {
		board.initialize();
		Position source = new Position(0,6);
		Position target = new Position(0,7);
		
		assertEquals(new Pawn(Color.BLACK, source), board.findPiece(source));		
		board.movePiece(source, target);
		// 아군을 잡으려고 하면 이동을 방지한다.
		assertEquals(new Pawn(Color.BLACK, source), board.findPiece(source));		
	}
	public void testNoMoveToNoneTheirDirection() throws Exception {
		board.initialize();
		Position source = new Position(0,1);
		Position target = new Position(0,4);
		
		assertEquals(new Pawn(Color.WHITE, source), board.findPiece(source));		
		board.movePiece(source, target);
		// 말의 종류에 맞지않은 이동을 하면 이동을 방지한다.
		assertEquals(new Pawn(Color.WHITE, source), board.findPiece(source));		
		assertEquals(new Empty(Color.NOCOLOR, target), board.findPiece(target));		

	}
}
