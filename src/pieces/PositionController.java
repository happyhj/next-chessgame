package pieces;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
	private Position position;;

	public PositionController(Position position) {
		this.position = position;
	}

	public List<Position> findsLinearPositionAll() {
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}
	
	public List<Position> findsDiagonalPositionAll() {
		Direction[] diagonals = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : diagonals) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}
	
	public List<Position> findsKingPositionAll() {
		List<Position> positions = new ArrayList<Position>();
		
		Direction[] diagonals = Direction.diagonalDirection();		
		for (Direction direction : diagonals) {
			if(position.move(direction).isValid())
				positions.add(position.move(direction));
		}
	
		Direction[] linears = Direction.linearDirection();
		for (Direction direction : linears) {
			if(position.move(direction).isValid())
				positions.add(position.move(direction));
		}		
		
		return positions;		
	}
	
}
