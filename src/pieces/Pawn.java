package pieces;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Piece {
	public final static int whiteStartingPosY = 1;
	public final static int BlackStartingPosY = 6;

	
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> positions = new ArrayList<Position>();		
		// 흰색일 경우 북쪽으로 한칸 이동가능
		if((super.color==Color.WHITE)&&(super.position.move(Direction.NORTH).isValid())) {
			positions.add(super.position.move(Direction.NORTH));
			// 시작위치일 경우 두칸이동가능
			if(super.position.getY()==whiteStartingPosY){
				positions.add(super.position.move(Direction.NORTH).move(Direction.NORTH));	
			}
		}
		// 검색일 경우 남쪽으로 한칸 이동가능
		else if((super.color==Color.BLACK)&&(super.position.move(Direction.SOUTH).isValid())) {
			positions.add(super.position.move(Direction.SOUTH));
			// 시작위치일 경우 두칸이동가능
			if(super.position.getY()==BlackStartingPosY){
				positions.add(super.position.move(Direction.SOUTH).move(Direction.SOUTH));	
			}
		}
		return positions;
	}
}
