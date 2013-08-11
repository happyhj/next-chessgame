package chess;

import java.util.List;

public interface ExportingBoardStrategy {
	String generateRank(List<Rank> ranks,int rankIndex);
	String generateBoard(List<Rank> ranks);
}