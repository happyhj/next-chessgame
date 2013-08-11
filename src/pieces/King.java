package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> positions = new ArrayList<Position>();
		PositionController controller = new PositionController(super.position);
		positions.addAll(controller.findsKingPositionAll());
		return positions;	
	}
}

