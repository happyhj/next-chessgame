package pieces;

import java.util.List;


public class Bishop extends Piece {
	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController controller = new PositionController(super.position);
		return controller.findsDiagonalPositionAll();	
	}
}