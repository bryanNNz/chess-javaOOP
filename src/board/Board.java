package board;

public class Board {
	private Integer rows;
	private Integer cols;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer cols) {
		this.rows = rows;
		this.cols = cols;
		pieces = new Piece[this.rows][this.cols];
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getCols() {
		return cols;
	}

	public void setCols(Integer cols) {
		this.cols = cols;
	}
	
	public Piece piece(Integer row, Integer col) {
		return pieces[row][col];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getCol()];
	}
	
}
