package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.exceptions.ChessException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch cm = new ChessMatch();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printMatch(cm);
				System.out.println();
				System.out.println("SOURCE: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = cm.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(cm.getPiece(), possibleMoves);
				
				System.out.println();
				System.out.println("TARGET: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = cm.performChessMove(source, target);
			}
			catch(ChessException err) {
				System.out.println(err.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException err) {
				System.out.println(err.getMessage());
				sc.nextLine();
			}
		}
		
	}

}
