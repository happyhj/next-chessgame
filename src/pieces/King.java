package pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> positions = new ArrayList<Position>();
				
		Direction[] diagonals = Direction.diagonalDirection();	
		Direction[] linears = Direction.linearDirection();
		
		ArrayList<Direction> directions = new ArrayList<Direction>(Arrays.asList(diagonals));
		directions.addAll(Arrays.asList(linears));
		
		for (Direction direction : directions) {
			if(position.move(direction).isValid())
				positions.add(position.move(direction));
		}	
				
		return positions;	
	}
}

