package triangles.controller;

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
			ArrayList<Node> firstEdgeNodes = new ArrayList<Node>(edgesToSwap.get(0).getNodes());
			edgesToSwap.get(0).setNodes(edgesToSwap.get(1).getNodes());
			edgesToSwap.get(1).setNodes(firstEdgeNodes);
		} else if (edgesToSwap.size() == 3) {
			// TODO: 3 edge swap, special case (rotate clockwise)
			System.out.println("WARN: 3 edges special case, not implemented yet.");
			return;
		} else {
			System.out.println("ERROR: Invalid state, " + edgesToSwap.size() + " selected.");
			return;
		}

		app.repaint();
	}
}
