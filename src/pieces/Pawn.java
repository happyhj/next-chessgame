package pieces;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> positions = new ArrayList<Position>();		
		// 흰색일 경우 북쪽으로 한칸 이동가능
		if((super.color==Color.WHITE)&&(super.position.move(Direction.NORTH).isValid())) {
			positions.add(super.position.move(Direction.NORTH));
		}
		// 검색일 경우 남쪽으로 한칸 이동가능
		else if((super.color==Color.BLACK)&&(super.position.move(Direction.SOUTH).isValid())) {
			positions.add(super.position.move(Direction.SOUTH));			
		}
		return positions;
	}
}
