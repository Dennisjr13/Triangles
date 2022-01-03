package triangles.controller;

import java.awt.Dimension;

import junit.framework.TestCase;
import triangles.model.Model;
import triangles.model.TrianglePuzzle;
import triangles.view.TrianglesApp;

public class TestExitController extends TestCase {

	TrianglesApp app;
	Model model;
	
	@Override
	protected void setUp() {
		model = new Model();
		app = new TrianglesApp (model);
		
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
	
	public void testExecutes() {
		Thread thread = new Thread() {
			public void run() {
				new ExitController(app).exit();
			}
		};
		thread.start();
	}
}
