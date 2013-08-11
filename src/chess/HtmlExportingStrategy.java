package chess;

import java.util.List;

public class HtmlExportingStrategy implements ExportingBoardStrategy {

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
		int positionCount = 0;
		String color;
		sb.append("<html><head><meta charset='utf-8'/><title>NEXT CHESSGAME</title>");
		sb.append("<style>div{position: relative;display:inline-block;width: 50px;height: 50px;}");
		sb.append("div.black {background-color: #848484;}div.white {background-color: #e3e3e3;}");
		sb.append("div>h1 {position: absolute;top:-14px;left:14px;font-size: 32px;font-family: sans-serif;}");
		sb.append("div>h1.black {text-shadow: 1px 1px 4px white;color:black;}");
		sb.append("div>h1.white {text-shadow: 1px 1px 4px black;color:white;}</style></head><body>");

		for (int i = ROW_SIZE; i > 0; i--) {
			String aRank = generateRank(ranks,i-1);
			for(int j = 0;j<ROW_SIZE;j++){
				positionCount++;
				if(i%2==0){
					if(positionCount%2 == 1) color = "white";
					else color = "black";
				} else {
					if(positionCount%2 == 1) color = "black";
					else color = "white";					
				}
				sb.append("<div class='"+color+"'>");
				// 말이 흑색일 경우
				if(Character.isUpperCase(aRank.charAt(j))){
					sb.append("<h1 class='black'>");
					sb.append(aRank.charAt(j));
					sb.append("</h1></div>");
				} 
				// 말이 백색일 경우
				else if(Character.isLowerCase(aRank.charAt(j))) {
					sb.append("<h1 class='white'>");
					sb.append(Character.toUpperCase(aRank.charAt(j)));
					sb.append("</h1></div>");
				} else {
					sb.append("</div>");
				}
				if(positionCount%8 == 0) sb.append("<br/>");

			}
		}
		
		sb.append("</body></html>");

		return sb.toString();
	}
}
