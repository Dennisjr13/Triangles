package triangles;

import triangles.model.Model;
import triangles.model.Node;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class Main {
	public static void main(String[] args) {
		Model model = new Model();
		
		TrianglePuzzle puzzle = new TrianglePuzzle();
		
		// TODO: create all nodes here
		puzzle.addNode(new Node(20), 5, 5);
		
		// TODO: set adjNodes here
		
		model.setPuzzle(puzzle);
		
		TrianglesApp trianglesApp = new TrianglesApp(model);
		trianglesApp.setVisible(true);
	}
}
