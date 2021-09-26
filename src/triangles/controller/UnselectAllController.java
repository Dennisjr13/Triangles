package triangles.controller;

import triangles.model.Model;
import triangles.model.Node;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class UnselectAllController {
	
	TrianglesApp app;
	Model model;
	
	public UnselectAllController(Model model, TrianglesApp app) {
		this.model = model;
		this.app = app;
	}
	
	public void process() {
		System.out.println("User clicked Unselect All");
		TrianglePuzzle puzzle = model.getPuzzle();
		
		for (Node node : puzzle.getNodes()) {
			node.setSelected(false);
		}
		
		app.repaint();
	}
}
