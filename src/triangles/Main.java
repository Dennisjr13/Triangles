package triangles;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import triangles.controller.ExitController;
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
		
		model.createNodes(trianglesApp.getPuzzlePanel().getSize());
		model.createEdges();
		
		trianglesApp.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(trianglesApp).exit();
			}
		});
	}
}
