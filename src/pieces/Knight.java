package pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> positions = new ArrayList<Position>();		
		Direction[] knightDirection = Direction.knightDirection();
		for(Direction direction:knightDirection){
			if((super.position.move(direction).isValid())) {
				positions.add(super.position.move(direction));
			}			
		}
		return positions;
	}
}
