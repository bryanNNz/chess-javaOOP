package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char col = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(row, col);
		}
		catch(RuntimeException err) {
			throw new InputMismatchException("Valid values ​​are a1 to b8");
		}
	}
	
	public static void printMatch(ChessMatch chessMatch) {
		printBoard(chessMatch.getPiece());
		System.out.println();
		System.out.println("TURN: " + chessMatch.getTurn());
		System.out.println("WAITING PLAYER: " + chessMatch.getCurrentPlayer());
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		for (int l = 0; l < pieces.length; l++) {
			System.out.print((8 - l) + " ");

			for (int c = 0; c < pieces.length; c++) {
				printPiece(pieces[l][c], false);
			}

			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int l = 0; l < pieces.length; l++) {
			System.out.print((8 - l) + " ");

			for (int c = 0; c < pieces.length; c++) {
				printPiece(pieces[l][c], possibleMoves[l][c]);
			}

			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}


	public static void printPiece(ChessPiece piece, boolean background) {
		if(background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (piece == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if(piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + piece + ANSI_RESET);				
			}else {
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET);	
			}
		}

		System.out.print(" ");
	}
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
