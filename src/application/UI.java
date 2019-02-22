package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPiece());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("TURN: " + chessMatch.getTurn());
		if(!chessMatch.getCheck()) {
			System.out.println("WAITING PLAYER: " + chessMatch.getCurrentPlayer());
			
			if(chessMatch.getCheck()) {
				System.out.println("CHECK!");
			}
		}else {
			System.out.println("CHECKMATE!");
			System.out.println("WINNER: " + chessMatch.getCurrentPlayer());
		}

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
	
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.println("CAPTURED PIECES");
		System.out.print("WHITE: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("BLACK: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray()));
		System.out.print(ANSI_RESET);
	}
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
