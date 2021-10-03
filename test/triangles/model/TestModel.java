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
}
