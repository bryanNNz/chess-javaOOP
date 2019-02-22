package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{
	public Knight(Board board, Color color) {
		super(board, color);
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getCols()];
		Position p = new Position(0,0);
		
		p.setValues(position.getRow() - 1, position.getCol() - 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		p.setValues(position.getRow() - 2, position.getCol() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		p.setValues(position.getRow() - 2, position.getCol() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getCol() + 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		p.setValues(position.getRow() + 2, position.getCol() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		

		p.setValues(position.getRow() + 2, position.getCol() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		

		p.setValues(position.getRow() + 2, position.getCol() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getCol() - 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		return matrix;
	}
	
	@Override
	public String toString() {
		return "N";
	}

}
