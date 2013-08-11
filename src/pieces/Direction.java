package pieces;

public enum Direction {
	NORTH(0, 1),
	NORTHEAST(1, 1),
	EAST(1, 0),
	SOUTHEAST(1, -1),
	SOUTH(0, -1),
	SOUTHWEST(-1, -1),
	WEST(-1, 0),
	NORTHWEST(-1, 1),
	NNW(-1, 2),
	NNE(1, 2),
	SSW(-1, -2),
	SSE(1, -2),
	EEN(2, 1),
	EES(2, -1),
	WWN(-2, 1),
	WWS(-2, -1);

	private int xDegree;
	private int yDegree;

	private Direction(int xDegree, int yDegree) {
		this.xDegree = xDegree;
		this.yDegree = yDegree;
	}

	public int getXDegree() {
		return xDegree;
	}

	public int getYDegree() {
		return yDegree;
	}
	
	public static Direction[] linearDirection() {
		return new Direction[] { NORTH, EAST, SOUTH, WEST };
	}

	public static Direction[] knightDirection() {
		return new Direction[] { NNW, NNE, SSW, SSE, EEN, EES, WWN, WWS };
	}
	
	public static Direction[] diagonalDirection() {
		return new Direction[] { NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST };
	}
}
