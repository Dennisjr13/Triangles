package triangles.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import triangles.model.Edge;
import triangles.model.Model;
import triangles.model.Node;
import triangles.model.TrianglePuzzle;

public class TrianglesDrawer extends JPanel {

	Model model;
	int boxSize;
	
	/**
	 * Create the panel.
	 */
	public TrianglesDrawer(Model model) {
		this.model = model;
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		// protects when looking inside WindowBuilder
		if (model == null) {
			return;
		}
		
		// TODO: do the math and figure out WHERE to draw all the boxes (nodes), lines (edges)

		// TODO: Draw entire puzzle here
		graphics.drawString("test", 100, 100);
		
		TrianglePuzzle puzzle = model.getPuzzle();
		for (Node node : puzzle.getNodes()) {
			if (node.isSelected()) {
				graphics.setColor(Color.black);
			} else {
				graphics.setColor(Color.white);
			}
			
			graphics.fillRect(node.getX(), node.getY(), node.getSize(), node.getSize());
		}
		
		for (Edge edge : puzzle.getEdges()) {
			// TODO: set color
			
			graphics.drawString("test", 100, 100);
		}
	}

}
