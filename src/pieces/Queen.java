package pieces;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController controller = new PositionController(super.position);
		List<Position> positions = new ArrayList<Position>();
		
		positions.addAll(controller.findsLinearPositionAll());
		positions.addAll(controller.findsDiagonalPositionAll());

		return positions;			

	}
}
