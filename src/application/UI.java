package application;

import chess.color.ChessPiece;

public class UI {
	public static void printBoard(ChessPiece[][] pieces) {
		for (int l = 0; l < pieces.length; l++) {
			System.out.print((8-l) + " ");
			
			for (int c = 0; c < pieces.length; c++) {
				printPiece(pieces[l][c]);
			}
			
			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}
	
	public static void printPiece(ChessPiece piece) {
		if(piece == null) {
			System.out.print("-");
		}else {
			System.out.print(piece);
		}
		
		System.out.print(" ");
	}
}
