package chess;

import board.Position;
import chess.exceptions.ChessException;

public class ChessPosition {
	private Integer row;
	private char col;
		
	public ChessPosition(Integer row, char col) {
		if(col < 'a' || col > 'h' || row < 1 || row > 8) {
			throw new ChessException("Valid values ​​are a1 to b8");
		}
		this.row = row;
		this.col = col;
	}

	public Integer getRow() {
		return row;
	}

	public char getCol() {
		return col;
	}
	
	protected Position toPosition() {
		return new Position(8 - this.row, this.col - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition(8 - position.getRow() , (char)('a' - position.getCol()));
	}
	
	@Override
	public String toString() {
		return "" + this.col + this.row;
	}
}
