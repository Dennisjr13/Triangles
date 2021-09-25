package triangles.model;

public class Node {
	public final int size;
	boolean isSelected;
	int x;
	int y;
	Node[] adjNodes;

	public Node(int size) {
		this.size = size;
	}
	
	public int getSize() { return size; }
	
	public boolean isSelected() { return isSelected; }
	public void setSelected(boolean flag) { isSelected = flag; }
	
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	
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
	
	public Node[] getAdjNodes() { return adjNodes; }
	public void setAdjNodes(Node[] nodes) { adjNodes = nodes; }
}
