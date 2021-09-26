package triangles.controller;

import java.awt.Color;
import java.util.ArrayList;

import triangles.model.Edge;
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
		
		ArrayList<Node> nodesSelected = new ArrayList<Node>();
		for (Node node : puzzle.getNodes()) {
			if (node.isSelected()) {
				nodesSelected.add(node);
			}
		}
		
		if (nodesSelected.size() != 3) {
			System.out.println("ERROR: User selected " + nodesSelected.size() + 
					" nodes, must be exactly 3.");
			return;
		}
		
		ArrayList<Edge> edgesToSwap = new ArrayList<Edge>();
		for (Edge edge : puzzle.getEdges()) {
			if (nodesSelected.containsAll(edge.getNodes())) {
				edgesToSwap.add(edge);
			}
		}
		
		if (edgesToSwap.size() == 2) {
			// 2 edge swap
			Color firstEdgeColor = edgesToSwap.get(0).getColor();
			edgesToSwap.get(0).setColor(edgesToSwap.get(1).getColor());
			edgesToSwap.get(1).setColor(firstEdgeColor);
		} else if (edgesToSwap.size() == 3) {
			// TODO: 3 edge swap, special case (rotate clockwise)
			System.out.println("WARN: 3 edges special case, not implemented yet.");
			
			
			// TODO: calculate rightside up triangle, else upsidedown triangle
			return;
		} else {
			System.out.println("ERROR: Invalid state, " + edgesToSwap.size() + " selected.");
			return;
		}
		
		model.setNumMoves(model.getNumMoves() + 1);
		// TODO: calculate score
		
		app.getActualMovesLabel().setText("" + model.getNumMoves());
		app.getActualScoreLabel().setText("" + model.getScore());
		app.repaint();
	}
}
