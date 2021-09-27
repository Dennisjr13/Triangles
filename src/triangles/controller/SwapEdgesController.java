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
			// 3 edge swap, special case (rotate clockwise)
			
			// first, identify the flat edge
			Edge flatEdge = null;
			for (Edge edge : edgesToSwap) {
				if (edge.getNodes().get(0).getY() == edge.getNodes().get(1).getY()) {
					// found the flat/parallel edge
					flatEdge = edge;
				}
			}
			edgesToSwap.remove(flatEdge);
			
			// next, identify middle Node ("tip") to determine triangle orientation
			Node middleNode;
			if (flatEdge.getNodes().contains(edgesToSwap.get(0).getNodes().get(0))) {
				middleNode = edgesToSwap.get(0).getNodes().get(1);
			} else {
				middleNode = edgesToSwap.get(0).getNodes().get(0);
			}
			
			// next, identify the left/right edges 
			// (the flat edge was already removed from edgesToSwap)
			Edge leftEdge;
			Edge rightEdge;
			if (edgesToSwap.get(0).getNodes().get(0).equals(middleNode)) {
				// oops, grabbed the middle node (which both slanted edges share),
				// use the other node
				if (edgesToSwap.get(0).getNodes().get(1).getX() < middleNode.getX()) {
					leftEdge = edgesToSwap.get(0);
					rightEdge = edgesToSwap.get(1);
				} else {
					leftEdge = edgesToSwap.get(1);
					rightEdge = edgesToSwap.get(0);
				}
			} else if (edgesToSwap.get(0).getNodes().get(0).getX() < middleNode.getX()) {
				leftEdge = edgesToSwap.get(0);
				rightEdge = edgesToSwap.get(1);
			} else {
				leftEdge = edgesToSwap.get(1);
				rightEdge = edgesToSwap.get(0);
			}

			// finally, we have all the edges and can determine orientation
			// (time to swap)
			Color leftEdgeColor = leftEdge.getColor();
			Color rightEdgeColor = rightEdge.getColor();
			Color flatEdgeColor = flatEdge.getColor();
			if (middleNode.getY() > flatEdge.getNodes().get(0).getY()) {
				// upward triangle
				flatEdge.setColor(leftEdgeColor);
				rightEdge.setColor(flatEdgeColor);
				leftEdge.setColor(rightEdgeColor);
			} else {
				// downward triangle
				rightEdge.setColor(leftEdgeColor);
				flatEdge.setColor(rightEdgeColor);
				leftEdge.setColor(flatEdgeColor);
			}
		} else {
			System.out.println("ERROR: Invalid state, " + edgesToSwap.size() + " selected.");
			return;
		}
		
		// after successful swap, unselect nodes
		for (Node node : puzzle.getNodes()) {
			node.setSelected(false);
		}
		
		model.setNumMoves(model.getNumMoves() + 1);
		model.setScore(model.calculateScore() - model.getNumMoves());
		
		app.getActualMovesLabel().setText("" + model.getNumMoves());
		app.getActualScoreLabel().setText("" + model.getScore());
		app.repaint();
	}
}
