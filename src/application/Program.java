package application;

import chess.color.ChessMatch;

public class Program {

	public static void main(String[] args) {
		ChessMatch cm = new ChessMatch();
		UI.printBoard(cm.getPiece());
	}

}
