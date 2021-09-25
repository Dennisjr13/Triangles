package triangles.model;

public class Model {
	TrianglePuzzle puzzle;
	int numMoves = 0;
	
	public Model() {
		
	}
	
	public void setPuzzle(TrianglePuzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	public TrianglePuzzle getPuzzle() {
		return puzzle;
	}
}
