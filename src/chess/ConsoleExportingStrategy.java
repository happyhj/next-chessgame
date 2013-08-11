package chess;

import java.util.List;

public class ConsoleExportingStrategy implements ExportingBoardStrategy {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	
	public String generateRank(List<Rank> ranks, int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}
	
	@Override
	public 	String generateBoard(List<Rank> ranks) {
		StringBuilder sb = new StringBuilder();
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(ranks,i-1) + NEW_LINE);
		}
		return sb.toString();
	}

}
