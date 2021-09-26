package triangles.controller;

import triangles.model.Edge;
import triangles.model.Model;
import triangles.model.Node;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class ResetController {
	
	TrianglesApp app;
	Model model;
	
	public ResetController(Model model, TrianglesApp app) {
		this.model = model;
		this.app = app;
	}
	
	public void process() {
		System.out.println("User clicked Reset");
		TrianglePuzzle puzzle = model.getPuzzle();
		
		for (Node node : puzzle.getNodes()) {
			node.setSelected(false);
		}
		
		for (Edge edge : puzzle.getEdges()) {
			edge.setColor(edge.getInitialColor());
		}
		
		model.setNumMoves(0);
		model.setScore(0);
		
		app.getActualMovesLabel().setText("" + model.getNumMoves());
		app.getActualScoreLabel().setText("" + model.getScore());
		app.repaint();
	}
}
