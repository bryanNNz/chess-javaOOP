package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
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
		
		return matrix;
	}
	
}
