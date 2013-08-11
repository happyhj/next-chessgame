package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Empty;
import pieces.PieceOperations;
import pieces.Piece.Color;
import pieces.Position;

public class Board {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;

	private ExportingBoardStrategy exportingStrategy = new ConsoleExportingStrategy();

	void setExportingBoardStrategy(ExportingBoardStrategy exportingStrategy) {
		this.exportingStrategy = exportingStrategy;
	}
	
	List<Rank> ranks = new ArrayList<Rank>();
	
	Board() {
	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	PieceOperations findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	PieceOperations findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {
		PieceOperations targetPiece = findPiece(source);
		boolean isColored = !targetPiece.equals(new Empty(Color.NOCOLOR,source));
		boolean isVaildPosition = target.isValid();
		List<Position> possibleMoves = new ArrayList<Position>();	
		possibleMoves = targetPiece.getPossibleMoves();
		boolean isVaildDirection = possibleMoves.contains(target);

		if(isColored&&isVaildPosition&&isVaildDirection){
			boolean isNotSameTeam = !targetPiece.isSameTeam(findPiece(target));
			if(isNotSameTeam) {
				PieceOperations sourcePiece = targetPiece.leave();
				
				Rank sourceRank = ranks.get(source.getY());
				sourceRank.move(sourcePiece, source);
				
				Rank targetRank = ranks.get(target.getY());
				targetRank.move(targetPiece, target);
			}
		}
	}
	
	public String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}	
	
	public String generateBoard(){
		return this.exportingStrategy.generateBoard(ranks);
	}
}
