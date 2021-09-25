package triangles;

import triangles.model.Model;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class Main {
	public static void main(String[] args) {
		Model model = new Model();
		
		TrianglePuzzle puzzle = new TrianglePuzzle();
		model.setPuzzle(puzzle);
		
		TrianglesApp trianglesApp = new TrianglesApp(model);
		trianglesApp.setVisible(true);
	}
}
