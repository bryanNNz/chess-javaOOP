package board;

public class Position {
	private Integer row;
	private Integer col;
	
	public Position() {

	}
	
	public Position(Integer row, Integer col) {
		this.row = row;
		this.col = col;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getCol() {
		return col;
	}
	

	public void setVlaues(Integer row, Integer col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public String toString() {
		return col + ", " + row;
	}
}