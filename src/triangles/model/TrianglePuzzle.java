package triangles.model;

import java.util.ArrayList;

public class TrianglePuzzle {
	
	ArrayList<Edge> edges = new ArrayList<>();
	ArrayList<Edge> originalEdges = new ArrayList<>();
	
	ArrayList<Node> nodes = new ArrayList<>();
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void addEdge(Edge edge) {
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
