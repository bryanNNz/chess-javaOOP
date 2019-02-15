package chess.color;

import board.Board;

public class ChessMatch {
	 private Board board;
	 
	 public ChessMatch() {
		 board = new Board(8,8);
	 }
	 
	public ChessPiece[][] getPiece() {
		ChessPiece[][] matt = new ChessPiece[board.getRows()][board.getCols()];
		for(int l = 0; l < board.getRows(); l++) {
			for (int c = 0; c < board.getCols(); c++) {
				matt[l][c] = (ChessPiece) board.piece(l,c);
			}
		}
		
		return matt;
	}
	 
}
