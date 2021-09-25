package triangles.model;

public class Model {
	TrianglePuzzle puzzle;
	boolean gameOver;
	int numMoves = 0;
	int score = 0;
	
	/**
	 *         0() 	
	 *      1()   2()
	 *    3()  4()  5()
	 *  6()  7()  8()  9()
	 * 
	 */
	public Model() {
		
	}
	
	public void setPuzzle(TrianglePuzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	public TrianglePuzzle getPuzzle() {
		return puzzle;
	}
	
	public int getNumMoves() { return numMoves; }
	
	public int getScore() { return score; }
	
	public boolean isGameOver() { return gameOver; }
	public void setGameOver(boolean flag) { gameOver = flag; }
}
