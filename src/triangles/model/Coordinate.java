package triangles.model;

public class Coordinate {
	public final int x;
	public final int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString () {
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) { return false; }
		
		if (o instanceof Coordinate) {
			Coordinate other = (Coordinate) o;
			return x == other.x && y == other.y;
		}
		
		return false;
	}
}
