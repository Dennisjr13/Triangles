package triangles.controller;

import java.awt.Color;
import java.awt.Dimension;

import junit.framework.TestCase;
import triangles.model.Edge;
import triangles.model.Model;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class TestResetController extends TestCase {
	TrianglesApp app;
	Model model;
	
	@Override
	protected void setUp() {
		model = new Model();
		app = new TrianglesApp(model);

		// create nodes and edges
		model.setPuzzle(new TrianglePuzzle());
		model.createNodes(new Dimension(800, 800));
		model.createEdges();
		
		app.setVisible(true);
	}
	
	@Override 
	protected void tearDown() {
		app.dispose();
		
	}
	
	public void testStart() {
		// verify initial Edge colors
		for (Edge curEdge : model.getPuzzle().getEdges()) {
			assertTrue(curEdge.getInitialColor() == curEdge.getColor());
		}

		// swap edge colors for nodes [1,2,3]
		model.getPuzzle().getNodes().get(1).setSelected(true);
		model.getPuzzle().getNodes().get(2).setSelected(true);
		model.getPuzzle().getNodes().get(3).setSelected(true);
		model.trySwap();

		// verify new colors ... edge 11 = nodes(1,2), edge 1 = nodes(1,3)
		assertEquals(Color.RED, model.getPuzzle().getEdges().get(1).getInitialColor());
		assertEquals(Color.GREEN, model.getPuzzle().getEdges().get(11).getInitialColor());
		assertEquals(Color.GREEN, model.getPuzzle().getEdges().get(1).getColor());
		assertEquals(Color.RED, model.getPuzzle().getEdges().get(11).getColor());

		// reset button
		new ResetController(model, app).process();

		// verify current Edge colors again match initial
		for (Edge curEdge : model.getPuzzle().getEdges()) {
			assertTrue(curEdge.getInitialColor() == curEdge.getColor());
		}
	}
}
