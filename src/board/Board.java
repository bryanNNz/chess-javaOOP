package board;

import board.exceptions.BoardException;

public class Board {
	private Integer rows;
	private Integer cols;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer cols) {
		if(rows < 1 || cols < 1) {
			throw new BoardException("Error: At least 1 column and 1 line to create the board");
		}
		this.rows = rows;
		this.cols = cols;
		pieces = new Piece[this.rows][this.cols];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getCols() {
		return cols;
	}

	public Piece piece(Integer row, Integer col) {
		if(!positionExists(row, col)) {
			throw new BoardException("Error: Non-existent position");
		}
		return pieces[row][col];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Non-existent position");
		}
		return pieces[position.getRow()][position.getCol()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a part in this position" + position);
		}
		pieces[position.getRow()][position.getCol()] = piece;
		piece.position = position; 
	}
	
	public boolean positionExists(Integer row, Integer col) {
		return row >= 0 && row < this.rows && col >= 0 && col < this.cols;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCol());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Non-existent position");
		}
		return piece(position) != null;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Error: Non-existent position");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		this.pieces[position.getRow()][position.getCol()] = null;
		return aux;
	}
}
