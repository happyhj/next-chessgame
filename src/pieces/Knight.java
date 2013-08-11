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

		if((super.position.move(Direction.NORTH).move(Direction.NORTHEAST).isValid())) {
			positions.add(super.position.move(Direction.NORTH).move(Direction.NORTHEAST));
		}
		if((super.position.move(Direction.NORTH).move(Direction.NORTHWEST).isValid())) {
			positions.add(super.position.move(Direction.NORTH).move(Direction.NORTHWEST));
		}
		if((super.position.move(Direction.SOUTH).move(Direction.SOUTHWEST).isValid())) {
			positions.add(super.position.move(Direction.SOUTH).move(Direction.SOUTHWEST));
		}
		if((super.position.move(Direction.SOUTH).move(Direction.SOUTHEAST).isValid())) {
			positions.add(super.position.move(Direction.SOUTH).move(Direction.SOUTHEAST));
		}
		if((super.position.move(Direction.WEST).move(Direction.NORTHWEST).isValid())) {
			positions.add(super.position.move(Direction.WEST).move(Direction.NORTHWEST));
		}
		if((super.position.move(Direction.WEST).move(Direction.SOUTHWEST).isValid())) {
			positions.add(super.position.move(Direction.WEST).move(Direction.SOUTHWEST));
		}
		if((super.position.move(Direction.EAST).move(Direction.NORTHEAST).isValid())) {
			positions.add(super.position.move(Direction.EAST).move(Direction.NORTHEAST));
		}
		if((super.position.move(Direction.EAST).move(Direction.SOUTHEAST).isValid())) {
			positions.add(super.position.move(Direction.EAST).move(Direction.SOUTHEAST));
		}
		
		return positions;
	}
}
