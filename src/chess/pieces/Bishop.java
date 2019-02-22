package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{
	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getCols()];
		Position p = new Position(0,0);
		
		//noroeste
		p.setValues(position.getRow() - 1, position.getCol() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
			p.setValues(p.getRow() - 1, p.getCol() - 1);
		}		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//nordeste
		p.setValues(position.getRow() - 1, position.getCol() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
			p.setValues(p.getRow() - 1, p.getCol() + 1);
		}

		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//sudeste
		p.setValues(position.getRow() + 1, position.getCol() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
			p.setValues(p.getRow() + 1, p.getCol() + 1);
		}
		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//sudoeste
		p.setValues(position.getRow() + 1, position.getCol() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
			p.setValues(p.getRow() + 1, p.getCol() - 1);
		}
		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}

		
		return matrix;
	}
	
	@Override
	public String toString() {
		return "B";
	}
}
