package triangles.controller;

import triangles.model.Model;
import triangles.model.Node;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class SwapEdgesController {
	
	TrianglesApp app;
	Model model;
	
	public SwapEdgesController(Model model, TrianglesApp app) {
		this.model = model;
		this.app = app;
	}
	
	public void process() {
		System.out.println("User clicked Swap Edges.");
		TrianglePuzzle puzzle = model.getPuzzle();
		
		if (model.trySwap()) {
			// swap successful
			model.setNumMoves(model.getNumMoves() + 1);
			model.setScore(model.calculateScore() - model.getNumMoves());
			
			app.getActualMovesLabel().setText("" + model.getNumMoves());
			app.getActualScoreLabel().setText("" + model.getScore());
			
			// unselect nodes
			for (Node node : puzzle.getNodes()) {
				node.setSelected(false);
			}
			
			app.repaint();
		}
	}
}
