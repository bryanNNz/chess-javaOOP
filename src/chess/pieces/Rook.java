package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getCols()];
		Position p = new Position(0,0);
		
		//cima
		p.setValues(position.getRow() - 1, position.getCol());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
			p.setRow(p.getRow() - 1);
		}		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//baixo
		p.setValues(position.getRow() + 1, position.getCol());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
			p.setRow(p.getRow() + 1);
		}

		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//esquerda
		p.setValues(position.getRow(), position.getCol() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
			p.setCol(p.getCol() - 1);
		}
		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}
		
		//direita
		p.setValues(position.getRow(), position.getCol() + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
			p.setCol(p.getCol() + 1);
		}
		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			matrix[p.getRow()][p.getCol()] = true;
		}

		
		return matrix;
	}
	
	
}
