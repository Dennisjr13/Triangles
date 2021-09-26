package triangles.model;

import java.awt.Color;
import java.util.ArrayList;

public class Edge {
	public final Color color;
	public final ArrayList<Node> initialNodes;
	ArrayList<Node> currentNodes;

	public Edge (Color color, ArrayList<Node> nodes) {
		this.color = color;
		initialNodes = nodes;
		currentNodes = nodes;
	}
	
	public Color getColor() { return color; }
	public ArrayList<Node> getNodes() { return currentNodes; }
	public ArrayList<Node> getInitialNodes() { return initialNodes; }
	
	public void setNodes(ArrayList<Node> newNodes) {
		currentNodes = newNodes;
	}
}
