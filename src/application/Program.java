package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch cm = new ChessMatch();
		
		while(true) {
			UI.printBoard(cm.getPiece());
			System.out.println();
			System.out.println("SOURCE: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.println("TARGET: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = cm.performChessMove(source, target);
		}
		
	}

}
