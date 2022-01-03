package triangles.model;

import java.util.ArrayList;

public class Node {
	public final int size;
	public final int x;
	public final int y;
	boolean isSelected;
	ArrayList<Node> adjNodes = new ArrayList<Node>();

	public Node(int size, int x, int y) {
		this.size = size;
		this.x = x;
		this.y = y;
	}
	
	public int getSize() { return size; }
	
	public boolean isSelected() { return isSelected; }
	public void setSelected(boolean flag) { isSelected = flag; }
	
	public int getX() { return x; }
	public int getY() { return y; }
	public Coordinate getLocation () { return new Coordinate(x, y); }
	
	public boolean contains(Coordinate coordinate) {
		if (coordinate.x >= x && coordinate.x < x + size && 
				coordinate.y >= y && coordinate.y < y + size) {
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Node> getAdjNodes() { return adjNodes; }
	public void addAdjNode(Node node) { adjNodes.add(node); }
}
