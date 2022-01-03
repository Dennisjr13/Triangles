package triangles.controller;

import java.awt.Dimension;

import junit.framework.TestCase;
import triangles.model.Model;
import triangles.model.Node;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class TestUnselectAllController extends TestCase {
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
		// verify 0 Nodes selected
		for (Node curNode : model.getPuzzle().getNodes()) {
			assertFalse(curNode.isSelected());
		}

		// select 4 Nodes [4,5,6,7]
		model.getPuzzle().getNodes().get(4).setSelected(true);
		model.getPuzzle().getNodes().get(5).setSelected(true);
		model.getPuzzle().getNodes().get(6).setSelected(true);
		model.getPuzzle().getNodes().get(7).setSelected(true);
		
		// verify 4 Nodes selected
		int nodesSelected = 0;
		for (Node curNode : model.getPuzzle().getNodes()) {
			if (curNode.isSelected()) {
				nodesSelected++;
			}
		}
		assertEquals(4, nodesSelected);

		// unselect all button
		new UnselectAllController(model, app).process();

		// verify 0 Nodes selected
		for (Node curNode : model.getPuzzle().getNodes()) {
			assertFalse(curNode.isSelected());
		}
	}
}
