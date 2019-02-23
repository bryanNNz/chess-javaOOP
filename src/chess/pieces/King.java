package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getCols()];
		Position p = new Position(0,0);
		
		//cima
		p.setValues(position.getRow() - 1, position.getCol());
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//baixo
		p.setValues(position.getRow() + 1, position.getCol());
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//esquerda
		p.setValues(position.getRow(), position.getCol() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//direita
		p.setValues(position.getRow(), position.getCol() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//noroeste 
		p.setValues(position.getRow() - 1, position.getCol() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//nordeste
		p.setValues(position.getRow() - 1, position.getCol() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//sudoeste 
		p.setValues(position.getRow() + 1, position.getCol() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//sudeste
		p.setValues(position.getRow() + 1, position.getCol() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			//castling king side
			Position p_aux1 = new Position(position.getRow(), position.getCol() + 3);
			if(testRookCastling(p_aux1)) {
				Position p1 = new Position(position.getRow(), position.getCol() + 1);
				Position p2 = new Position(position.getRow(), position.getCol() + 2);
				
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					matrix[position.getRow()][position.getCol() + 2] = true; 
				}
			}
			//castling queen side
			Position p_aux2 = new Position(position.getRow(), position.getCol() - 4);
			if(testRookCastling(p_aux2)) {
				Position p1 = new Position(position.getRow(), position.getCol() - 1);
				Position p2 = new Position(position.getRow(), position.getCol() - 2);
				Position p3 = new Position(position.getRow(), position.getCol() - 3);
				
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					matrix[position.getRow()][position.getCol() - 2] = true; 
				}
			}
		}
		
		return matrix;
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	
	@Override
	public String toString() {
		return "K";
	}
}
