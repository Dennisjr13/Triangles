package triangles.model;

import java.util.ArrayList;

public class TrianglePuzzle {
	
	ArrayList<Edge> edges = new ArrayList<>();
	ArrayList<Edge> originalEdges = new ArrayList<>();
	
	ArrayList<Node> nodes = new ArrayList<>();
	
	public void addNode(Node node, int x, int y) {
		// TODO: check overlapping
		node.setX(x);
		node.setY(y);
		nodes.add(node);
	}
	
	public void addEdge(Edge edge) {
		// TODO: check overlapping
		edges.add(edge);
		originalEdges.add(edge);
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
	public void reset() {
		edges.clear();
		for (Edge edge : originalEdges) { edges.add(edge); }
		for (Node node : nodes) { node.setSelected(false); }
	}

}
