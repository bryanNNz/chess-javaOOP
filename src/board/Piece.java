package board;

public abstract class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		this.position = null;
	}
	
	protected Board getBoard() {
		return this.board;
	}
	
	public abstract boolean[][] possibleMoves(); 
	
	public boolean possibleMove(Position position) {
		//rook methods
		return possibleMoves()[position.getRow()][position.getCol()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] matrix = possibleMoves();
		
		for (int l = 0; l < matrix.length; l++) {
			for (int c = 0; c < matrix.length; c++) {
				if(matrix[l][c]) {
					return true;
				}
			}
		}
		return false;
	}
}
