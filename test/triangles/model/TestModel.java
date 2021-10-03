package triangles.model;

import java.awt.Dimension;

import junit.framework.TestCase;

public class TestModel extends TestCase {
	
	public void testPuzzle() {
		Model model = new Model();
		assertNull (model.getPuzzle());

		model.setPuzzle(new TrianglePuzzle());
		assertNotNull (model.getPuzzle());
	}
	
	public void testNumMoves() {
		Model model = new Model();
		assertEquals(0, model.getNumMoves());

		model.setNumMoves(1);
		assertEquals(1, model.getNumMoves());
	}
	
	public void testScore() {
		Model model = new Model();
		assertEquals(0, model.getScore());

		model.setScore(1);
		assertEquals(1, model.getScore());
	}
	
	public void testIsGameOver() {
		Model model = new Model();
		assertFalse(model.isGameOver());

		model.setGameOver(true);
		assertTrue(model.isGameOver());
	}
	
	public void testCreateNodes() {
		Model model = new Model();
		model.setPuzzle(new TrianglePuzzle());
		assertEquals(0, model.getPuzzle().getNodes().size());

		model.createNodes(new Dimension(800, 800));
		assertEquals(10, model.getPuzzle().getNodes().size());
	}

	public void testCreateEdges() {
		Model model = new Model();
		model.setPuzzle(new TrianglePuzzle());
		assertEquals(0, model.getPuzzle().getEdges().size());

		model.createNodes(new Dimension(800, 800));
		model.createEdges();
		assertEquals(18, model.getPuzzle().getEdges().size());
	}
	
	public void testCalculateScore() {
		Model model = new Model();
		model.setPuzzle(new TrianglePuzzle());

		model.createNodes(new Dimension(800, 800));
		model.createEdges();
		
		assertEquals(0, model.calculateScore());
		
		// swap edge colors for nodes [1,2,3]
		model.getPuzzle().getNodes().get(1).setSelected(true);
		model.getPuzzle().getNodes().get(2).setSelected(true);
		model.getPuzzle().getNodes().get(3).setSelected(true);
		model.trySwap();
		
		// T1 is complete and correct color (RED)
		assertEquals(10, model.calculateScore());
		
		// TODO: all 6 triangles completed
	}

	public void testThreeEdgeSwap() {
		Model model = new Model();
		model.setPuzzle(new TrianglePuzzle());

		model.createNodes(new Dimension(800, 800));
		model.createEdges();
		
		// verify initial Edge colors
		for (Edge curEdge : model.getPuzzle().getEdges()) {
			assertTrue(curEdge.getInitialColor() == curEdge.getColor());
		}
		
		// swap edge colors for nodes [2,4,5]
		model.getPuzzle().getNodes().get(2).setSelected(true);
		model.getPuzzle().getNodes().get(4).setSelected(true);
		model.getPuzzle().getNodes().get(5).setSelected(true);
		model.trySwap();
		
		// T3 rotated clockwise, verify new colors
		assertTrue(model.getPuzzle().getEdges().get(4).getColor() == model.getPuzzle().getEdges().get(17).getInitialColor()); // RED edge is now BLUE
		assertTrue(model.getPuzzle().getEdges().get(10).getColor() == model.getPuzzle().getEdges().get(4).getInitialColor()); // GREEN edge is now RED
		assertTrue(model.getPuzzle().getEdges().get(17).getColor() == model.getPuzzle().getEdges().get(10).getInitialColor()); // BLUE edge is now GREEN
	}
}
