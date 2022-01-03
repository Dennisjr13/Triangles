package triangles.model;

import junit.framework.TestCase;

public class TestCoordinate extends TestCase {
	
	public void testToString() {
		Coordinate coord1 = new Coordinate(1, 2);
		assertEquals("(1,2)", coord1.toString());
	}
	
	public void testEquals() {
		Coordinate coord1 = new Coordinate(1, 2);
		Coordinate coord2 = new Coordinate(3, 4);
		Coordinate coord3 = new Coordinate(3, 4);
		
		assertFalse(coord1.equals(coord2));
		assertTrue(coord2.equals(coord3));
	}
	
}
