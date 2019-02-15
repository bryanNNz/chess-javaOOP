package chess;

public class ChessPosition {
	private Integer row;
	private char col;
	
	public ChessPosition() {

	}
	
	public ChessPosition(Integer row, char col) {
		this.row = row;
		this.col = col;
	}

	public Integer getRow() {
		return row;
	}

	public char getCol() {
		return col;
	}
		
}
