package triangles.model;

import java.awt.Color;
import java.util.ArrayList;

public class Edge {
	public final ArrayList<Node> nodes;
	public final Color initialColor;
	Color color;

	public Edge (Color color, ArrayList<Node> nodes) {
		initialColor = color;
		this.color = color;
		this.nodes = nodes;
	}
	
	public ArrayList<Node> getNodes() { return nodes; }
	public Color getInitialColor() { return initialColor; }
	public Color getColor() { return color; }
	
	public void setColor(Color color) {
		this.color = color;
	}
}
